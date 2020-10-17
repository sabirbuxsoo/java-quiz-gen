import java.io.IOException;
import java.util.Scanner;

class Driver {
    public static void main(String args[]) throws IOException {
        int choice;
        System.out.println("~~~ Welcome to Data Structures Quiz Generator ~~~");
        Scanner command = new Scanner(System.in);
        while(true){            
            System.out.println("Please chose the Data Structure you would like to generate questions for from the list below:");
            System.out.println("1. Binary Search Tree");
            System.out.println("2. AVL Tree");
            System.out.println("3. Hashtable");
            System.out.println("4. Priority Queue");
            System.out.println("5. Create Test");
            System.out.println("0. Exit");
            System.out.println("Choice: ");      
            
            while (true){
                choice = command.nextInt();

                if(choice == 1){
                    System.out.println("########### Binary Search Tree ###########");
                    BSTQuestion bstQuestion = new BSTQuestion(command);
                    bstQuestion.promptUser();
                }else if(choice == 2){
                    System.out.println("2. Hash Tables");
                    Hashtable x = new Hashtable();
                    x.genMain();
                }else if(choice == 3){
                    System.out.println("3. Priority Queues");
                }else if(choice == 0){
                    System.out.println("Goodbye!");
                    System.exit(0);
                }

                System.out.println("########### What would you like to do next? ###########");
                System.out.println("0. Exit");
                System.out.println("9. Go back to main menu");
                System.out.println("Choice: ");

                choice = command.nextInt();
                if(choice == 0){
                    System.out.println("Goodbye!");
                    System.exit(0);
                }else if(choice == 9){
                    break;
                }
            }   
        }  
    }
}