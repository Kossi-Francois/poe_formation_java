import java.util.Scanner;

public class IntroII {


    public static void main(String[] args) {

        revDisplay();
    }


    public static void mean(){
        Scanner input = new Scanner(System.in);

        System.out.println("entrez la taille du tableau");
        int tabSize = input.nextInt();
        int[] notes = new int[tabSize];

        double sum = 0;

        for(int i =0; i<notes.length; i++){
            System.out.printf("Note[%d]\n", i);
            int temp = input.nextInt();
            notes[i] = temp;
            sum+=temp;

        }


//        Affichage du tableau
        System.out.println("Affichage du tableau\n===============");
        for(int i=0;i<notes.length;i++){
            System.out.printf("Note[%d] : %d \n",i,notes[i]);
        }


        System.out.printf("la moyenne vaut : %f", (notes.length == 0) ?  0 : sum/tabSize );
    }



    public static void revDisplay(){

        Scanner input = new Scanner(System.in);

        System.out.println("entrez la taille du tableau");
        int tabSize = input.nextInt();
        int[] notes = new int[tabSize];


        for(int i = 0; i<notes.length; i++){
            System.out.printf("Note[%d]\n", i);
            int temp = input.nextInt();
            notes[i] = temp;

        }


        //Affichage du tableau
        String out = "[";
        System.out.println("Affichage du tableau\n===============");
        for(int i= notes.length -1 ;  i>-1; i--){

            out += notes[i] + ", ";

        }

        out = out.substring(0, out.length()-2);
        out+= "]";
        System.out.println(out);

        System.out.println("Affichage multiple de 5\n===============");
        for(int elt: notes){
            if(elt%15 == 0) System.out.println(elt);
        }


    }


}
