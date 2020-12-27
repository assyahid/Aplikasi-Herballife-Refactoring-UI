package com.herballife.main;

import android.app.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class Cari_Penyakit  extends Activity implements TextWatcher , OnClickListener{
	 	TextView selection;
	    AutoCompleteTextView edit;
	    String[] items = { "Batuk Pada Anak", "Sakit Perut","Diare","Mual",
				"Kembung","Wasir","Biduran",
				"Demam","Step","Kencing Batu","Radang Paru-paru","Asma","Mimisan","Hepatitis",
				"Prostat","Keputihan","Diabetes Melitus","Bisul","Jerawat","Gatal berupa bintik-bintik merah bergelembung air",
				"Gatal pada bekas luka yang sudah kering","Nyeri haid","Haid bau anyir","Batuk Kering","Sariawan","Campak",
				"Borok","Jantung Lemah","Gangguan saraf","Rematik","Demam Pada Anak","Masuk Angin","Disentri","Hipertensi",
				"Diabetes","Kutu Air","Sakit Kepala","Flu","Bronkitis","Cacingan","Migrain","Maag","Cantengan","Osteoporosis"};
	   
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cari_penyakit);
       
     
       
       
       
        selection = (TextView) findViewById(R.id.selection);
        edit = (AutoCompleteTextView) findViewById(R.id.edit);
        edit.addTextChangedListener(this);
        edit.setAdapter(new ArrayAdapter<String>(this,
        		android.R.layout.simple_dropdown_item_1line,items));
        edit.setOnItemClickListener(new OnItemClickListener(){
        	

			
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent tambah = new Intent(Cari_Penyakit.this,Detail.class);
				String a = edit.getText().toString();
				tambah.putExtra("kirim_penyakit",a);
				startActivity(tambah);
			}
        	
});
    }
	public void onTextChanged(CharSequence s,int start,
								int count,int before){
		selection.setText(edit.getText());
		
		
	}
	public void beforeTextChanged(CharSequence s,int start,
									int count,int after){
		
	}
	public void afterTextChanged(Editable s){
		
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

