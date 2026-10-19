import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int[] temp = new int[31];
        remplitTableau(temp);
        afficheEnLigne(temp);
        System.out.println("Minimum du mois : "+ min(temp));
        System.out.println("Maximum du mois : "+ max(temp));
        System.out.println("Température moyenne : "+ moyenne(temp));
        System.out.println("Nb de jours inférieurs à 0°: "+nbValIntervalle(temp,-99,0));
        System.out.println("Nb de jours entre 0 et 10°: "+nbValIntervalle(temp,0,10));
        System.out.println("Nb de jours supérieurs à 10°: "+nbValIntervalle(temp,10,99));
        afficheEnLigne(temp);
        histogramme(temp);
        modif(temp);
    }

    // une action remplitTableau qui remplit le tableau avec des valeurs aléatoires entre −20 inclus et 50 inclus
    public static void remplitTableau(int[] tab){
        for(int i = 0; i < tab.length; i++){
            // Equation : (int)(Math.random() * ((max - min) + 1))
            tab[i] = ((int) (Math.random() * ((50 - -20) + 1))) - 20;
            // we put -20 to include the numbers below 0
        }
    }

    // une action afficheEnLigne, qui affiche sur une seule ligne les éléments du tableau
    public static void afficheEnLigne(int[] tab){
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i] + " ");
        System.out.println();
    }

    // une fonction min qui renvoie la plus petite valeur du tableau
    public static int min(int[] tab){
        int min = 100;

        for(int i = 0; i < tab.length; i++){
            if(min > tab[i])
                min = tab[i];
        }

        return min;
    }

    // une fonction max qui renvoie la plus grande valeur du tableau
    public static int max(int[] tab){
        int max = -100;

        for(int i = 0; i < tab.length; i++){
            if(max < tab[i])
                max = tab[i];
        }

        return max;
    }

    // une fonction moyenne qui renvoie la moyenne des valeurs
    public static double moyenne(int[] tab){
        double totalSum = 0;

        for(int i = 0; i < tab.length; i++){
            totalSum += tab[i];
            // equals to : totalSum = totalSum + tab[i];
        }

        return (totalSum / tab.length);
    }

    // Une fonction nbValIntervalle qui renvoie le nombres de valeurs entre une borne
    // inférieure incluse et une borne supérieure incluse
    public static int nbValIntervalle(int[] tab, int min, int max){
        int countNbElementsInIterval = 0;

        for(int i = 0; i < tab.length; i++){
            if((min <= tab[i]) && (tab[i] <= max))
                countNbElementsInIterval++;
        }

        return countNbElementsInIterval;
    }

    // une fonction histogramme qui affiche une ligne pour chaque température avec un
    // nombre de ‘*’ correspondant à la valeur de la température
    public static void histogramme(int[] tab){
        System.out.println("       -20       -10       0         10        20        30        40        50");
        for(int i = 0; i < tab.length; i++){
            String nbStars = "";
            for (int j = -20; j < tab[i]; j++)
                nbStars += "*";
            System.out.println("Jour " + i + " :" + nbStars );
        }
    }

    // une action modif qui demande en boucle à l’utilisateur s’il veut modifier des valeurs
    //    et, si oui, lui demande le jour et la température
    public static void modif(int[] tab){
        char inputUser;
        Scanner s = new Scanner(System.in);

        do{
            System.out.println("Voulez-vous modifier le relevé ? (o/n)");
            inputUser = s.nextLine().charAt(0);
            if(inputUser == 'o'){
                System.out.println("Quel jour ?");
                int jour = Integer.parseInt(s.nextLine());
                System.out.println("Quelle température ?");
                int temp = Integer.parseInt(s.nextLine());
                if(0 <= jour && jour <= tab.length){
                    tab[jour - 1] = temp;
                }
            } else {
                afficheEnLigne(tab);
            }
        }while(inputUser == 'o');
    }
}