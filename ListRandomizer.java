import java.util.ArrayList;
import java.util.Random;

public class ListRandomizer {
	
/* This class has the following objects:
 * An array list object to randomly generate an ArrayList of size < 30
 * An object to swap and shuffle an array list 
 * By: Mlungiseleli Notshokovu 
 * Reference:
 * https://www.journaldev.com/32661/shuffle-array-java
 */
	public ArrayList<Integer> getArr() {
	    int max = 30; 
	    int min = 1; 
	    int range = max - min + 1; 
	    ArrayList<Integer> arr = new ArrayList();
	    // generate random numbers within 1 to 10 
	    for (int i = 0; i < 10; i++) { 
	        int rand = (int)(Math.random() * range) + min; 
	        if (!arr.contains(rand)) {
	        	arr.add(rand);
	        }
	    }
	    return arr;
	}

    public static void shuffleList(ArrayList<Integer> a) {
        int n = a.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(ArrayList<Integer> a, int i, int change) {
        int helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }
}