import java.util.*;
import java.io.*;

public class Main{

	public static Node[][][] grid;

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

			System.out.println(size);
			
			grid = new Node[size][size][size];
			//sets up board
			for(int i = 0; i<size; i++){
				for(int j = 0; j<size; j++){
					for(int k = 0; k<size; k++){
						grid[i][j][k] = new Node(i,j,k);
					}
				}
			}
			System.out.println(1);
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
				grid[x][y][z].setBee(new Bee(x,y,z));

			}
			System.out.println(3);
			int obsCount = Integer.parseInt(s.nextLine());
			System.out.println(obsCount);
			for(int i = 0; i < obsCount; i++){
				//System.out.println(i);
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				grid[x][y][z].setName("Occupied");
			}

		}
		catch(Exception e){
			System.out.println("Reading failed");
		}

		//grid = g;
	}

	public static void main(String[] args){

		read();

	}


}