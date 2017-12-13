import java.util.*;
import java.io.*;

public class Bee extends Node{

	private int moveCount;

	public Bee(){
		super();
		moveCount = 0;
	}

	public Bee(int x, int y, int z){
		super(x, y, z);
		moveCount = 0;
	}

	public void move(int x, int y, int z){
		this.setX(x); this.setY(y); this.setZ(z);
		moveCount += 1;
	}

}