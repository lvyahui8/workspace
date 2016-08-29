package analyseData;

import myApmUtils.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by henryjhuang on 2015/11/4.
 */
public class CalcDelayTime {

    public static void main(String[] args)
    {

//        File file = new File(Constants.MYAPM_ROOT+"TestData\\round2\\DelayMonitor.txt");
        File file = new File(Constants.MYAPM_ROOT+"delayTestData.txt");
//        File file = new File("D:\\qzoneTest\\TestData\\round2\\DelayPrintStack.txt");

        try {
            if(file.isFile()&&file.exists())
            {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf8");
                BufferedReader reader=new BufferedReader(read);
                String line;
                int count=0;
                int count2=0;
                int count3=0;
                long totalTime=0;
                long totalTime2=0;
                long totalTime3=0;


                while ((line = reader.readLine()) != null)
                {
                    if(line.indexOf("myApmA")>0)  //myApmA13060:2923ns
                    {
                        int index = line.indexOf("myApmA");
                        String data = line.substring(index+7);
                        int time = Integer.valueOf(data.replace("ns", ""));
                        totalTime+=time;
                        count++;
                    }
                    else if(line.indexOf("myApmT")>0)   //myApmT:2461ns
                    {
                        int index = line.indexOf("myApmT");
                        String data = line.substring(index+7);
                        int time2 = Integer.valueOf(data.replace("ns", ""));
                        totalTime2+=time2;
                        count2++;
                    }
                    else if(line.indexOf("myApmS")>0)   //myApmT:2461ns
                    {
                        int index = line.indexOf("myApmS");
                        String data = line.substring(index+7);
                        int time3 = Integer.valueOf(data.replace("ns", ""));
                        totalTime3+=time3;
                        count3++;
                    }
                }
//                System.out.println("a method avg time:"+totalTime/count+"naoms,count:"+count+"highCount:"+highCount1+"maxTime:"+maxTime1);
//                System.out.println("t method avg time:"+totalTime2/count2+"naoms,count:"+count2+"highCount:"+highCount2+"maxTime:"+maxTime2);
                if(count>0)
                   System.out.println("a method avg time:"+totalTime/count+"naoms,count:"+count);
                if(count2>0)
                   System.out.println("t method avg time:"+totalTime2/count2+"naoms,count:"+count2);
                if(count3>0)
                   System.out.println("s method avg time:"+totalTime3/count3+"naoms,count:"+count3);
                read.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
