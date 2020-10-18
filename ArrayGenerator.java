import java.util.ArrayList;
import java.util.Collections;
/**
 * This class is used togenerate random array, insert and delete values
 * Author: Sabir Buxsoo
 * 
 */
public class ArrayGenerator {
    private static int arrSize = 7; //Fixed array size 7
    private static int[] arr = new int[arrSize]; // Array of Length 5
    private static int insertValue;
    private static int deleteValue;

    //Fill array with random integers
    ArrayGenerator() {
        //Create a random array of size 5 with elements from 1 to 100 inclusive
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<100; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        for (int i=0; i<arrSize; i++) {
            arr[i] = list.get(i);
        }

        insertValue = list.get(arrSize + 1);

        if(arrSize%2 == 0){
            deleteValue = list.get(arrSize/2);
        }else{
            deleteValue = list.get((arrSize+1) / 2);
        }
       
    }
    

    //Get Random Array
    int[] getArray(){
        return arr;
    }

    int getInsertValue(){
        return insertValue;
    }

    int getDeleteValue(){
        return deleteValue;
    }
    
}
