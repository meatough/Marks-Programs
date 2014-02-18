/*********************************************************** 
 * Programming Assignment 12
 * Shortest Path program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created April 29, 2013
 * Modified May 6, 2013
 * Modified by Mark Eatough
 ***********************************************************/
//visited = new boolean[cityList.length];
//wieghts = graph.getWieghts();
 
import java.util.*;
//import java.util.Stack;

public class ShortestPath extends AdjMatrixDiGraph//<T>
{
	private WeightedAdjMatrixGraph<String> graph = null;
	private Stack <Vertex<String>> stack = new ListStack <Vertex<String>>();
	private Queue <Vertex<String>> queue = new ListQueue<Vertex<String>>();
	boolean[] visited;
	
	public ShortestPath()
	{
		graph = new WeightedAdjMatrixGraph<String>();
		visited = new boolean[cityList.length];
	}


	String [] cityList =	{	"Seattle",
									"San Francisco",
									"Los Angeles",
									"Las Vegas",
									"Phoenix",
									"Oklahoma City",
									"Dallas",
									"Minneapolis",
									"Milwaukee",
									"Chicago",
									"New Orleans",
									"New York City",
									"Washington DC",
									"Miami"
								};
	double[][]weights = new double[cityList.length][cityList.length];
	
	//method to add cities to graph
	public void addCities()
	{
		for(String city : cityList)
		{
			graph.addVertex(new Vertex<String>(city));
		}
	}
	
	//create list of strings variables for cities
	Vertex<String> seattle = new Vertex<String> ("Seattle");
	Vertex<String> sanFrancisco = new Vertex<String> ("San Francisco");
	Vertex<String> losAngeles = new Vertex<String> ("Los Angeles");
	Vertex<String> lasVegas = new Vertex<String> ("Las Vegas");
	Vertex<String> pheonix = new Vertex<String> ("Phoenix");
	Vertex<String> oklahomaCity = new Vertex<String> ("Oklahoma City");
	Vertex<String> dallas = new Vertex<String> ("Dallas");
	Vertex<String> minneapolis = new Vertex<String> ("Minneapolis");
	Vertex<String> milwaukee = new Vertex<String> ("Milwaukee");
	Vertex<String> chicago = new Vertex<String> ("Chicago");
	Vertex<String> newOrleans = new Vertex<String> ("New Orleans");
	Vertex<String> newYorkCity = new Vertex<String> ("New York City");
	Vertex<String> washingtonDC = new Vertex<String> ("Washington DC");
	Vertex<String> miami = new Vertex<String> ("Miami");
	
	
	
	//Add edges to the graph
	public void addPaths()
	{
		graph.addEdge(seattle, 808.0, sanFrancisco);
		graph.addEdge(seattle, 2060.0, chicago);
	
		//all of sanFrancisco
		//graph.addEdge(sanFrancisco, 808.0, seattle);				//may not need?
		graph.addEdge(sanFrancisco, 414.0, losAngeles);
		graph.addEdge(sanFrancisco, 2257.0, milwaukee);
	
		// all of losAngeles
		//graph.addEdge(losAngeles, 414.0, sanFrancisco);			//may not need?
		graph.addEdge(losAngeles, 272.0, lasVegas);
		graph.addEdge(losAngeles, 1440.0, dallas);
	
		// all of lasVegas
		//graph.addEdge(lasVegas, 272.0, losAngeles);				//may not need?
		graph.addEdge(lasVegas, 1780.0, chicago);
	
		// all of pheonix
		graph.addEdge(pheonix, 1771.0, milwaukee);
	
		// all of oklahomaCity
		graph.addEdge(oklahomaCity, 792.0, minneapolis);
	
		// all of dallas
		//graph.addEdge(dallas, 1440.0, losAngeles);				//may not need?
		graph.addEdge(dallas, 949.0, minneapolis);
		graph.addEdge(dallas, 571.0, newOrleans);
		graph.addEdge(dallas, 1614.0, newYorkCity);
	
		// all of minneapolis
		//graph.addEdge(minneapolis, 792.0, oklahomaCity);		//may not need?
		//graph.addEdge(minneapolis, 949.0, dallas);				//may not need?
		graph.addEdge(minneapolis, 1217.0, newYorkCity);
	
		// all of milwaukee
		//graph.addEdge(milwaukee, 2257.0, sanFrancisco);			//may not need?
		//graph.addEdge(milwaukee, 1771.0, pheonix);				//may not need?
		graph.addEdge(milwaukee, 811.0, washingtonDC);
	
		// all of chicago
		//graph.addEdge(chicago, 2060.0, seattle);					//may not need?
		//graph.addEdge(chicago, 1780.0, lasVegas);					//may not need?
		graph.addEdge(chicago, 948.0, newOrleans);
		graph.addEdge(chicago, 1423.0, miami);
	
		// all of newOrleans
		//graph.addEdge(newOrleans, 571.0, dallas);					//may not need?
		//graph.addEdge(newOrleans, 948.0, chicago);				//may not need?
	
		// all of newYorkCity
		//graph.addEdge(newYorkCity, 1614.0, dallas);				//may not need?
		//graph.addEdge(newYorkCity, 1217.0, minneapolis);		//may not need?
		graph.addEdge(newYorkCity, 237.0, washingtonDC);
	
		// all of washingtonDC
		//graph.addEdge(washingtonDC, 811.0, milwaukee);			//may not need?
		//graph.addEdge(washingtonDC, 237.0, newYorkCity);		//may not need?
	
	
		// all of miami
		//graph.addEdge(miami, 1423.0, chicago);						//may not need?
	}//end add paths method
	
