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
		
		System.out.println("================��Ա��Ϣ����ϵͳ================");
		System.out.println("    1-�����û�");
		System.out.println("    2-�޸��û�");
		System.out.println("    3-ɾ���û�");
		System.out.println("    4-��ѯ�����û�");
		System.out.println("    5-��ѯ�����û�");
		System.out.println("    6-�˳�ϵͳ");
		
		InputData input = new InputData();
		
		int ch = input.getInt("��ѡ��", "��������ȷ��ѡ�");
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
