package Poke;

public class RNG {
	    public static boolean rolaDado(int chance) {
	        int SIDES = 100;
	        int roll = (int) (Math.random() * SIDES);
	        if(roll<=chance)
	        	return true;
	        return false;
	    }
	    public static void main(String args[])
	    {
	    	boolean d = RNG.rolaDado(33);
	    	System.out.println("asdasd "+d);
	    }
}
