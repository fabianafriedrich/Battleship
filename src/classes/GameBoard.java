package classes;

import javax.naming.SizeLimitExceededException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameBoard {

    /*Global Variables
        - Size of the board
        - Initializing Board Sizes of Players
    */
    int sizeX, sizeY, numberOfBattleship, maximumLimitOfBattleship;
    int playerBoard1[][], playerBoard2[][], playerBoard3[][], playerBoard4[][];

    public GameBoard(){
        sizeOfBoard();
        calMaximumLimitOfBattleship();
        initializingBoardSizes();
        getQuantityOfShip();
    }
    public void sizeOfBoard(){
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

    }
    public void initializingBoardSizes(){
        playerBoard1 = new int [sizeX][sizeY];
        playerBoard2 = new int [sizeX][sizeY];
        playerBoard3 = new int [sizeX][sizeY];
        playerBoard4 = new int [sizeX][sizeY];


    }
    public void calMaximumLimitOfBattleship(){

        maximumLimitOfBattleship = (sizeX * sizeY) /  3;
    }
    public void getQuantityOfShip(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of Ships");
        System.out.println("Max: " + maximumLimitOfBattleship + " ships:");
        numberOfBattleship = input.nextInt();
        if(numberOfBattleship < 1 || numberOfBattleship > maximumLimitOfBattleship){
            numberOfBattleship = maximumLimitOfBattleship;
        }
        System.out.println(numberOfBattleship);
    }
    public static void main(String[] args) {
        // write your code here
        new GameBoard();
    }
}
