1. Introduction

The Vula Learning Management System, powered by Sakai, is used at the University of Cape Town. It has a Tests and Quizzes feature which is a tool which allows lecturers to test students by providing them with different, but similar, questions such as Multiple Choice or True or False questions. However, the process of creating those quizzes is time consuming. 

As such, the goal of this project is to create a software which will allow lecturers to generate random questions on Data Structures which are covered in the CSC2001F lectures, in an attempt to prevent plagiarism among peers by having different variations of the same question for  each of the students in a class. These generated questions will test the students’ abilities to insert and delete items into various data structures covered in the CSC2001F course.

The system provides a command line interface for the lecturer to interact with, to generate specified number of questions on Data Structures such as Priority Queues, Hash Tables, Binary Search Trees and AVL Trees. The software then generates the questions into a formatted text file as required by the Vula Tests and Quizzes tool.

We approached the project by first gathering the user requirements from our client and gaining a good understanding of the problem to solve and what kind of solution our client wanted to have. We adopted a Vertical Evolutionary Prototype during the early stage of the project as it allowed us to focus on the core features. The evolutionary prototype allowed us to demonstrate a working prototype to our client and get feedback to improve the solution to the client’s vision. This provided us with the benefit of testing and refining our core features while allowing our client to be part of our development process. Throughout the course of the development process, we made use of Agile Methodologies and Test Driven Development to ensure that each of the features we implemented were working properly before moving on to the next. 

Given the nature of the project, which required the implementation of several common Data Structures, research was done into several Data Structures to gain an understanding of how to implement them into our project. The resources we used were mostly the website Geeksforgeeks.com [1] to learn implementation of the common Data Structures, the book Data Structures and Algorithm Analysis in Java by Mark Allen Weiss [2] and the book Algorithms by C.L.R.S [3]. Those resources helped us not only implement the common Data Structures, but also gave us insight on how to design questions from scratch to test the understanding of students who will be answering those questions on Vula.



3. Design Overview

The solution is based on the following features:



*   Command-line interface (CLI) to interact with the program based on Java to run on Windows and Mac OS using the JVM
*   Inputs are made via the CLI
*   User will have a list of Data Structures to choose from
*   User can make choice of Data Structure 
*   User can select the question they want to generate for a specific Data Structure
*   User can specify the number of questions they want generated
*   User can specify the file name in which the generated questions will be saved

Figure 1 below shows the design class diagram of the final solution. We ensured that the code was built to be modular and re-usable.


**_Table 7: Summary of helper classes and other additional classes_**


<table>
  <tr>
   <td><strong>Class name</strong>
   </td>
   <td><strong>Purpose</strong>
   </td>
  </tr>
  <tr>
   <td>
    CreateTest
   </td>
   <td>This class contains the important method promptUser() which basically prompts the user to enter their preferences and then it creates all the questions for the different data structures and saves them. This code is particularly long due to it being a full generator.
   </td>
  </tr>
</table>


This feature is shown in the User Manual (Annex A).





    10. Other classes

In addition to the classes described above, several other classes were created to be used by other classes. Some of those classes were necessary for the correct working of another class (e.g. Node.java). Other classes were used as helper classes. Those classes are described in Table 7 below.

**_Table 8: Summary of helper classes and other additional classes_**


