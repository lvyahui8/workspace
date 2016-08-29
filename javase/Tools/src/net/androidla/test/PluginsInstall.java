package net.androidla.test;
/*
 * ���⣬�����Ͽ�������һ�ַ�����û���Թ���ת�����£�
===================================================================================================
1.��������SVN����site -1.6.17
2.��ѹSVN����Ȼ���ҵ����е������ļ��У�features �� plugins
3.���⽨һ���ļ��У�λ�ú������Լ����ͺ��ˣ��ҵ���E:\myEclipsePlugin\svn����Ȼ��ѵڶ����Ľ�ѹ�õ�features �� plugins�ŵ�����ļ�����
4.�ҵ�myeclipse�İ�װĿ¼��������һ��configuration\org.eclipse.equinox.simpleconfigurator\bundles.info �ļ���������Ҫ���ľ����ڸ��ļ�����ӵĶ���
5.��ӵ�����������������ɣ�
6.���������ɵ��ַ�����һ��ѣ���ӵ����Ĳ�bundles.info�ļ��ĺ��棬Ȼ������myeclipse���ɡ�
 */
import java.io.File;   
import java.util.ArrayList;   
import java.util.List;   
/**  
 * MyEclipse9 ������ô���������  
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
                int last = fileName.lastIndexOf("_");// ���һ���»��ߵ�λ��   
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
        /*���SVN��features �� plugins���ƺ�ŵ�Ŀ¼*/  
        String plugin = "C:\\Program Files\\Genuitec\\plugins\\jdeclipse_update_site";   
        new PluginsInstall().print(plugin);   
    }   
} 
