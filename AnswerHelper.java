import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * This class provides methods to generate the answers to questions involving
 * trees. The class is used by the BSTQuestion, AVLQuestion and RBTQuestion
 * classes Author: Sabir Buxsoo
 */
public class AnswerHelper {

    //Flip middle values of a string
    static String rotateMiddle(String values) {
        String[] arr = values.split(" ");
        if (arr.length >= 4) {
          String temp = arr[1];
          for(int i=1; i<=(arr.length-3); i++) {
            arr[i] = arr[i+1];
          }
          arr[arr.length-2] = temp;
        }
        return String.join(" ", arr);
      }

    // This method randomizes the original answer
    static String[] randomizeAnswer(String ans) {
        
        String[] results = new String[3];
      
        results[0] = rotateMiddle(ans);
        results[1] = rotateMiddle(results[0]);
        results[2] = rotateMiddle(results[1]);

        return results;
    }

    // This method generates the MCQ answers for BST
    static String generateAnswers(String ans) {
        String[] answers = new String[5];
        answers[0] = ans;
        answers[4] = "None of the answers are correct";
        String[] randomAns = randomizeAnswer(ans);
        for (int x = 0; x < 3; x++) {
           answers[x+1] = randomAns[x];
        }

        String ansA = "* A. " + answers[0];
        String ansB = "B. " + answers[1];
        String ansC = "C. " + answers[2];
        String ansD = "D. " + answers[3];
        String ansE = "E. " + answers[4];
        String randomize = "#randomize";
        String answerGroup = ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize + "\n";
        return answerGroup;
    }

    // This method generates the MCQ answers
    static String generateHashtableAnswers(String ans) {
      String[] answers = new String[5];
      answers[0] = ans;
      answers[4] = "None of the answers are correct";
      String[] randomAns = randomizeAnswer(ans);
      for (int x = 0; x < 3; x++) {
         answers[x+1] = randomAns[x];
      }

      String ansA = "* A. Hashtable 1: " + answers[0];
      String ansB = "B. Hashtable 2: " + answers[1];
      String ansC = "C. Hashtable 3: " + answers[2];
      String ansD = "D. Hashtable 4: " + answers[3];
      String ansE = "E. " + answers[4];
      String randomize = "#randomize";
      String answerGroup = ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize + "\n";
      return answerGroup;
  }


    //This method write the answers to the output file
    static void writeAnswers(String fileName, String outputAns){
      try
      {
          PrintWriter writer = new PrintWriter("generatedQuestions/"+fileName+".txt", "UTF-8");
          writer.println(outputAns);
          System.out.println();
          System.out.println("##########     " + fileName + ".txt Successfully Generated     ##########");
          System.out.println();
          writer.close();

      }
      catch (FileNotFoundException | UnsupportedEncodingException ex)  
      {
         System.out.println("File not found");
      }
    }
}