<table>
  <tr>
   <td><strong>Class name</strong>
   </td>
   <td><strong>Purpose</strong>
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>AnswerHelper
</li>
</ol>
   </td>
   <td>This class is used by the PqQuestion, HashtableQuestion, BSTQuestion, the AVLQuestion. It basically is a simpler helper class which generates randomized versions of the original answer to make sure there are different answer options for the multiple choice questions which are generated.
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>Node
</li>
</ol>
   </td>
   <td>This class is used by the BST.java and the AVL.java classes. Those classes require the Node.java to function. This is a very important class as the BST and AVL tree require this class to perform their tasks.
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>ArrayGenerator
</li>
</ol>
   </td>
   <td>This class generates a random array as well as two values. This class is used to help the AVL Hashtable and BST classes as it provides an array of integers which are used to create the AVL and BST trees. This class also provides a randomly generated value which will be inserted in a created tree. It also provides a random value from the generate array which will be used by the AVL and BST to remove the element from a tree.
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>Traversal
</li>
</ol>
   </td>
   <td>The Traversal class is used the the AVL and BST classes to provide the InOrder, PreOrder and PostOrder of a tree. This is a specially important class as it is used heavily to create questions.
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>Driver
</li>
</ol>
   </td>
   <td>This is the main class of the program. This is where the program starts its execution and takes commands from the user. This class prompts the user to select the Data Structure for which they want to generate questions.
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>ListRandomizer
</li>
</ol>
   </td>
   <td>This class behaves like the ArrayGenerator class but is separate as it is only used by the PQueue class which requires ArrayLists instead of Arrays.
   </td>
  </tr>
</table>




5. Program Validation and Verification

The key to a successful project is to ensure that the final product is thoroughly tested before delivery to the client. This ensures that the solution behaves as expected, is robust and does not contain logical errors. 

Given the nature of the project was to implement Data Structures, it was important to test that the output of the implemented Data Structures were correct. In this section, we describe the testing approaches we used and  give an outline of the test cases.



    11. Summary of testing cases

The table below shows the Summary of our testing plan.

**_Table 9: Summary of testing plan_**


<table>
  <tr>
   <td><strong>Process</strong>
   </td>
   <td><strong>Approach</strong>
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>Class testing
</li>
</ol>
   </td>
   <td>Each class was tested individually to ensure the methods were working as expected. This was done using the White-box testing approach by looking at the individual methods and checking they correctness.
<p>
If a method was not giving the correct behaviour, the test failed and would require fixes. This was done manually and by making us of trace debugging techniques (using System.out.println, for example).
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>Integration testing
</li>
</ol>
   </td>
   <td>Here as well we made use of the White-box testing technique to test the coupling and cohesion of our classes. Since the code is very modular, it is very important for classes to behave as expected and work perfectly with other classes. We conducted this test manually as well by using tracing debugging techniques.
<p>
We also tested the program as a whole to see if the classes worked together. Here we used a black-box testing technique to see if the program achieved expected behavior.
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>Validation testing
</li>
</ol>
   </td>
   <td>For this testing phase, we used the black-box testing technique, which is basically a form of acceptance testing, to test whether our client’s requirements were met. This meant running the program multiple times and going through the various flows of the program to ensure all features and functionalities were behaving as expected. 
   </td>
  </tr>
  <tr>
   <td>
<ol>

<li>System testing
</li>
</ol>
   </td>
   <td>This testing was done to check the behaviour of the program to ensure it was robust and portable. This was done by running the program on various machines to test their portability across different operating systems using Java Version 8. We also tested the robustness of the program by inputting large number of questions to be generated to find whether or not the program would crash when generating large sets of questions (e.g  100,000&lt;=n &lt;=1,000,000) where is is the number of question variation to be generated.
   </td>
  </tr>
</table>




    12. Summary of tests carried out

<table>
  <tr>
   <td>
