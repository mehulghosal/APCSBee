import java.util.*;
import java.io.*;

public class Node{

	protected int x;//x coordinate
	protected int y;//y coordinate
	protected int z;//z coordinate
	protected String name; //if null, the node is empty

	public Node(){

	}

	public Node(int x, int y, int z){
		this.x = x; this.y = y; this.z = z; name = "Bee";
	}

	public Node(int x, int y, int z, String n){
		this.x = x; this.y = y; this.z = z; name = n;
	}

	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public int getZ(){return this.z;}
	public String getName(){return name;}

	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setZ(int z){this.z = z;}
	public void setName(String n){this.name = name;}

}

