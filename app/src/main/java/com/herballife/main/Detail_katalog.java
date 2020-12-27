package com.herballife.main;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail_katalog extends Activity
{
	public static SQLiteDatabase db;
    SQLiteDBHelper helper;
	TextView nama;
	TextView guna;
	ImageView gambar;
	String cek;
	protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_katalog);
        Intent qwe = getIntent();
		cek = qwe.getStringExtra("kirim_tumbuhan");
        try 
        {
            helper = new SQLiteDBHelper(this);
        	db = helper.getDb();
        	
        }
        catch (SQLException e)
        {
        	Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
       String sql = "select * from Katalog where Nama ='"+cek+"'";
       Cursor c = db.rawQuery(sql, null);
       c.moveToFirst();
       nama = (TextView)findViewById(R.id.nama_tumbuhan);
       guna = (TextView)findViewById(R.id.kegunaan);
       gambar = (ImageView)findViewById(R.id.gambar);
       nama.setText(cek);
       int index1 = c.getColumnIndex("Kegunaan");
       int index3 = c.getColumnIndex("Gambar");
       byte[] image_byte = c.getBlob(index3); 
       Bitmap image = BitmapFactory.decodeByteArray(image_byte, 0, image_byte.length);
	   gambar.setImageBitmap(image);
       String use = c.getString(index1);
       guna.setText("Kegunaan : "+use);
	}
}