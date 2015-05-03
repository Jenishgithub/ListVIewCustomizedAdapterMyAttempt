package com.example.listviewcustomizedadaptermyattempt;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	UserItemAdapter adapter;
	List<UserRecord> mahlist = new ArrayList<>();
	Integer[] imgIDs = { R.drawable.elephantass, R.drawable.elephanttrunk,
			R.drawable.cartman, R.drawable.cuboids };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mahlist.add(new UserRecord("Jenish Shakya", "jenish_hope@yaoo.com"));
		mahlist.add(new UserRecord("Shrigesh", "shrigesh_dds@gmail.com"));
		mahlist.add(new UserRecord("Pranita", "shakyapranita14@hotmail.com"));

		ListView mahlistview = getListView();
		adapter = new UserItemAdapter(this, R.layout.list_item, mahlist, imgIDs);
		mahlistview.setAdapter(adapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		final int p = position;
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				MainActivity.this);
		alertDialogBuilder.setTitle("Freakshow");
		alertDialogBuilder.setMessage("Fucking choose");
		alertDialogBuilder.setCancelable(true);
		alertDialogBuilder.setPositiveButton("Delete",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						mahlist.remove(p);
						Log.d("jenish shakya", "the value of mahlist is now :"
								+ mahlist);

						adapter.notifyDataSetChanged();
						adapter.notifyDataSetInvalidated();
					}
				});

		alertDialogBuilder.setNegativeButton("No",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
		AlertDialog alertdialog = alertDialogBuilder.create();
		alertdialog.show();
	}

}
