package ro.anca.activity_boardgame;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartPage extends Activity{
	Button startGame,rules,back;
	TextView rulesText;
	LinearLayout startButtons,startFrame;
	int h,w;
	
	
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_page);	
		startGame=(Button) findViewById(R.id.startGame);
		rules=(Button)findViewById(R.id.rules);
		rulesText=(TextView)findViewById(R.id.rulesText);
		startButtons=(LinearLayout)findViewById(R.id.startButtons);
		back=(Button)findViewById(R.id.back);
		
		rulesText.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		back.setVisibility(TRIM_MEMORY_UI_HIDDEN);
		
		

		
		Display display = getWindowManager().getDefaultDisplay();
		w=display.getWidth();
		h=display.getHeight();
		
		rulesText.setPadding(w/10, h/10, w/10, h/10);		
		rulesText.setTextSize(h/35);
		back.setTextSize(h/35);
		rules.setTextSize(h/35);
		startGame.setTextSize(h/35);
		
		
	
		
		 startGame.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					Intent startGame=new Intent(StartPage.this,Start.class);
					startActivity(startGame);
					finish();
					
				}  
			});
		 rules.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					startButtons.setVisibility(TRIM_MEMORY_UI_HIDDEN);
					rulesText.setVisibility(1);
					back.setVisibility(1);					
					rulesText.setText("Acest joc poate fi jucat de 2 sau 3 echipe a cate cel putin 2 jucatori."+ '\n' +'\n'+
							"La fiecare runda echipa isi poate alege unul din cele 3 nivele de dificultate (3,4,5)"+'\n'+
							"urmand sa primeasca punctaje corespunzatoare"+'\n'+'\n'+
							"In functie de locul de pe tabla al pionului fiecarei echipe, un membru al echipei va trebui" +'\n' +
							"sa mimeze, explice sau deseneze cuvantul generat de aplicatie."+'\n'+'\n'+
							"Ceilalti membrii ai echipei trebuie sa il ghiceasca intr-un minut pentru a inainta in joc"+'\n');				
				}  
			});
		 back.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					startButtons.setVisibility(1);
					rulesText.setVisibility(TRIM_MEMORY_UI_HIDDEN);
					back.setVisibility(TRIM_MEMORY_UI_HIDDEN);					
					rulesText.setText(" ");				
				}  
			});
	
	
	
	
	
	
	}

}