<strong>Test Description</strong>
   </td>
   <td><strong>Data Set</strong>
   </td>
   <td><strong>Reason of Choice</strong>
   </td>
   <td colspan="3" ><strong>Test Cases</strong>
   </td>
  </tr>
  <tr>
   <td>
   </td>
   <td>
   </td>
   <td>
   </td>
   <td><strong>Normal Function</strong>
   </td>
   <td><strong>Extreme Boundary Case</strong>
   </td>
   <td><strong>Invalid Data</strong>
   </td>
  </tr>
  <tr>
   <td>Input choice of Data Structure
   </td>
   <td>1,2,3,4,5,0 (input commands)
   </td>
   <td>To check if user can input commands in the terminal
   </td>
   <td>User is redirected to next step of the program flow with data 1,2,3,4,5
   </td>
   <td>With 0, program exits
   </td>
   <td>The program asks the user what they want to do again
   </td>
  </tr>
  <tr>
   <td>Binary Search tree select options by input
   </td>
   <td>1,2,3,4(input commands)
   </td>
   <td>To check if user can input commands in the terminal to select their choice of question
   </td>
   <td>User prompted with further steps to generate questions
   </td>
   <td>n/a
   </td>
   <td>The program exits with error
   </td>
  </tr>
  <tr>
   <td>Hashtable select options by input
   </td>
   <td>1,2,3,4(input commands)
   </td>
   <td>To check if user can input commands in the terminal to select their choice of question
   </td>
   <td>User prompted with further steps to generate questions
   </td>
   <td>n/a
   </td>
   <td>The program exits with error
   </td>
  </tr>
  <tr>
   <td>AVL tree select options by input
   </td>
   <td>1,2,3,4(input commands)
   </td>
   <td>To check if user can input commands in the terminal to select their choice of question
   </td>
   <td>User prompted with further steps to generate questions
   </td>
   <td>n/a
   </td>
   <td>The program exits with error
   </td>
  </tr>
  <tr>
   <td>Priority Queue select options by input
   </td>
   <td>1,2,3 (input commands)
   </td>
   <td>To check if user can input commands in the terminal to select their choice of question
   </td>
   <td>User prompted with further steps to generate questions
   </td>
   <td>n/a
   </td>
   <td>The program exits with error
   </td>
  </tr>
  <tr>
   <td>Test if output files contain questions
   </td>
   <td>Data is generated from the program and are questions which are predefined in the BSTQuestion, AVLQuestion, HashtableQuestion and PqQuestion classses
   </td>
   <td>To check  output files contain the questions as expected
   </td>
   <td>Output files contain generated questions
   </td>
   <td>n/a
   </td>
   <td>Output files are empty, Output files are not generated
   </td>
  </tr>
  <tr>
   <td>Check if output file generated
   </td>
   <td>n/a
   </td>
   <td>To check if output file is created in the correct directory
   </td>
   <td>Directory contains output files
   </td>
   <td>n/a
   </td>
   <td>Directory does not contain output files
   </td>
  </tr>
  <tr>
   <td>Binary Search tree validity (See Appendix B)
   </td>
   <td>Binary search tree node, traversals
   </td>
   <td>To check if the tree provided is actually a BST
   </td>
   <td>Tree is valid
   </td>
   <td>n/a
   </td>
   <td>Tree invalid
   </td>
  </tr>
  <tr>
   <td>AVL tree validity (See Appendix B)
   </td>
   <td>AVL tree node, traversals
   </td>
   <td>To check if the tree provided is actually an AVL
   </td>
   <td>Tree is valid
   </td>
   <td>n/a
   </td>
   <td>Tree invalid
   </td>
  </tr>
  <tr>
   <td>Hashtable validity (See Appendix B)
   </td>
   <td>Array of data, size of hashtable
   </td>
   <td>To check if hashtable is valid after insert and delete
   </td>
   <td>Hashtable is valid
   </td>
   <td>n/a
   </td>
   <td>Hashtable invalid
   </td>
  </tr>
  <tr>
   <td>Priority queue validity (See Appendix B)
   </td>
   <td>ArrayList
   </td>
   <td>To check if the priority queue is valid
   </td>
   <td>Priority queue is valid
   </td>
   <td>n/a
   </td>
   <td>Priority queue is  invalid
   </td>
  </tr>
</table>




6. Conclusion

After a thorough analysis and testing of the final product, we concluded that the solution was behaving as expected, robust and portable. The objective was to create a program which would allow the generation of questions involving Data Structures and we achieved the result to completion and this was heavily influenced by adoption an initial vertical evolutionary prototype approach, right at the beginning, to understand the full client requirements. 

