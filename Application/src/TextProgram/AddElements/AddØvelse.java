package TextProgram.AddElements;


import java.util.Scanner;

public class AddØvelse {

    Scanner sc = new Scanner(System.in);

    public AddØvelse(){

    }


    public String getSQLStatement(){
        String sqlStatement = "\nINSERT INTO Øvelse (Øvelse_id, Navn, Beskrivelse) VALUES " + "(?, ? , ?)";
        return sqlStatement;
    }

    public int Øvelse_id(){
        System.out.println("Please enter the exercise ID.");
        int øvelse_id = sc.nextInt();
        return øvelse_id;
    }

    public String getNavn(){
        System.out.println("Enter the name of the exercise.");
        String navn = sc.nextLine();
        return navn;
    }

    public String getBeskrivelse(){
        System.out.println("Write a short description of the exercise.");
        String besk = sc.nextLine();
        return besk;
    }
}
