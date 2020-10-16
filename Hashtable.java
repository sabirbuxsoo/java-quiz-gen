//https://www.sanfoundry.com/java-program-implement-hash-tables-linear-probing/

/**
 * @author Sicelokuhle Shabalala
 * @version 1.0
 * @date 31/08/2020
 */

import java.security.SecureRandom;
import java.util.*;
import java.io.*;

/**
 * Hashtable class that implements the Linear Probing scheme for hashing elements
 */
public class Hashtable 
{
    /**
     * Instance Variables
    */
    private int maxSize;
    private int currentSize;
    private int questionTypeChoice;
    private int variations;
    private String[] arrayForKeys;
    private String[] arrayForValues;

    /**
     * Constructor the has no parameters
     */
    public Hashtable()
    {
        this.maxSize = 7;
        this.currentSize = 0;
        this.arrayForKeys = new String[this.maxSize];
        for(int i=0; i<this.maxSize; i++)
            arrayForKeys[i] = i+"";
        this.arrayForValues = new String[this.maxSize];
        for(int i=0; i<this.maxSize; i++)
            arrayForValues[i] = "-";
    }
    
    /**
     * Constructor that takes a parameter capacity for user to specify the hashtable size 
     * @param capacity
     */
    public Hashtable(int capacity)
    {
        this.maxSize = capacity;
        this.currentSize = 0;
        this.arrayForKeys = new String[this.maxSize];
        for(int i=0; i<this.maxSize; i++)
            arrayForKeys[i] = i+"";
        this.arrayForValues = new String[this.maxSize];
        for(int i=0; i<this.maxSize; i++)
            arrayForValues[i] = "-";
    }

    /**
     * Hash function to return a hash value
     * @param value
     * @return
     */
    private int hash(int value)
    {
        return value%this.maxSize;
    }

    /**
     * clear method that empty's the hashtable when called
     */
    public void clear()
    {
        currentSize = 0;
        this.arrayForKeys = new String[this.maxSize];
        for(int i=0; i<this.maxSize; i++)
            arrayForKeys[i] = i+"";
        this.arrayForValues = new String[this.maxSize];
        for(int i=0; i<this.maxSize; i++)
            arrayForValues[i] = "-";
    }

    /**
     * Returns the current size of the hashtable
     * @return
     */
    public int size()
    {
        return currentSize;
    }

    /**
     * put method inserts values into the hashtable to the corresponding keys
     * @param value
     */
    public void put(String value)
    {
        int temp = hash(Integer.parseInt(value));
        int i = temp;

        do
        {
            if(arrayForValues[i] == "-")
            {
                arrayForValues[i] = value;
                currentSize++;
                return;       
            }
            i = (i+1)%this.maxSize;
        }while(i != temp);
    }

