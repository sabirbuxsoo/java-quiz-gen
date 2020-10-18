import java.io.IOException;
import java.util.Scanner;

/**
 * This is the main Driver class which allows interaction with the program from the CLI
 * The class takes input form the user and performs various operations (generates questions)
 * Author: Sabir Buxsoo (BXSMUH001)
 */

class Driver {
    public static void main(String args[]) throws IOException {
        int choice;
        System.out.println("############################################################################");
        System.out.println("###########                                                      ###########");
        System.out.println("###########      Welcome to Data Structures Quiz Generator       ###########");
        System.out.println("###########                                                      ###########");
        System.out.println("############################################################################");
        Scanner command = new Scanner(System.in);
        while(true){            
            System.out.println();
            System.out.println("Please chose the Data Structure from the list below:");
            System.out.println();
            System.out.println("1. Binary Search Tree");
            System.out.println("2. AVL Tree");
            System.out.println("3. Hashtable");
            System.out.println("4. Priority Queue");
            System.out.println("5. Create Test");
            System.out.println("0. Exit");
            System.out.println();
            System.out.println("Enter Choice: ");      
            
            while (true){
                choice = command.nextInt();

                if(choice == 1){
                    System.out.println("############################################################################");
                    System.out.println("###########                                                      ###########");
                    System.out.println("###########                 Binary Search Tree                   ###########");
                    System.out.println("###########                                                      ###########");
                    System.out.println("############################################################################");
                    System.out.println();
                    BSTQuestion bstQuestion = new BSTQuestion(command);
                    bstQuestion.promptUser();
                }else if(choice == 2){
                    System.out.println("############################################################################");
                    System.out.println("###########                                                      ###########");
                    System.out.println("###########                      AVL Tree                        ###########");
                    System.out.println("###########                                                      ###########");
                    System.out.println("############################################################################");
                    System.out.println();
                    AVLQuestion avlQuestion = new AVLQuestion(command);
                    avlQuestion.promptUser();
                }else if(choice == 3){
                    System.out.println("############################################################################");
                    System.out.println("###########                                                      ###########");
                    System.out.println("###########                      Hashtable                       ###########");
                    System.out.println("###########                                                      ###########");
                    System.out.println("############################################################################");
                    System.out.println();
                    HashtableQuestion hsQuestion = new HashtableQuestion(command);
                    hsQuestion.promptUser();
                }else if(choice == 4){
                    System.out.println("############################################################################");
                    System.out.println("###########                                                      ###########");
                    System.out.println("###########                       PQueue                         ###########");
                    System.out.println("###########                                                      ###########");
                    System.out.println("############################################################################");
                    System.out.println();
                    PqQuestion pqQuestion = new PqQuestion(command);
                    pqQuestion.promptUser();
                }else if(choice == 5){
                    System.out.println("############################################################################");
                    System.out.println("###########                                                      ###########");
                    System.out.println("###########                    Create Test                       ###########");
                    System.out.println("###########                                                      ###########");
                    System.out.println("############################################################################");
                    System.out.println();
                    CreateTest test = new CreateTest(command);
                    test.promptUser();
                }else if(choice == 0){
                    System.out.println("Goodbye!");
                    System.exit(0);
                }

                System.out.println("############################################################################");
                System.out.println("###########                                                      ###########");
                System.out.println("###########           What would you like to do next?            ###########");
                System.out.println("###########                                                      ###########");
                System.out.println("############################################################################");
                System.out.println();
                System.out.println("0. Exit");
                System.out.println("9. Go back to main menu");
                System.out.println();
                System.out.println("Enter Choice: ");
                choice = command.nextInt();
                if(choice == 0){
                    System.out.println("Goodbye!");
                    System.exit(0);
                }else if(choice == 9){
                    break;
                }else{
                    System.out.println("Option unavailable. You will be redirected to the Main Menu");
                    break;
                }
            }   
        }  
    }
}