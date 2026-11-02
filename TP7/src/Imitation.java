public class Imitation {
    public static void main(String[] args){
        char[]rotor1 = {'e','l','w','m','h','a','s','n','o','i','x','y','b','r','z','q','d','c','v','g','t','f','k','p','u','j'};
        char[]rotor2 = {'d','k','s','c','l','p','b','x','w','o','t','g','u','j','f','z','e','v','r','q','m','i','a','y','n','h'};
        char[]reflec = {'m','q','e','t','c','z','w','u','n','l','y','j','a','i','v','x','b','s','r','d','h','o','g','p','k','f'};

        // Test for rotor 1
        System.out.println("Rotor Aller for a is " + passeUnRotorAller(rotor1, 'a'));
        System.out.println("Rotor Aller for b is " + passeUnRotorAller(rotor1, 'b'));
        System.out.println("Rotor Aller for z is " + passeUnRotorAller(rotor1, 'z'));

        // Test for rotor 2
        System.out.println("Rotor Retour for a is " + passeUnRotorRetour(rotor1, 'a'));
        System.out.println("Rotor Retour for w is " + passeUnRotorRetour(rotor1, 'w'));
        System.out.println("Rotor Retour for j is " + passeUnRotorRetour(rotor1, 'j'));

        // Test for Decode Car
        System.out.println("Decode Car for a is " + decodeCar(rotor1, rotor2, reflec, 'a'));
        System.out.println("Decode Car for h is " + decodeCar(rotor1, rotor2, reflec, 'h'));
    }

    /*
    passeUnRotorAller qui étant donné un tableau et un caractère renvoie le caractère
    correspondant dans le sens aller. Par exemple passeUnRotorAller(rotor1,'c') doit renvoyer 'w'. Il faut juste
    utiliser le rang de la lettre dans l'alphabet pour trouver la lettre en sortie.
    Pour cela, rappelez-vous que les caractères peuvent être considérés comme des entiers et que
    donc 'c'-'a' vaut 2 ! Testez votre programme en affichant le résultat de cet exemple dans le
    main.
    */
    public static char passeUnRotorAller(char[] rotor, char charToBeFound){
        // les caractères peuvent être considérés comme des entiers et que donc 'c'-'a' vaut 2
        int indexResult = charToBeFound - 'a';

        // We return the character in rotor1[indexResult]
        return rotor[indexResult];
    }


    /*
    passeUnRotorRetour qui étant donné un tableau et un caractère renvoie le caractère
    correspondant au retour. Par exemple, passeUnRotorRetour(rotor1,'w') doit renvoyer 'c.
    Cette fois-ci, il faut chercher dans le tableau la position du caractère (par exemple, 2 pour 'w'
    et renvoyer le 3e caractère de l'alphabet). Tester votre programme comme précédemment.
    */
    public static char passeUnRotorRetour(char[] rotor, char charToBeFound){
        int indexOfChar = 0;
        for(int i = 0; i < rotor.length; i++){
            if(charToBeFound == rotor[i]) {
                indexOfChar = i;
                break;
            }
        }

        return (char) ('a' + indexOfChar);
    }


    /*
    decodeCar qui étant donné les 3 tableaux et un caractère, renvoie le caractère associé. Utilisez
    les fonctions précédentes. Par exemple, avec 'a', la fonction doit renvoyer 'h' (de 'a' à 'e'
    par le rotor 1, de 'e' à 'l' par le rotor 2, de 'l' à 'j' par le déflecteur, de 'j' à 'n' par le
    rotor 2 inversé et de 'n' à 'h' par le rotor 1 inversé). Testez votre programme et vérifiez que
    decodeCar('a') renvoie bien 'h' et que decodeCar('h') renvoie bien 'a'. Si ce n'est pas le cas,
    faites des affichages intermédiaires pour isoler le dysfonctionnement
    char[]rotor1 = {'e','l','w','m','h','a','s','n','o','i','x','y','b','r','z','q','d','c','v','g','t','f','k','p','u','j'};
    char[]rotor2 = {'d','k','s','c','l','p','b','x','w','o','t','g','u','j','f','z','e','v','r','q','m','i','a','y','n','h'};
    char[]reflec = {'m','q','e','t','c','z','w','u','n','l','y','j','a','i','v','x','b','s','r','d','h','o','g','p','k','f'};
     */
    public static char decodeCar(char[] rotor1, char[] rotor2, char[] reflec, char charToBeFound){
        // Final result : avec 'a', la fonction doit renvoyer 'h'
        char step1, step2, step3, step4, step5, result;

        // First step : de 'a' à 'e' par le rotor 1
        step1 = passeUnRotorAller(rotor1, charToBeFound);

        // Second step : de 'e' à 'l' par le rotor 2
        step2 = passeUnRotorAller(rotor2, step1);

        // Third step : de 'l' à 'j' par le déflecteur
        step3 = passeUnRotorAller(reflec, step2);

        // Fourth step : de 'j' à 'n' par le rotor 2 inversé
        step4 = passeUnRotorRetour(rotor2, step3);

        // Fifth step : de 'n' à 'h' par le rotor 1 inversé
        step5 = passeUnRotorRetour(rotor1, step4);

        result = step5;

        return step5;

    }
}
