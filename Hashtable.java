import java.security.SecureRandom;
import java.util.*;
import java.io.*;

public class Hashtable
{
    /**
     * Instance Variables
    */
    private int maxSize;
    private int currentSize;
    private String[] arrayForKeys;
    private String[] arrayForValues;
    private String originalHT;
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
    public int hash(int value)
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
     * Method to shuffle array values for users to attain same values in different order
     * @param array
     */
    public String[] shuffleArray(String[] array)
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
        return array;
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
    }

    /**
     * Return a String value of the hashtable
     * @return
     */
    public String toString()
    {
        originalHT = "";
        
        for(int i=0; i<this.maxSize; i++)
        {
            originalHT = originalHT+String.format("%s ",arrayForValues[i]);
        }
        return originalHT;
    }

    int getMaxSize(){
        return maxSize;
    }

    int getCurrentSize(){
        return currentSize;
    }

    String createHT(int[] arr){
        String[] array = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        for (int i = 0; i < array.length; i++) {
            put(array[i]);
        }

        originalHT = "";
        
        for(int i=0; i<this.maxSize; i++)
        {
            originalHT = originalHT+String.format("%s ",arrayForValues[i]);
        }
        return originalHT;
    }

    String remove(int deleteValue){
        String delVal = Integer.toString(deleteValue);
        
        String[] newHT = new String[arrayForValues.length];

        for(int i = 0; i<arrayForValues.length; i++){
            if(arrayForValues[i].equals(delVal)){
                newHT[i] = "-";
            }else{
                newHT[i] = arrayForValues[i];
            }
        }
       
        String delHT = "";
        
        for(int i=0; i<this.maxSize; i++)
        {
            delHT = delHT + String.format("%s ",newHT[i]);
        }
        return delHT;
    }
}