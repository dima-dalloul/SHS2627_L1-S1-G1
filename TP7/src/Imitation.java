import java.util.Arrays;

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

        // Test for Decode Message
        System.out.println("The hidden message is : " + decodeMsgQuestionB("ugdxl avtgvl ov bheh qhg lvkhxzv evgl sh ovtixvkv hzzvv zdtl vkkvzv", rotor1, rotor2, reflec));

        // Test for Decaler
        char[] t = {'a','b','c','d'};
        System.out.println(Arrays.toString(t));
        decaler(t);
        System.out.println(Arrays.toString(t));

        // Test for Decode Message Question D
        System.out.println("The hidden message is : " + decodeMsgQuestionD("ypoyarhcmsejvud nfs zpl isw uvssacwvv", rotor1, rotor2, reflec));

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
    les fonctions précédentes. Par exemple, avec 'a', la fonction doit renvoyer 'h' (
    1- de 'a' à 'e' par le rotor 1,
    2- de 'e' à 'l' par le rotor 2,
    3- de 'l' à 'j' par le déflecteur,
    4- de 'j' à 'n' par le rotor 2 inversé
    5- et de 'n' à 'h' par le rotor 1 inversé). Testez votre programme et vérifiez que
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

    /**
     * Écrire la fonction decodeMsg pour décoder, caractère par caractère, une chaîne. Si un caractère est
     * un espace, ne le décodez pas, recopiez-le tel quel dans la chaîne résultat. Utilisez votre programme pour
     * décoder le message :
     *
     */
    public static String decodeMsgQuestionB(String stringToDecode, char[] rotor1, char[] rotor2, char[] reflec){
        String result = "";

        for(int i = 0; i < stringToDecode.length(); i++){
            if(stringToDecode.charAt(i) == ' '){
                result += ' ';
            } else {
                result += decodeCar(rotor1, rotor2, reflec, stringToDecode.charAt(i));
            }
        }

        return result;
    }

    /**
     * Écrire l'action decaler qui, étant donné un tableau de caractères, décale ses éléments d'un cran vers le
     * début, le premier élément étant affecté à la dernière case du tableau. Attention à l'ordre dans lequel
     * vous faites ces opérations. Testez cette action. Pour cela, vous pouvez afficher le contenu d'un tableau
     * en écrivant votre propre action ou en utilisant la fonction Arrays.toString (en ayant ajouté import
     * java.util.Arrays; au début du programme). Voici une façon de tester votre action decaler :
     * char[] t = {'a','b','c','d'};
     * System.out.println(Arrays.toString(t));
     * decaler(t);
     * System.out.println(Arrays.toString(t))
     */

    public static void decaler(char[] arrayOfCharacters){
        // We copy the first letter and keep it aside
        char firstCharacter = arrayOfCharacters[0];

        // for the next letters, we are going to move them by one index
        for(int i = 1; i < arrayOfCharacters.length; i++){
            arrayOfCharacters[i - 1] = arrayOfCharacters[i];
        }

        // We paste the stored letter into the last place
        arrayOfCharacters[arrayOfCharacters.length - 1] = firstCharacter;
    }

    /**
     *  Lorsque le rotor 1 a fait un tour complet, il décale d'un cran le rotor 2, comme dans un compteur
     * kilométrique de voiture. Modifier la fonction decodeMsg pour prendre en compte ces décalages.
     * Vous devriez alors pouvoir décoder ce message :
     * ypoyarhcmsejvud nfs zpl isw uvssacwvv
     */
    public static String decodeMsgQuestionD(String stringToDecode, char[] rotor1, char[] rotor2, char[] reflec){

        String result = "";
        int decalageCount = 0;

        for(int i = 0; i < stringToDecode.length(); i++){
            if(stringToDecode.charAt(i) == ' ')
                result += ' ';
            else
                result += decodeCar(rotor1, rotor2, reflec, stringToDecode.charAt(i));

            decaler(rotor1);
            decalageCount++;

            if(decalageCount == rotor1.length){
                decaler(rotor2);
                decalageCount = 0;
            }
        }
        return result;
    }
}
