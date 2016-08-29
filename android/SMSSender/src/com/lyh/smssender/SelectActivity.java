package com.lyh.smssender;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yahui.readcontactsinfo.domain.ContactInfo;
import com.yahui.readcontactsinfo.service.ContactInfoService;

public class SelectActivity extends Activity {

	private ListView lv_select_phone = null;
	private List<ContactInfo> contactInfos = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		contactInfos = ContactInfoService.getContactInfo(this);
		lv_select_phone = (ListView) super.findViewById(R.id.lv_select_phone);
		lv_select_phone.setAdapter(new ContactAdapter());
		
		lv_select_phone.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				ContactInfo info = contactInfos.get(position);
				String number = info.getNumber();
				Intent intent = new Intent();
				intent.putExtra("number", number);
				setResult(0, intent);
				finish();
			}
			
		});
	}

	private class ContactAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return contactInfos.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return contactInfos.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ContactInfo info = contactInfos.get(position);
			View view = View.inflate(getApplicationContext(), R.layout.contact_item, null);//´òÆøÍ²
			
			TextView tv_name = (TextView) view.findViewById(R.id.tv_contact_name);
			TextView tv_number = (TextView) view.findViewById(R.id.tv_contact_phone);
			
			tv_name.setText(info.getName());
			tv_number.setText(info.getNumber());
			return view;
		}
		
		
	}
}
