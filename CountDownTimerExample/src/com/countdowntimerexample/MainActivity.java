package com.countdowntimerexample;

import android.support.v7.app.ActionBarActivity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.*;


public class MainActivity extends ActionBarActivity {

    private MaCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted=false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private final long startTime=50 * 1000;
    private final long interval= 1 * 1000;
    
	
	
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startB=(Button)this.findViewById(R.id.Btn);

        
        text=(TextView)this.findViewById(R.id.timer);
        timeElapsedView=(TextView)this.findViewById(R.id.timeElapsed);
        countDownTimer=new MaCountDownTimer(startTime,interval);
        text.setText(text.getText()+String.valueOf(startTime));
    }

	public void onClick(View v)
	{	
       switch(v.getId()){
       case R.id.Btn:
				if(!timerHasStarted)
				{
					countDownTimer.start();
					timerHasStarted=true;
					startB.setText("Started");
				}
				else
				{
					countDownTimer.cancel();
					timerHasStarted=false;
					startB.setText("Reset");
				}
				break;
       }

      
       /*case R.id.Btn:
    	   new CountDownTimer(30000,1000) {//两个参数，前一个指倒计时的总时间，后一个指多长时间倒数一下。  
               
               @Override  
               public void onTick(long millisUntilFinished) {  
                   // TODO Auto-generated method stub  
                   text.setText("seconds remainling:"+ millisUntilFinished/1000);  
               }  
                 
               @Override  
               public void onFinish() {  
                   // TODO Auto-generated method stub  
                   text.setText("done");  
               }  
           }.start(); 
           break;
         */
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
    
    //CountDownTimer class
    public class MaCountDownTimer extends CountDownTimer
    {
    	public MaCountDownTimer(long startTime,long interval)
    	{
    		super(startTime,interval);
    	}
    	@Override
    	public void onFinish()
    	{
    		text.setText("Time's up!");
    		timeElapsedView.setText("Time Elapsed: "+String.valueOf(startTime));
    	}
    	@Override
    	public void onTick(long millisUntilFinished)
    	{
    		text.setText("Time remain:"+ millisUntilFinished);
    		timeElapsed=startTime-millisUntilFinished;
    		timeElapsedView.setText("Time Elapsed: "+String.valueOf(timeElapsed));
    	}
    
    }
}
