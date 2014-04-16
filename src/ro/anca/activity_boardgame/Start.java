package ro.anca.activity_boardgame;


import java.util.ArrayList;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
 
public class Start extends Activity{ 
	ArrayList<String> colors;
	ArrayList<Team> dataList ;
	Button b1,b2,b3,start;
	public Team team1,team2,team3;
	EditText name1,name2,name3;
	int count1=0,count2=0,count3=0;
	TextView text1,text2,text3;
	int h,w;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);	
		 name1=(EditText) findViewById(R.id.name1);
		 name2=(EditText) findViewById(R.id.name2);
		 name3=(EditText) findViewById(R.id.name3);
		 
		 
		 b1=(Button) findViewById(R.id.color1);
		 b2=(Button) findViewById(R.id.color2);
		 b3=(Button) findViewById(R.id.color3);
		 start=(Button)findViewById(R.id.start);
		
		colors=new ArrayList<String>();
		colors.add("#FB0404");
		colors.add("#12F90F");
		colors.add("#EFF709");
		colors.add("#F8A109");
		colors.add("#0689F9");
		colors.add("#900664");
		

		Display display = getWindowManager().getDefaultDisplay();
		w=display.getWidth();
		h=display.getHeight();

		text1=(TextView) findViewById(R.id.text1);
		text1.setTextSize(h/20);
		text2=(TextView) findViewById(R.id.text2);
		text2.setTextSize(h/20);
		text3=(TextView) findViewById(R.id.text3);
		text3.setTextSize(h/20);
		
		start.setTextSize(h/25);
		start.setPadding(h/40, h/50,h/40, h/50);
		
		
		team1=new Team();
		team2=new Team();
		team3=new Team();
		
		 b1.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
				if(name1.getText().length()!=0)
					team1.setName(name1.getText().toString());
					else if(team1.getName()==null)
						team1.setName("cu numarul 1");
					
					if(team1.getColor()!=null)
						colors.add(team1.getColor());
					team1.setColor(colors.get(count1));
					b1.setBackgroundColor(Color.parseColor(colors.get(count1)));
					colors.remove(count1++);
					if(count1==colors.size()) count1=0;
					
				}  
			});
		 b2.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					if(name2.getText().length()!=0)
						team2.setName(name2.getText().toString());
						else if(team2.getName()==null)
							team2.setName("cu numarul 2");
				
					if(team2.getColor()!=null)
						colors.add(team2.getColor());
					team2.setColor(colors.get(count2));
					b2.setBackgroundColor(Color.parseColor(colors.get(count2)));
					colors.remove(count2++);
					if(count2==colors.size()) count2=0;
					
					
					
					
				}  
			});
		 
		 b3.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
					if(name3.getText().length()!=0)
						team3.setName(name3.getText().toString());
						else if(team3.getName()==null)
							team3.setName("cu numarul 1");
					
					
					if(team3.getColor()!=null)
						colors.add(team3.getColor());
					team3.setColor(colors.get(count3));
					b3.setBackgroundColor(Color.parseColor(colors.get(count3)));
					colors.remove(count3++);
					if(count3==colors.size()) count3=0;
					
				}  
			});
		 
		 start.setOnClickListener(new OnClickListener() {	        	
				@Override
				public void onClick(View arg0) {
				if(team1.getName()==null||team2.getName()==null)
					Toast.makeText(Start.this, "Trebuie sa existe cel putin 2 echipe!",Toast.LENGTH_SHORT).show();
				else {
					Intent startGame=new Intent(Start.this,MainActivity.class);
					dataList = new ArrayList<Team>();
					dataList.add(team1);
					dataList.add(team2);	
					if(team3.getName()!=null)
					{						
						dataList.add(team3);
					}
								
					MyApp app=(MyApp)getApplication();
					app.setDataList(dataList);
					startActivity(startGame);
					finish();
					}
					
				}  
			});
		 
		 
	}
}