We also understood the important of writing modular code and ensuring that the code is maintainable. The modular code allowed us to devise a feature which will potentially allow lecturers to generate Tests Question Pools within matter of seconds.

We also made use of Test-Driven development to ensure the features were working correctly and the code was refactored to ensure consistency across the board.

Unfortunately, we realised that Vula is very limited in terms of what can be uploaded as question and as such we encountered some limitations which made it difficult to generate more complex questions, especially on graphs data structures which require images. More complex tree and hashtable questions could also not be generated. 

In conclusion, the project was deemed successful although communication could have been better among team members. We had a steep learning curve and managed to apply the concepts of Software engineering to build a fully functional product.




# Annex A – User Manual

The tables below give 1 sample question for each operation available to each data structure and the expected outcome (Correct Answer), this is done for the user to perform manual analyses of the performance of the data structure. 

**_Table 1: Binary Search Tree Sample Questions_**


<table>
  <tr>
   <td><strong>Binary Search Tree (Operation) </strong>
   </td>
   <td><strong>Preview Question </strong>
   </td>
   <td><strong>Answers to Choose from </strong>
   </td>
   <td><strong>Correct Answer </strong>
   </td>
  </tr>
  <tr>
   <td><strong>Pre-Order Traversal </strong>
   </td>
   <td>Suppose you have a Binary Search Tree with In-Order Traversal 4 68 75 82 86 88 99 and Post-Order Traversal 4 75 68 86 99 88 82. What is the Pre-Order Traversal of the Tree? 
   </td>
   <td>A. 82 68 4 75 88 86 99  
<p>
B. 82 4 75 88 86 68 99 
<p>
C. 82 75 88 86 68 4 99 
<p>
D. 82 88 86 68 4 75 99 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 82 68 4 75 88 86 99  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Post-Order Traversal </strong>
   </td>
   <td>Suppose you have a Binary Search Tree with inorder traversal 25 29 74 79 82 92 94 and preorder traversal 79 29 25 74 92 82 94. What is the postorder traversal of the tree? 
   </td>
   <td>A. 25 74 29 82 94 92 79 
<p>
B. 25 29 82 94 92 74 79 
<p>
C. 25 82 94 92 74 29 79 
<p>
D. 25 94 92 74 29 82 79 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 25 74 29 82 94 92 79 
   </td>
  </tr>
  <tr>
   <td><strong>Insertion </strong>
   </td>
   <td>Suppose you have a Binary Search Tree with inorder traversal 15 27 32 64 73 75 86 and postorder traversal 15 32 27 73 86 75 64. Now suppose you insert 71 in the tree. What is the preorder traversal of the resulting tree after the insert? 
   </td>
   <td>A. 64 27 15 32 75 73 71 86  
<p>
B. 64 15 32 75 73 71 27 86 
<p>
C. 64 32 75 73 71 27 15 86 
<p>
D. 64 75 73 71 27 15 32 86 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 64 27 15 32 75 73 71 86  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Deletion </strong>
   </td>
   <td>Suppose you have a Binary Search Tree with inorder traversal 4 21 44 51 76 86 93 and postorder Traversal 4 44 21 76 93 86 51. Now suppose you Delete 76 from the tree. What is the preorder Traversal of the resulting tree after the deletion? 
   </td>
   <td>A. 51 21 4 44 86 93  
<p>
B. 51 4 44 86 21 93 
<p>
C. 51 44 86 21 4 93 
<p>
D. 51 86 21 4 44 93 
   </td>
   <td>A. 51 21 4 44 86 93  
<p>
 
   </td>
  </tr>
</table>


 

 



**_Table 2: AVL Tree Sample Questions_**


