/**
 * This class contains the questions for Binary Search Tree (BST)
 * Author: Sabir Buxsoo
 */
public class BSTQuestion {

    //Question 1
   static  String one(){
        String question = "Suppose you have a Binary Search Tree with In-Order Traversal {1,2,4} and Post-Order Traversal {2,3,1}. What is the Pre-Order Traversal of the Tree?";
        String point = "Question (1 point)";
        String ansA = "* A. " + "PreOrder";
        String ansB = "B. " + "PostOrder";
        String ansC = "C. " + "InOrder";
        String ansD = "D. " + "RandomArray";
        String ansE = "E. " + "None of the answers are correct";
        String randomize = "#randomize";
        String questionOne = point + "\n" + question + "\n" + ansA + "\n" + ansB + "\n" + ansC + "\n" + ansD + "\n" + ansE + "\n" + randomize;
        return questionOne;
    }

    public static void main(String args[]){
        System.out.println(one());
    }
    
}
