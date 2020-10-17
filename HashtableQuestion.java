import java.security.SecureRandom;
import java.util.*;
import java.io.*;

public class HashtableQuestion extends AnswerHelper
{
    Scanner scan;
    HashtableQuestion(Scanner scan){
        this.scan = scan;
    }

    static String one(String points) {
        Hashtable hashtable = new Hashtable();
        ArrayGenerator arrayGen = new ArrayGenerator();

        String[] array = Arrays.stream(arrayGen.getArray()).mapToObj(String::valueOf).toArray(String[]::new);


        for (int i = 0; i < array.length; i++) {
            hashtable.put(array[i]);
        }

        String point = "Question (" + points + " point)";
        String insertionQuestion = "What is the resulting hashtable after inserting the following elements "
                + Arrays.toString(array) + " in a hashtable of length " + hashtable.maxSize
                + " using the linear probing scheme and the hash function is h(x) = x % " + hashtable.maxSize + " ?";
        String ans = generateHashtableAnswers(hashtable.toString()); // Generate Answers
        String questionOne = point + "\n" + insertionQuestion + "\n" + ans;
        hashtable.clear();

        return questionOne;
    }

    // Method to Generate questions from user selection. Method also takes number of
    // questions to be generated
    static void generateQuestions(int numQuestions, int selection, String fileName, String points) {
        String finalAnswers = "";
        switch (selection) {
            case 1:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += one(points);
                }
                break;
            case 2:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += one(points);
                }
                break;
            default:
                System.out.println("Wrong selection. Please try again");
                break;
        }
        writeAnswers(fileName, finalAnswers);
    }

    void promptUser(){
        System.out.println("Select question to generate:\n1. Insert values into hash table with linear probing\n2. Delete value from hashtable\n");
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