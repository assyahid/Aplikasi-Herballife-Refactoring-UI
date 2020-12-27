package com.herballife.main;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class List extends Activity  implements OnClickListener
{
	public static SQLiteDBHelper db;
	SQLiteDatabase database;
	public ListView list;
	Button button;
	int checked = -1;
	ArrayList<String > listitem1 = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	 protected void onCreate(Bundle savedInstanceState)
	 {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list);
	        try 
	        {
	        	db = new SQLiteDBHelper(this);
						//SQLiteDatabase.openDatabase(getDatabasePath("data2.sqlite").getAbsolutePath(),null,SQLiteDatabase.CREATE_IF_NECESSARY);
	        	database = db.getDb();
	        } 
	        catch (SQLException e)
	        {
	        	Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
	        }
	       String sql = "select * from data_penyakit ";
	       Cursor c = database.rawQuery(sql, null);
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
	       list = (ListView) findViewById(R.id.listpenyakit);
	       adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listitem1);
	  
	       list.setAdapter(adapter);
	       list.setOnItemClickListener(new OnItemClickListener(){
	        	

				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
				{
					checked = arg2;
					String penyakit = listitem1.get(checked);
					
					Intent tambah = new Intent(List.this,Detail.class);
					tambah.putExtra("kirim_penyakit",penyakit);
					startActivity(tambah);
					//Toast.makeText(getApplicationContext(),"anda mengklick = " +listitem1.get(checked).toString(),Toast.LENGTH_SHORT).show();
					
				}
	        	
	        });
	       button = (Button)findViewById(R.id.tombol_cari);
	       button.setOnClickListener(this);
	       
	  
  }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent tombol = new Intent(this, Cari_Penyakit.class);
		startActivity(tombol);
		
	}
}
