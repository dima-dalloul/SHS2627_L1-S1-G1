import java.util.Scanner;

public class Exo3 {

	public static void main(String[] args) {		
		/*
		 * Résolution de ax+b=c
		a ? 2
		b ? 3
		c ? 10
		La solution est x=3.5.
		 */
		
		double a, b, c, res;
		Scanner s = new Scanner(System.in);
		System.out.println("Résolution de ax+b=c");
		System.out.print("a ? ");
		a = s.nextDouble();
		System.out.print("b ? ");
		b = s.nextDouble();
		System.out.print("c ? ");
		c = s.nextDouble();
		
		res = (c - b) / a;
		
		System.out.println("La solution est x = " + res);
		

	}

}
