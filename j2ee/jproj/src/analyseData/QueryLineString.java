package analyseData;

import myApmUtils.Constants;
import myApmUtils.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by henryjhuang on 2015/11/19.
 */
public class QueryLineString {


    public static void main(String[] args)
    {


        String tarMsg ="com.tencent.component.utils.injector.SystemClassLoaderInjector.inject/com.tencent.component.utils.injector.SystemClassLoaderInjector.injectAboveEqualApiLevel14";

        getLine(tarMsg);

    }

    public static void getLine(String tarMsg)
    {
        List<String> lineList = new ArrayList<String>();
        File file = new File(Constants.MYAPM_ROOT+"lineInfo");

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

                    if(line.indexOf(tarMsg)>=0)
                    {
                        System.out.println(line);;
                    }

                    if(line.indexOf(tarMsg)>=0 && !lineList.contains(line))
                    {
                        lineList.add(line);
                    }

                }
                read.close();
            }

            System.out.println("unique line: ");
            for(String line : lineList)
            {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
