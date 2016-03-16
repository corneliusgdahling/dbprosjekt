package TextProgram.PrintElements;


import java.util.Scanner;


public class RecieveMain {
	
	public RecieveMain(){
		RecieveTreningsøkt treningsøkt = new RecieveTreningsøkt(getDato());
		
	}

	public String getDato(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date (day/month/year) of the session you wish to view");
		String datoInput = sc.nextLine();
		String[] datoList = datoInput.split("/");
		String dato = datoList[2] + "-" + datoList[1] + "-" + datoList[0];
		return dato;
	}

}
