package org.lyh.utils.file.test;

import java.io.File;

import org.junit.Test;
import org.lyh.utils.file.DirectoryTools;

public class DirectoryToolsTest {
	
	@Test
	public void testListDirectory(){
		File dir = new File("E:/WorkSpace/HTML");
		DirectoryTools.listDirectory(dir, 1, false);
	}
}
