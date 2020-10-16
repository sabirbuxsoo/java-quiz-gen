import java.util.*;
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
		lr.shuffleList(temp);
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
	
	/*returns a multiple choice question and answer based on the option chosen:
	 * Choice 1: returns a Priority Queue from a randomly generated list
	 * Choice 2: returns a newly ordered Priority Queue after inserting a random generated value
	 * Choice 3: returns a newly ordered Priority Queue after deleting a random value from the Queue
	 */
	
	public String getChoice(int val) {
		
		if(val == 1) {
			String answer = pQueue.toString();
			pQueue.clear();//Clear Priority Queue after retrieving question and answer
			return "Question(1 point)\nWhat is the resulting Priority Queue from this list "+this.qList+"?\n"+"*A. "+answer+"\nB. "+arrayShuffle()+"\nC. "+arrayShuffle()+"\nD. "+arrayShuffle()+"\n#randomize";
		}
		
		else if(val ==2) {
			rand = new Random();
		    //generate random values from 0-30
		    int int_random = rand.nextInt(30);
		    String queue = pQueue.toString();
		    int random_num = checkDuplicate(int_random);
		    insertValue(random_num);//Inserts the random generated value
		    String answer = pQueue.toString();//Storing the queue answer clearing the queue
		    pQueue.clear();//Clear Priority Queue after retrieving question and answer
			return "Question(1 point)\nWhat is the resulting Priority Queue when the value "+random_num+" is inserted to the list "+queue+"?\n"+"*A. "+answer+"\nB. "+arrayShuffle()+"\nC. "+arrayShuffle()+"\nD. "+arrayShuffle()+"\n#randomize";
		}
		
		else if(val==3) {
			rand = new Random();
			String queue = pQueue.toString();
			//Queue size
			int queueSize = pQueue.size() -1;
			int num = this.qList.get(rand.nextInt(queueSize));
			removeValue(num);//Deletes the random number from the Queue
			String answer = pQueue.toString();
			pQueue.clear();//Clear Priority Queue after retrieving question and answer
			return "Question(1 point)\nWhat is the resulting Priority Queue from deleting value "+num+" from the list "+queue+"?\n"+"*A. "+answer+"\nB. "+arrayShuffle()+"\nC. "+arrayShuffle()+"\nD. "+arrayShuffle()+"\n#randomize";
		}
		
		else {
			return "Option does not exist.";
		}
		
	}

	//Driver Class - to be deleted if separate Driver class already exists
	public static void main(String[] args) {
		PQueue pq = new PQueue();
		Scanner kb = new Scanner(System.in);
		int variation, choice;
		ListRandomizer lr = new ListRandomizer(); //This creates a randomized list to pass into the Priority Queue
		ArrayList<Integer> qList = lr.getArr(); //Randomized Array list for the Priority Queue
		
		System.out.println("Select Type of question to generate:\n1. Priority Queue Heap\n2. Insertion\n3. Deletion");
		choice = kb.nextInt();
		
		if(choice == 1) {
			System.out.println("Enter the number of variations: ");
			variation = kb.nextInt();
			
			for(int i=0; i<variation; i++) {
				pq.addList(lr.getArr());
				System.out.println(pq.getChoice(1));
				System.out.println();
			}
		}
		
		else if(choice == 2) {
			System.out.println("Enter the number of variations: ");
			variation = kb.nextInt();
			for(int i=0; i<variation; i++) {
				pq.addList(lr.getArr());
				System.out.println(pq.getChoice(2));
				System.out.println();
			}

		}
		else if(choice ==3) {
			System.out.println("Enter the number of variations: ");
			variation = kb.nextInt();
			for(int i=0; i<variation; i++) {
				pq.addList(lr.getArr());
				System.out.println(pq.getChoice(3));
				System.out.println();
			}
		}
		else {
			System.out.println("Option does not exist.");
		}
	}
}
