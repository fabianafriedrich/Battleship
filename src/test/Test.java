package test;

import java.util.Scanner;

public class Test {


    static Scanner input = new Scanner(System.in);

   public static  void main(String args[]){
       System.out.println("Choose the string: ");
       String test = input.nextLine();

       System.out.println("Choose the string: ");
       Integer test2 = input.nextInt();

       System.out.println(test + " - " + test2);


   }

}
