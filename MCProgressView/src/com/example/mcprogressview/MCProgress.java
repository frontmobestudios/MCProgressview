package com.example.mcprogressview;

import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MCProgress
{
	
	LayoutInflater layoutInflater;
	Context myContext;
	View parentView; 
	
	int progressID; 
	int textViewID;
	
	RelativeLayout myView; 
	
	
	public MCProgress(Context context, View p) 
	{
		myContext = context;
		parentView = p;
	}
	
	
	public void hide()
	{
		enableDisableViewGroup(((ViewGroup) parentView), true);
		((ViewGroup) parentView).removeView(myView);

	}
	public void ShowMCProgress()
	{
				
		
		enableDisableViewGroup(((ViewGroup) parentView), false);

		myView = getViewBackground();
		RelativeLayout r = getProgressBackground();
		
		r.addView(getProgressBar());
		myView.addView(r);
		
		
		int addIndex = ((ViewGroup) parentView).getChildCount(); 
				
		((ViewGroup) parentView).addView(myView, addIndex);
		
		

	}
	
	
	public void ShowMCProgressViewWithText(String text)
	{
		
		
		
		enableDisableViewGroup(((ViewGroup) parentView), false);

		myView = getViewBackground();
		RelativeLayout r = getProgressBackground();
		
		r.addView(getProgressBar());
		r.addView(getTextView(text));
		myView.addView(r);
		
		
		int addIndex = ((ViewGroup) parentView).getChildCount(); 
		
		
		((ViewGroup) parentView).addView(myView, addIndex);
		
		
			
	}
	
	public void ShowMCProgressViewWithTextaAndDetail(String text, String detail)
	{		
		
		enableDisableViewGroup(((ViewGroup) parentView), false);

		myView = getViewBackground();
		RelativeLayout r = getProgressBackground();
		
		r.addView(getProgressBar());
		r.addView(getTextView(text));
		r.addView(getDetailTextView(detail));
		myView.addView(r);
		
		
		int addIndex = ((ViewGroup) parentView).getChildCount(); 
		
		
		((ViewGroup) parentView).addView(myView, addIndex);
				
			
	}
	
	public void ShowMCProgressOnlyText(String text)
	{
				
		
		enableDisableViewGroup(((ViewGroup) parentView), false);

		myView = getViewBackground();
		RelativeLayout r = getProgressBackground();
		
		r.addView(getTextView(text));
		myView.addView(r);
		
		
		int addIndex = ((ViewGroup) parentView).getChildCount(); 
				
		((ViewGroup) parentView).addView(myView, addIndex);
		
		
			
	}
	
	private TextView getTextView(String text)
	{
		
		TextView textView = new TextView(myContext);
		textView.setText(text); 
		RelativeLayout.LayoutParams textViewParams = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		textViewParams.addRule(RelativeLayout.BELOW, progressID);
		
		textViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

		textView.setLayoutParams(textViewParams); 
		
		textView.setGravity(Gravity.CENTER_HORIZONTAL);
		
		textView.setId(1234);
		
		textViewID = textView.getId(); 
		
		textView.setTextColor(Color.WHITE);
		
		textView.setTextSize(18);
		
		return textView; 
		
	}
	private TextView getDetailTextView(String text)
	{
		
		TextView textView = new TextView(myContext);
		textView.setText(text); 
		RelativeLayout.LayoutParams textViewParams = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		textViewParams.addRule(RelativeLayout.BELOW, textViewID);
		textViewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
		textViewParams.setMargins(2, 0, 2, 0);	
		
		textView.setLayoutParams(textViewParams); 
		
		textView.setGravity(Gravity.CENTER_HORIZONTAL);
		
		textView.setTextColor(Color.WHITE);

		
		
		textView.setTextSize(13);
		
		return textView; 
		
	}
	
	
	private ProgressBar getProgressBar()
	{
		ProgressBar progressbar = new ProgressBar(myContext);
		
		RelativeLayout.LayoutParams progressbarParams = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		
		progressbarParams.addRule(RelativeLayout.CENTER_HORIZONTAL);


		
		progressbar.setId(1337); 
		progressID = progressbar.getId();
		
		progressbar.setLayoutParams(progressbarParams);
		
		return progressbar;
		
	}

	private RelativeLayout getViewBackground()
	{
		RelativeLayout backGround = new RelativeLayout(myContext);
		

		RelativeLayout.LayoutParams backgroundsParams = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT, 
                    RelativeLayout.LayoutParams.MATCH_PARENT);
		

		backGround.setBackgroundResource(color.transparent);
		
		backGround.setLayoutParams(backgroundsParams);
		
		return backGround; 
	
		
	}
	private RelativeLayout getProgressBackground()
	{
		RelativeLayout backGround = new RelativeLayout(myContext);
		
		RelativeLayout.LayoutParams backgroundsParams = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
		
		backgroundsParams.addRule(RelativeLayout.CENTER_IN_PARENT);
		backgroundsParams.addRule(LinearLayout.VERTICAL);
		
		
		
		backGround.setBackgroundResource(R.layout.rectangle);
		
		backGround.setPadding(10, 10, 10, 10);
		
		backGround.setLayoutParams(backgroundsParams);
		
		return backGround; 
	
		
	}

	
	 private static void enableDisableViewGroup(ViewGroup viewGroup, boolean enabled) {
		    int childCount = viewGroup.getChildCount();
		    for (int i = 0; i < childCount; i++) {
		      View view = viewGroup.getChildAt(i);
		      view.setEnabled(enabled);
		      if (view instanceof ViewGroup) {
		        enableDisableViewGroup((ViewGroup) view, enabled);
		      }
		    }
		  }



}
