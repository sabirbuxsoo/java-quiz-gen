import java.util.Random;
import java.util.Scanner;

/**
 * This class contains the questions for Binary Search Tree (BST) 
 * Class Made By: Mlungiseleli Notshokovu
 */

class PqQuestion extends AnswerHelper{
	/*returns a multiple choice question and answer based on the option chosen:
	 * Choice 1: returns a Priority Queue from a randomly generated list
	 * Choice 2: returns a newly ordered Priority Queue after inserting a random generated value
	 * Choice 3: returns a newly ordered Priority Queue after deleting a random value from the Queue
	 */

    Scanner scan;

    PqQuestion(){
        
    }
    
    PqQuestion(Scanner scan){
        this.scan = scan;
    }


    static String createHeap(String points) {
        PQueue qq = new PQueue();
        ListRandomizer lr = new ListRandomizer(); // This creates a randomized list to pass into the Priority Queue
        
        String answer;
        qq.addList(lr.getArr());
        answer = qq.pQueue.toString();
        qq.pQueue.clear();

        // Create Question
        String question = "Min-heap: What is the resulting Priority Queue from this list " + qq.qList + "?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(answer); // Generate Answers
        String questionOne = point + "\n" + question + "\n" + ans;
        return questionOne;
    }

    static String createInsert(String points) {
        PQueue qq = new PQueue();
        ListRandomizer lr = new ListRandomizer(); // This creates a randomized list to pass into the Priority Queue
        Random rand = new Random();

        qq.addList(lr.getArr());
        // generate random values from 0-30
        int int_random = rand.nextInt(30);
        String queue = qq.pQueue.toString();
        int random_num = qq.checkDuplicate(int_random);
        qq.insertValue(random_num);// Inserts the random generated value
        String answer = qq.pQueue.toString();// Storing the queue answer clearing the queue
        qq.pQueue.clear();// Clear Priority Queue after retrieving question and answer

        // Create Question
        String question = "Min-heap: What is the resulting Priority Queue when the value " + random_num
                + " is inserted to the list " + queue + "?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(answer); // Generate Answers
        String questionTwo = point + "\n" + question + "\n" + ans;
        return questionTwo;
    }

    static String createDelete(String points) {
        PQueue qq = new PQueue();
        ListRandomizer lr = new ListRandomizer(); // This creates a randomized list to pass into the Priority Queue

        qq.addList(lr.getArr());
        int n = qq.qList.size() - 1;
        int random_num = lr.getRandomVal(n);// Generate a random number based on array size
        int random_val = qq.qList.get(random_num);// get the value to be removed from the Priority Queue
        String queue = qq.pQueue.toString();// Original Priority Queue
        qq.pQueue.remove(random_val);// remove value from Priority Queue
        String answer = qq.pQueue.toString();
        qq.pQueue.clear();

        // Create Question
        String question = "Min-heap: What is the resulting Priority Queue from deleting value " + random_val + " from the list "
                + queue + "?";
        String point = "Question (" + points + " point)";
        String ans = generateAnswers(answer); // Generate Answers
        String questionThree = point + "\n" + question + "\n" + ans;
        return questionThree;
    }


    // Method to Generate questions from user selection. Method also takes number of
    // questions to be generated
    static void generateQuestions(int numQuestions, int selection, String fileName, String points) {
        String finalAnswers = "";
        switch (selection) {
            case 1:

                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += createHeap(points);
                }
                break;
            case 2:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += createInsert(points);
                }
                break;
            case 3:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += createDelete(points);
                }
                break;
            default:
                System.out.println("Wrong selection. Please try again");
                break;
        }
        writeAnswers(fileName, finalAnswers);
    }

    void promptUser(){
        System.out.println("Select question to generate:\n1. Find resulting Priority queue from list\n2. Resulting priority queue after insert\n3. Resulting priority queue after delete");
        System.out.print("Enter question selection and press Enter: ");
        int selection = scan.nextInt();
        System.out.print("Enter number of questions you want generated and press Enter: ");
        int numQuestions = scan.nextInt();
        System.out.print("Enter number of points for each question: ");
        String points = scan.next();
        System.out.print("Enter output file name to save questions (do not add extension): ");
        String fileName = scan.next();
        generateQuestions(numQuestions, selection, fileName, points);
    }
}
