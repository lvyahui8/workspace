package cn.itcast.commons.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.itcast.commons.CommonUtils;

/**
 * 测试CommonUtils类
 *
 * @author admin
 *
 */
public class CommonUtilsTest {
	/**
	 * 测试uuid()
	 * 生成一个32位长的随机字符串
	 */
	@Test
	public void testUuid(){
		String s = CommonUtils.uuid();
		System.out.println(s);
	}
	
	
	/**
	 * 测试toBean方法
	 * 作用：把一个map中的数据封装到javabean中
	 */
	@Test
	public void testToBean()
	{
		/**
		 * 创建map
		 *
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("pid", "123");
		map.put("name", "吕亚辉");
		map.put("age", "12");
		map.put("xxx","xxx");
		
		Person p = CommonUtils.toBean(map, Person.class);
		System.out.println(p);
	}
}
