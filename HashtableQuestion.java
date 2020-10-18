import java.util.*;

public class HashtableQuestion extends AnswerHelper
{
    Scanner scan;

    HashtableQuestion(){
        
    }
    HashtableQuestion(Scanner scan){
        this.scan = scan;
    }

    static String one(String points) {
        int htSize = 7;
        Hashtable hashtable = new Hashtable(htSize);
        ArrayGenerator arrayGen = new ArrayGenerator();

        String[] array = Arrays.stream(arrayGen.getArray()).mapToObj(String::valueOf).toArray(String[]::new);


        for (int i = 0; i < array.length; i++) {
            hashtable.put(array[i]);
        }

        String point = "Question (" + points + " point)";
        String insertionQuestion = "What is the resulting hashtable after inserting the keys "
        + Arrays.toString(array) + " into an initially empty hashtable of length " + hashtable.getMaxSize()
        + " using open addressing with hash function is h(x) = x % " + hashtable.getMaxSize() + " and linear probing ?";
        String ans = generateHashtableAnswers(hashtable.toString()); // Generate Answers
        String questionOne = point + "\n" + insertionQuestion + "\n" + ans;
        hashtable.clear();

        return questionOne;
    }

    static String two(String points) {
        int htSize = 10;
        Hashtable hashtable = new Hashtable(htSize);
        ArrayGenerator arrayGen = new ArrayGenerator();

        String[] array = Arrays.stream(arrayGen.getArray()).mapToObj(String::valueOf).toArray(String[]::new);


        for (int i = 0; i < array.length; i++) {
            hashtable.put(array[i]);
        }

        String point = "Question (" + points + " point)";
        String insertionQuestion = "What is the resulting hashtable after inserting the keys "
        + Arrays.toString(array) + " into an initially empty hashtable of length " + hashtable.getMaxSize()
        + " using open addressing with hash function is h(x) = x % " + hashtable.getMaxSize() + " and linear probing ?";
        String ans = generateHashtableAnswers(hashtable.toString()); // Generate Answers
        String questionTwo = point + "\n" + insertionQuestion + "\n" + ans;
        hashtable.clear();

        return questionTwo;
    }

    static String three(String points) {
        int htSize = 10;
        Hashtable hashtable = new Hashtable(htSize);
        ArrayGenerator arrayGen = new ArrayGenerator();

        int delValue = arrayGen.getDeleteValue();

        String originalHT = hashtable.createHT(arrayGen.getArray());
        
        String delHT = hashtable.remove(delValue);

        String point = "Question (" + points + " point)";
        String insertionQuestion = "What is the resulting hashtable after deleting "
                + delValue + " from the hashtable " + originalHT
                + " assuming LAZY  DELETION ?";
        String ans = generateHashtableAnswers(delHT); // Generate Answers
        String questionThree = point + "\n" + insertionQuestion + "\n" + ans;
        hashtable.clear();

        return questionThree;
    }

    static String four(String points) {
        int htSize = 7;
        Hashtable hashtable = new Hashtable(htSize);
        ArrayGenerator arrayGen = new ArrayGenerator();

        int delValue = arrayGen.getDeleteValue();

        String originalHT = hashtable.createHT(arrayGen.getArray());
        
        String delHT = hashtable.remove(delValue);

        String point = "Question (" + points + " point)";
        String insertionQuestion = "What is the resulting hashtable after deleting "
                + delValue + " from the hashtable " + originalHT
                + " assuming LAZY  DELETION ?";
        String ans = generateHashtableAnswers(delHT); // Generate Answers
        String questionFour = point + "\n" + insertionQuestion + "\n" + ans;
        hashtable.clear();

        return questionFour;
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
                    finalAnswers += two(points);
                }
                break;
            case 3:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += three(points);
                }
                break;
            case 4:
                for (int i = 0; i < numQuestions; i++) {
                    finalAnswers += four(points);
                }break;
            default:
                System.out.println("Wrong selection. Please try again");
                break;
        }
        writeAnswers(fileName, finalAnswers);
    }

    void promptUser(){
        System.out.println("Select question to generate:\n1. Insert values into hash table with linear probing h(k) = x % 7\n2. Insert values into hash table with linear probing h(k) = x % 10\n3. Delete values from a hashtable size 10\n4. Delete values from a hashtable size 7\n");
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