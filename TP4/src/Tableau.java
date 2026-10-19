public class Tableau {
    public static void main(String[] args) {
        int[] t = {6,8,5,4,8,1,2,7,4,9,8,4,2,2,6,0,5,8,5,7,5,2,1,9};
        int sum = 0, min = t[0];
        double average = 0.0;
        // Ecrire ci-dessous du code pour afficher la moyenne des éléments de t
        for(int i = 0; i < t.length; i++){
            // I will sum the current element to the whole sum that I have
            sum += t[i];

            // if the current element is smaller than my min, then I update the min
            if(min > t[i])
                min = t[i];
        }

        average = (double) sum / t.length;
        System.out.println("The average is " + average);

        // Ecrire ci-dessous du code pour afficher la plus petite valeur du tableau
        System.out.println("The smallest value in the array is " + min);
    }
}