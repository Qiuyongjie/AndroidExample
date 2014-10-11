package com.intent;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.net.*;



public class MainActivity extends ActionBarActivity {

    private Button btn_UrlOpen1;
    private Button btn_UrlOpen2;
    private Button btn_TelOpen;
    private Intent intent;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn_UrlOpen1=(Button)findViewById(R.id.urlBtn1);
        btn_UrlOpen2=(Button)findViewById(R.id.urlBtn2);
        btn_TelOpen=(Button)findViewById(R.id.telBtn);
    }
	
	public void onClick(View v)
	{
		switch(v.getId()){
		case R.id.urlBtn1:
			intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://iotpanda.tk"));
			startActivity(intent);
			break;
		case R.id.urlBtn2:
			intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
			startActivity(intent);
			break;
		case R.id.telBtn:
			intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:1008611"));
			startActivity(intent);
			break;
			
		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