	//method to populate weights of graph with proper values
	public void addDoublesToWeights()
	{
		for(int i = 0; i < cityList.length; i++)
		{
			for(int j = 0; j < cityList.length; j++)
			{
				Vertex<String> city1 = new Vertex<String>(cityList[i]);
				Vertex<String> city2 = new Vertex<String>(cityList[j]);
				weights[i][j] = graph.getEdgeWeight(city1, city2);
			} 
		}
	} 
	
	//method to print adjacency matrix
	public void showAdjacencyMatrix()
	{
		System.out.print("\t\t");
		for(String city : cityList)
		{
			System.out.printf("%15s", city);
		}
		
		for(int i = 0; i < cityList.length; i++)
		{
			System.out.println();
			System.out.printf("%15s", cityList[i]);
			for(int j = 0; j < cityList.length; j++)
			{
				System.out.printf("%15.0f", weights[i][j]);
			}//end inner for loop
		}//end outer for loop
	}
	
	//method to show all neighbors of all cities
	public void showNeighbors()
	{
		for(int i = 0; i< vertices.length; i++)
		{
			Vertex<String> city = new Vertex<String>(cityList[i]);
			
			ArrayList<Vertex<String>> neighbors = ( ArrayList<Vertex<String>> )
   			graph.getNeighbors( city );
			
			System.out.printf("%s:  ", cityList[i]);
			for(int j = 0; j < neighbors.size(); j++)
			{
				System.out.printf("%s %.0f, ", neighbors.get(j),
					graph.getEdgeWeight(neighbors.get(j),city));
			}//end inner for loop
			System.out.println("\n");
		}//end outer for loop   
	}//end show neighbors method
	
