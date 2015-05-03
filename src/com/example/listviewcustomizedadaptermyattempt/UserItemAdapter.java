package com.example.listviewcustomizedadaptermyattempt;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserItemAdapter extends ArrayAdapter<UserRecord> {
	Context mContext;
	List<UserRecord> list_adapter = new ArrayList<>();
	Integer[] imgid_adpater;

	public UserItemAdapter(Context context, int textViewResourceId,
			List<UserRecord> objects, Integer[] imgIDS) {
		super(context, textViewResourceId, objects);

		// TODO Auto-generated constructor stub
		mContext = context;
		list_adapter = objects;
		imgid_adpater = imgIDS;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		LayoutInflater li = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		v = li.inflate(R.layout.list_item, null);
		UserRecord single_record = list_adapter.get(position);
		TextView username = (TextView) v.findViewById(R.id.tvusername);
		TextView email = (TextView) v.findViewById(R.id.tvemail);
		ImageView imgview = (ImageView) v.findViewById(R.id.imgView);
		username.setText(single_record.username);
		email.setText(single_record.useremail);
		imgview.setImageResource(imgid_adpater[position]);
		return v;
	}

}
