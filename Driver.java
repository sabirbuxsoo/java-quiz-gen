import java.util.Scanner;

class Driver{
    public static void main(String args[]){
        System.out.println("~~~ Welcome to Data Structures Quiz Generator ~~~");
        System.out.println("The following options are available:");
        System.out.println("1. Linear Data Structures");
        System.out.println("2. Non-linear Data Structures");
        System.out.println("3. Exit");

        Scanner command = new Scanner(System.in);
        System.out.println("Enter the number of your choice and press Enter: ");

        int choice = command.nextInt();

        if(choice == 1){
            System.out.println("You selected Linear Data Structures");
        }else if(choice == 2){
            System.out.println("You selected Non-linear Data Structures");
        }else if(choice == 0){
            System.out.println("Goodbye!");
        }

    }
}