	//method to make sure city is contained in graph
	public boolean contains(String c)
	{
		ArrayList<String> cities = new ArrayList<String>();
		for(String city: cityList)
		{
			cities.add(city);
		}
		if(cities.contains(c))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//method to find where city index is
	public int cityIndex(Vertex v)
	{
		String vert = v.toString();
		ArrayList<String> cities = new ArrayList<String>();
		for(String c: cityList)
		{
			cities.add(c);
		}
		if(cities.contains(vert))
		{
		 	return cities.indexOf(vert);
		}
		else
		{
			return -1;
		}
	}
	
	//method to reset all visited cities to false
	public void resetVisited()
	{
		for(int i = 0; i < visited.length; i++)
		{
			visited[i] = false;
		}
	}
	//method for while loops in shortest path methods
	public boolean containsFalse()
	{
		ArrayList<Boolean> hasFalse = new ArrayList<Boolean>();
		for(boolean bool: visited)
		{
			hasFalse.add(bool);
		}
		if(hasFalse.contains(false))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//method to do a depth first traversal
	public void dfs(String cityDFS)
	{
		boolean contains = contains(cityDFS);
		if(contains == true)
		{
			Vertex<String> myCityDFS = new Vertex<String>(cityDFS);
			
			stack.push(myCityDFS);
			visited[cityIndex(myCityDFS)] = true;
			System.out.println(myCityDFS);
			int printCounter = 1;
			int j = 0;
			while(printCounter < 14)
			{
				ArrayList<Vertex<String>> neighbors = ( ArrayList<Vertex<String>> )
   				graph.getNeighbors( myCityDFS );
	
				if(visited[cityIndex(neighbors.get(j))] == false)
				{
					myCityDFS = neighbors.get(j);
					System.out.println(myCityDFS);
					printCounter++;
					stack.push(myCityDFS);
					visited[cityIndex(neighbors.get(j))] = true;
					j = 0;
				}//end inner if statement
				else
				{
					j++;
					if(j == neighbors.size())
					{
						stack.pop();
						myCityDFS = stack.peek();
						j = 0;
					}
				}//end inner else statement
			}//end while loop  
		}//end outer if statement
		else
		{
			System.out.print("City does not exist on this graph");
		}
		while(stack.size() > 0)
		{
			stack.pop();
		}	
		resetVisited();
	}
	
	//method to do a breadth first search
	public void bfs(String cityBFS)
	{
		boolean contains = contains(cityBFS);
		if(contains(cityBFS) == true)
		{
			Vertex<String> myCityBFS = new Vertex<String>(cityBFS);
			
			queue.enqueue(myCityBFS);
			visited[cityIndex(myCityBFS)] = true;
			for(int i = 0; i < cityList.length; i++)
			{
				ArrayList<Vertex<String>> neighbors = ( ArrayList<Vertex<String>> )
   				graph.getNeighbors( myCityBFS );
				for(int j = 0; j < neighbors.size(); j++)
				{
					if(visited[cityIndex(neighbors.get(j))] == false)
					{
						queue.enqueue(neighbors.get(j));
						visited[cityIndex(neighbors.get(j))] = true;
					}//end inner if statement
				}//end inner for loop
				myCityBFS = queue.dequeue();
				System.out.println(myCityBFS);
			}//end outer for loop  
		}//end outer if statement
		else
		{
			System.out.print("City does not exist on this graph");
		}
		resetVisited();
	}//end breadth first search method
	
	//method to find the shortest number of connections between cities
	public void shortestConnections(String city1, String city2)
	{
		//cant get to Washington DC or Pheonix from Seattle...
		boolean contains1 = contains(city1);
		boolean contains2 = contains(city2);
		if(contains1 == false)
		{
			System.out.printf("%s does not exist on this graph", city1);
		}
		else if(contains2 == false)
		{
			System.out.printf("%s does not exist on this graph", city2);
		}
		else
		{
			//Queue <Vertex<String>> tempQueue = new ListQueue<Vertex<String>>();
			Vertex<String> myCity1 = new Vertex<String>(city1);
			Vertex<String> myCity2 = new Vertex<String>(city2);
			Vertex<String> temp = myCity1;
			Stack <Vertex<String>> tempStack = new ListStack <Vertex<String>>();
			stack.push(myCity1);
			
			visited[cityIndex(myCity1)] = true;
			int j = 0;
			int k = 0;
			
			while(containsFalse() == true)
			{
				ArrayList<Vertex<String>> neighbors = ( ArrayList<Vertex<String>> )
   				graph.getNeighbors(temp);
				
				//temp = neighbors.get(j);
				
				if(neighbors.contains(myCity2))
				{
					stack.push(myCity2);
					
					for(int i = 0; i < visited.length; i++)
					{
						visited[i] = true;
					}
				}
				else if(visited[cityIndex(neighbors.get(j))] == false)
				{
					visited[cityIndex(neighbors.get(j))] = true;
					temp = neighbors.get(j);
					stack.push(temp);
					j= 0;
				}
				else
				{
					if(j < neighbors.size()-1)
					{
						j++;
					}
					else
					{
						j = 0;
						stack.pop();
						temp = stack.peek();
					}
				}
			}//end while
			
			System.out.printf("\n\nThe shortest path between %s and %s is: \n", city1, city2);
			while(stack.isEmpty() == false)
			{
				tempStack.push(stack.pop());
			}
			
			int connections = tempStack.size()-1;
			
			while(tempStack.isEmpty() == false)
			{
				System.out.println(tempStack.pop());
			}
			
			System.out.printf("\nConnections: %d\n\n\n\n", connections);
			resetVisited();
		}//end else statement
	}//end shortest connections method
	
	//method to find the path of shortest distance between two cities
	public void shortestDistance(String city1, String city2)
	{
		boolean contains1 = contains(city1);
		boolean contains2 = contains(city2);
		if(contains1 == false)
		{
			System.out.printf("%s does not exist on this graph", city1);
		}
		else if(contains2 == false)
		{
			System.out.printf("%s does not exist on this graph", city2);
		}
		else
		{
			Vertex<String> myCity1 = new Vertex<String>(city1);
			Vertex<String> myCity2 = new Vertex<String>(city2);
			Vertex<String> temp = myCity1;
			Stack <Vertex<String>> tempStack = new ListStack <Vertex<String>>();
			stack.push(myCity1);
			
			visited[cityIndex(myCity1)] = true;
			int j = 0;
			
			while(containsFalse() == true)
			{
				ArrayList<Vertex<String>> neighbors = ( ArrayList<Vertex<String>> )
   				graph.getNeighbors(temp);
				
				//temp = neighbors.get(j);
				if(neighbors.contains(myCity2))
				{
					stack.push(myCity2);
					
					for(int i = 0; i < visited.length; i++)
					{
						visited[i] = true;
					}
				}
				else if(visited[cityIndex(neighbors.get(j))] == false)
				{
					visited[cityIndex(neighbors.get(j))] = true;
					temp = neighbors.get(j);
					stack.push(temp);
					j = 0;
				}
				else
				{
					if(j < neighbors.size()-1)
					{
						j++;
					}
					else
					{
						j = 0;
						stack.pop();
						temp = stack.peek();
					}
				}
			}//end while
			
			System.out.printf("\n\nThe shortest path between %s and %s is: \n", city1, city2);
			while(stack.isEmpty() == false)
			{
				tempStack.push(stack.pop());
			}
			
			int distance = 0;
			
			while(tempStack.isEmpty() == false)
			{
				temp = tempStack.pop();
				System.out.println(temp);
				if(tempStack.isEmpty() == false)
				{
					distance += graph.getEdgeWeight(temp, tempStack.peek());
				}
			}
			
			System.out.printf("\nDistance: %d miles\n\n\n\n", distance);
			resetVisited();

		}
	}//end shortest distance method
}//end shortest path class