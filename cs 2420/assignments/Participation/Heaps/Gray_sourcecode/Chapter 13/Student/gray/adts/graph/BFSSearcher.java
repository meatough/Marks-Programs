package gray.adts.graph;

import java.util.List;
import java.util.ArrayList;
import gray.adts.queue.*;
import java.util.HashMap;
import gray.misc.Pair;

public class BFSSearcher<T> {
  private Graph<T> graph;
  private short[] visitedVertices;
  private HashMap<Vertex<T>, Vertex<T>> visited;
  private boolean pathFound;

  /**
   *
   * @param g The graph to search.
   * @throws NullArgumentException if <code>g</code> is <code>null</code>.
   */
  public BFSSearcher( Graph<T> g ) {
    this.graph = g;
    this.visitedVertices = new short[g.getNumberOfVertices()];
  }

  /**
   * Determine if there is a path from <code>v1</code> to <code>v2</code> in graph.
   * @param v1 The source vertex; must not be <code>null</code> and must be a
   *   vertex in this graph.
   * @param v2 The destination vertex; must not be <code>null</code> and must be a
   *   vertex in this graph.
   * @return <code>true</code> if there is a path from <code>v1</code> to <code>v2</code>
   *  in the graph.
   * @throws IllegalArgumentException if <code>v1</code> or <code>v2</code> are
   * <code>null</code> or are not in this graph.
   */
  public boolean containsPath( Vertex<T> v1, Vertex<T> v2 ) {
    ArrayList<Vertex<T>> verticesList = ( ArrayList<Vertex<T>> )this.bfs( v1 );
    return verticesList.contains( v2 );
  }

  /**
   * Determine if the length of the path from <code>v1</code> to <code>v2</code> in
   * the graph.
   * @param v1 The source vertex; must not be <code>null</code> and must be a
   *   vertex in this graph.
   * @param v2 The destination vertex; must not be <code>null</code> and must be a
   *   vertex in this graph.
   * @return int The length of the path from <code>v1</code> to <code>v2</code>;
   *  0 if there is no path
   * @throws IllegalArgumentException if <code>v1</code> or <code>v2</code> are
   * <code>null</code> or are not in this graph.
   */
  public int getPathLength( Vertex<T> v1, Vertex<T> v2 ) {
    int pathLength = 0;
    ArrayList<Vertex<T>> verticesList = ( ArrayList<Vertex<T>> )this.bfs( v1 );

    if ( !verticesList.contains( v2 ) ) {
      return 0; // no path
    }

    Vertex<T> neighbor;
    while ( ( neighbor = visited.get( v2 ) ) != null ) {
      pathLength++;
      v2 = neighbor;
    }
    pathLength--;
    return pathLength;
  }

  /**
   * Get the vertices on the path from <code>v1</code> to <code>v2</code> in the
   * graph.
   * @param v1 The source vertex; must not be <code>null</code> and must be a
   *   vertex in this graph.
   * @param v2 The destination vertex; must not be <code>null</code> and must be a
   *   vertex in this graph.
   * @return List A list of the vertices on the path from <code>v1</code> to
   *  <code>v2</code>. This list will be empty if there is no path.
   * @throws IllegalArgumentException if <code>v1</code> or <code>v2</code> are
   * <code>null</code> or are not in this graph.
   */
  public List<Vertex<T>> getPath( Vertex<T> v1, Vertex<T> v2 ) {
    List<Vertex<T>> thepath = new ArrayList<Vertex<T>> ();
    ArrayList<Vertex<T>> verticesList = ( ArrayList<Vertex<T>> )this.bfs( v1 );

    if ( !verticesList.contains( v2 ) ) {
      return thepath; // no path, return empty list
    }

    // a path exists; let's get it!
    thepath.add( v2 );
    Vertex<T> neighbor;
    while ( ( neighbor = visited.get( v2 ) ) != null ) {
      if ( !neighbor.getLabel().equals( "" ) ) {
        thepath.add( neighbor );
        //System.out.printf("Adding %s to the path\n", neighbor );
      }
      v2 = neighbor;
    }

    java.util.Collections.reverse( thepath );
    return thepath;
  }

  /**
   * bfs
   *
   * @param startVertex Vertex
   * @return List
   */
  public List<Vertex<T>> bfs( Vertex<T> startVertex ) {
    visited = new HashMap<Vertex<T>, Vertex<T>> ();
    ArrayList<Vertex<T>> verticesList = new ArrayList<Vertex<T>> ();
    Queue<Pair<Vertex<T>>> toVisitQueue = new ListQueue<Pair<Vertex<T>>> ();

    verticesList.add( startVertex );
    visited.put( startVertex, new Vertex( "" ) );

    // get the start vertex's neighbors and put them into the toVisitQueue
    ArrayList<Vertex<T>> neighbors = ( ArrayList<Vertex<T>> ) graph.
        getNeighbors( startVertex );
    for ( Vertex<T> neighbor : neighbors ) {
      toVisitQueue.enqueue( new Pair<Vertex<T>> ( startVertex, neighbor ) );
    }

    while ( !toVisitQueue.isEmpty() ) {
      Pair<Vertex<T>> vertexPair = toVisitQueue.dequeue();
      Vertex<T> src = vertexPair.getFirstElement();
      Vertex<T> dest = vertexPair.getSecondElement();
      // skip over visited vertices
      if ( visited.get( dest ) == null ) {
        verticesList.add( dest ); // place in list to return
        visited.put( dest, src ); // "mark" the vertex as visited

        // now queue up invisited neighbors
        neighbors = ( ArrayList<Vertex<T>> ) graph.getNeighbors( dest );
        for ( Vertex<T> neighbor : neighbors ) {
          // only queue up unvisited neighbors
          if ( visited.get( neighbor ) == null ) {
            toVisitQueue.enqueue( new Pair<Vertex<T>> ( dest, neighbor ) );
          }
        }
      }
    }

    return verticesList;
  }
}
