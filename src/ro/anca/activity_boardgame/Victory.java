package ro.anca.activity_boardgame;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Victory extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.victory);	
		
		String name=getIntent().getStringExtra("team");
		TextView text=(TextView) findViewById(R.id.victoryText);
		text.setText("A castigat echipa "+name);
	}

}
