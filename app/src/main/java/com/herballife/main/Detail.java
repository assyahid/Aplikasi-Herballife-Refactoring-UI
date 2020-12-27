package com.herballife.main;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Detail extends Activity  implements OnClickListener
{
	public static SQLiteDatabase db;
    SQLiteDBHelper helper;
	TextView nama;
	TextView bahan;
	TextView tutor;
	Button button;
	String cek;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_penyakit);
        Intent qwe = getIntent();
		cek = qwe.getStringExtra("kirim_penyakit");
        try {
            helper = new SQLiteDBHelper(this);
        	db = helper.getDb();
        	
        	
        } 
        catch (SQLException e)
        {
        	Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
       String sql = "select * from data_penyakit where Nama ='"+cek+"'";
       Cursor c = db.rawQuery(sql, null);
       c.moveToFirst();
       nama = (TextView)findViewById(R.id.daftar_penyakit);
       bahan =(TextView)findViewById(R.id.bahan);
       button = (Button)findViewById(R.id.button1);
       tutor = (TextView)findViewById(R.id.tutorial);
       nama.setText(cek);
       int index1 = c.getColumnIndex("BahanObat");
       int index2 = c.getColumnIndex("Tutorial");
       String alat = c.getString(index1);
       String tutorial = c.getString(index2);
       bahan.setText("Bahan : " +alat);
       tutor.setText("Cara Menggunakan : "+tutorial);
       button.setOnClickListener(this);
	
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent tombol = new Intent(this, List_catalog.class);
		startActivity(tombol);
	}
}