<table>
  <tr>
   <td><strong>AVL Tree (Operations) </strong>
   </td>
   <td><strong>Preview Question </strong>
   </td>
   <td><strong>Answer to Choose from </strong>
   </td>
   <td><strong>Correct Answer </strong>
   </td>
  </tr>
  <tr>
   <td><strong>Pre-Order Traversal </strong>
   </td>
   <td>Suppose you have an AVL Tree with inorder traversal 8 29 32 48 61 66 76 and postorder traversal 8 32 29 61 76 66 48. What is the preorder traversal of the tree? 
   </td>
   <td>A. 48 29 8 32 66 61 76  
<p>
B. 48 8 32 66 61 29 76 
<p>
C. 48 32 66 61 29 8 76 
<p>
D. 48 66 61 29 8 32 76 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 48 29 8 32 66 61 76  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Post-Order Traversal </strong>
   </td>
   <td>Suppose you have an AVL Tree with inorder traversal 21 23 26 53 54 80 88 and preorder traversal 53 23 21 26 80 54 88. What is the postorder traversal of the tree? 
   </td>
   <td>A. 21 26 23 54 88 80 53  
<p>
B. 21 23 54 88 80 26 53 
<p>
C. 21 54 88 80 26 23 53 
<p>
D. 21 88 80 26 23 54 53 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 21 26 23 54 88 80 53  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Insertion </strong>
   </td>
   <td>Suppose you have an AVL Tree with Inorder traversal 2 19 29 32 41 94 95 and Postorder traversal 19 2 32 29 94 95 41. Now suppose you insert 11 in the tree. What is the Preorder Traversal of the resulting tree after the insert? 
   </td>
   <td>A. 41 29 11 2 19 32 95 94  
<p>
B. 41 11 2 19 32 95 29 94 
<p>
C. 41 2 19 32 95 29 11 94 
<p>
D. 41 19 32 95 29 11 2 94 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 41 29 11 2 19 32 95 94  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Deletion </strong>
   </td>
   <td>Suppose you have an AVL Tree with Inorder traversal 1 44 59 71 72 93 99 and Postorder traversal 1 44 71 93 99 72 59. Now suppose you Delete 72 from the tree. What is the Preorder Traversal of the resulting tree after the deletion? 
   </td>
   <td>A. 59 44 1 93 71 99  
<p>
B. 59 1 93 71 44 99 
<p>
C. 59 93 71 44 1 99 
<p>
D. 59 71 44 1 93 99 
<p>
E. None of the answers are correct 
   </td>
   <td>A. 59 44 1 93 71 99  
<p>
 
   </td>
  </tr>
</table>


 



 

**_Table 3: Hashtable Sample Questions _**


<table>
  <tr>
   <td><strong>Hashtable (Operations) </strong>
   </td>
   <td><strong>Preview Question </strong>
   </td>
   <td><strong>Answer to Choose from </strong>
   </td>
   <td><strong>Correct Answer </strong>
   </td>
  </tr>
  <tr>
   <td><strong>Insertion via Linear Probing using Hash function h(x) = x%7 </strong>
   </td>
   <td>What is the resulting hashtable after inserting the keys [9, 44, 36, 62, 99, 45, 21] into an initially empty hashtable of length 7 using open addressing with hash function is h(x) = x % 7 and linear probing ? 
   </td>
   <td>A. Hashtable 1: 21 36 9 44 99 45 62  
<p>
B. Hashtable 2: 21 9 44 99 45 36 62 
<p>
C. Hashtable 3: 21 44 99 45 36 9 62 
<p>
D. Hashtable 4: 21 99 45 36 9 44 62 
<p>
E. None of the answers are correct 
   </td>
   <td>A. Hashtable 1: 21 36 9 44 99 45 62  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Insertion via Linear Probing using Hash function h(x) = x%10 </strong>
   </td>
   <td>What is the resulting hashtable after inserting the keys [14, 7, 30, 41, 46, 73, 25] into an initially empty hashtable of length 10 using open addressing with hash function is h(x) = x % 10 and linear probing ? 
   </td>
   <td>A. Hashtable 1: 30 41 - 73 14 25 46 7 - -  
