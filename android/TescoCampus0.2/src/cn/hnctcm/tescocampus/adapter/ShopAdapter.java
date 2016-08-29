package cn.hnctcm.tescocampus.adapter;

import java.text.DateFormat;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.hnctcm.tescocampus.R;
import cn.hnctcm.tescocampus.domain.Shop;

public class ShopAdapter extends BaseAdapter {

	private List<Shop> shops;//绑定的数据
	
	private int resource;//绑定数据的条目界面
	
	private LayoutInflater inflater;//android 内置布局填充服务，可以使用一个xml生成一个view对象
	
	public ShopAdapter(Context context,List<Shop> persons,int resource) {
		this.shops = persons;
		this.resource = resource;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return shops.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return shops.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView shopNameView = null;
		TextView shopInducView = null;
		TextView shopSendUpPricesView = null;
		ImageView shopImgSrcView = null;
		TextView shopOpenDateView = null;
		
		if(null == convertView){
			convertView = inflater.inflate(resource, null);
//			
			shopImgSrcView = (ImageView)convertView.findViewById(R.id.list_element_img);
			shopNameView = (TextView)convertView.findViewById(R.id.list_element_name);
			shopInducView = (TextView)convertView.findViewById(R.id.list_element_introduction);
			shopSendUpPricesView = (TextView)convertView.findViewById(R.id.list_element_sendUpPrices);
			shopOpenDateView = (TextView)convertView.findViewById(R.id.list_element_openDate);
			
			
			ViewCache cache = new ViewCache();
			cache.shopNameView = shopNameView;
			cache.shopInducView = shopInducView;
			cache.shopSendUpPricesView = shopSendUpPricesView;
			cache.shopOpenDateView = shopOpenDateView;
			cache.shopImgSrcView = shopImgSrcView;
			
			convertView.setTag(cache);
		}
		else{
			ViewCache cache = (ViewCache)convertView.getTag();
			shopNameView = cache.shopNameView;
			shopInducView = cache.shopInducView;
			shopSendUpPricesView = cache.shopSendUpPricesView;
			shopImgSrcView = cache.shopImgSrcView;
			shopOpenDateView = cache.shopOpenDateView;
		}
//System.err.println(shopSendUpPricesView);
		Shop shop = shops.get(position);
		
		shopImgSrcView.setImageResource(shop.getImgSrcId());
		shopInducView.setText(shop.getInduc());
		shopNameView.setText(shop.getName());
		shopSendUpPricesView.setText(String.valueOf(shop.getSendUpPrices()));
		shopOpenDateView.setText(DateFormat.getDateInstance().format(shop.getOpenDate()));
		
		return convertView;
	}

	private final class ViewCache{
		public TextView shopNameView;
		public TextView shopInducView;
		public TextView shopSendUpPricesView;
		public ImageView shopImgSrcView;
		public TextView shopOpenDateView;
	}
}
