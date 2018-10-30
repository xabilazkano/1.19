import java.util.Scanner;
import java.util.Random;
public class Args {

	public static void main(String[] args) {
		
		if (args.length==2) {
		System.out.println("Hello "+args[0]+" "+args[1]+"!");
		
		Scanner sc = new Scanner (System.in);
		Random ran = new Random();
		boolean flag=true;
		int tries=0;
		int number = ran.nextInt(200)+1; //the method we create a number between 0 and 199. By summing 1 we change the range to 1-200.
		String num = String.valueOf(number);
		System.out.println("I will think a number between 1 and 200, try to guess it in less than 10 tries.");
		
		while (flag) { 
			System.out.println("Tell me a number");
			if (sc.hasNextInt()) { //we control that we enter a number
				int number2=sc.nextInt();
				if (number2>=1 && number2<=200) { //we control if the number is in our range
					if (number<number2) {
						System.out.println("My number is smaller");
						tries++;//we control the tries
					}
					else if (number>number2) {
						System.out.println("My number is bigger");
						tries++;//we control the tries
					}
					else {
						tries++;//we control the tries
						System.out.println("You guessed it in " + tries + " tries.");
						flag=false;//we finish the game
					}
				}
				else {
					System.out.println("You haven't entered a number between 1 and 200");
				}						
			}
			else {
				System.out.println("You haven't entered a number");
				sc.next();
			}
			switch(tries) { //we use a switch to give hints for specific number of tries
				
				
				case 3:
					System.out.println("I will give you a hint");
					char[] array = num.toCharArray();
					String alderantziz="";
					for (int i=num.length()-1;i>=0;i--) {
						alderantziz=alderantziz+array[i];
					}
					if (num.equals(alderantziz)) {
						System.out.println("My number is palindrome");
					}
					else {
						System.out.println("My number isn't palindrome");
					}
					
					break;
					
				case 5:
					System.out.println("I will give you another hint");
					if (number<100) {
					System.out.println("The first digit is " + num.charAt(0));
					}
					else {
						if (number%2==0) {
							System.out.println("My number is even");
						}
						else {
							System.out.println("My number is odd");
						}
					}
					
					break;
					
				case 8:
					System.out.println("I will give you my last hint");
					if (number>=100) {
						System.out.println("The last digit is " + num.charAt(num.length()-1));
					}
					else {
						if (number%2==0) {
							System.out.println("My number is even");
						}
						else {
							System.out.println("My number is odd");
						}
					}
					
					break;
					
				case 10:
					System.out.println("Game Over");
					System.out.println("My number was "+ number);
					flag=false; //if we have done 10 tries we finish the game 
			}
		}
	}
		else {
			System.out.println("You haven't entered two arguments.");
		}
}
}
