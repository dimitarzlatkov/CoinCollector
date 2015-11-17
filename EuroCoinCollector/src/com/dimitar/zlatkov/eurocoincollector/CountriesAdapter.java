package com.dimitar.zlatkov.eurocoincollector;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimitar.zlatkov.eurocoincollector.db.bean.Country;

public class CountriesAdapter extends BaseAdapter {

	private List<Country> list;
	private Activity activity;
	private Resources resources;

	public CountriesAdapter(Activity activity, List<Country> list) {
		this.list = list;
		this.activity = activity;
		resources = activity.getResources();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View listRowView, ViewGroup arg2) {
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (listRowView == null) {
			listRowView = inflater.inflate(R.layout.countries_row_layout, null);
		}

		ImageView flag = (ImageView) listRowView
				.findViewById(R.id.flag_image_view_id);
		TextView text = (TextView) listRowView
				.findViewById(R.id.country_name_id);

		Country country = list.get(position);
		int identifier = resources.getIdentifier(country.getImageUrl(),
				"drawable", activity.getPackageName());
		if (identifier > 0) {
			try {
				Drawable drawable = resources.getDrawable(identifier, null);
				flag.setImageDrawable(drawable);
			} catch (Exception e) {
				Log.d("TEST", country.getCountryName());
			}
		}

		text.setText(country.getCountryName());
		return listRowView;
	}
}
