package GuessTheNumber;
import java.util.Scanner;
import java.util.Random;
public class Game {
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    Random rand=new Random();
    int number=rand.nextInt(100)+1;
    int guess;
    String name;
    int attempts=0;
    int max_attempts=5;
    System.out.println("Welcome to Guess the Number Game! \nHope you have the best time!");
    System.out.println("Enter your name:");
    name=sc.nextLine();
    System.out.println("Hi "+name+"\nLet's begin our Game!:");
    while(attempts<max_attempts){
        System.out.println("Enter your Guessing number:");
        guess=sc.nextInt();
        attempts++;
        if(guess==number){
            System.out.println("Congratulations "+name+"\n You guessed the number in "+attempts+"attempts");
        }
        else if(guess<number){
            System.out.println("Too low Number");
        }
        else{
            System.out.println("Too High Number");
        }
    }
    if(attempts==max_attempts){
        System.out.println("Sorry...!"+name+"you lost. \nThe number was"+number);
    }

    sc.close();
    }
    
    
}