<p>
B. Hashtable 2: 30 - 73 14 25 46 7 - 41 - 
<p>
C. Hashtable 3: 30 73 14 25 46 7 - 41 - - 
<p>
D. Hashtable 4: 30 14 25 46 7 - 41 - 73 - 
<p>
E. None of the answers are correct 
   </td>
   <td>A. Hashtable 1: 30 41 - 73 14 25 46 7 - -  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Lazy Deletion in hashtable of length 7 </strong>
   </td>
   <td>What is the resulting hashtable after deleting 31 from the hashtable 5 53 23 31 46 68 6 assuming LAZY DELETION? 
   </td>
   <td>A. Hashtable 1: 5 53 23 - 46 68 6  
<p>
B. Hashtable 2: 5 23 - 46 68 53 6 
<p>
C. Hashtable 3: 5 - 46 68 53 23 6 
<p>
D. Hashtable 4: 5 46 68 53 23 - 6 
<p>
E. None of the answers are correct 
   </td>
   <td>A. Hashtable 1: 5 53 23 - 46 68 6  
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Lazy Deletion in hashtable of length 10 </strong>
   </td>
   <td>What is the resulting hashtable after deleting 3 from the hashtable 17 51 - 43 3 - - 47 38 59 assuming LAZY DELETION? 
   </td>
   <td>A. Hashtable 1: 17 51 - 43 - - - 47 38 59  
<p>
B. Hashtable 2: 17 - 43 - - - 47 38 51 59 
<p>
C. Hashtable 3: 17 43 - - - 47 38 51 - 59 
<p>
D. Hashtable 4: 17 - - - 47 38 51 - 43 59 
<p>
E. None of the answers are correct 
   </td>
   <td>A. Hashtable 1: 17 51 - 43 - - - 47 38 59  
<p>
 
   </td>
  </tr>
</table>


 

 



**_Table 4: Priority Queue Questions _**


<table>
  <tr>
   <td><strong>Priority Queue (Operations) </strong>
   </td>
   <td><strong>Preview Question </strong>
   </td>
   <td><strong>Answer to Choose from </strong>
   </td>
   <td><strong>Correct Answer </strong>
   </td>
  </tr>
  <tr>
   <td><strong>Insertion into empty priority queue </strong>
   </td>
   <td>Min-Heap: What is the resulting Priority Queue from this list [19, 14, 24, 2, 30, 1, 7, 20, 21, 12]? 
   </td>
   <td>A. [1, 12, 2, 19, 14, 24, 7, 20, 21, 30] 
<p>
B. [1, 2, 19, 14, 24, 7, 20, 21, 12, 30] 
<p>
C. [1, 19, 14, 24, 7, 20, 21, 12, 2, 30] 
<p>
D. [1, 14, 24, 7, 20, 21, 12, 2, 19, 30] 
<p>
E. None of the answers are correct 
   </td>
   <td>A. [1, 12, 2, 19, 14, 24, 7, 20, 21, 30] 
   </td>
  </tr>
  <tr>
   <td><strong>Insertion of a value into priority queue </strong>
   </td>
   <td>Min-Heap:  What is the resulting Priority Queue when the value 6 is inserted to the list [3, 12, 5, 13, 17, 16, 28, 24, 14]? 
   </td>
   <td>A. [3, 6, 5, 13, 12, 16, 28, 24, 14, 17] 
