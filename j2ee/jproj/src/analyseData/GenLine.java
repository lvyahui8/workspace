package analyseData;

import com.tencent.utils.IOUtils;
import myApmUtils.Constants;
import myApmUtils.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by henryjhuang on 2015/11/27.
 */
public class GenLine {

    private static Map<String, String> DecodeMap = new HashMap<String, String>();
//    private static String dataPath = Constants.MYAPM_ROOT+"TestData\\round3\\";
//    private static String dataPath = "E:\\APM\\myAPMTesting\\version\\myAPM-reportDelay\\";
//    private static String dataPath = "E:\\APM\\myAPMTesting\\version\\myAPM-reportDelay-1s\\";
    private static String dataPath = IOUtils.getBasePath() + "/data";
    private static List<LowDataBean> reportData = new ArrayList<LowDataBean>();
    private static long maxTime = 1000 * 1000000; //ns, 阀值为1000ms
    private Map<String, LineSumInfo> lineList = new HashMap<String, LineSumInfo>();


    public static void main(String[] args)
    {
        GenLine genLine = new GenLine();
        genLine.loadReportData(null);
        genLine.generateLine();
        System.out.println("========================line avg delay analyse===============================");
        genLine.showLineAvgDelay();
    }

    public GenLine() {
        initDncodeMapData(dataPath + "/EncodeMap");
    }

    public Map<String, LineSumInfo> getLineList() {
        return lineList;
    }

    private void showLineAvgDelay()
    {
        List<LineSumInfo> list = new ArrayList<LineSumInfo>(lineList.values());
        // 按链路最长耗时降序排序
        Collections.sort(list);
        for (LineSumInfo item : list)
        {
            //将链接和延时拼接在一起
            item.getLineInfo();
        }
    }

    public void generateLine()
    {
        if(reportData.size()==0)
            return;

        LowDataBean firstItem = reportData.get(0);
        StringBuffer lineBuf = new StringBuffer();
        StringBuffer lineIdBuf = new StringBuffer();
        List<LowDataBean> currentlineItems = new ArrayList<LowDataBean>();
        lineBuf.append(firstItem.getToMethod() + "/" + firstItem.getFromMethod() + "("+ firstItem.getLineNumber()+")");
//        lineIdBuf.append(firstItem.getNodeId()+"["+firstItem.getType()+","+firstItem.getDelay()+"]");
        lineIdBuf.append(firstItem.getNodeId()+"["+firstItem.getDelay()+"]");
        firstItem.setLevel(0);
        currentlineItems.add(firstItem);
        this.findParentMethodPair(firstItem, lineBuf, lineIdBuf,1, currentlineItems,0);


        //链路倒序
        /*
         * lineIdBuf : 85114[804]/84516[806]/84529[1350]
         * lineBuf : methodC/methodB(24)/methodA(28) ## 在A方法中的28行调用B方法，在B方法中的24行调用C方法
         */
        List<String> lineInfoList = recoerLine(lineBuf.toString(), lineIdBuf.toString());

        /*
         * 恰好翻转
         * lineString : methodA(28)/methodB(24)/methodC/
         * lineId : 84529[1350]/84516[806]/85114[804]/
         */
        String lineString = lineInfoList.get(0);
        String lineId = lineInfoList.get(1);
        //统计链路平均耗时
        if(lineList.containsKey(lineString))  // 如果存在相同的调用栈
        {
            lineList.get(lineString).addLine(lineId); //addLine()：链路平均，最大、最小统计在里面
        }
        else
        {
            LineSumInfo item = new LineSumInfo();
            item.setLine(lineString);
            item.addLine(lineId);
            item.addLowDataBeans(currentlineItems);
            lineList.put(lineString,item);
        }

        //删除当前已组成链路的节点
        for(LowDataBean abc : currentlineItems)
        {
            for (Iterator it = reportData.iterator(); it.hasNext();)
            {
                LowDataBean item = (LowDataBean)it.next();
                if (abc.getFromMethod().equals(item.getFromMethod())
                        && abc.getToMethod().equals(item.getToMethod())
                        && abc.getDelay()==item.getDelay()
                        && abc.getReportTime()==item.getReportTime())
                {
                    it.remove();
                }
            }
        }

        //若还有其它上报数据，则递归处理 。
        if(reportData.size()>0)
           generateLine();
    }


    private List<String> recoerLine(String lineStr, String lineId)
    {
        List<String> list = new ArrayList<String>();

        if(lineStr==null || lineStr.trim().length()==0 || lineId==null || lineId.trim().length()==0)
            return list;

        String contextArr[] = lineStr.split("/");
        String contextId[] = lineId.split("/");
        StringBuffer lineIdBuf = new StringBuffer();
        StringBuffer lineBuf = new StringBuffer();
        StringBuilder lineIdND = new StringBuilder();
        //倒序链路
        for(int i= contextArr.length-1; i>=0; i--)
        {
            lineBuf.append(contextArr[i]);
            lineBuf.append("/");
        }
        //倒序ID链路。会比上面的少一节。所以，要分开处理 。
        for(int i= contextId.length-1; i>=0; i--)
        {
            lineIdBuf.append(contextId[i]);
            lineIdBuf.append("/");
        }

        list.add(lineBuf.toString());
        list.add(lineIdBuf.toString());
        list.add(lineIdND.toString());
//        System.out.println("myLine: "+lineBuf.toString());
//        System.out.println("myLineID: "+lineIdBuf.toString());
        return list;
    }


