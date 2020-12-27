package com.herballife.main;


import android.app.Activity;
import android.app.AlertDialog;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener
{

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// memanggil layout activity_main.xml
		// untuk ngeset tombol klik untuk tombol yang ada
		
	 	View searchButton = findViewById(R.id.btn_search);
		searchButton.setOnClickListener(this);
		View catalogButton = findViewById(R.id.btn_catalog);
		catalogButton.setOnClickListener(this);		 
		View helpButton = findViewById(R.id.btn_help);
		helpButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.btn_exit);
		exitButton.setOnClickListener(this);
	}

	public void onClick(View v) 
	{ 
		switch (v.getId()) 
		{
		
		case R.id.btn_search: 
		Intent btn_search = new Intent(this, List.class ); 
		startActivity(btn_search); 
		break; 
		case R.id.btn_catalog: 
		Intent btn_catalog = new Intent(this, List_catalog.class ); 
		startActivity(btn_catalog);
		break;		 
		case R.id.btn_help:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("             Herbal Life  \n\n"
							+ "Herbal Life adalah \n"
							+ "aplikasi berbasis android \n"
							+ "yang berisi cara pengobatan penyakit\n"
							+ "terutama menggunakan tumbuhan herbal\n\n"
							+ "Menu Search:\n"
							+ "Digunakan untuk mencari jenis \n"
							+ "penyakit sesuai dengan keyword yang dimasukkan\n\n"
							+ "Menu Katalog:\n"
							+ "Berisi seluruh daftar tumbuhan \n"
							+ "yang bisa digunakan sebagai obat\n\n"
							+ "Application Name :\n\n"
							+ "Herbal Life v1.0.0\n\n" + "Developed By : \n\n"
							+ "Nama : Fajar Teguh \n"
							+ "Nrp    : 2103121006 \n"
							+ "Nama : Abdurachman Rizal    \n"
							+ "Nrp    : 2103121007 \n"
							+ "Nama : Moch Fajar Ramadhan \n"
							+ "Nrp    : 2103121027\n\n")
					.setCancelable(false)
					.setPositiveButton("OK",new DialogInterface.OnClickListener() 
							{
								public void onClick(DialogInterface dialog,int id) 
								{
									dialog.cancel();
								}
							});
			AlertDialog judul = builder.create();
			judul.setIcon(R.drawable.help);
			judul.setTitle("Help");
			judul.show();
			break;
		case R.id.btn_exit:
			AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
			builder2.setMessage("Apakah anda benar-benar ingin keluar?")
					.setCancelable(false)
					.setPositiveButton("Tidak",new DialogInterface.OnClickListener() 
							{
								public void onClick(DialogInterface dialog,int id)
								{
									dialog.cancel();
								}
							})
					.setNegativeButton("Ya",new DialogInterface.OnClickListener() 
							{
								public void onClick(DialogInterface dialog,int id) 
								{
									MainActivity.this.finish();
								}
							});
			AlertDialog judul2 = builder2.create();
			judul2.setIcon(R.drawable.exit);
			judul2.setTitle("Exit");
			judul2.show();
			break;
		}
	}

}