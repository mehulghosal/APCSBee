import java.util.*;
import java.io.*;

public class Main{

	public static Node[][][] grid;

	public static void setup(){

	}

	public static void read(){
		try{
			Scanner s = new Scanner(new File("test.txt"));
			s.nextLine();
			String firstLn = s.nextLine();
			int size = Integer.parseInt(firstLn.split(",")[0]);
			Node[][][] g = new Node[size][size][size];

			//set up the 
			for(int i = 0; i<15; i++){

			}

		}
		catch(Exception e){
			System.out.println("Reading failed");
		}

		grid = g;
	}

	public static void main(String[] args){


	}


}