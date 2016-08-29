package com.yahui.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yahui.db.R;
import com.yahui.domain.Shop;

public class PersonAdapter extends BaseAdapter {

	private List<Shop> persons;//绑定的数据
	
	private int resource;//绑定数据的条目界面
	
	private LayoutInflater inflater;//android 内置布局填充服务，可以使用一个xml生成一个view对象
	
	public PersonAdapter(Context context,List<Shop> persons,int resource) {
		this.persons = persons;
		this.resource = resource;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return persons.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView nameView = null;
		TextView phoneView = null;
		if(null == convertView){
			convertView = inflater.inflate(resource, null);
			
			nameView = (TextView)convertView.findViewById(R.id.name);
			phoneView = (TextView)convertView.findViewById(R.id.phone);
			
			ViewCache cache = new ViewCache();
			cache.nameView = nameView;
			cache.phoneView = phoneView;
			convertView.setTag(cache);
		}
		else{
			ViewCache cache = (ViewCache)convertView.getTag();
			nameView = cache.nameView;
			phoneView = cache.phoneView;
		}
		Shop person = persons.get(position);
		nameView.setText(person.getName());
		phoneView.setText(person.getPhone());
		
		return convertView;
		
	}

	private final class ViewCache{
		public TextView nameView;
		public TextView phoneView;
	}
}
