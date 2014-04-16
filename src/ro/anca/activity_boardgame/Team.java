package ro.anca.activity_boardgame;



public class Team {
	
	private String name;
	private int score;
	private String color;
		
	public Team()
	{
		this.name=null;
		this.score=0;
		this.color=null;
	}
	public Team(String name,String color)
	{
		this.name=name;
		score=0;
		this.color=color;
							
	}
	public String getName() {
		return name;
	}
	public void setName(String nume) {
		this.name= nume;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int scor) {
		this.score = scor;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}




}

