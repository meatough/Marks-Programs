package gray.adts.graph;

import java.util.*;

import gray.adts.priorityqueue.*;
import gray.adts.priorityqueue.PriorityQueue;
import gray.misc.*;

/**
 * A weighted, undirected graph stored in an adjacency matrix.
 *  The weights must be >= 0.
 */
public class WeightedAdjMatrixGraph<T> extends AdjMatrixGraph<T> implements
    WeightedGraph<T> {
  /**
   * The default weight for an edge in a weighted graph.
   */
  public float DEFAULT_WEIGHT = 1.0;

  /**
   * Store weight edges. The adjacency matrix storing
   * edges is in an ancestor class.
   */
  protected double[][] weights;

  public WeightedAdjMatrixGraph() {
    super();
    weights = new double[super.SIZE][super.SIZE];
  }

  /**
   * Add an edge connecting vertex <code>v1</code> to
   * <code>v2</code>. In an undirected graph, this edge is
   * bidirectional.
   * @param v1  The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param weight The weight of this edge; must be >= 0.0.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph, or if <code>weight</code> is < 0.
   */
  public void addEdge( Vertex<T> v1, double weight,
                       Vertex<T> v2 ) {
    if ( weight < 0.0 ) {
      throw new IllegalArgumentException( "Edge weight " +
                                          " must be >= 0.0" );
    }

    super.addEdge( v1, v2 );

    // if we get here, method in superclass didn't throw
    // an exception and method preconditions are met
    this.setEdgeWeight( v1, weight, v2 );
  }

  /**
   * Get the weight of the edge from <code>v1</code> to
   * <code>v2</code>.
   * @param v1  The source vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @return double The weight of the edge from <code>v1</code>
   * to <code>v2</code>.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  public double getEdgeWeight( Vertex<T> v1, Vertex<T> v2 ) {
    int v1Pos = super.getVerticesIndexFor( v1 );
    int v2Pos = super.getVerticesIndexFor( v2 );
    // if we get here, method in superclass didn't throw
    // an exception and method preconditions are met
    return weights[v1Pos][v2Pos];
  }

  /**
   * Reset the weight for the edge connecting vertex
   * <code>v1</code> to <code>v2</code>.
   * @param v1  The source vertex; must not be <code>null</code>
   * and must be a vertex in this graph.
   * @param newWeight The weight of this edge; must be >= 0.0.
   * @param v2  The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph, or if <code>weight</code> is < 0.
   */
  public void setEdgeWeight( Vertex<T> v1, double newWeight,
                             Vertex<T> v2 ) {
    if ( newWeight < 0.0 ) {
      throw new IllegalArgumentException( "Edge weight "
                                          + "must be >= 0.0" );
    }
    int v1Pos = super.getVerticesIndexFor( v1 );
    int v2Pos = super.getVerticesIndexFor( v2 );
    // if we get here, method in superclass didn't throw an
    // exception and method preconditions are met
    weights[v1Pos][v2Pos] = newWeight;
    weights[v2Pos][v1Pos] = newWeight;
  }

  // overloaded methods from AdjMatrixGraph
  /**
   * Add an edge connecting vertex <code>v1</code> to
   * <code>v2</code>. The edge is bidirectional in an
   * undirected graph. The default weight for an edge
   * is <code>DEFAULT_WEIGHT</code>.
   * @param v1 The source vertex; must not be <code>null</code>
   *  and must be a vertex in this graph.
   * @param v2 The destination vertex; must not be
   * <code>null</code> and must be a vertex in this graph.
   * @throws IllegalArgumentException if <code>v1</code> or
   * <code>v2</code> are <code>null</code> or are not in this
   * graph.
   */
  public void addEdge( Vertex<T> v1, Vertex<T> v2 ) {
    this.addEdge( v1, DEFAULT_WEIGHT, v2 );
  }

  /**
   * Find a minimal cost path from <code>src</code> to
   * <code>dest</code> in this graph. Assumes edge weights
   * are positive.
   * @param src Vertex The first vertex in the path.
   * @param dest Vertex The last vertex in the path.
   * @return double The cost of the path or -1 if none is found.
   */
  public double minimalPath( Vertex<T> src, Vertex<T> dest ) {
    // keep track of which vertices have been visited already
    ArrayList<Vertex<T>> visitedVertices =
        new ArrayList<Vertex<T>> ();

    // Comparator for the priority queue where the shortest
    //  paths found so far a stored.
    final Comparator pathCostComparator = new Comparator() {
      public int compare( Object o1, Object o2 ) {
        Double i1 = ( ( Tuple<Vertex<T>, Double> ) o1 ).
            getSecondElement();
        Double i2 = ( ( Tuple<Vertex<T>, Double> ) o2 ).
            getSecondElement();
        return i1.compareTo( i2 );
      }

      public boolean equals( Object obj ) {
        return false;
      }
    };

    // Stores the shortest paths from the source vertex
    // found so far. These are stored as tuples.
    // The first field of the tuple is the terminating
    //  node in some shortest path starting from src
    // The second field is the cost of that path
    PriorityQueue<Tuple<Vertex<T>, Double>> pq
        = new HeapPriorityQueue<Tuple<Vertex<T>,
        Double>> ( pathCostComparator );

    Tuple<Vertex<T>, Double> pathTuple;

    // start with the source, which has a cost of 0 to
    //  get to itself
    pq.enqueue( new Tuple( src, 0.0 ) );

    while ( !pq.isEmpty() ) {
      // get cheapest path seen so far from src to some
      //  other vertex
      pathTuple = pq.dequeue();

      // extract the fields of the tuple so we can
      //  work with them
      Vertex<T> v = pathTuple.getFirstElement();
      double minCostToV = pathTuple.getSecondElement();

      visitedVertices.add( v ); // visit vertex v

      // if v is the destination vertex, we are done
      if ( v.equals( dest ) ) {
        return minCostToV;
      }

      // okay, not done yet; look at the vertices
      // adjacent to v
      ArrayList<Vertex<T>>
          neighbors = ( ArrayList<Vertex<T>> ) getNeighbors( v );
      while ( !neighbors.isEmpty() ) {
        Vertex<T> w = neighbors.remove( 0 ); // next neighbor

        // if w hasn't been visited already, add it to
        // the priority queue
        if ( !visitedVertices.contains( w ) ) {
          // get the total path cost from src to v
          double minCostToW = minCostToV
              + getEdgeWeight( v, w );
          pathTuple =
              new Tuple<Vertex<T>, Double> ( w, minCostToW );
          pq.enqueue( pathTuple );
        }
      }
    }
    // if the loop terminates naturally, we never found
    // the destination vertex, so return failure
    return -1;
  }
}
