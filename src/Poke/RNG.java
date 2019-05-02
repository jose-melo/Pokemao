package Poke;

public class RNG {
	    public static boolean rolaDado() {
	        int SIDES = 2;
	        int roll = (int) (Math.random() * SIDES);
	        if(roll==1)
	        	return true;
	        return false;
	    }
	    public static void main(String args[])
	    {
	    	boolean d = RNG.rolaDado();
	    	System.out.println("asdasd "+d);
	    }
}
