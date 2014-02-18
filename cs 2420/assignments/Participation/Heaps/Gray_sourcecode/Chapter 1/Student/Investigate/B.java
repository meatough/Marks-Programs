package pkg1;


public class B extends A {
   public int publicVarInB;
   private int privateVarInB;
   protected int protectedVarInB;
   int packageVarInB;

   private void privateMethodInB() {
      System.out.println( "privateMethodInB" );
   }
	
   public void publicMethodInB() {
      System.out.println( "publicMethodInB" );
   }
	
   protected void protectedMethodInB() {
      System.out.println( "protectedMethodInB" );
   }
	
   void packageMethodInB(){
      System.out.println( "packageMethodInB" );
   }
}
