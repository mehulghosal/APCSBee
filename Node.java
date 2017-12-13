import java.util.*;
import java.io.*;

public abstract class Node{

	protected int x;//x coordinate
	protected int y;//y coordinate
	protected int z;//z coordinate

	public Node(){

	}

	public Node(int x, int y, int z){
		this.x = x; this.y = y; this.z = z;
	}

	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public int getZ(){return this.z;}

	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public void setZ(int z){this.z = z;}

}

