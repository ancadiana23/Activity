package ro.anca.activity_boardgame;


import java.util.ArrayList;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity{
	Button b3,b4,b5,yes,no;	
	 Bitmap img1,img2,img3;
	int h1=100,h2=120,h3=130,w1=120,w2=140,w3=130;
	CountDownTimer count;
	ArrayList<Team> dataList;
	boolean right1=true,right2=true,right3=true;
		
	int current_team=0,nivel=0,h,w;
	String word=" ";
	TextView t,cuv,timer,mytext;
	MyApp app;
	boolean timetochoose=true;
	LinearLayout chooseLayout,levelButtons;
	View v;
	SurfaceView surface;
	SurfaceHolder holder;
	Canvas canvas;
	String action=" ";
	String words[];
	ArrayList<Bitmap> bitmap=new ArrayList<Bitmap>();
	
	final int[] ntalk={1,4,5,7,10,12,17,26,28,30,36,42,43,45,49};
	final int[] nsharades={3,6,9,14,15,18,19,20,24,27,29,34,35,37,40,44,47,48};
	
	final String[] draw={ "caucazian","talc","PMS","senzor","secretie","tranzistor","Velociraptor","rumegus","laser tag","minion","arhitectura","efervescent","ad-hoc","concomitent","stingher","obiect","Moartea caprioarei","portret robot","conexiune","abstract","calomnie","concept","xenofob","utopie","cataclism","paradox","recensamant","plasma","Morometii","colaborare"};
	final String[] sharades={"efervescent","croaziera","sclav","stingher","vector","matrice","andrele","mansarda","voltaj","HD","flagel","xenofob","limbric","caucazian","senzor","manusi de scos tava din cuptor","biblioraft","recensamant","recalcitrant","plasma","puericultura","calomnie","concept","concomitent","sperjur","cataclism","prerogativ","psoriazis","pachiderm","fonetic"};
	final String[] talk={"flagel","utopie","cataclism","paradox","psoriazis","fonetic","obiect","recensamant","sperjur","focar","inchiriere de ambarcatiuni","pachiderm","L'Hospital","cuart","spectroscop","palmares","irefutabil","monocotiledonat","vizuina de vulpe","rezonanta","puericultura","decapant","caleidoscop","brau de lana","leandru","ser fiziologic","ornitorinc de plus","chestie dubioasa","rasol de porc","compot de sarmale"};
	
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);	
		
		chooseLayout=(LinearLayout) findViewById(R.id.choose);
		levelButtons=(LinearLayout)findViewById(R.id.buttons);
		v=findViewById(R.layout.activity);
		
		chooseLayout.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		
		app=(MyApp)getApplication();
		dataList=app.getDataList();	
		
		surface=(SurfaceView) findViewById(R.id.surface);
		holder=surface.getHolder();
		t=(TextView) findViewById(R.id.mytext);
		cuv =(TextView) findViewById(R.id.word);	
		timer=(TextView) findViewById(R.id.timer);
		
		timer.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		
		mytext=(TextView) findViewById(R.id.mytext);
		
		
		Display display = getWindowManager().getDefaultDisplay();
		w=display.getWidth();
		h=display.getHeight();
		
		/*chooseLayout.setTop(top);
		chooseLayout.setBottom(bottom);
		chooseLayout.setRight();
		chooseLayout.setLeft(left);*/
		
		mytext.setTextSize(w/40);
		cuv.setTextSize(w/20);
		timer.setTextSize(w/40);
	/*	b3.setHeight(h/20);
		b3.setWidth(h/30);
		b4.setHeight(h/20);
		b4.setWidth(h/30);
		b5.setHeight(h/20);
		b5.setWidth(h/30);*/
	
		b3=(Button)findViewById(R.id.b3);
		b4=(Button)findViewById(R.id.b4);
		b5=(Button)findViewById(R.id.b5);	
		
		yes=(Button)findViewById(R.id.yes);
		no=(Button)findViewById(R.id.no);
		
		holder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder arg0) {
				// TODO Auto-generated method stub
				setPawns();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
		});
	
		
	}
	
	public void Buttons()
	{
		int pos =find(dataList.get(current_team).getScore());
		
		switch(pos){
		case 0: {
			
			action="explicati";
			words=talk;
			b3.setBackgroundResource(R.drawable.fetita3);
			b4.setBackgroundResource(R.drawable.fetita4);
			b5.setBackgroundResource(R.drawable.fetita5);
			} break;
	
		case 1: {
			words=sharades;
			action="mimati";
			b3.setBackgroundResource(R.drawable.mim3);
			b4.setBackgroundResource(R.drawable.mim4);
			b5.setBackgroundResource(R.drawable.mim5);
			}break;
		case 2:{
			words=draw;
			action="desenati";
			b3.setBackgroundResource(R.drawable.creion3);
			b4.setBackgroundResource(R.drawable.creion4);
			b5.setBackgroundResource(R.drawable.creion5);
		}break;		
		}
		 b3.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					nivel=3;
					choose(0,action,words);} }); 	 
			
		 b4.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					nivel=4;
					choose(1,action,words);}}); 		
		 b5.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					nivel=5;
					choose(2,action,words);}  }); 	
		 
		
	}
	
	public void choose(int d, String action, String[] words)
	{
		
		
		b3.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		b4.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		b5.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		
		yes.setVisibility(1);
		no.setVisibility(1);
		
		yes.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					nextRound(true);
				}  }); 	
		no.setOnClickListener(new OnClickListener() {	        	
			@Override
			public void onClick(View arg0) {
				nextRound(false);
			}  }); 	
		
		
		word=words[(int) (Math.random()*10+d*10-1)];
		t.setText("Aveti un minut sa "+action+" cuvantul:");
		cuv.setVisibility(1);
		cuv.setText(word);
	
		timer.setText("1:00");
		timer.setVisibility(1);
		count =new CountDownTimer(62000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				if((millisUntilFinished/1000)!=61)
					if(millisUntilFinished>=11000)
						timer.setText("0:"+((millisUntilFinished/1000)-1));
					else timer.setText("0:0"+((millisUntilFinished/1000)-1));
				
			}
			
			@Override
			public void onFinish() {
				// TODO Auto-generated method stub
				nextRound(false);
				
			}
		};
		count.start();
	}
	
	public int find(int pos)
	{
		for(int i=0;i<ntalk.length;i++)
		{
			if(pos==ntalk[i]) return 0;
		}
		for(int i=0;i<nsharades.length;i++)
			{if(pos==nsharades[i]) return 1;}
		return 2;
	}
	
	
	
	public boolean onTouchEvent(MotionEvent event)
	{
		
		if(event.getAction()==MotionEvent.ACTION_DOWN)
		{
			if(timetochoose)
			{
			chooseLayout.setVisibility(1);
			yes.setVisibility(TRIM_MEMORY_UI_HIDDEN);
			no.setVisibility(TRIM_MEMORY_UI_HIDDEN);
			b3.setVisibility(1);
			b4.setVisibility(1);
			b5.setVisibility(1);
			t.setText("Alegeti un nivel de dificultate");
			cuv.setVisibility(TRIM_MEMORY_UI_HIDDEN);
			timer.setVisibility(TRIM_MEMORY_UI_HIDDEN);
			timetochoose=false;
			Buttons();
			
			return true;}
		}
		return false;
	}


	
	public void nextRound(boolean b)
	{
		
		count.cancel();
		chooseLayout.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		
		
		
		if(b)
		{
			if(dataList.get(current_team).getScore()+nivel>50)
			{
				Intent victory=new Intent(MainActivity.this,Victory.class);
				victory.putExtra("team", dataList.get(current_team).getName());
				startActivity(victory);
				finish();
			}		
			
		for(int i=0;i<nivel;i++)
		{
			dataList.get(current_team).setScore(dataList.get(current_team).getScore()+1);
			
						
				switch(current_team)
				{
				case 0: {
					if(dataList.get(current_team).getScore()%4==1&&dataList.get(current_team).getScore()!=1)
					{
						if(right1) right1=false;
						else right1=true;
						w1=w1+w/30;	
					}
					else
					{
						if(right1)
						h1=h1+h/30;
						else h1=h1-h/30;
					}
					movePawns(0);
				}break;
				case 1: {
					if(dataList.get(current_team).getScore()%4==1&&dataList.get(current_team).getScore()!=1)
					{if(right2) right2=false;
					else right2=true;
						w2=w2+100;		
					}
					else
					{
						if(right2)
						h2=h2+120;
						else h2=h2-120;
					}	
					movePawns(1);				
				}break;
				case 2:
				{
					if(dataList.get(current_team).getScore()%4==1&&dataList.get(current_team).getScore()!=1)
					{
						if(right3) right3=false;
						else right3=true;
						w3=w3+100;
					}
					else
					{
						if(right3)
						h3=h3+120;
						else h3=h3-120;
					}		
					movePawns(2);
				}break;
				}			
			}
		
		}
		if(current_team<dataList.size()-1) current_team++;
		else current_team=0;
		Toast.makeText(this, "Este randul echipei "+dataList.get(current_team).getName(),Toast.LENGTH_SHORT).show();
		timetochoose=true;
	}
	public int choosePawn(int pos)
	{
		int pawn = 0;
        if(dataList.get(pos).getColor()=="#FB0404") pawn=R.drawable.red;
		else
			if(dataList.get(pos).getColor()=="#EFF709") pawn=R.drawable.yellow;
			else
				if(dataList.get(pos).getColor()=="#12F90F") pawn=R.drawable.green;
				else
					if(dataList.get(pos).getColor()=="#F8A109") pawn=R.drawable.orange;
					else
						if(dataList.get(pos).getColor()=="#0689F9") pawn=R.drawable.blue;
						else
							if(dataList.get(pos).getColor()=="#900664") pawn=R.drawable.purple;
	return pawn;
	}
	
	public void setPawns()
	{	
           	 int h_canvas,w_canvas;
           	 
                canvas = holder.lockCanvas();
                Bitmap background=BitmapFactory.decodeResource(getResources(), R.drawable.board);
                h_canvas= canvas.getHeight();
                w_canvas=canvas.getWidth();
                        							
          
                canvas.drawBitmap(Bitmap.createScaledBitmap(background, w_canvas, h_canvas, false), 0, 0, null);
           	 
                img1=BitmapFactory.decodeResource(getResources(), choosePawn(0));
                canvas.drawBitmap(img1, w1, h1, null); 
                
                img2=BitmapFactory.decodeResource(getResources(), choosePawn(1));
                canvas.drawBitmap(img2, w2, h2, null);  
                
                if(dataList.size()==3)
                {
               	img3=BitmapFactory.decodeResource(getResources(), choosePawn(2));
                    canvas.drawBitmap(img3, w3, h3, null); 
                }
           	 
            
                holder.unlockCanvasAndPost(canvas);
           
	}
	public void movePawns(int team)
	{	
           	 int h_canvas,w_canvas;
           	 
                canvas = holder.lockCanvas();
                Bitmap background=BitmapFactory.decodeResource(getResources(), R.drawable.board);
                h_canvas= canvas.getHeight();
                w_canvas=canvas.getWidth();
                        							
          
                canvas.drawBitmap(Bitmap.createScaledBitmap(background, w_canvas, h_canvas, false), 0, 0, null);
                switch(team)
                {
                case 0:
                {
                	img1=BitmapFactory.decodeResource(getResources(), choosePawn(0));
                	canvas.drawBitmap(img1, w1, h1, null); 
                }break;
                case 1:
                {
                	img2=BitmapFactory.decodeResource(getResources(), choosePawn(1));
                	canvas.drawBitmap(img2, w2, h2, null);  
                }break;
                case 2:
                {
                	img3=BitmapFactory.decodeResource(getResources(), choosePawn(2));
                	canvas.drawBitmap(img3, w3, h3, null); 
                }break;
                }
            
                holder.unlockCanvasAndPost(canvas);
           
	}
}