<p>
B. [3, 5, 13, 12, 16, 28, 24, 14, 6, 17] 
<p>
C. [3, 13, 12, 16, 28, 24, 14, 6, 5, 17] 
<p>
D. [3, 12, 16, 28, 24, 14, 6, 5, 13, 17] 
<p>
E. None of the answers are correct 
   </td>
   <td>A. [3, 6, 5, 13, 12, 16, 28, 24, 14, 17] 
   </td>
  </tr>
  <tr>
   <td><strong>Deletion </strong>
   </td>
   <td>Min-Heap:  What is the resulting Priority Queue from deleting value 9 from the list [2, 7, 8, 10, 12, 13, 9, 30, 16]? 
   </td>
   <td>A. [2, 7, 8, 10, 12, 13, 16, 30] 
<p>
B. [2, 8, 10, 12, 13, 16, 7, 30] 
<p>
C. [2, 10, 12, 13, 16, 7, 8, 30] 
<p>
D. [2, 12, 13, 16, 7, 8, 10, 30] 
<p>
E. None of the answers are correct 
   </td>
   <td>A. [2, 7, 8, 10, 12, 13, 16, 30] 
   </td>
  </tr>
</table>


 

 




# Annex B – Test Runs for Each Data Structure

**Test Cases for Hashtable Linear Probing insertion: **



1. Testing for Tablesize = 7 

    Keys = [9,44,36,62,99,45,21] 


    Modulo Operation: 


      9%7 = 2 


    44%7 = 2 


    36%7 = 1 


    62%7 = 6 


    99%7 = 1 


    45%7 = 3 


    21%7 = 0 


     


    Resulting Hashtable: 


    0      21 


    1      36 


    2      9 


    3      44 


    4      99 


    5      45 


    6      62 


     

1. Testing for Tablesize = 10 

    Keys = [14,7,30,41,46,73,25] 


    Modulo Operation: 


    14%10 = 4  


      7%10 = 7 


    30%10 = 0 


    41%10 = 1 


    46%10 = 6 


    73%10 = 3 


    25%10 = 5 


     


    Resulting Hashtable: 


    0    30 


    1    41 


    2    - 


    3    73 


    4    14 


    5    25 


    6    46 


    7    7 


    8    - 


    9    - 




The hashtable works correctly since Resulting hashtables are similar to the Correct Answer computed manually as the above hashtable table. This proves that the algorithm is working. Deletion is a straight-forward operation, the value to be deleted is replaced by a flag (HYPHEN) to show it’s been deleted. This can be seen on the program output directly.

**Test Cases for Min-Heap Priority Queue:**

**Test case 1 **

Description: Check if given a randomly generated array list, it will return a newly ordered Priority Queue 

Input: insert a randomly generated array [22, 4, 20, 25, 21, 15, 28, 10, 13] 

Expected output: [4, 10, 15, 13, 22, 20, 28, 25, 21] 

Test outcome: [4, 10, 15, 13, 22, 20, 28, 25, 21], Test passed 

  

**Test case 2 **

Description: Check if the multiple-choice questions do not have duplicates. 

Input: insert a randomly generated array [6, 15, 28, 4, 24, 26] and checked if multiple questions are not duplicated. 

Expected output: Four Distinct multiple-choice options 

Test outcome: all options are distinct, test passed 

  

**Test case 3 **

Description: Check if inserting a single element, it will return a newly ordered Priority Queue with the element included 

Input: insert element 22 to Priority Queue [4, 8, 12, 10, 23, 14, 29, 20, 13, 27] 

Expected output: [4, 8, 12, 10, 22, 14, 29, 20, 13, 27, 23] 

Test outcome: [4, 8, 12, 10, 22, 14, 29, 20, 13, 27, 23], Test passed 

  

**Test case 4 **

Description: Check if deleting an element from a Priority Queue will return a newly ordered Priority Queue with the element deleted. 

Input: Delete element 6 from [6, 16, 10, 18, 20, 28, 19, 25]. 

Expected output: [10, 16, 19, 18, 20, 28, 25] with 6 removed. 

Test outcome: [10, 16, 19, 18, 20, 28, 25], test passed 

 


