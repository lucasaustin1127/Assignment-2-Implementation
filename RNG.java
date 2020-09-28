import java.util.Random;
import java.util.Scanner;

public class RNG
{
	private static int count=0;
	static Scanner userInput;
	public RNG()
	{
		count++;
	}
	
	public static void resetCount()
	{
		count = 0;
	}
	
	public static int rand()
	{
		Random random = new Random();
		int randomInt = random.nextInt(100) + 1;
		return randomInt;
	}
	
	public static boolean inputValidation(int numberGuess, int lowGuess, int highGuess)
	{
		boolean returnValue = true;
		if (numberGuess >= highGuess || numberGuess <= lowGuess)
		{
			System.out.println("Guess must be between " + lowGuess + " and " + highGuess + ". Please try again.");                 
			returnValue = false;
        }
		
		else
			count++;
		return returnValue;
		}
	public static int getCount()
	{
		return count;
	}
}