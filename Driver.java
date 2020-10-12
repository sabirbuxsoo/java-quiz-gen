import java.util.Scanner;

class Driver{
    public static void main(String args[]){
        System.out.println("~~~ Welcome to Data Structures Quiz Generator ~~~");
        System.out.println("The following options are available:");
        System.out.println("1. Linear Data Structures");
        System.out.println("2. Non-linear Data Structures");
        System.out.println("3. Exit");

        Scanner command = new Scanner(System.in);
        System.out.println("Choice: ");

        int choice = command.nextInt();

        if(choice == 1){
            System.out.println("You selected Linear Data Structures");
        }else if(choice == 2){
            System.out.println("Please chose the Non-linear Data Structure you would like to generate questions for from the list below:");
            System.out.println("1. Binary Search Tree");
            System.out.println("2. Hash Tables");
            System.out.println("3. Priority Queues");
            System.out.println("0. Exit");
            System.out.println("Choice:");
            choice = command.nextInt();

            if(choice == 1){
                System.out.println("1. Binary Search Tree");
            }else if(choice == 2){
                System.out.println("2. Hash Tables");
            }else if(choice == 3){
                System.out.println("3. Priority Queues");
            }else if(choice == 0){
                System.exit(0);
            }

        }else if(choice == 0){
            System.out.println("Goodbye!");
        }

    }
}