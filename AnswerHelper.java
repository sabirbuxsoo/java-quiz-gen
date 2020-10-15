import java.util.Arrays;
import java.util.Collections;

/**
 * This class provides methods to generate the answers to questions involving
 * trees. The class is used by the BSTQuestion, AVLQuestion and RBTQuestion
 * classes
 * Author: Sabir Buxsoo
 */
public class AnswerHelper {
    //This method randomizes the original answer
    static String randomizeAnswer(String ans) {
        String[] arr = ans.split(" ");
        int arraySize = arr.length;

        String firstElement = arr[0];
        String lastElement = arr[arraySize - 1];

        String[] arr2 = new String[arraySize - 2];

        String arr3[] = new String[arraySize];

        arr3[0] = firstElement;
        for (int i = 0; i < arraySize - 2; i++) {
            arr2[i] = arr[i + 1];
        }

        Collections.shuffle(Arrays.asList(arr2));

        for (int j = 0; j < arr2.length; j++) {
            arr3[j + 1] = arr2[j];
        }
        arr3[arraySize - 1] = lastElement;

        return String.join(" ", arr3);

    }

    //This method generates the MCQ answers
    static String generateAnswers(String ans) {
        String[] answers = new String[5];
        answers[0] = ans;
        answers[4] = "None of the answers are correct";

        for (int x = 0; x < 3; x++) {
            while (true) {
                String randomAns = randomizeAnswer(ans);
                if (Arrays.stream(answers).anyMatch(randomAns::equals)) {
                    continue;
                } else {
                    answers[x + 1] = randomAns;
                    break;
                }
            }
        }

        String ansA = "* A. " + answers[0];
        String ansB = "B. " + answers[1];
        String ansC = "C. " + answers[2];
        String ansD = "D. " + answers[3];
        String ansE = "E. " + answers[4];
        String randomize = "#randomize";
        String answerGroup = ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize;
        return answerGroup;
    }
}
