package com.example.arrayadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
	
	static final String [] items = {"����1","����2","����3","����4"};
	ListView list ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = (ListView)super.findViewById(R.id.list);
//		list.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.item, items));
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String, Object>();
		map1.put("nametext", "���ǵ�һ������");
		map1.put("iconid", R.drawable.dir);
		
		Map<String,Object> map2 = new HashMap<String, Object>();
		map2.put("nametext", "���ǵ�2������");
		map2.put("iconid", R.drawable.fuck);
		
		Map<String,Object> map3 = new HashMap<String, Object>();
		map3.put("nametext", "���ǵ�3������");
		map3.put("iconid", R.drawable.fun);
		
		Map<String,Object> map4 = new HashMap<String, Object>();
		map4.put("nametext", "���ǵ�4������");
		map4.put("iconid", R.drawable.game);
		
		data.add(map1);
		data.add(map2);
		data.add(map3);
		data.add(map4);
		list.setAdapter(new SimpleAdapter(this, data, R.layout.list_item,new String[]{"nametext","iconid"} , new int[]{R.id.item_tv,R.id.item_iv}));
	}
}
