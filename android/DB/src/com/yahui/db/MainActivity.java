package com.yahui.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.yahui.adapter.PersonAdapter;
import com.yahui.domain.Shop;
import com.yahui.service.PersonService;

public class MainActivity extends Activity {
	
	private ListView listView = null;
	private PersonService personService = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        personService = new PersonService(this);
        listView = (ListView)super.findViewById(R.id.listView);
        listView.setOnItemClickListener(new ItemClickListener());
        show3(); 
    }
    
    private final class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			ListView lView = (ListView) parent;
			//show3
			Shop person = (Shop)lView.getItemAtPosition(position);
			Toast.makeText(getApplicationContext(), person.getId().toString(), 1).show();
			
//			show2
//			Cursor cursor = (Cursor)lView.getItemAtPosition(position);
//			int personid = cursor.getInt(cursor.getColumnIndex("_id"));
//			Toast.makeText(getApplicationContext(), personid+"", 0).show();
			
		}
    	
    }
	private void show3() {
		// TODO Auto-generated method stub
		List<Shop> persons = personService.getScrollData(0, 20);
		PersonAdapter adapter = new PersonAdapter(this, persons, R.layout.item);
		listView.setAdapter(adapter);
	}
	@SuppressWarnings("unused")
	private void show() {
		// TODO Auto-generated method stub
		List<Shop> persons = personService.getScrollData(0, 20);
System.err.println(persons.size());
		//适配器的作用，是将数据绑定到控件上
		List<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();
		for(Shop person : persons){
			HashMap<String,Object> item = new HashMap<String, Object>();
			item.put("name", person.getName());
			item.put("phone", person.getPhone());
			item.put("id", person.getId());
			data.add(item);
		}
		SimpleAdapter  adapter = new SimpleAdapter(this,data,R.layout.item,
				new String[]{"name","phone"},new int[]{R.id.name,R.id.phone});
		
		listView.setAdapter(adapter);{//内部代码
//			int total = adapter.getCount();//用来得到数据总数
//			int perpage = 7;
//			for(int i=0;i < perpage;i++){
//				View view = adapter.getView(i, convertView, parent)//用于得到相应View
//			}
		}
		
		
	}
	@SuppressWarnings("unused")
	private void show2(){
		Cursor cursor = personService.getCursorData(0, 20);
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.item,cursor,
				new String[] {"name","phone"},new int [] {R.id.name,R.id.name});
		listView.setAdapter(adapter);
	}
}