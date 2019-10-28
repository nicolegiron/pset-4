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

        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();

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
      System.out.print("\n");
      do{
        System.out.print("Lower bound: ");
        lowerBound = in.nextInt();
        System.out.print("Upper bound: ");
        upperBound = in.nextInt();
      }while(lowerBound>upperBound); //prints the lower and upper until a valid imput is provided

      while(lowerBound<=upperBound){
        if(lowerBound%2==0){ //if statements checks if the lowerBound is an even number
          sum = sum + lowerBound;
          lowerBound++;
        }else{
          lowerBound++;
        }
      }
        System.out.printf("\n%,.0f.\n", sum);
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
      System.out.print("\n");
      do{
        System.out.print("Positive integer: ");
        posInt = in.nextInt();
      }while(posInt<=0);

      System.out.print("\n");
      String posIntString = Integer.toString(posInt); //the int is changed into a string
      int posIntLength = posIntString.length(); // finding the length of the string
      for(int i = posIntLength - 1; i >= 0; i--){ //repeats for as long as the string
        if(i==0){ //if the number is the last number, it will print a period instead of a comma
          letterInString = posIntString.charAt(i);
          System.out.print(letterInString + ".\n");
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
      System.out.print("\n");

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
      System.out.println("\n"+sum+".\n");
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      int nonNeg = 0;
      double sum = 0;
      int i = 0;
      do{
        System.out.print("Non-negative integer: ");
        nonNeg = in.nextInt();
        if(nonNeg>=1){ //without the if statement, the sum will run one last time also the i++
          sum = sum + nonNeg;
          i++;
        }
      }while(nonNeg>0); //while the inputted values are higher than one, run this do while
      double average = sum / i;
      System.out.printf("\n%,.2f.\n\n", average);
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
        System.out.println("\nPrime.\n");
      }else{
        System.out.println("\nNot Prime.\n");
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
      do{
        System.out.print("Positive integer: ");
        fib = in.nextInt();
      }while(fib<=1||fib>=92);

      for(int i = 2; i <= fib; i++){
        numSeq = n1 + n2;
        n1 = n2;
        n2 = numSeq;
      }
      System.out.println("\n" + numSeq + ".\n");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
      double posNum = 0;
      int factorNum = 0;
      double dividedNum = 0;
      do{
        System.out.print("Positive integer: ");
        posNum = in.nextInt();
      }while(posNum<=0);
      System.out.print("\n");

      for(int i = 1; i <= Math.sqrt(posNum); i++){
        dividedNum=posNum/i;
        if(posNum % i == 0){
          if(i == 1){
            System.out.print(i + ", ");
            System.out.printf("%,.0f", dividedNum);
          }else{
            System.out.print(", " + i + ", ");
            System.out.printf("%,.0f", dividedNum);
          }
        }
      }
      System.out.print(".\n\n");
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
      int height = 0;
      String initial = "##";
      String add = "#";
      do{
        System.out.print("Height: ");
        height = in.nextInt();
      }while(height<1||height>24);

      for(int i = 0; i < height; i++){
        if(i == 0){
          System.out.print("\n");
          for(int x = 0; x < height-1; x++){
            System.out.print(" ");
          }
          System.out.println("##");
        }else{
          for(int y = 1; y < height-i; y++){ /*Don't know why this line of code took FOREVER to figure out when I wrote
            the same exact thing above but the amount of spaces printed is the height subtracted by i */
            System.out.print(" ");
          }
          initial+=add; //Adds more pound symbols to the initial string with two pounds
          System.out.println(initial);
        }
      }
      System.out.print("\n");
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {
      int lHeight = 0;
      String initial = "##";
      String add = "#";
      do{
        System.out.print("Height: ");
        lHeight = in.nextInt();
      }while(lHeight<1||lHeight>24);

        for(int i = 0; i < lHeight; i++){
          if(i == 0){
            System.out.print("\n");
            for(int x = 0; x < lHeight-1; x++){
              System.out.print(" ");
            }
            System.out.println("## ##");
          }else{
            for(int y = 1; y < lHeight-i; y++){
              System.out.print(" ");
            }
            initial+=add;
            System.out.println(initial + " " + initial);
        }
      }
      System.out.println("");
    }

    /*
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {
      long number;
      String notMul = "";
      String mul = "";
      String multiply = "";
      long sum = 0;
      String amex = "37";
      String masterCard = "5";
      String visa = "4";
      System.out.println("");
      do{
        System.out.print("Number: ");
        number = in.nextLong();
      }while(number<=0);
      String original = Long.toString(number);
      String numberS = new StringBuffer(original).reverse().toString();

      for(int i = 0; i < numberS.length(); i++){ /*This for loop separates the numbers to multiply and the numbers not
          to multiply*/
        long numberSN = Long.parseLong(String.valueOf(numberS.charAt(i)));
        if(i==0){
          notMul = numberS.substring(i, i+1);
        }else if(i==1){
          mul = numberS.substring(i, i+1);
        }else if(i%2==0){
          notMul += numberS.substring(i, i+1);
        }else if(i%2==1){
          mul += numberS.substring(i, i+1);
        }
      }

      for(int x = 0; x < mul.length(); x++){ /*Adds together all of the numbers that are supposed to be multiplied into
          a string*/
        long numberSN = Long.parseLong(String.valueOf(mul.charAt(x)));
        long multipliedNumber = numberSN * 2;
        String mNS = Long.toString(multipliedNumber);
        multiply += mNS;
      }

      for(int y = 0; y < multiply.length(); y++){ /*Adding each number that was multiplied together*/
        long addDigits = Long.parseLong(String.valueOf(multiply.charAt(y)));
        sum += addDigits;
      }


      for(int z = 0; z < notMul.length(); z++){ /*Adding the final sum to the sum of the numbers not multiplied in the
          beginning*/
        long addDigit = Long.parseLong(String.valueOf(notMul.charAt(z)));
        sum += addDigit;
      }

      long sumFinal = Long.parseLong(String.valueOf(sum));
      if(sumFinal%10==0){
        if(amex.equals(original.substring(0, 2))){
          System.out.println("\nAmex.");
        }else if (masterCard.equals(original.substring(0, 1))){
          System.out.println("\nMasterCard.");
        }else if (visa.equals(original.substring(0, 1))){
          System.out.println("\nVisa.");
        }else{
          System.out.println("\nInvalid.");
        }
      }else{
        System.out.println("\nInvalid.");
      }
    }
}
