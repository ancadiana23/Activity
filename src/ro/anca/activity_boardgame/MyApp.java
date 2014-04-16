package ro.anca.activity_boardgame;

import java.util.ArrayList;

import android.app.Application;

public class MyApp extends Application{
	 
private ArrayList<Team> dataList;

public ArrayList<Team> getDataList() {
	return dataList;
}

public void setDataList(ArrayList<Team> dataList) {
	this.dataList = dataList;
}


	

}
