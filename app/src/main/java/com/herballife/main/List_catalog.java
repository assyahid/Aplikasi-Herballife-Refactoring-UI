package com.herballife.main;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class List_catalog extends Activity
{
	SQLiteDBHelper helper;
	public static SQLiteDatabase db;
	public ListView list;
	int checked = -1;
	ArrayList<String > listitem1 = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	 protected void onCreate(Bundle savedInstanceState)
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list_katalog);
	        try 
	        {
	        	helper = new SQLiteDBHelper(this);
				db = helper.getDb();
				String sql = "select * from Katalog";
				Cursor c = db.rawQuery(sql, null);
				c.moveToFirst();


				int i = 0;
				while (!c.isAfterLast())
				{
					int index = c.getColumnIndex("Nama");
					String temp = c.getString(index);
					listitem1.add(temp);

					i++;
					c.moveToNext();
				}
				list = (ListView) findViewById(R.id.list_tumbuhan);
				adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listitem1);

				list.setAdapter(adapter);
				list.setOnItemClickListener(new OnItemClickListener()
				{


					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
					{
						checked = arg2;
						String tumbuhan = listitem1.get(checked);

						Intent tambah = new Intent(List_catalog.this,Detail_katalog.class);
						tambah.putExtra("kirim_tumbuhan",tumbuhan);
						startActivity(tambah);
						//Toast.makeText(getApplicationContext(),"anda mengklick = " +listitem1.get(checked).toString(),Toast.LENGTH_SHORT).show();

					}

				});

			}
	        catch (SQLException e)
	        {
				Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
			}

  }
}