    /**
     * 构造调用链路，链路的顺序恰好与函数堆栈的顺序相反
     * @param item
     * @param lineBuf
     * @param lineBufId
     * @param index
     * @param currentlineItems
     */
    private void findParentMethodPair(LowDataBean item, StringBuffer lineBuf, StringBuffer lineBufId, int index, List<LowDataBean> currentlineItems,int level)
    {
        String fromMethod = item.getFromMethod();
        for(int i=index; i<reportData.size(); i++)
        {
            LowDataBean parentItem = reportData.get(i);
            if(isParentMethod(item, parentItem)) //1000ms
            {
                lineBuf.append("/");
                lineBuf.append(parentItem.getFromMethod() + "("+ parentItem.getLineNumber()+")");

                lineBufId.append("/");
                lineBufId.append(parentItem.getNodeId()+"["+parentItem.getDelay()+"]");

                currentlineItems.add(parentItem);
                parentItem.setLevel(++level);
                findParentMethodPair(parentItem, lineBuf, lineBufId, i + 1, currentlineItems,level);  //上一个方法的上报时间，肯定是比当前方法慢。一定是在当前方法的一下个开始查找。
                break;  //若有合适，取最近一个。然后不做下面查询。这个很重要。不然，会出现链路拼接其它链路。
            }
        }
    }

    /**
     * 判断是否是调用关系，比如item表示B-C（B调用C），而parentItem表示A-B（A调用B），
     * @param item
     * @param parentItem
     * @return
     */
    private boolean isParentMethod(LowDataBean item, LowDataBean parentItem)
    {
        if((parentItem.getReportTime()-item.getReportTime())>maxTime) //若超过阀值间隔时间的记录，不考虑
            return false;

        if(parentItem.getDelay()<item.getDelay()) //上一层的延时一定不小于子方法耗时
            return false;

        //now ,just handle main thread. so , no need the thread id
//        if(parentItem.getThreadId()!=item.getThreadId())  //若线程Id不一样，则不对。
//            return false;

        if(parentItem.getToMethod().equals(item.getFromMethod())) //时间间隔OK，且类+方法名，则OK
            return true;
        else  //若类+方法名不一样，但其中方法名是一样的。（由于在同一时间段，所以，认为是可以对接的）
        {
            String parentMethod = parentItem.getToMethod();
            String itemFromMethod = item.getFromMethod();
            if(parentMethod!=null && itemFromMethod!=null)
            {
                String pMethodName = parentMethod.substring(parentMethod.lastIndexOf(".")+1);
                String iMethodName = itemFromMethod.substring(itemFromMethod.lastIndexOf(".")+1);
                if(pMethodName.equals(iMethodName))
                    return true;
            }
        }

        return false;
    }

    public void loadReportData(String  lowDataFile)
    {
        if(lowDataFile == null || "".equals(lowDataFile)){
            lowDataFile = dataPath+"lowData";
        }

        File file = new File(lowDataFile);

        try {
            if(file.isFile()&&file.exists())
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf8");
                BufferedReader reader=new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null)
                {
                    if (line.trim().length()==0)
                        continue;

                    // lowData line format: nodeId:delay:reportTime
                    String contextArr[] = line.split(":");


                    //id format: fromMethod-lineNum/toMethod
                    //22358:com.qzonex.component.process.WebProcessService.onCreate-24/com.qzonex.proxy.browser.IBrowserService.loadBrowserModuleDex
                    LowDataBean item = new LowDataBean();
                    item.setNodeId(contextArr[0]);
                    String[] nodeStr = DecodeMap.get(item.getNodeId()).split("/");
                    if(nodeStr.length!=2)
                    {
                        System.out.println("------------error-----nodeStr--------------"+nodeStr[0]);
                        continue;
                    }
                    String fromMethodInfo[] = nodeStr[0].split("-");
                    if(fromMethodInfo.length!=2)
                    {
                        System.out.println("------------error---fromMethodInfo----------------"+fromMethodInfo[0]);
                        continue;
                    }
                    /*
                     * 在fromMethodInfo[0] 方法中的  fromMethodInfo[1] 行调用了 nodeStr[1] 方法
                     */
                    item.setFromMethod(fromMethodInfo[0]);
                    item.setLineNumber(fromMethodInfo[1]);
                    item.setToMethod(nodeStr[1]);
                    item.setDelay(Integer.valueOf(contextArr[1]));
                    item.setReportTime(Long.valueOf(contextArr[2]));
//                    item.setThreadId(Long.valueOf(contextArr[3]));
                    reportData.add(item);

//                    //须添加去重。因为卡慢上报，有可能一个链路上报多次。
//                    if(!fromMethodList.contains(item.getFromMethod()))
//                        fromMethodList.add(item.getFromMethod());
//
//                    if(!toMethodList.contains(item.getToMethod()))
//                        toMethodList.add(item.getToMethod());
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //按上报时间排序
        Collections.sort(reportData);

        printReportData();
    }


    private void printReportData()
    {
        for(LowDataBean item : reportData)
        {
            System.out.println(item.getNodeId()+":"+item.getReportTime());
        }
    }


    public static void initDncodeMapData(String fileName)
    {
        File file = new File(fileName);
        try {
            if(file.isFile()&&file.exists())
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf8");
                BufferedReader reader=new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null)
                {
                    String contextArr[] = line.split(":");
                    if(contextArr.length!=2)
                    {
                        continue;
                    }
                    DecodeMap.put(contextArr[0], contextArr[1]);
                }
                read.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDncode(String MethodId)
    {
        if (DecodeMap.containsKey(MethodId))
            return DecodeMap.get(MethodId);
        else {
            FileUtil.fileWriter(Constants.MYAPM_ROOT, "IdNotFoundWhenDecode", MethodId);
            return "not found";
        }
    }


}
