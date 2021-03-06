import java.util.*;
import java.io.*;

public class Bee implements Comparable<Bee>{

	private int moveCount;
	private int x;
	private int y;
	private int z;
	private double distToHive;
	private boolean done;

	public Bee(){
		moveCount = 0;
	}

	public Bee(int x, int y, int z){
		this.x = x; this.y = y; this.z = z;
		moveCount = 0; done = false;
	}

	public int getX(){return x;}
	public int getY(){return y;}
	public int getZ(){return z;}
	public double getDist(){return distToHive;}

	public void setX(int i){x = i;}
	public void setY(int i){y = i;}
	public void setZ(int i){z = i;}
	public void setDist(double i){distToHive = i;}

	public int compareTo(Bee b){
		if (this.distToHive<b.distToHive){
			return -1;
		}
		else if (this.distToHive >b.distToHive){
			return 1;
		}
		else{return 0;}

	}

	// public void move(int x, int y, int z){
	// 	this.setX(x); this.setY(y); this.setZ(z);
	// 	moveCount += 1;
	// }

}