package classes;

import classes.Players;
import exceptions.*;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static List<Players> listPlayers = new ArrayList<Players>();
    static GameBoard gameBoard = new GameBoard();
    static Players player = new Players();
    final Integer QUANTITYOFSHIP = 3;
    static int sizeX, sizeY, calLengthOfShip;

    //Line Color
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    public static void initialMenu() throws Exception {
            System.out.println("Choose the number of players (maximum 4): ");
            Integer numberOFPlayers = input.nextInt();
            if(numberOFPlayers > 4 || numberOFPlayers < 1){
               //
                System.out.println(ANSI_RED + "Invalid Number of players. Try again" + ANSI_RESET);
                System.out.println("");
                initialMenu();
            }else{
                for(int i = 0; i <= numberOFPlayers - 1; i++){
                    Scanner s1 = new Scanner(System.in);
                    System.out.println("Enter your first name and surname: ");
                    String fullName = s1.nextLine();
                    boolean nameValid = player.validationName(fullName);
                    if(nameValid){
                        player.setName(fullName);
                    }else{
                       // throw new ExceptionName();
                        System.out.println(ANSI_RED + "Invalid Name and Surname. Try again" + ANSI_RESET);
                        System.out.println("");
                        initialMenu();
                    }
                    System.out.println("Enter your age (12-100): ");
                    Integer age = s1.nextInt();
                    player.setAge(age);
                    boolean ageValid = player.validationAge(age);
                    if(ageValid){
                        player.setAge(age);
                    }else {
                       // throw new ExceptionAge();
                        System.out.println(ANSI_RED +"Invalid Age. Try again" + ANSI_RESET);
                        System.out.println("");
                        initialMenu();
                    }

                    System.out.println("Enter your email address: ");
                    String email = s1.next();
                    player.setEmail(email);
                    boolean emailValid = player.validationEmail(email);
                    if(emailValid){
                        player.setEmail(email);
                    }else {
                       // throw new ExceptionEmail();
                        System.out.println(ANSI_RED + "Invalid email. Try again" + ANSI_RESET);
                        System.out.println("");
                        initialMenu();
                    }


                    if(i != numberOFPlayers - 1){
                        System.out.println("");
                        System.out.println("---Next Player---");
                        System.out.println("");
                    }
                    listPlayers.add(player);
                }
            }

    }
    public static void sizeOfBoard(){
        /* Game Board
               Asking the Player the size of the board
        */
        Scanner input = null;
        for (;;) {
            boolean allRight=false;
            try {
                input = new Scanner(System.in);
                System.out.println("Enter the height of the board (Minimum 10, max of 20): ");
                sizeX = input.nextInt();
                if(sizeX < 10 || sizeX > 20){
                    throw new SizeLimitExceededException();
                }
                System.out.println("Enter the width of the board (Minimum 10, max of 20):");
                sizeY = input.nextInt();
                if(sizeY < 10 || sizeY > 20){
                    throw new SizeLimitExceededException();
                }
                allRight=true;
            } catch (InputMismatchException error) {
                System.out.println("Enter a number");
            } catch (SizeLimitExceededException error) {
                System.out.println("Number must be minimum 10 and max of 20");
            }
            if(allRight){
                break;
            }
        }
        gameBoard.initializingBoardSizes(sizeX, sizeY);
        gameBoard.initializingBoard(sizeY);
        gameBoard.printingBoard(sizeX, sizeY);
        gameBoard.insertTheShipsInThePlayersbBoard(sizeX, sizeY);


    }

    public static void main(String[] args) {
	// write your code here
        try {
            initialMenu();
            sizeOfBoard();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
