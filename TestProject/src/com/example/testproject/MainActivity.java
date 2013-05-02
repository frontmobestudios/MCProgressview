package com.example.testproject;

import com.example.mcprogressview.MCProgress;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button buttonShow;
	Button buttonShowWithText;
	Button buttonShowWithDetail; 
	Button buttonOnlyText; 
	
	MCProgress progress;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        View v = findViewById(R.id.mainview); 
        progress = new MCProgress(this, v);

        
        buttonShow = (Button) findViewById(R.id.button1);
        buttonShowWithText = (Button) findViewById(R.id.button2);
        buttonShowWithDetail = (Button) findViewById(R.id.button3);
        buttonOnlyText = (Button) findViewById(R.id.button4);
        
        buttonShow.setOnClickListener(this);
        buttonShowWithText.setOnClickListener(this);
        buttonShowWithDetail.setOnClickListener(this);
        buttonOnlyText.setOnClickListener(this);

        
    }
   

	@Override
	public void onClick(View v)
	{
		switch (v.getId()) {
		case R.id.button1:
			progress.ShowMCProgress();
			hideProgress();
			break;
		case R.id.button2:
			progress.ShowMCProgressViewWithText("Loading...");
			hideProgress();
			break;
		case R.id.button3:
			progress.ShowMCProgressViewWithTextaAndDetail("Loading..", "Detail...");
			hideProgress();
			break;
		case R.id.button4:
			progress.ShowMCProgressOnlyText("Only text...");
			hideProgress();
			break;

		default:
			break;
		}
		
	}
	
	private void hideProgress()
	{
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		  @Override
		  public void run()
		  {
			  progress.hide();
		  }
		}, 3000);
		
	}
}
