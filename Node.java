import java.util.*;
import java.io.*;

public class Node{

	private int x;//x coordinate
	private int y;//y coordinate
	private int z;//z coordinate
	private String name; //if null, the node is empty
	private Bee b;
	private int value;//numebr of moves from start
	private boolean visited;//if visited, true

	public Node(){

	}

	public Node(int x, int y, int z){
		this.x = x; this.y = y; this.z = z; value = 0; visited = false; name = "null";
	}

	public Node(int x, int y, int z, String n){
		this.x = x; this.y = y; this.z = z; name = n; value = 0; visited = false;
	}


	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public int getZ(){return this.z;}
	public String getName(){return this.name;}
	public Bee getBee(){return b;}
	public int getVal(){return this.value;}
	public boolean getVisited(){return visited;}
	
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setZ(int z){this.z = z;}
	public void setName(String n){this.name = n;}
	public void setBee(Bee b){this.b = b;}
	public void setVal(int i){this.value = i;}
	public void setVisited(boolean b){visited = b;}
	public String toString() {
		return ("(" + x + ", " + y + ", " + z + ")");
	}

}

