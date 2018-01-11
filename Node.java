import java.util.*;
import java.io.*;

public class Node{

	private int x;//x coordinate
	private int y;//y coordinate
	private int z;//z coordinate
	private String name; //if null, the node is empty
	private Bee b;

	private Node parentNode;//the node that connects to this
	private int gCost;//distance from starting Node
	private int hCost;//cost to end Node
	private int fCost;//sum of g and h


	public Node(){

	}

	public Node(int x, int y, int z){
		this.x = x; this.y = y; this.z = z; name = "Bee";
	}

	public Node(int x, int y, int z, String n){
		this.x = x; this.y = y; this.z = z; name = n;
	}

	public void calcCost(Node start, Node end){
		gCost = (int) Math.sqrt((Math.pow(this.x - start.x, 2) + Math.pow(this.y - start.y, 2) + Math.pow(this.z - start.z, 2)));
		hCost = (int) Math.sqrt((Math.pow(this.x - end.x, 2) + Math.pow(this.y - end.y, 2) + Math.pow(this.z - end.z, 2)));
		fCost = gCost + hCost;
	}

	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public int getZ(){return this.z;}
	public String getName(){return name;}
	public Bee getBee(){return b;}
	public Node getParent(){return parentNode;}
	public int getfCost(){return fCost;}
	public int getgCost(){return gCost;}
	public int gethCost(){return hCost;}

	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setZ(int z){this.z = z;}
	public void setName(String n){this.name = name;}
	public void setBee(Bee b){this.b = b;}
	public void setParent(Node n){this.parentNode = n;}
	// public void setfCost(int i){this.fCost = i;}
	// public void setgCost(int i){this.gCost = i;}
	// public void sethCost(int i){this.hCost = i;}


}

