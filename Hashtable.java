import java.util.*;
/**
 * @author Sicelokuhle Shabalala
 * @version 1.0
 * Reference: https://www.journaldev.com/35238/hash-table-in-c-plus-plus
 */

/**
 * This is a Hashtable class, a Hashtable is a class the maps values to keys
 */
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
     * Constructor that takes a parameter capacity for user to specify the hashtable size 
     * @param capacity
     */
    Hashtable(int capacity)
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
    void clear()
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
    int size()
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

    /**
     * Returns the maximum size of the hashtable
     * @return
     */
    public int getMaxSize()
    {
        return maxSize;
    }

    /**
     * Returns the current size of the hashtable
     * @return
     */
    public int getCurrentSize()
    {
        return currentSize;
    }

    /**
     * Creates a hashtable and returns a string
     * @return
     */
    public String createHT(int[] arr)
    {
        String[] array = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        for (int i = 0; i < array.length; i++) 
        {
            put(array[i]);
        }

        originalHT = "";
        
        for(int i=0; i<this.maxSize; i++)
        {
            originalHT = originalHT+String.format("%s ",arrayForValues[i]);
        }
        return originalHT;
    }

    /**
     * Removes a value from the hashtable and returns a String rep of the hashtable with the deleted value not available
     * @return
     */
    public String remove(int deleteValue){
        String delVal = Integer.toString(deleteValue);
        
        String[] newHT = new String[arrayForValues.length];

        for(int i = 0; i<arrayForValues.length; i++)
        {
            if(arrayForValues[i].equals(delVal))
            {
                newHT[i] = "-";
            }
            else
            {
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