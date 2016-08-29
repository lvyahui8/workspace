package net.androidla.test;
/*
 * 另外，在网上看到了另一种方法，没有试过，转载如下：
===================================================================================================
1.首先下载SVN包：site -1.6.17
2.解压SVN包，然后找到其中的两个文件夹：features 和 plugins
3.随意建一个文件夹（位置和名称自己定就好了，我的是E:\myEclipsePlugin\svn），然后把第二步的解压好的features 和 plugins放到这个文件夹下
4.找到myeclipse的安装目录，下面有一个configuration\org.eclipse.equinox.simpleconfigurator\bundles.info 文件。现在需要做的就是在该文件内添加的东西
5.添加的内容用下面的类生成：
6.把以上生成的字符串（一大堆）添加到第四步bundles.info文件的后面，然后重启myeclipse即可。
 */
import java.io.File;   
import java.util.ArrayList;   
import java.util.List;   
/**  
 * MyEclipse9 插件配置代码生成器  
 *  
 *  
 */  
public class PluginsInstall   
{   
    public PluginsInstall()   
    {   
    }   
    public void print(String path)   
    {   
        List<String> list = getFileList(path);   
        if (list == null)   
        {   
            return;   
        }   
        int length = list.size();   
        for (int i = 0; i < length; i++)   
        {   
            String result = "";   
            String thePath = getFormatPath(getString(list.get(i)));   
            File file = new File(thePath);   
            if (file.isDirectory())   
            {   
                String fileName = file.getName();   
                if (fileName.indexOf("_") < 0)   
                {   
                    print(thePath);   
                    continue;   
                }   
                String[] filenames = fileName.split("_");   
                String filename1 = filenames[0];   
                String filename2 = filenames[1];   
                result = filename1 + "," + filename2 + ",file:/" + path + "/"  
                        + fileName + "\\,4,false";   
                System.out.println(result);   
            } else if (file.isFile())   
            {   
                String fileName = file.getName();   
                if (fileName.indexOf("_") < 0)   
                {   
                    continue;   
                }   
                int last = fileName.lastIndexOf("_");// 最后一个下划线的位置   
                String filename1 = fileName.substring(0, last);   
                String filename2 = fileName.substring(last + 1, fileName   
                        .length() - 4);   
                result = filename1 + "," + filename2 + ",file:/" + path + "/"  
                        + fileName + ",4,false";   
                System.out.println(result);   
            }   
        }   
    }   
    public List<String> getFileList(String path)   
    {   
        path = getFormatPath(path);   
        path = path + "/";   
        File filePath = new File(path);   
        if (!filePath.isDirectory())   
        {   
            return null;   
        }   
        String[] filelist = filePath.list();   
        List<String> filelistFilter = new ArrayList<String>();   
        for (int i = 0; i < filelist.length; i++)   
        {   
            String tempfilename = getFormatPath(path + filelist[i]);   
            filelistFilter.add(tempfilename);   
        }   
        return filelistFilter;   
    }   
    public String getString(Object object)   
    {   
        if (object == null)   
        {   
            return "";   
        }   
        return String.valueOf(object);   
    }   
    public String getFormatPath(String path)   
    {   
        path = path.replaceAll("\\\\", "/");   
        path = path.replaceAll("//", "/");   
        return path;   
    }   
    public static void main(String[] args)   
    {   
        /*你的SVN的features 和 plugins复制后放的目录*/  
        String plugin = "C:\\Program Files\\Genuitec\\plugins\\jdeclipse_update_site";   
        new PluginsInstall().print(plugin);   
    }   
} 
