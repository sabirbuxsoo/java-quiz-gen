import java.security.SecureRandom;
import java.util.*;
import java.io.*;

public class HashtableQuestion
{
    public static Hashtable hashtable = new Hashtable();
    public void generateQuestion(String[] array) throws IOException
    {
        Random rd = new Random();
        String[] Array = new String[array.length];

        String insertionQuestion = "\nQuestion(1 point)\nWhat is the resulting hashtable after inserting the following elements "+Arrays.toString(array)+" in a hashtable of length "+hashtable.maxSize+" using the linear probing scheme and the hash function is h(x) = x % "+hashtable.maxSize+" ?\n";

        if(hashtable.questionTypeChoice == 1) //Insertion question
        {
            if(hashtable.variations == 1)
            {
                File file = new File("questionTextFileInsertion.txt");
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println(insertionQuestion);
                for(int i=0; i<array.length; i++)
                {
                    hashtable.put(array[i]);
                }
                printWriter.println("*A.Hashtable 1, "+hashtable.toString());
                hashtable.clear();

                Array = hashtable.shuffleArray(array);
                for(int j=0; j<array.length; j++)
                {
                    hashtable.put(Array[j]);
                }
                printWriter.println("B.Hashtable 2, "+hashtable.toString());
                hashtable.clear();

                Array = hashtable.shuffleArray(array);
                for(int a=0; a<array.length; a++)
                {
                    hashtable.put(Array[a]);
                }
                printWriter.println("C.Hashtable 3, "+hashtable.toString());
                hashtable.clear();

                Array = hashtable.shuffleArray(array);
                for(int b=0; b<array.length; b++)
                {
                    hashtable.put(Array[b]);
                }
                printWriter.println("D.Hashtable 4, "+hashtable.toString());
                hashtable.clear();
                
                printWriter.println("E.None of the options\n#randomize");

                printWriter.close();
            }

            else
            {
                File file = new File("questionTextFileInsertion.txt");
                FileWriter fileWriter = new FileWriter(file,true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                printWriter.println(insertionQuestion);
                for(int i=0; i<array.length; i++)
                {
                    hashtable.put(array[i]);
                }
                printWriter.println("*A.Hashtable 1, "+hashtable.toString());
                hashtable.clear();

                Array = hashtable.shuffleArray(array);
                for(int j=0; j<array.length; j++)
                {
                    hashtable.put(Array[j]);
                }
                printWriter.println("B.Hashtable 2, "+hashtable.toString());
                hashtable.clear();

                Array = hashtable.shuffleArray(array);
                for(int a=0; a<array.length; a++)
                {
                    hashtable.put(Array[a]);
                }
                printWriter.println("C.Hashtable 3, "+hashtable.toString());
                hashtable.clear();

                Array = hashtable.shuffleArray(array);
                for(int b=0; b<array.length; b++)
                {
                    hashtable.put(Array[b]);
                }
                printWriter.println("D.Hashtable 4, "+hashtable.toString());
                hashtable.clear();
                
                printWriter.println("E.None of the options\n#randomize");
                
                printWriter.close();
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Type of question to generate.\n1. Insertion\n2. Deletion\n3. TorF\n4. MCQ\n5. Fill in the blank ");
        System.out.print("Enter number and press ENTER: ");
        hashtable.questionTypeChoice = sc.nextInt();

        HashtableQuestion qg = new HashtableQuestion();
        String[] array = hashtable.listOfRandomItems(0,25);
        String[] temp = new String[hashtable.maxSize];
        for(int j=0; j<hashtable.maxSize; j++)
            temp[j]=array[j];

        if(hashtable.questionTypeChoice == 1)
        {
            System.out.print("\nEnter the number of variations: ");
            hashtable.variations = sc.nextInt();
            if(hashtable.variations == 1)
            {
                qg.generateQuestion(temp);
                System.out.println("\nTextfile Generated!");
            }
            else
            {
                for(int i=0; i<hashtable.variations; i++)
                {
                    qg.generateQuestion(temp);
                }
                System.out.println("\nTextfile Generated!");
            }
        }  
    }
}