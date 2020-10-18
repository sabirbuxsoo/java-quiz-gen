import java.util.*;

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
    Hashtable()
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