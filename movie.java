/*
Charlie, Dylan, PT, Ray
5/1/2016
Movie List
*/

public class movie{
	private String title;
	private int release;
	private int code;
	private int rtScore;
	private boolean inStock = false;

	public movie(String title0, int release0, int code0, int rtScore0, boolean inStock0){
		title = title0;
		release = release0;
		code = code0;
		rtScore = rtScore0;
		inStock = inStock0
	}

	public int getRdate(){
		return release;
	}
	public String getTitle(){
		return title;
	}
	public int getRTscore(){
		return  rtScore;
	}
	public int getCode(){
		return code;
	}
	public boolean checkStock(){
		return inStock;
	}

	public static void main(String[] args){
		movie movie1 = new movie("Step Brothers", 20110616, 00001, 98, true);

		movie movie2 = new movie("Up", 20090411, 00002, 87, true);

		movie movie3 = new movie("Mighty Ducks", 19861008, 00003, 92, true);

		movie movie4 = new movie("Doogle", 20070819, 00004, 6, true);

		movie movie5 = new movie("Ping Pong Summer", 20120612, 00005, 2, true);

		movie movie6 = new movie("Catch Me if You Can", 20030906, 00006, 99, true);

		movie movie7 = new movie("Dylan's Feeling 22'", 20150416, 00007, 22, true);

		movie movie8 = new movie("This Weekend", 20160422, 00008, 91, true);

		movie movie9 = new movie("Everybody Loves Ray", 20021114, 00009, 63, true);

		movie movie10 = new movie("Sub-par Programmer", 20150902, 00010, 43, true);

		

	}



}