import java.util.*;
import java.io.*;

public class Main{

	public static Node[][][] grid;
	public static ArrayList<Bee> bees = new ArrayList<Bee>();
	public static ArrayList<Node> beehives = new ArrayList<Node>();

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
				beehives.add(grid[x][y][z]);
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
				bees.add(b);
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

	public static void readTest(){
		try{
			//System.out.println("1");
			Scanner s = new Scanner(new File("test.txt"));
			//System.out.println("2");
			s.nextLine();
			//System.out.println("3");
			String firstLn = s.nextLine();
			//System.out.println("4");
			int size = Integer.parseInt(firstLn.split(",")[0]);

			
			grid = new Node[size][size][size];
			//sets up board
			for(int i = 0; i<size; i++){
				for(int j = 0; j<size; j++){
					for(int k = 0; k<size; k++){
						grid[i][j][k] = new Node(i,j,k);
					}
				}
			}
			//sets up beehives
			for(int i = 0; i<3; i++){
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				grid[x][y][z] = new Node(x, y, z, "Beehive"); 
				beehives.add(grid[x][y][z]);
			}
			//System.out.println(2);
			//sets up the bees
			for(int i = 0; i<3; i++){
				//System.out.println(i);
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				Bee b = new Bee(x,y,z);
				grid[x][y][z].setBee(b);
				bees.add(b);
			}
			//System.out.println(3);
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
			System.out.println("error: " + e.getMessage());
		}
	}

	public static void move(Bee b, int x, int y, int z){
		getNode(b).setBee(null);//sets old Node's bee to Null
		grid[x][y][z].setBee(b);//new node's bee set to b
		b.setX(x); b.setY(y); b.setZ(z);//b's x,y,z set
	}

	public static Node getNode(Bee b){
		return grid[b.getX()][b.getY()][b.getZ()];
	}

	public static ArrayList<Node> around(Node center){
		int x = center.getX(); int y = center.getY(); int z = center.getZ();
		ArrayList<Node> around = new ArrayList<Node>();


		for(int i = -1; i<2; i++){
			for(int j = -1; j < 2; j++){
				for(int k = -1; k<2; k++){
					int xNew = x+i;
					int yNew = y+i;
					int zNew = z+i;
					if(!(i==0 && j == 0 && k == 0) && xNew<=grid.length && xNew>=0 && yNew<=grid.length && yNew>=0 && zNew<=grid.length && zNew>=0) {
						around.add(grid[x+i][y+i][z+i]);
					}

				}
			}
		}

		return around;
	}

	//do floodfill
	//returns number of moves needed for bee to move from starting location to end node
	public static int algorithm(Bee b){
		Node goal = beehives.get(0);
		beehives.remove(goal);
		Node start = getNode(b);
		start.setVal(0);//signifies that first node has a value of 0 from the start
		ArrayList<Node> aroundArr = new ArrayList<Node>();
		Node current = start;

		while(!current.equals(goal)){

			aroundArr = around(current);
			for(Node n: aroundArr){
				n.setVal(current.getVal()+1); n.setVisited(true);
			}

		}
		return 0;
	}

	public static void main(String[] args){

		Main.readTest();
		for(int i = 0; i< grid.length; i++){
			for(int j = 0; j< grid.length; j++){
				for(int k = 0; k < grid.length; k++){
					System.out.println(grid[i][j][k]);
				}
			}
		}


	}


}