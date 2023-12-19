import java.util.Random;
import java.util.Scanner;
 
public class NumberGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int play=0;
		do {
			GuessTheNumber(sc);
			play = sc.nextInt();
		}while(play==1);
		System.out.println("Thanks for playing this game");

	}
	public static void GuessTheNumber(Scanner sc){
		
		Random random = new Random();
		int randomNumber = random.nextInt(101);
		System.out.println("You have 7 chances to guess the number");
		int guesses =1;
		boolean b = true;
		
		while(b) {
			if(guesses>7) {
				System.out.println("You used all your 7 guesses \nYou lost the game");
				System.out.println("\nTo play this game again enter 1");
				b=false;
			}else {
				System.out.println("Enter your guess");
				int g = sc.nextInt();
				if(g==randomNumber) {
					System.out.println("Congratualation you guessed the number correctly in "+guesses+ " Guesses\n");
					//System.out.println("To play this game again enter 1");
					System.out.println("To play this game again enter 1 else enter 0");
					
					b=false;
					
				}else if(g>randomNumber) {
					System.out.println("Your number is high ");
					guesses++;
				}else if(g<randomNumber) {
					System.out.println("Your number is low ");
					guesses++;
				}
			}
			
		}
	
}
}