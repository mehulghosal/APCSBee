import java.util.*;
import java.io.*;

public class Main{

	public static Node[][][] grid;
	public static Bee[] bees;

	public static void read(){
		try{
			//System.out.println("1");
			Scanner s = new Scanner(new File("beesetup1.txt"));
			//System.out.println("2");
			s.nextLine();
			//System.out.println("3");
			String firstLn = s.nextLine();
			//System.out.println("4");
			int size = Integer.parseInt(firstLn.split(",")[0]);

			
			grid = new Node[size][size][size];
			bees = new Bee[15];
			//sets up board
			for(int i = 0; i<size; i++){
				for(int j = 0; j<size; j++){
					for(int k = 0; k<size; k++){
						grid[i][j][k] = new Node(i,j,k);
					}
				}
			}
			//sets up beehives
			for(int i = 0; i<15; i++){
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				grid[x][y][z] = new Node(x, y, z, "Beehive"); 
			}
			System.out.println(2);
			//sets up the bees
			for(int i = 0; i<15; i++){
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				Bee b = new Bee(x,y,z);
				grid[x][y][z].setBee(b);
				bees[i] = b;
			}
			int obsCount = Integer.parseInt(s.nextLine());
			for(int i = 0; i < obsCount; i++){
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				grid[x][y][z].setName("Occupied");
				//System.out.println(x+" "+y+" "+z);

			}

		}
		catch(Exception e){
			System.out.println("Reading failed");
		}
	}

	public static void move(Bee b, int x, int y, int z){
		grid[b.getX()][b.getY()][b.getZ()].setBee(Null);//sets old Node's bee to Null
		grid[x][y][z].setBee(b);//new node's bee set to b
		b.setX(x); b.setY(y); b.setZ(z);//b's x,y,z set
	}

	public static void main(String[] args){

		read();

	}


}