<table>
  <tr>
   <td> 
   </td>
   <td><strong>Test case </strong>
   </td>
   <td><strong>Input </strong>
   </td>
   <td><strong>Output </strong>
   </td>
   <td><strong>Method used </strong>
   </td>
  </tr>
  <tr>
   <td><strong>Generate Priority Queue from given List </strong>
   </td>
   <td>Check if given a specific list, and compare against a python min heap code which should have the same results 
   </td>
   <td>[15, 9, 13, 3, 10, 7, 2, 12] 
   </td>
   <td>[2, 9, 3, 12, 10, 13, 7, 15]. Test passed 
   </td>
   <td>Manually added [15, 9, 13, 3, 10, 7, 2, 12] 
<p>
To both the Java and Python code and compared the results. 
   </td>
  </tr>
  <tr>
   <td><strong>Generate Priority Queue from a non-integer list </strong>
   </td>
   <td>Check if the code will still work and output an error message if provided list has an incorrect Data type. 
   </td>
   <td>[“a”,”heap”,”2”,”7”,”queue”] 
   </td>
   <td>An appropriate an message prompting the user to try again. 
   </td>
   <td>Using a list of strings instead of the expected integers. 
   </td>
  </tr>
  <tr>
   <td><strong>Insert a specified value </strong>
   </td>
   <td>Insert a specified value into the Priority queue to check if it will be placed correctly. 
   </td>
   <td>6 is inserted to the Queue [2, 11, 10, 12, 14, 30, 28, 15, 19] 
   </td>
   <td>[2, 6, 10, 12, 11, 30, 28, 15, 19, 14]. Test passed 
   </td>
   <td>6 is inserted to the list [2, 11, 10, 12, 14, 30, 28, 15, 19] 
<p>
To both the Java and Python code and compared the results. 
<p>
 
   </td>
  </tr>
  <tr>
   <td><strong>Delete a value from the Priority Queue </strong>
   </td>
   <td>Delete a specified value from the Priority queue to check if it will be removed and the Queue will be reordered accordingly. 
<p>
 
   </td>
   <td>Remove 10 from the Queue [3, 8, 10, 21, 29, 24, 23, 28, 25] 
   </td>
   <td>[3, 8, 23, 21, 29, 24, 25, 28], Test passed 
   </td>
   <td>Remove 10 from the Queue [3, 8, 10, 21, 29, 24, 23, 28, 25] 
<p>
To both the Java and Python code and compared the results. 
<p>
 
   </td>
  </tr>
</table>


 

**Test Cases for Binary Search Trees and AVL Trees:**

The tests for BST and AVL was done manually to verify whether the output were actually BSTs or AVLs. This was conducted by first taking the answers obtained and questions generated and checking the validity for those outputs manually by using the algorithm. It was found out that those tests passed and this confirming the validity of the BST and AVL trees questions.




# References

[1] [https://geeksforgeeks.com](https://geeksforgeeks.com)

[2] Th. H. Cormen, C. E. Leiserson, R. L. Rivest, and C. Stein, Introduction to Algorithms, MIT Press, Cambridge, Massachusetts, 2009.

[3] Mark A. Weiss. 2011. Data Structures and Algorithm Analysis in Java (3rd ed.). Addison Wesley.

[4] [https://www.geeksforgeeks.org/binary-search-tree-data-structure/](https://www.geeksforgeeks.org/binary-search-tree-data-structure/)

[5] [https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/](https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/)

[6] [https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/](https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/)

[7] [https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/](https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/)

[8] [https://www.geeksforgeeks.org/priority-queue-class-in-java-2/](https://www.geeksforgeeks.org/priority-queue-class-in-java-2/)

[9] [https://www.geeksforgeeks.org/generating-random-numbers-in-java/](https://www.geeksforgeeks.org/generating-random-numbers-in-java/)

[10] [https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java](https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java)

[12] https://www.journaldev.com/35238/hash-table-in-c-plus-plus
