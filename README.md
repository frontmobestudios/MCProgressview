MCProgressview
==============

a simple progressview for android 


Just refrence MCProgressView as a library in your project. 


To create a new progressView 

  MCProgress progress;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        View v = findViewById(R.id.mainview); 
        progress = new MCProgress(this, v);

        
        progress.ShowMCProgressViewWithText("Loading text");
        
        /*  more functions 
        progress.ShowMCProgress();
        progress.ShowMCProgressViewWithTextaAndDetail("Loading", "Detail");
        progress.ShowMCProgressOnlyText("OnlyText");
        */
        
        // To hide call
        //  progress.hide();
        
    }

