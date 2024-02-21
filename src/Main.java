import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random gen = new Random();
        Scanner in = new Scanner(System.in);
        int die1 = 0;
        int die2 = 1; //set this to 1 since we can't have both die equaling the same
        int crapsRoll = 0;
        int crapsRoll2 = 0;
        int point = 0;
        boolean done = false;
        boolean donePoint = false;
        boolean playAgain = true;
        String playResponse = "";

        while(playAgain)
        {

        do {
            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;
            crapsRoll = die1 + die2;

            System.out.println("This is the roll for die 1: " + die1);
            System.out.println("This is the roll for die 2: " + die2);
            System.out.println("This is the craps roll : " + crapsRoll);

            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12)
            {
                System.out.println("You crapped out ");
                done = true;
            }
            else if (crapsRoll == 7 || crapsRoll == 11)
            {
                System.out.println("You won!");
                done = true;
            }
            else // rollling for point
            {
                point = crapsRoll; // point variable is now the same as the craps roll
                System.out.println("You are trying for point " + point);
                while (!donePoint)
                {
                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    crapsRoll2 = die1 + die2; //  need another "crapsRoll" variable so "crapsRoll2" exists now to not reset "crapsRoll" from line 42

                    System.out.println("This is the roll for die 1: " + die1);
                    System.out.println("This is the roll for die 2: " + die2);
                    System.out.println("This is the craps roll : " + crapsRoll2);

                    if (crapsRoll2 == 7 ) // you lost bc you rolled number 7 and that is auto lose in making point portion of game
                    {
                        System.out.println("You got a 7 and lost.");
                        donePoint = true; // set to true to get out of line 44's while loop
                        done = true; // set to true to get out of line 21's do while loop
                    }
                    else if (crapsRoll2 == point) // if crapsRoll2 equals point (from line 42) we have won the game
                    {
                        System.out.println(" Made the point and won!");
                        donePoint = true;
                        done = true;
                    }
                }

            }

        } while (!done);
        done = false; // have to reset done to false since it's still set to true from line 44's while loop if user crapped out or won
        donePoint = false; //have to reset donePoint to false since it's still set to true from line 44's while loop if user crapped out or won
        do
        {
            System.out.print("Do you want to play again [Y/N]? ");
            playResponse = in.nextLine(); // we need this and NOT in.hasNextLine to bulletproof

            if (playResponse.equalsIgnoreCase("N"))
            {
                done = true;
                playAgain = false;
            }
            else if (playResponse.equalsIgnoreCase("Y"))
            {
                done = true;
                //playAgain = true; not needed redeclared since it's playAgain is already set to true in line 18
            }
            else
            {
                System.out.println("Enter a valid response, not " + playResponse); //this is how we bulletproof this example
            }
        } while (!done);
        done = false; // have to reset done to false since it's still set to true from do while loop in line 73 if user chooses Y or N
        }
    }
}
