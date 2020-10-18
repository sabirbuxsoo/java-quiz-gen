import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class PQueue {
	/* The PQueue class has takes a random Integer Array List and generates a Priority Queue.
	 * It has 3 parts to generate a Queue from:
	 * 1. Given an Array List and returns a Priority Queue.
	 * 2. Given a specific integer that is not currently found in the Queue and returns a Queue with the new element inserted accordingly
	 * 3. It removes a specified element and returns a newly ordered Queue
	 * 
	 * Class Made By: Mlungiseleli Notshokovu 
	 * The class and some of the objects are referenced from the following websites to ensure correct outputs:
	 * https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
	 * https://www.geeksforgeeks.org/generating-random-numbers-in-java/
	 * https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
	 * */
		
		//Initialize Priority Queue
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		ListRandomizer lr = new ListRandomizer();//Initialize an instance of class ListRandomizer to get access to its objects, which will then be used in this class.
		Random rand; //instance of random class
		ArrayList<Integer> temp;
		ArrayList<Integer> qList;
		
		//insert a single value to the Queue
		public void insertValue(int num) {
			if	(pQueue.contains(num) == false){
				pQueue.add(num);
			}
			else {
				insertValue(num+3);
			}
		}
		
		//checks if Priority Queue already contains the element, increments 1 until the value is not within the Queue
		public int checkDuplicate(int num) {
			
			while((pQueue.contains(num) == true)|(num == 0)) {
				num++;
			}
			return num;
		}
		
		//to reshuffle an ArrayList and return a string version
		public String arrayShuffle() {
			ListRandomizer.shuffleList(temp);
			return temp.toString();
		}
		
		//A method to add an Array of integers to a Priority Queue
		public void addList(ArrayList<Integer> qList) {
			temp = new ArrayList<Integer>();
			temp = qList;
			this.qList = qList;
			pQueue.addAll(this.qList);
		}
		
		//Removes a specified value from the existing Priority Queue
		public void removeValue(int num) {
			pQueue.remove(num);
			
		}
}
