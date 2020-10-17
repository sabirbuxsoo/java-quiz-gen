import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class is used to create a package with different pools of questions for each data structure.
 * This is done as the bonus feature for the project
 * This class can be used to generate question quickly for a Test, for example. This makes the process much faster.
 * Author: Sabir Buxsoo
 * 
 */
public class CreateTest {
    Scanner scan;
    int numQuestions;
    String dirName, points;
    CreateTest(Scanner scan) {
        this.scan = scan;
    }

    // This method write the answers to the output file
    static void writeAnswers(String dirName, String fileName, String outputAns) throws IOException {
        try
        {
            Path path = Paths.get("generatedQuestions/"+dirName+"/");
            Files.createDirectories(path);

            PrintWriter writer = new PrintWriter("generatedQuestions/"+dirName+"/"+fileName+".txt");
            writer.println(outputAns);
            System.out.println();
            System.out.println("##########     " + fileName + ".txt Successfully Generated     ##########");
            System.out.println();
            writer.close();

        }
        catch (FileNotFoundException ex) 
        {
           System.out.println("File not found");
        }
      }

      void promptUser(){
        System.out.print("Enter number of questions you want generated and press Enter: ");
        numQuestions = scan.nextInt();
        System.out.print("Enter number of points for each question: ");
        points = scan.next();
        System.out.print("Enter Test Directory name: ");
        dirName = scan.next();

        //BST Questions
        for(int x = 0; x<4; x++){
            String finalAnswers = "";
            String fileName = "BST-Q" + Integer.toString(x+1);
            switch (x+1) {
                case 1:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += BSTQuestion.one(points);
                    }
                    break;
                case 2:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += BSTQuestion.two(points);
                    }
                    break;
                case 3:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += BSTQuestion.three(points);
                    }
                    break;
                case 4:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += BSTQuestion.four(points);
                    }
                    break;
                default:
                    System.out.println("Wrong selection. Please try again");
                    break;
            }
            try {
                writeAnswers(dirName, fileName, finalAnswers);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //AVLQuestions
        for(int x = 0; x<4; x++){
            String finalAnswers = "";
            String fileName = "AVL-Q" + Integer.toString(x+1);
            switch (x+1) {
                case 1:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += AVLQuestion.one(points);
                    }
                    break;
                case 2:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += AVLQuestion.two(points);
                    }
                    break;
                case 3:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += AVLQuestion.three(points);
                    }
                    break;
                case 4:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += AVLQuestion.four(points);
                    }
                    break;
                default:
                    System.out.println("Wrong selection. Please try again");
                    break;
            }
            try {
                writeAnswers(dirName, fileName, finalAnswers);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //Hashtable Questions
        for(int x = 0; x<1; x++){
            String finalAnswers = "";
            String fileName = "Hashtable-Q" + Integer.toString(x+1);
            switch (x+1) {
                case 1:
                    for (int i = 0; i < numQuestions; i++) {
                        finalAnswers += HashtableQuestion.one(points);
                    }
                    break;
                default:
                    System.out.println("Wrong selection. Please try again");
                    break;
            }
            try {
                writeAnswers(dirName, fileName, finalAnswers);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
      }
}
