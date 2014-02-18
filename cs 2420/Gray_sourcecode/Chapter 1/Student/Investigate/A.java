package pkg1;

public class A {
   public int publicVarInA;
   private int privateVarInA;
   protected int protectedVarInA;
   int packageVarInA;

   private void privateMethodInA() {
      System.out.println( "privateMethodInA" );
   }
	
   public void publicMethodInA() {
      System.out.println( "publicMethodInA" );
   }
	
   protected void protectedMethodInA() {
      System.out.println( "protectedMethodInA" );
   }
	
   void packageMethodInA(){
      System.out.println( "packageMethodInA" );
   }
}
