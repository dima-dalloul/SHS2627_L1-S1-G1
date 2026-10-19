import java.util.Scanner;

public class Exo2 {

	public static void main(String[] args) {
		/*Chaine 1 ? BLABLA
		Chaine 2 ? BOUM
		BLABLA BOUM
		BOUM BLABLA
		*/
		
		Scanner s = new Scanner(System.in);
		System.out.print("Chaîne 1 ?");
		String ch1 = s.nextLine();
		System.out.print("Chaîne 2 ?");
		String ch2 = s.nextLine();
		
		System.out.println(ch1 + " " + ch2);
		System.out.println(ch2 + " " + ch1);

	}

}
