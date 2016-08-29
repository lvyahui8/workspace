package myApmUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class FileUtil {

	public static Map<Integer,String> readFileByLines(String fileName)
	{
		Map<Integer,String> moduleMap = new HashMap<Integer,String>();
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
					moduleMap.put(Integer.valueOf(contextArr[0]), contextArr[1]);	
					//			            System.out.println(contextArr[0]+"-"+contextArr[1]);
				}
				read.close();      
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return moduleMap;
	}

    //»»ÐÐ
	public static void fileWriter(String path, String fileName, String data)
	{
		try{
			File fileFolder = new File(path);
			if( !fileFolder.isDirectory() )
			{
				fileFolder.mkdirs();
			}
			File myFile = new File(path+fileName);
			if( !myFile.exists() )
			{
				myFile.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFile,true);
			BufferedWriter buffer = new BufferedWriter(resultFile);
			buffer.write(data);
			buffer.newLine();
			buffer.flush();
			resultFile.flush();
			buffer.close();
			resultFile.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{

		}
	}


	private static void cleanContext(String filePath)
	{
		File myFile = new File(filePath);
		if(myFile.exists())
		{
			try {
				FileWriter fw =  new FileWriter(myFile);
				fw.write("");
				fw.close();
				System.out.println("clean context: "+filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {

		cleanContext("D:\\test\\1\\lowData");
		//		FileUtil.readFileByLines("C:/upload/module.txt");
		//		double abc = 456.0;
		//		System.out.println(abc);
		//		System.out.println((int)abc);

		//		FileUtil.fileWriter("C:/test/test2/", "test2.txt", "my testing data");


//		File fileFolder = new File("C:/test/test2/");
//		if(!fileFolder.isDirectory())
//		{
//			fileFolder.mkdirs();
//		}
//
//		File[] allFiles = fileFolder.listFiles();
//
//		for(File item : allFiles)
//		{
//			System.out.println(item.getName());
//		}



	}

}
