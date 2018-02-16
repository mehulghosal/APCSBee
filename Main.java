import java.util.*;
import java.io.*;

public class Main{

	public static Node[][][] grid;
	public static ArrayList<Bee> bees = new ArrayList<Bee>();
	public static ArrayList<Node> beehives = new ArrayList<Node>();

	public static void read(){
		try{
			Scanner s = new Scanner(new File("beesetup1.txt"));
			s.nextLine();
			String firstLn = s.nextLine();
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
				grid[x][y][z].setName("Obstacle");
				//System.out.println(grid[x][y][z]);
				//System.out.println(grid[x][y][z].getName());

			}

		}
		catch(Exception e){
			System.out.println("Reading failed");
		}
	}

	public static void readTest(){
		try{
			Scanner s = new Scanner(new File("test.txt"));
			s.nextLine();
			String firstLn = s.nextLine();
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
			for(int i = 0; i<1; i++){
				String[] hold = s.nextLine().split(",");
				int x = Integer.parseInt(hold[0]);
				int y = Integer.parseInt(hold[1]);
				int z = Integer.parseInt(hold[2]);
				grid[x][y][z] = new Node(x, y, z, "Beehive"); 
				beehives.add(grid[x][y][z]);
			}
			//sets up the bees
			for(int i = 0; i<1; i++){
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
				grid[x][y][z].setName("Obstacle");
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
					int yNew = y+j;
					int zNew = z+k;
					if((xNew<grid.length && xNew>=0) && (yNew<grid.length && yNew>=0) && (zNew<grid.length && zNew>=0)) {
						Node n = grid[xNew][yNew][zNew];

						if(n.getVisited()==false) {
							if(!n.getName().equals("Obstacle")){
								n.setVisited(true);
								around.add(n);
							}
						}
					}

				}
			}
		}

		return around;
	}

	//do floodfill
	//returns number of moves needed for bee to move from starting location to end node
	public static int algorithm(Bee b, Node hive) {

		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid.length; j++){
				for(Node n: grid[i][j]){
					n.setVisited(false);
					n.setVal(0);
				}
			}
		}
		int counter = 0;
		Node goal = hive;
		Node start = getNode(b);
		start.setVal(counter);//signifies that first node has a value of 0 from the start
		ArrayList<Node> aroundArr = new ArrayList<Node>();
		aroundArr.add(start);
		
		boolean bool = true;
		while(bool) {
			ArrayList<Node> toAdd = new ArrayList<Node>();
			counter++;

			for(Node n: aroundArr) {
				ArrayList<Node> newAround = around(n);
				toAdd.addAll(newAround);
				for(Node a: newAround) {
					a.setVal(counter);
				}
				if(newAround.contains(goal)) {
					bool = false;
					System.out.println("Reached goal." + start + " " + goal);
					break;
				}
			}
			aroundArr = toAdd;
			
		}
		System.out.println(goal.getVal());
		return goal.getVal();
	}


	//sorts beehives array based on distance
	public static void sortHives(Bee b){
		
		for (int j = 0; j< beehives.size(); j++){
			Node hive = beehives.get(j);
			hive.setDist(Math.sqrt(Math.pow(hive.getX() - b.getX(),2) + Math.pow(hive.getY() - b.getY(),2) + Math.pow(hive.getZ() - b.getZ(),2)));
		}
		selectionSort(beehives);

	}

	public static void selectionSort(ArrayList<Node> arr){

		for (int i = 0; i < arr.size()-1; i++){
			int minId = i;

			for (int j = i+1; j < arr.size(); j++){
				if (arr.get(j).compareTo(arr.get(minId))<0){
  					minId = j;
				}
			}
			Node hold = arr.get(minId);
			//arr[minId] = arr[i];
			arr.set(minId, arr.get(i));
			//arr[i] = hold;
			arr.set(i, hold);

        }
    }


	public static void main(String[] args){

		Main.read();
		int c = 0;
		for(int i = 0; i<15; i++) {
			sortHives(bees.get(i));
			for(int j = 0; j < 15; j++){
				if(!beehives.get(j).getHV()){
					c += algorithm(bees.get(i), beehives.get(j));
					//System.out.println(beehives);
					beehives.get(j).setHV(true);
					break;
				}
			}
			
			/*try {
			    Thread.sleep(1000);
			} 
			catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}*/
		}
		System.out.println(c);


	}


}