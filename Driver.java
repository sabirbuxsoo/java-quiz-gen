import java.io.IOException;
import java.util.Scanner;

class Driver {
    public static void main(String args[]) throws IOException {
        System.out.println("~~~ Welcome to Data Structures Quiz Generator ~~~");
        

        Scanner command = new Scanner(System.in);
        System.out.println("Please chose the Data Structure you would like to generate questions for from the list below:");
        System.out.println("1. Binary Search Tree");
        System.out.println("2. Hash Tables");
        System.out.println("3. Priority Queues");
        System.out.println("0. Exit");
        
        System.out.println("Choice: ");

        int choice = command.nextInt();

        choice = command.nextInt();

        if(choice == 1){
            System.out.println("1. Binary Search Tree");
        }else if(choice == 2){
            System.out.println("2. Hash Tables");
            Hashtable x = new Hashtable();
            x.genMain();
        }else if(choice == 3){
            System.out.println("3. Priority Queues");
        }else if(choice == 0){
            System.exit(0);
        }

    }
}