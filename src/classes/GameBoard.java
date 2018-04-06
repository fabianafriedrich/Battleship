package classes;

import javax.naming.SizeLimitExceededException;
import java.util.*;

public class GameBoard {

    /*Global Variables
        - Size of the board
        - Initializing Board Sizes of Players
    */
    int calLengthOfShip;
    final Integer QUANTITYOFSHIP = 3;
    int playerBoard[][];

    public void initializingBoard(Integer sizeY){
        calLengthOfShip(sizeY);
        //insertTheShipsInThePlayersbBoard();
    }

    public void initializingBoardSizes(Integer sizeX, Integer sizeY){
         playerBoard = new int [sizeX][sizeY];
    }
    public void calLengthOfShip(Integer sizeY){

        calLengthOfShip = sizeY/3;
    }
    public int [][] returnNewBoardWithShips(Integer sizeX, Integer sizeY){
        int newBoard[][] = new int [sizeX] [sizeY];
        int restOfShips = QUANTITYOFSHIP;
        Random randomNumber= new Random();

        do {
            for (int[] line : newBoard){
                for(int column : line){
                    if (randomNumber.nextInt(100 ) <= 10){
                        if (column == 0){
                            column = 1;
                            restOfShips--;
                            break;
                        }
                        if (restOfShips <=0 ){
                            break;
                        }
                    }
                    if (restOfShips <=0 ){
                        break;
                    }
                }
                if (restOfShips <=0 ){
                    break;
                }
            }
        }while (restOfShips >0);
        return newBoard;
       // return returnNewBoardWithShips(newBoard);
    }
    public void  insertTheShipsInThePlayersbBoard(Integer sizeX, Integer sizeY){
        playerBoard = returnNewBoardWithShips(sizeX,sizeY);
    }
    public void printingBoard(Integer sizeX, Integer sizeY){
        int i,j;

        for(i = 0; i < sizeX; i++) {

            System.out.print("|"); //start of a row;

            for(j=0;j<sizeY;j++) {
                //print a row
                System.out.print("_|");
            }

            System.out.println("");	//go to next row
        }
        returnNewBoardWithShips(sizeX, sizeY);
    }
    public static void main(String[] args) {
        // write your code here
        new GameBoard();

    }
}
