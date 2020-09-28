import java.util.Scanner;
public class RNGDriver
{
	public static Scanner userInput;
	public static int numberRandom;
	public static int numberGuess, highGuess, lowGuess;
	public static RNG randomNumberGenerator;
	public static void main (String[] args)
	{
		String tryAgain = "yes";
		while ( tryAgain.equalsIgnoreCase("yes"))
		{
			initialiseGame();
			playGame();
			System.out.println ("Would you like to try again? (yes or no)");
			tryAgain = userInput.next();
			System.out.println ("");
			}
		System.out.println ("Thank you for playing!\n\n" + "Programmer: Lucas Austin\n" + "Course: CMSC203\n" + "Assignment 2\n");
		}
	
	public static void initialiseGame()
	{
		lowGuess = 1;
		highGuess = 100;
		numberRandom = RNG.rand();
		RNG.resetCount();
	}
	
	public static void playGame()
	{
		userInput = new Scanner(System.in);
		System.out.println ("I am thinking of a number between 0 and 99.");
		System.out.println ("Enter your first guess:");
		numberGuess = userInput.nextInt();
		
		while(numberGuess != numberRandom)
		{
			if (!RNG.inputValidation(numberGuess, lowGuess, highGuess))
			{
				numberGuess = userInput.nextInt();
				continue;
			}
			
			System.out.println ("Number of guesses is " + RNG.getCount() + ".");
			
			if (numberGuess > numberRandom)
			{
				highGuess = numberGuess;
				System.out.println ("Your guess is too high.");
			}
			
			else
			{
				lowGuess = numberGuess;
				System.out.println ("Your guess is too low.");
			}
			
			System.out.println ("Enter your next guess between " + lowGuess + " and " + highGuess + ".");
			numberGuess = userInput.nextInt();
			}
		
		System.out.println ("Number of guesses is " + (RNG.getCount() + 1) + ".");
		System.out.println ("Congratulations, you guessed the number!");
		}
	}