package analyseData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineSumInfo implements Comparable<LineSumInfo>
{
    private String line;
    private String lineIdNd;
    private int count;
    private String type;
    private Map<Integer, Integer> nodeDelayList = new HashMap<Integer, Integer>();

    private int maxDelay;
    private int minDelay;
    private String maxDelayLine;
    private String minDelayLine;

//    private Map<Integer,Integer> lineNumMap = new HashMap<Integer, Integer>();
//
//    public void saveLineNum(int lineNum)
//    {
//        lineNumMap.put(lineNumMap.size(),lineNum);
//    }


    public String getLineIdNd() {
        return lineIdNd;
    }
    private List<LowDataBean> lowDataBeans = new ArrayList<LowDataBean>();
    public void addLowDataBean(LowDataBean lowDataBean){
        this.lowDataBeans.add(lowDataBean);
    }

    public void addLowDataBeans(List<LowDataBean> lowDataBeans){
        this.lowDataBeans.addAll(lowDataBeans);
    }

    public List<LowDataBean> getLowDataBeans() {
        return lowDataBeans;
    }

    public int compareTo(LineSumInfo arg0)
    {
        return this.getMaxDelay()-arg0.getMaxDelay();
    }

    public void addLine(String lineInfo)
    {
        if(lineInfo==null || lineInfo.trim().length()==0)
            return;

        //lineInfo: 66964[1379]/66951[611]/67416[611]/
        String contextArr[] = lineInfo.trim().split("/");
        if(lineIdNd == null || lineIdNd.equals("")){
            lineIdNd = lineInfo.replaceAll("\\[\\w+\\]","");
        }
        for(int index=0; index<=contextArr.length-1 ; index++)
        {
            String nodeInfo = contextArr[index];
            int delay =  Integer.valueOf(nodeInfo.substring(nodeInfo.indexOf("[")+1, nodeInfo.indexOf("]")));

            if(!nodeDelayList.containsKey(index))
            {
                nodeDelayList.put(index,delay);
//                this.type = nodeInfo.substring(nodeInfo.indexOf("[")+1, nodeInfo.indexOf(",")).equals("1") ? "mainThread" : "secThread";

                if(index==0) // the first method is the line total cost time
                {
                    minDelay = delay;
                    maxDelay = delay;
                    maxDelayLine = lineInfo;
                    minDelayLine = lineInfo;
                }
            }
            else
            {
                int totalDelay = nodeDelayList.get(index);
                totalDelay += delay;
                nodeDelayList.put(index, totalDelay);

                if(index==0)
                {
                    if(delay>maxDelay)
                    {
                        maxDelay = delay;
                        maxDelayLine = lineInfo;
                    }
                    if(delay<minDelay)
                    {
                        minDelay = delay;
                        minDelayLine = lineInfo;
                    }
                }
            }
        }
        count++;
    }

    public void getLineInfo()
    {
        /*
         * lien : methodA(28)/methodB(24)/methodC/
         */
        String contextArr[] = line.trim().split("/");
        StringBuffer buf = new StringBuffer();
        System.out.println("============================type:"+type+"==============================");
        System.out.println("avgLineDelay:  count:"+count);
//        for (int index=0; index<contextArr.length-1 ; index++)
//        {
//            int totalDelay = nodeDelayList.get(index);
//            double avgDelay = handleNumber(totalDelay/count);
//            buf.append(contextArr[index]);
//            buf.append("["+avgDelay+"]/");
//            buf.append("\n");
//        }
//        buf.append(contextArr[contextArr.length-1]);


        buf.append(contextArr[0]+"/");
        buf.append("\n");
        for (int index=1; index<contextArr.length; index++)
        {
            int totalDelay = nodeDelayList.get(index-1);
            // 所有LowDataBean 也就是一个B-C，出现的累加的耗时除以出现的次数，就是这个调用过程的平均耗时
            double avgDelay = handleNumber(totalDelay/count);
            buf.append(contextArr[index]);
            buf.append("["+avgDelay+"]/");
            buf.append("\n");
        }



        System.out.println(buf.toString());

        System.out.println("maxLineDelay:"+maxDelay);
        System.out.println(maxDelayLine);

        System.out.println("minLineDelay:"+minDelay);
        System.out.println(minDelayLine);
    }

    public  double handleNumber(double num)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(num));
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getCount() {
        return count;
    }

    public int getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(int maxDelay) {
        this.maxDelay = maxDelay;
    }

    public int getMinDelay() {
        return minDelay;
    }

    public void setMinDelay(int minDelay) {
        this.minDelay = minDelay;
    }

    public String getMaxDelayLine() {
        return maxDelayLine;
    }

    public void setMaxDelayLine(String maxDelayLine) {
        this.maxDelayLine = maxDelayLine;
    }

    public String getMinDelayLine() {
        return minDelayLine;
    }

    public void setMinDelayLine(String minDelayLine) {
        this.minDelayLine = minDelayLine;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
