package TextProgram;

import java.util.Scanner;


public class Main {

    private static int answer;

    public static void main (String[] args){
        System.out.println("Welcome to the Ultimate exercise program!");
        System.out.println("-----------------------------------------------\n");
        System.out.println("Press 1 to enter a new workout.");
        System.out.println("Press 2 to view old workouts.");
        Scanner sc = new Scanner(System.in);
        answer = sc.nextInt();
        if (answer == 1){
            CreateWorkout newWorkout = new CreateWorkout();
        }

    }
}
