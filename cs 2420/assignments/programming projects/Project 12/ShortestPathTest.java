/*********************************************************** 
 * Programming Assignment 12
 * Shortest Path program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created April 29, 2013
 * Modified May 6, 2013
 * Modified by Mark Eatough
 ***********************************************************/
import java.util.Scanner;

public class ShortestPathTest
{
	public static void main(String[] args)
	{
		char choice;
		Scanner menuInput = new Scanner(System.in);
		Scanner cityInput = new Scanner(System.in);
		ShortestPath graph = new ShortestPath();
		
		//create our graph
		graph.addCities();
		graph.addPaths();
		graph.addDoublesToWeights();
		
		do
  	   {
     		System.out.println("\n    1 . . . Show connecting cities ");
        	System.out.println("    2 . . . Depth-first Traversal ");
        	System.out.println("    3 . . . Breadth-first Traversal ");
			System.out.println("    4 . . . Shortest Path - Connections");
			System.out.println("    5 . . . Shortest Path - Distance");
			System.out.println("    6 . . . Adjacency Matrix");
       	System.out.println("    Press any other key to exit ");
       	choice = menuInput.nextLine().charAt(0);
			
			switch (choice)
       	{
         	case '1':  				
					System.out.println("Show Connecting Cities:\n\n");
					graph.showNeighbors();
				break;
				
				case '2':  				
					System.out.print("Enter the city you would like to start");
					System.out.print(" your depth-first traversal from: ");
					String cityDFS = cityInput.nextLine();
					System.out.println("\n");
					
					graph.dfs(cityDFS);
				break;
				
				case '3':  				
					System.out.print("Enter the city you would like to start");
					System.out.print(" your bredth-first traversal from: ");
					String cityBFS = cityInput.nextLine();
					System.out.println();
					graph.bfs(cityBFS);					
				break;
				
				case '4':  				
					System.out.println("Shortest Path - Connections");
					System.out.print("Enter the city you would like to start from: ");
					String city1conn = cityInput.nextLine();
					System.out.print("Enter the city you would like to end at: ");
					String city2conn = cityInput.nextLine();
					graph.shortestConnections(city1conn, city2conn);
					
				break;
				
				case '5':  				
					System.out.println("Shortest Path - Distance");
					System.out.print("Enter the city you would like to start from: ");
					String city1dist = cityInput.nextLine();
					System.out.print("Enter the city you would like to end at: ");
					String city2dist = cityInput.nextLine();
					graph.shortestDistance(city1dist, city2dist);
				break;
				
				case '6':  				
					System.out.println("Adjacency Matrix:\n\n");
					graph.showAdjacencyMatrix();
				break;
				
				default:
        			System.out.println("Goodbye");
       	}//end switch
 		}while("123456".indexOf(choice) != -1);//end doWhile loop
				
	}//end main method
}//end class