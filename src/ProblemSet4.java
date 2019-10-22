/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

        // ps.sum();
        // ps.reverse();
        // ps.digits();
        // ps.average();
        // ps.prime();
        // ps.fibonacci();
        ps.factors();
        // ps.mario();
        // ps.luigi();
        // ps.credit();

        in.close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {

      double sum = 0;
      int lowerBound = 0;
      int upperBound = 0;
      System.out.println("");
      do {
        System.out.print("Lower bound: ");
        lowerBound = in.nextInt();
        System.out.print("Upper bound: ");
        upperBound = in.nextInt();
      } while (lowerBound>upperBound); //prints the lower and upper until a valid imput is provided

      while(lowerBound<=upperBound){
        if(lowerBound%2==0){ //if statements checks if the lowerBound is an even number
          sum = sum + lowerBound;
          lowerBound++;
        }else{
          lowerBound++;
        }
      }
        System.out.printf("\n%,.0f.", sum);
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
      int posInt = 0;
      char letterInString = 'A'; //need to initialize the char
      System.out.println("");

      do {
        System.out.print("Positive integer: ");
        posInt = in.nextInt();
      } while (posInt<=0);

      System.out.println("");

      String posIntString = Integer.toString(posInt); //the int is changed into a string
      int posIntLength = posIntString.length(); // finding the length of the string

      for(int i = posIntLength - 1; i >= 0; i--){ //repeats for as long as the string
        if(i==0){ //if the number is the last number, it will print a period instead of a comma
          letterInString = posIntString.charAt(i);
          System.out.print(letterInString + ".");
        }else{
          letterInString = posIntString.charAt(i);
          System.out.print(letterInString + ", ");
        }
      }

    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
      int backToInt = 0;
      int posIntOdd = 0;
      char letterInStringOdd = 'a';
      int sum = 0;
      System.out.println("");

      do{
        System.out.print("Positive integer: ");
        posIntOdd = in.nextInt();
      }while(posIntOdd<=0);

      String posIntOddString = Integer.toString(posIntOdd);
      int posIntOddLength = posIntOddString.length();

      for(int i = posIntOddLength - 1; i >= 0; i--){
        letterInStringOdd = posIntOddString.charAt(i);
        backToInt = Character.getNumericValue(letterInStringOdd);
        if(backToInt%2==0){
          sum = sum;
        }else{
          sum = sum + backToInt;
        }
      }
      System.out.println("\n"+sum+".");
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      System.out.println("");
      int nonNeg = 0;
      double sum = 0;
      int i = 0;
      do{
        System.out.print("Non-negative integer: ");
        nonNeg = in.nextInt();
        if(nonNeg>0){ //without the if statement, the sum will run one last time also the i++
          sum = sum + nonNeg;
          i++;
        }
      }while(nonNeg>=0); //while the inputted values are higher than one, run this do while
      double average = sum / i;
      System.out.printf("\n%,.2f.", average);
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
      int primeNum = 0;
      int remainder = 0;
      boolean isPrime = true;
      System.out.println("");

      do{
        System.out.print("Non-negative integer: ");
        primeNum = in.nextInt();
      }while(primeNum<=0);

      for(int i = 2; i <= primeNum/2; i++){ /*Starts at two since 0 and 1 won't be used to find the remainder, prime number
        is divided by 2 to only since checking the modulus of the first half will be the same as the second hald*/
        remainder =  primeNum % i;
        if(remainder==0||primeNum==1){ /*if any of the remainers equal 1 or 0, there is another number that it is
            divisable by*/
          isPrime=false;
          break;
        } // else means prime is true
      }
      if(isPrime){
        System.out.println("\nPrime.");
      }else{
        System.out.println("\nNot Prime.");
      }
    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {
      int fib = 0;
      int numSeq = 0;
      int n1 = 0;
      int n2 = 1;
      System.out.println("");

      do{
        System.out.print("Positive integer: ");
        fib = in.nextInt();
      }while(fib<=0&&fib>=92);

      for(int i = 2; i <= fib; i++){
        numSeq = n1 + n2;
        n1 = n2;
        n2 = numSeq;
      }
      System.out.println("\n" + numSeq + ".");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
      double posNum = 0;
      System.out.println("");
      do{
        System.out.print("Positive integer: ");
        posNum = in.nextInt();
      }while(posNum<=0);
      System.out.println("");

      for(int i = 1; i <= Math.sqrt(posNum); i++){

        if(i<posNum/i-i*2){

          if(posNum % i == 0){
            System.out.print(i + ", ");
            System.out.printf("%,.0f, ", posNum/i);
          }

        }else{

          if(posNum % i == 0){
            System.out.print(i + ", ");
            System.out.printf("%,.0f.\n", posNum/i);
          }

        }


      }
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {

    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {

    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {

    }
}
