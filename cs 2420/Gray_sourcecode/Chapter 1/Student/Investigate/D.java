package pkg2;

import pkg1.A;

public class D extends A {

	public int publicVarInD;
	private int privateVarInD;
	protected int protectedVarInD;
	int packageVarInD;

	private void privateMethodInD() {
		System.out.println( "privateMethodInD" );
	}
	
	public void publicMethodInD() {
		System.out.println( "publicMethodInD" );
	}
	
	protected void protectedMethodInD() {
		System.out.println( "protectedMethodInD" );
	}
	
	void packageMethodInD(){
		System.out.println( "packageMethodInD" );
	}
}
