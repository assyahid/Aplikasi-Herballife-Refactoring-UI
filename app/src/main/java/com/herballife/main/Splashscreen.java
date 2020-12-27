package com.herballife.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;
 
public class Splashscreen extends Activity
{
	 ProgressBar bar;
	 TextView txt;
	 int total=0;
	 Intent intent;
	 boolean isRunning=false;

	 // handler for the background updating
	 Handler handler=new Handler() 
	 {
	 //coding ini yang akan menampilkan berapa persen progress yang telah dijalani.
	 @Override
	 public void handleMessage(Message msg) 
	 {
	 total=total+20;
	 String perc=String.valueOf(total).toString();
	 txt.setText(perc+"% Completed");
	 bar.incrementProgressBy(20);
	 }
	 };

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		bar=(ProgressBar)findViewById(R.id.prog);
		txt=(TextView)findViewById(R.id.load);

	}
		
	public void onStart() 
	{
	 super.onStart();
	 
	 // reset the bar to the default value of 0
	 bar.setProgress(0);
	 
	 final Splashscreen sPlashScreen = this; 
	 // create a thread for updating the progress bar
	 Thread background=new Thread(new Runnable() {
	 
	 public void run() {
	 try {
	 for (int i=0;i<5 && isRunning;i++) {
		 
	 // wait 1000ms between each update
	 Thread.sleep(1000);
	 handler.sendMessage(handler.obtainMessage());
	 }
	 finish();
}
	 catch (Throwable t) {
	
	   }

	 Intent intent = new Intent();
//Coba merupakan nama activity yang kita isi saat pertama kali membuat project, jadi harus disesuaikan dengan nama activity yang kalian buat ya :))
//coding ini akan dijalankan ketika objek sPlashScreen yang merupakan objek langsung dari class Loading telah selesai maka Coba.class akan diproses atau dijalankan.
		intent.setClass(sPlashScreen, MainActivity.class);
		startActivity(intent);
	 }
	 
	 });
	 
	 isRunning=true;
	
	  // start the background thread
	 background.start();
	 
	 }
	
	 public void onStop() {
		 super.onStop();
	 isRunning=false;
	
		 }
}