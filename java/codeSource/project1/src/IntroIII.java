import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntroIII {

    public static void main(String[] args) {



        //nbrOccTP14();

       // sumMultiple3TP15();

        minMaxArrayTP16();
    }



    public static int[] newTab( String inpTxt){

        Scanner input = new Scanner(System.in);

        System.out.println("entrez la taille du tableau Tab" + inpTxt + ":\n");
        int tabSize = input.nextInt();
        int[] tab = new int[tabSize];

        for(int i =0; i<tab.length; i++){
            System.out.printf("Tab[%d]\n", i);
            int temp = input.nextInt();
            tab[i] = temp;

        }



        //Affichage du tableau
        String out = "[";
        System.out.println("Affichage du tableau\n===============");
        for(int i= 0 ;  i< tab.length; i++){

            out += tab[i] + ", ";

        }

        out = out.substring(0, out.length()-2);
        out+= "]";
        System.out.println(out);


        return tab ;
    }




    private static void nbrOccTP14(){

        System.out.println("nombre d'occurence TP14");

        int[] tab = newTab("");

        Map<Integer, Integer> occMap = new HashMap<Integer, Integer>();

        // occMap = { 2 : 2, 7 :3, 5 :1...}
        // {2, 7, 5, 6, 7, 1, 6, 2, 1, 7}

        for(int elt: tab){

            Integer temp = Integer.valueOf(elt);

            if( occMap.containsKey(temp)  ){
                occMap.put(temp, occMap.get(temp) + 1);
            }else{
                occMap.put(temp, 1);
            }


        }

        int max = occMap.get( Integer.valueOf(tab[0])   );
        int maxVal = tab[0];
        for (Integer key : occMap.keySet()) {

            if( occMap.get(key) >= max ){
                max = occMap.get(key);
                maxVal = key;
            }
        }


        System.out.printf(" max = %d \n maxVal%d", max, maxVal);





    }



    public static void sumMultiple3TP15(){

        int[] tab1 = newTab("1");
        int[] tab2 = newTab("2");
        int[] tab3 = newTab("3");

        int[][] tab = {tab1, tab2, tab3};


        int sum = 0;
        for (int[] aTab : tab){
            for( int aVal : aTab ){

                if(aVal%3 ==0){
                    sum+=aVal;
                }

            }
        }


        System.out.printf("sum des multiples de 3 vaut à  %d", sum);
    }



    public static void minMaxArrayTP16(){

        int[] tab = newTab("");

        int maxVal = tab[0];
        int maxIdx = 0;

        int minVal = tab[0];
        int minIdx = 0;


        for(int i = 0; i< tab.length; i++){

            if(tab[i]>= maxVal){
                maxVal = tab[i] ;
                maxIdx = i;
            }

            if(tab[i]<= minVal){
                minVal = tab[i] ;
                minIdx = i;
            }
        }


        //Affichage du tableau
        String out = "Tb: [";
        System.out.println("Affichage du tableau\n===============");
        for(int i= 0 ;  i< tab.length; i++){

            String suffix = "";
            if( i == maxIdx) suffix += "(PG)";
            if( i == minIdx) suffix += "(PP)";

            out += tab[i] + suffix + ", ";

        }

        out = out.substring(0, out.length()-2);
        out+= "]";
        System.out.println(out);

        System.out.printf("Plus grand: %d\nPlus petit: %d", maxVal, minVal);




    }



}
