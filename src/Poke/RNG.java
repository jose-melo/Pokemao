package Poke;

public class RNG {
	    	
		public static boolean rolaDado(int chance) {
	        int SIDES = 100;
	        int roll = (int) (Math.random() * SIDES);
	        if(roll<=chance)
	        	return true;
	        return false;
	    }
	    
	    public static int rolaPoke(int num_poke) {
	    	int NUM_POKE = num_poke;
	        int roll = (int) (Math.random() * NUM_POKE);
	        return roll;
	    }
	    
	    
	    public static void main(String args[])
	    {
	    	boolean d = RNG.rolaDado(33);
	    	System.out.println("asdasd "+d);
	    }
}
