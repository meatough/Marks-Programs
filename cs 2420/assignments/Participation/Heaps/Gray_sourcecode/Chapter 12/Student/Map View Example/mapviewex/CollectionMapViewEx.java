package mapviewex;

import gray.adts.map.*;

/**
 * Example of the Collection view of a Map.
 */
public class CollectionMapViewEx {
  public static void main( String[] args ) {
    HashMap map = new HashMap<String, String> ();

    //                KEY                  VALUE
    map.put( new String( "Hound" ), new String( "Ginger" ) );
    map.put( new String( "Dog" ), new String( "Blue" ) );
    map.put( new String( "Cat" ), new String( "Pepper" ) );
    map.put( new String( "Bird" ), new String( "Persian" ) );
    map.put( new String( "Fish" ), new String( "Penny" ) );
    map.put( new String( "Turtle" ), new String( "Tensy" ) );

    System.out.println( "Here are the values from the map" +
                        " that we can see in the collection." );
    java.util.Collection<String> collection = map.values();
    System.out.println( "Size of the collection view is " +
                        collection.size() );
    for ( String s : collection ) {
      System.out.println( "pet is " + s );
    }

    System.out.println( "\nRemoving \"Penny\" from " +
                        "the collection." );
    collection.remove( new String( "Penny" ) );
    System.out.println( "Is \"Penny\" still in the map? " +
                        map.containsValue( "Penny" ) );
    System.out.println( "\nDoes the collection contain " +
                        "\"Albert\"? " + collection.contains( "Albert" ) );
    System.out.println( "Adding (Snake, Albert) to the map." );
    map.put( new String( "Snake" ), new String( "Albert" ) );
    System.out.println( "Now does the collection contain " +
                        "\"Albert\"? " + collection.contains( "Albert" ) );

    collection.clear();
    System.out.println( "\nMap's size after clearing through" +
                        " the collection view is " + map.size() );
  }
}
