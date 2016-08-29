package com.grin.menu;

import com.grin.util.InputData;

public class Menu {
	public Menu(){
		while(true){
			this.show();
		}
	}

	private void show() {
		// TODO Auto-generated method stub
		
		System.out.println("================人员信息管理系统================");
		System.out.println("    1-增加用户");
		System.out.println("    2-修改用户");
		System.out.println("    3-删除用户");
		System.out.println("    4-查询单个用户");
		System.out.println("    5-查询所有用户");
		System.out.println("    6-退出系统");
		
		InputData input = new InputData();
		
		int ch = input.getInt("请选择：", "请输入正确的选项，");
		switch(ch){
		case 1:
			UserOprate.insert();
			break;
		case 2:
			UserOprate.update();
			break;
		case 3:
			UserOprate.delete();
			break;
		case 4:
			UserOprate.findId();
			break;
		case 5:
			UserOprate.findAll();
			break;
		case 6:
			System.exit(1);
			break;
		default:
		}
	}
}
