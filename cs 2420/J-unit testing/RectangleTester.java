package gray.adts.shapes;

import junit.framework.*;
import junit.extensions.*;

//  Step 1. Create a testing class that extends TestCase.
public class RectangleTester extends TestCase {
    // Step 2: Declare variables for the objects to be
    //         tested.
    private Rectangle r1, r2;

    // Step 3: Create a constructor that invokes the 
    //         super constructor. The name argument is the name 
    //         of a test case (see the suite() method).
    public RectangleTester(String name) {
        super(name);
    }

   // Step 4. Create a setUp() method to instantiate and  
   //         initialize the objects under test. This method  
   //         is invoked before EVERY test case.
    protected void setUp() {
        r1 = new Rectangle();
        r2 = new Rectangle( 2.0, 3.0 );
    }

   // Step 5. Create a tearDown() method to clean up after 
   //         EACH test case. Unless you need something more than 
   //         general garbage collection, such as closing I/O  
   //         streams, you can leave this method out.
    protected void tearDown() {
        r1 = null;
        r2 = null;
    }

    // Step 6. Create the test cases. Each test case should follow 
    //         the pattern:   void testXXX()
    //         where XXX is the name of the test to perform.

    /**
       Test Case 1: Verify that instantiation was done properly. 
       Note that setUp() is called before this method, but isn't 
       needed. C'est la vie.
    */
    public void testInstantiateDefault() {
        assertEquals( 1.0, r1.getLength() );
        assertEquals( 1.0, r1.getHeight() );
    }


   /**
       Test Case 2: Instantiation of a Rectangle object 
       with legal user-supplied values for the attributes 
       above the legal boundary.
    */
    public void testInstantiateLegal() {
        r1 = new Rectangle( 2.0, 3.0 );
        assertEquals( 2.0, r1.getLength() );
        assertEquals( 3.0, r1.getHeight() );
   }

    /**
       Test Case 3: Instantiation of a Rectangle object 
       with an illegal user-supplied value for the length 
       attribute.
    */
    public void testInstantiateIllegalLength() {
        try {
           new Rectangle( -3.0, 5.0 );
           fail( "Should raise IllegalArgumentException!" );
        } catch ( IllegalArgumentException e ) {
            assertTrue(true);
        }
   }
      
    /**
       Test Case 5: Mutator to change a Rectangle’s 
       length: legal input.
    */
    public void testLengthMutatorLegal() {
        r2.setLength( 5.0 );
        assertEquals( 5.0, r2.getLength() );
        assertEquals( 3.0, r2.getHeight() );
   }

   /** 
      Test Case 7: Accessor for a Rectangle’s perimeter
    */
    public void testGetPerimeter() {
        r2.setLength( 6.5 );
        r2.setHeight( 5.3 );
        assertEquals( 23.6, r2.getPerimeter(), 0.01 );
   }
      
    // Step 7: Create a suite of test cases.
    public static Test suite() {
        // The simplest approach is to let Junit do all the work 
        // using Java's reflection mechanism.
        return new TestSuite( RectangleTester.class );

        // Alternatively, you can create a TestSuite object and 
        // add the tests manually. But this shows the purpose 
        // of the String arg in the RectangleTester constructor.
/*        
        TestSuite suite = new TestSuite();
        suite.addTest( 
          new RectangleTester(" testInstantiateDefault") );
        suite.addTest(
          new RectangleTester("testInstantiateLegal"));
        suite.addTest(
          new RectangleTester( "testInstantiateIllegalLength") );
        suite.addTest(
          new RectangleTester( "testLengthMutatorLegal") );
        suite.addTest( new RectangleTester( "testPerimeter" ) );
        return suite;
*/        
    }

    // Step 8: Define a main() method that invokes JUnit to run 
    //         the test application.
    public static void main (String[] args) {
        // Use Java's reflection mechanism to get the name of 
        // this class.
        String[] TestCaseName = {RectangleTester.class.getName()};
        junit.textui.TestRunner.main (TestCaseName);
    }
}