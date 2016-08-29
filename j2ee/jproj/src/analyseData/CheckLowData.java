package analyseData;

import myApmUtils.Constants;
import myApmUtils.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CheckLowData
{
    private static Map<String, String> DecodeMap = new HashMap<String, String>();
    private static Map<String, String> TypeMap = new HashMap<String, String>();
    private static List<String> fromMethodList = new ArrayList<String>();
    private static List<String> toMethodList = new ArrayList<String>();
    private static List<String> expLineDataList = new ArrayList<String>();
    private static List<String> lastMethodLineList = new ArrayList<String>();

    private static String dataPath = Constants.MYAPM_ROOT+"TestData\\round2\\";
    public static void main(String[] args)
    {
        initDncodeMapData(dataPath+"EncodeMap");

        analyseLowData();

        recoverLineData();

        getLastMethod();

        for(String item : lastMethodLineList)
        {
            getLine(item);
        }
    }

    private static void getLastMethod()
    {
        List<String> lastMethodList = new ArrayList<String>();
        for(String toMethod : toMethodList)
        {
            if(!fromMethodList.contains(toMethod))
            {
                lastMethodList.add(toMethod);
            }
        }

        for(String item : expLineDataList)
        {
            for(String lastMethod : lastMethodList)
            {
                if(item.endsWith(lastMethod))
                {
                    lastMethodLineList.add(item);
                }
            }
        }
    }

    private static void recoverLineData()
    {
        File file = new File(dataPath+"lineData");

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

                    String contextArr[] = line.split(":");
                    int index = line.lastIndexOf("/");
                    String firstMsg = line.substring(0,index);
                    String secMsg = line.substring(index+1);
                    String lineMsg = firstMsg+"/"+DecodeMap.get(secMsg);
                    FileUtil.fileWriter(dataPath,"lineInfo",lineMsg);
                }
                read.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void analyseLowData()
    {
        List<LowDataBean> mainList = new ArrayList<LowDataBean>();
        List<LowDataBean> secList = new ArrayList<LowDataBean>();

        File file = new File(dataPath+"lowData");

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

                    String contextArr[] = line.split(":");


                    LowDataBean item = new LowDataBean();
                    item.setFromMethod(getDncode(contextArr[0]));
                    item.setToMethod(getDncode(contextArr[1]));
//                    item.setType(Integer.valueOf(contextArr[2]));
                    item.setDelay(Integer.valueOf(contextArr[3]));
                    if("1".equals(contextArr[2]))
                        mainList.add(item);
                    else
                        secList.add(item);

                    //须添加去重。因为卡慢上报，有可能一个链路上报多次。
                    if(!fromMethodList.contains(item.getFromMethod()))
                        fromMethodList.add(item.getFromMethod());

                    if(!toMethodList.contains(item.getToMethod()))
                        toMethodList.add(item.getToMethod());

                    String abc = item.getFromMethod()+"/"+item.getToMethod();
                    if(!expLineDataList.contains(abc))
                    {
                        expLineDataList.add(abc);
//                        TypeMap.put(abc,item.getType()+":"+item.getDelay());
                    }



                }
                read.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //排序输出 -->不排序，会造成分析误解。统计top时，才打开
//        Collections.sort(mainList);
//        Collections.sort(secList);
        for(LowDataBean item :mainList)
        {
            FileUtil.fileWriter(dataPath,"mainDelay",item.getDelay()+" : "+item.getFromMethod()+"/"+item.getToMethod());
        }
        for(LowDataBean item :secList)
        {
            FileUtil.fileWriter(dataPath,"secDelay",item.getDelay()+" : "+item.getFromMethod()+"/"+item.getToMethod());
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

    public static void getLine(String tarMsg)
    {
        List<String> lineList = new ArrayList<String>();
        List<String> beforeLineList = new ArrayList<String>();

        File file = new File(dataPath+"lineInfo");

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

//                    if(line.indexOf(tarMsg)>=0)
//                    {
//                        System.out.println(line);;
//                    }

                    if(line.indexOf(tarMsg)>=0 && !lineList.contains(line))
                    {
                        lineList.add(line);

                        int index = line.lastIndexOf(tarMsg);
                        String beforeMsg = line.substring(0,index)+tarMsg;
                        if(!beforeLineList.contains(beforeMsg))
                            beforeLineList.add(beforeMsg);
                    }

                }
                read.close();
            }

            String info[] =TypeMap.get(tarMsg).split(":");
            String type = info[0];
            String deleay = " (delay:"+info[1]+")";

            String flag ="";
            if("1".equals(type))
                flag = "(main)";

            FileUtil.fileWriter(dataPath, "analyseDelay", "==================================================================================");
            FileUtil.fileWriter(dataPath, "analyseDelay", flag+deleay+" "+tarMsg+" : ");
            FileUtil.fileWriter(dataPath, "analyseDelay"," before line :" );
            for(String item : beforeLineList)
            {
                FileUtil.fileWriter(dataPath, "analyseDelay",item+"" );
            }

            FileUtil.fileWriter(dataPath, "analyseDelay"," detail line :" );
            for(String line : lineList)
            {
                FileUtil.fileWriter(dataPath, "analyseDelay", line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
