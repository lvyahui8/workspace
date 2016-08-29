package com.tencent.utils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.Enumeration;
import java.util.List;

public class ZipUtil {

    static final int BUFFER = 2048;

    public static final String SYS_FILE_SP = System.getProperty("file.separator");

    /*
    public static void main (String argv[])
    {
        List<String> srcFileList = new ArrayList<String>();
        srcFileList.add("D:\\test\\lowData");
        srcFileList.add("D:\\test\\stackData");
        zipData("D:\\test\\zip123456.zip", srcFileList);

        try {
            unZipFiles("D:\\test\\zip123456.zip","D:\\test\\1\\");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    public static void zipData(String tarFile, List<String> srcFileList)
    {
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(tarFile);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));

            byte data[] = new byte[BUFFER];

            for(String srcFile : srcFileList)
            {
                File myFile = new File(srcFile);
                if (!myFile.exists())
                    continue;

                System.out.println("zip file: "+srcFile);
                FileInputStream fi = new FileInputStream(myFile);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(myFile.getName());
                out.putNextEntry(entry);
                int count;
                while((count = origin.read(data, 0, BUFFER)) != -1)
                {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void unZipFiles(String zipFilePath,String descDir) throws IOException{
        unZipFiles(zipFilePath,descDir,false);
    }

    public static void unZipFiles(String zipFilePath,String descDir,boolean deleteZip) throws IOException{
        if(!(descDir.endsWith(SYS_FILE_SP) || descDir.endsWith("/"))){
            descDir += SYS_FILE_SP;
        }
        File zipFile =  new File(zipFilePath);
        File pathFile = new File(descDir);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        ZipFile zip = new ZipFile(zipFile);
        for(Enumeration entries = zip.getEntries(); entries.hasMoreElements();)
        {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = descDir+zipEntryName;
            //输出文件路径信息
            System.out.println(outPath);

            OutputStream out = new FileOutputStream(outPath);
            byte[] data = new byte[BUFFER];
            int len;
            while((len=in.read(data))>0){
                out.write(data,0,len);
            }
            in.close();
            out.close();
        }
        if(deleteZip){
            zipFile.delete();
        }
    }

}