    /**
     * Removes the specified element from the hashtable
     * @param array
     * @param valueToRemove
     * @throws IOException
     */
    public void remove(String[] array,String valueToRemove) throws IOException
    {
        if(this.variations == 1)
        {
            File file = new File("questionTextFileDeletion.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int randomKey = 0;
            while(!arrayForValues[randomKey].equals(valueToRemove))
            {
                randomKey++;
            }

            String deletionQuestion = "\nQuestion(1 point)\nWhat is the resulting hash table after deleting the value at key "+this.arrayForKeys[randomKey]+" from the hash table below?\n";
            printWriter.println(deletionQuestion);

            printWriter.println("\nHash table\n"+toString()+"\n");
            
            for(int j=0; j<array.length; j++)
            {
        
                String[] tempArray = new String[array.length];
                
                for(int i=0; i<array.length; i++)
                {
                    tempArray[i] = array[i];
                }

                if(array[j].equals(valueToRemove))
                {
                    if(j==arrayForValues.length-1)
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-2] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-3] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E. None of the options\n#randomize");
                    }

                    else if(j==arrayForValues.length-2)
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-1] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-2] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E. None of the options\n#randomize");
                    }

                    else if(j==arrayForValues.length-3)
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+2] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-1] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E. None of the options\n#randomize");
                    }
                    
                    else
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+2] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+3] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E.None of the options\n#randomize");
                    }
                    break;
                }
            }
            printWriter.close();
        }
        else
        {
            File file = new File("questionTextFileDeletion.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int randomKey = 0;
            while(!arrayForValues[randomKey].equals(valueToRemove))
            {
                randomKey++;
            }

            String deletionQuestion = "\nQuestion(1 point)\nWhat is the resulting hash table after deleting the value at key "+this.arrayForKeys[randomKey]+" from the hash table below?\n";
            printWriter.println(deletionQuestion);

            printWriter.println("\nHash table\n"+toString()+"\n");
            
            for(int j=0; j<array.length; j++)
            {
        
                String[] tempArray = new String[array.length];
                
                for(int i=0; i<array.length; i++)
                {
                    tempArray[i] = array[i];
                }

                if(array[j].equals(valueToRemove))
                {
                    if(j==arrayForValues.length-1)
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-2] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-3] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E. None of the options\n#randomize");
                    }

                    else if(j==arrayForValues.length-2)
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-1] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-2] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E. None of the options\n#randomize");
                    }

                    else if(j==arrayForValues.length-3)
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+2] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j-1] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();

                        printWriter.println("E. None of the options\n#randomize");
                    }
                    
                    else
                    {
                        arrayForValues[j] = "-";
                        printWriter.println("*A. Hashtable 1\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+1] = "-";
                        printWriter.println("B. Hashtable 2\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+2] = "-";
                        printWriter.println("C. Hashtable 3\n"+toString());
                        clear();

                        shuffleArray(tempArray);
                        for(int i=0; i<array.length; i++)
                        {
                            put(tempArray[i]);
                        }
                        arrayForValues[j+3] = "-";
                        printWriter.println("D. Hashtable 4\n"+toString());
                        clear();
                        printWriter.println("E.None of the options\n#randomize");
                    }
                    break;
                }
            }
            printWriter.close();
        }
    }

    /**
     * Return a String value of the hashtable
     * @return
     */
    public String toString()
    {
        String hashtable = "Key Value\n";

        for(int i=0; i<this.maxSize; i++)
        {
            hashtable = hashtable+String.format("%3s %5s\n",arrayForKeys[i],arrayForValues[i]);
        }
        return hashtable;
    }

    /**
     * Returns a list of Random string items
     * @param start
     * @param end
     * @return
     */
    public String[] listOfRandomItems(int start, int end)
    {
        int n = end-start+1;

        int[] a = new int[n];

        for(int i=0; i<n; i++)
        {
            a[i] = i;
        }

        String[] result = new String[n];
        int x = n;
        SecureRandom srd = new SecureRandom();
        for(int i=0; i<n; i++)
        {
            int k = srd.nextInt(x);
            result[i] = a[k]+"";
            a[k] = a[x-1];
            x--;
        } 
        return result;
    }

    /**
     * Method to shuffle array values for users to attain same values in different order
     * @param array
     */
    private void shuffleArray(String[] array)
    {
        int index; 
        String temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Return a list of random numbers
     * @param start
     * @param end
     * @return
     */
    public int[] listOfRandomNumbers(int start, int end)
    {
        int n = end-start+1;

        int[] a = new int[n];

        for(int i=0; i<n; i++)
        {
            a[i] = i;
        }

        int[] result = new int[n];
        int x = n;
        SecureRandom srd = new SecureRandom();
        for(int i=0; i<n; i++)
        {
            int k = srd.nextInt(x);
            result[i] = a[k];
            a[k] = a[x-1];
            x--;
        } 
        return result;
    }

    /**
     * Generates a textfile containing a question that user wants i.e. Insertion, Deletion, TorF, MCQ, Fill in the blank or Numeric answer type of question.
     * @param trueArray
     * @throws IOException
     */
    public void generateQuestion(String[] trueArray) throws IOException
    {
        Random rd = new Random();
        if(this.questionTypeChoice == 1) //Insertion question
        {
            if(this.variations == 1)
            {
                File file = new File("questionTextFileInsertion.txt");
                FileWriter fileWriter = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                String insertionQuestion = "\nQuestion(1 point)\nWhat is the resulting hashtable after inserting the following elements "+Arrays.toString(trueArray)+" in a hashtable of length "+this.maxSize+" using the linear probing scheme and the hash function is h(x) = x % "+this.maxSize+" ?\n";
        
                printWriter.println(insertionQuestion);
                for(int i=0; i<trueArray.length; i++)
                {
                    put(trueArray[i]);
                }
                printWriter.println("*A. Hash Table 1\n"+toString());
                clear();

                shuffleArray(trueArray);
                for(int j=0; j<trueArray.length; j++)
                {
                    put(trueArray[j]);
                }
                printWriter.println("B. Hash Table 2\n"+toString());
                clear();

                shuffleArray(trueArray);
                for(int a=0; a<trueArray.length; a++)
                {
                    put(trueArray[a]);
                }
                printWriter.println("C.Hash table 3\n"+toString());
                clear();

                shuffleArray(trueArray);
                for(int b=0; b<trueArray.length; b++)
                {
                    put(trueArray[b]);
                }
                printWriter.println("D.Hash table 4\n"+toString());
                clear();
                
                printWriter.println("E. None of the options\n#randomize");

                printWriter.close();
            }
            else
            {
                File file = new File("questionTextFileInsertion.txt");
                FileWriter fileWriter = new FileWriter(file,true);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                String insertionQuestion = "\nQuestion(1 point)\nWhat is the resulting hashtable after inserting the following elements "+Arrays.toString(trueArray)+" in a hashtable of length "+this.maxSize+" using the linear probing scheme and the hash function is h(x) = x % "+this.maxSize+" ?\n";
        
                printWriter.println(insertionQuestion);
                for(int i=0; i<trueArray.length; i++)
                {
                    put(trueArray[i]);
                }
                printWriter.println("*A. Hash Table 1\n"+toString());
                clear();

                shuffleArray(trueArray);
                for(int j=0; j<trueArray.length; j++)
                {
                    put(trueArray[j]);
                }
                printWriter.println("B. Hash Table 2\n"+toString());
                clear();

                shuffleArray(trueArray);
                for(int a=0; a<trueArray.length; a++)
                {
                    put(trueArray[a]);
                }
                printWriter.println("C.Hash table 3\n"+toString());
                clear();

                shuffleArray(trueArray);
                for(int b=0; b<trueArray.length; b++)
                {
                    put(trueArray[b]);
                }
                printWriter.println("D.Hash table 4\n"+toString());
                clear();
                
                printWriter.println("E. None of the options\n#randomize");

                printWriter.close();
            }
        }

        else if(this.questionTypeChoice == 2)//Deletion Question
        {
            int randomKey = rd.nextInt(this.arrayForKeys.length);
            for(int i=0; i<trueArray.length; i++)
            {
                put(trueArray[i]);
            }
            remove(arrayForValues, arrayForValues[randomKey]);
        }

        else if(this.questionTypeChoice == 3)//True or False questions
        {
            File file = new File("questionTextFileTorF.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String[] arrayOfTorFQuestions = {"\nQuestion(1 point)\nInsert, Delete and Search are constant time operations [O(1)] in hash tables.\n*A. True\nB. False",
                                            "\nQuestion(1 point)\nA hash table is a data structure that maps values to keys.\nA. True\n*B. False",
                                            "\nQuestion(1 point)\nThe load factor in hash tables is defined as the ratio of the number of elements in the hash table to the table size.\n*A. True\nB. False",
                                            "\nQuestion(1 point)\nIn linear probing, an unsuccessful search takes shorter than a successful search.\nA. True\n*B. False",
                                            "\nQuestion(1 point)\nThe load factor for chaining must always be less than 1.\nA. True\n*B. False",
                                            "\nQuestion(1 point)\nChaining is used when the total number of elements to hash is known.\nA. True\n*B. False",
                                            "\nQuestion(1 point)\nThe load factor is one factor that affects the performance of hashing schemes.\n*A. True\nB. False",
                                            "\nQuestion(1 point)\nHashing is the problem of finding an appropriate mapping of keys into addresses.\n*A. True\nB. False",
                                            "\nQuestion(1 point)\nWhen a hash function indicates that two different items should be stored in the same location, this is called a collision.\n*A. True\nB. False",
                                            "\nQuestion(1 point)\nWhen using separate chaining for each index, the number of items that can be stored in a hash table is limited by the size of the hash table.\nA. True\n*B. False"};

            int[] index = listOfRandomNumbers(0,arrayOfTorFQuestions.length-1);
            Random random = new Random();
            int i = random.nextInt(index.length-1);
            printWriter.println(arrayOfTorFQuestions[index[i]]);
            printWriter.close();
        }

        else if(this.questionTypeChoice == 4)//MCQ questions
        {
            File file = new File("questionTextFileMCQ.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String[] mcqQuestions = {"\nQuestion(1 point)\nWhat is a hash function?\n*A. A function that computes the location of the key  in the array.\nB. A function that creates an array.\nC. A Function that computes the location of the values in the array.\nD. A function that allocates memory to keys.\nE. None of the options\n#randomize",
                                    "\nQuestion(1 point)\nIn simple chaining implementation, what data structure is appropriate?\n*A. Doubly linked list.\nB. Binary Tree.\nC. Circular linked list.\nD. Singly linked list.\nE None of the options\n#randomize",
                                    "\nQuestion(1 point)\nWhat is the advantage of a hash table as a data structure?\n*A. Faster access of data.\nB. Easy to implement.\nC. Very efficient for less number od entries.\nD. Exhibit good locality of reference.\nE. None of the options\n#randomize",
                                    "\nQuestion(1 point)\nWhat is a hash table?\n*A. A data structure that maps keys to values.\nB. A data structure that maps values to keys.\nC. A data structure used for storage.\nD. A data structure used to implement stack and queue.\nE. None of the options\n#randomize",
                                    "\nQuestion(1 point)\nIf several elements are competing for the same bucket in the hash table, what is it called?\n*A. Collision\nB. Replication\nC. Diffusion\nD. Duplication\nE. None of the options\n#randomize",
                                    "\nQuestion(1 point)\nIn simple uniform hashing, what is the search complexity?\n*A. O(1)\nB. O(n)\nC. O(logn)\nD. O(nlogn)\nE. None of the options\n#randomize",
                                    "\nQuestion(1 point)\nWhich of the following is not a collision resolution technique?\n*A. Hashing\nB. Linear probing\nC. Quadratic probing\nD. Chaining\nE. None of the options\n#randomize",
                                    "\nQuestion(1 point)\nWhich of the following operations are done in a hash table?\n*A. Insert and Search\nB. Insert only\nC.Search only\nD. Replace\nE. None of the options\n#randomize"};

            int[] index = listOfRandomNumbers(0,mcqQuestions.length-1);
            Random random = new Random();
            int i = random.nextInt(index.length-1);
            printWriter.println(mcqQuestions[index[i]]);
            printWriter.close();
        }

        else if(this.questionTypeChoice == 5)//Fill in the blank questions
        {
            File file = new File("questionTextFileFillInTheBlank.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String[]  FillInTheBlankQuestion = {"\nQuestion(1 point)\nThe__________ method for handling collisions looks for another open position in the table other than the one to which the element is originally hashed. \n*A. Open addressing\nB. Load Factor\nC. Closed addressing\nD. Hash Function\nE. None of the options\n#randomize",
                                                "\nQuestion(1 point)\n__________ is the maximum percentage occupancy allowed in the hash table before it is resized.\n*A. Load Factor\nB. Max size\nC. Table size\nD. Collision\nE. None of the options\n#randomize",
                                                "\nQuestion(1 point)\nThe __________ method for handling collisions simply treats the hash table conceptually as a table of collections rather than as a table of individual cells.\n*A. Chaining\nB. Linear Probing\nC. Double Hashing\nD. Quadratic Probing\nE. None of the options\n#randomize",
                                                "\nQuestion(1 point)\nChaining involves a __________ at each location in the hash table.\n*A. Linked List\nB. Queue\nC. Array\nD. Binary Search Tree\nE. None of the options\n#randomize",
                                                "\nQuestion(1 point)\nA hashing function that maps each element to a unique position in the table is said to be a __________ hashing function.\n*A. perfect\nB. imperfect\nC. regular\nD. iregular\nE.None of the options\n#randomize"};

            int[] index = listOfRandomNumbers(0,FillInTheBlankQuestion.length-1);
            Random random = new Random();
            int i = random.nextInt(index.length-1);
            printWriter.println(FillInTheBlankQuestion[index[i]]);
            printWriter.close();
        }

        else if(this.questionTypeChoice == 6)// Numeric Answer question
        {
            File file = new File("questionTextFileNumericAnswer.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String[] NumericAnswerQuestion = {"\nQuestion(1 point)\nWhat should be the load factor for chaining?\n*A. 1\nB. 0.5\nC. 1.5\nD. 2\nE. None of the options\n#randomize",
                                            "\nQuestion(1 point)\nThe load factor for linear probing must always be \n*A. < 1\nB. > 1\nC. = 1\nD. >= 1 \nE. None of the options\n#randomize"};

            int[] index = listOfRandomNumbers(0,NumericAnswerQuestion.length-1);
            Random random = new Random();
            int i = random.nextInt(index.length-1);
            printWriter.println(NumericAnswerQuestion[index[i]]);
            printWriter.close();
        }
    }

    /**
     * main method to provide entry point to the program/ Test the program implementation
     * @param args
     * @throws IOException
     */
    public void genMain() throws IOException
    {
        Hashtable ht = new Hashtable();
        Scanner sc = new Scanner(System.in);
        System.out.println("Select Type of question to generate.\n1. Insertion\n2. Deletion\n3. TorF\n4. MCQ\n5. Fill in the blank ");
        System.out.print("Enter number and press ENTER: ");
        ht.questionTypeChoice = sc.nextInt();

        int i = ht.maxSize;

        String[] arr = ht.listOfRandomItems(0, 30);

        String[] array = new String[i];
        for(int j=0; j<array.length; j++)
        {
            array[j] = arr[j];
        }

        if(ht.questionTypeChoice == 1)
        {
            System.out.print("\nEnter the number of variations: ");
            ht.variations = sc.nextInt();
            for(int k=0; k<ht.variations; k++)
                ht.generateQuestion(array);
            System.out.println("Textfile Generated!");
        }
        else if(ht.questionTypeChoice == 2)
        {
            System.out.print("\nEnter the number of variations: ");
            ht.variations = sc.nextInt();
            for(int k=0; k<ht.variations; k++)
                ht.generateQuestion(array);
            System.out.println("Textfile Generated!");
        }
        else if(ht.questionTypeChoice == 3)
        {
            ht.generateQuestion(array);
            System.out.println("Textfile Generated!");
        }
        else if(ht.questionTypeChoice == 4)
        {
            ht.generateQuestion(array);
            System.out.println("Textfile Generated!");
        }
        else if(ht.questionTypeChoice == 5)
        {
            ht.generateQuestion(array);
            System.out.println("Textfile Generated!");
        }
        else if(ht.questionTypeChoice == 6)
        {
            ht.generateQuestion(array);
            System.out.println("Textfile Generated!");
        }
    }
}