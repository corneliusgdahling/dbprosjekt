package TextProgram;

import TextProgram.AddElements.AddØvelse;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    private static int answer;

    public static void main (String[] args){
        System.out.println("Welcome to the Ultimate exercise program!");
        System.out.println("-----------------------------------------------\n");
        System.out.println("Press 1 to enter a new workout.");
        System.out.println("Press 2 to view old workouts.");
        System.out.println("Press 3 to add a new type of workout.");
        System.out.println("Press 4 to view top scores.");
        Scanner sc = new Scanner(System.in);
        try{
            answer = sc.nextInt();
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
        if (answer == 1){
            CreateWorkout newWorkout = new CreateWorkout();
        }
        else if (answer == 2){
            PrintWorkout print = new PrintWorkout();
        }
        else if (answer == 3){
            AddØvelse nyØvelse = new AddØvelse();
        }

        else if (answer == 4){
            TextProgram.PrintHighscore.DetermineType determineType = new TextProgram.PrintHighscore.DetermineType();
        }

    }
}
