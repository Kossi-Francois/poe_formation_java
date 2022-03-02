import java.util.*;

public class IntroVArrayList {

    final private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Integer> tab = new ArrayList<Integer>() ;

        //tab.

        //langTabTP23();

       // nbrTabTP24();

        percentAdressTP25();

    }


    public static void langTabTP23(){


        System.out.println("TP23: ");

        System.out.println("Veuillez saisir les langs au format: lang1, lang2,... ");
        String[] inpTxtArr = input.nextLine().replace(" ", "").toLowerCase().split(",");
        ArrayList<String> tab = new ArrayList<String>(Arrays.asList(inpTxtArr));


        System.out.println("Veuillez saisir les langs à supprimer au format: lang1, lang2,... ");
        String[] inpTxtArr2Del =   input.nextLine().replace(" ", "").toLowerCase().split(",");



        System.out.println( "Avant");
        System.out.println(tab);


        System.out.println( "Apres");
        tab.removeAll(List.of(inpTxtArr2Del));
        System.out.println(tab);

        // java, go , python

    }


    public static void nbrTabTP24(){


        System.out.println("TP24: ");

        System.out.println("Veuillez saisir les langs au format: nbr1, nbr2, nbr3... ");
        String[] inpTxtArr = input.nextLine().replace(" ", "").toLowerCase().split(",");

        Set<String> nbrSet = new HashSet<String>(Arrays.asList(inpTxtArr));


        System.out.println("Veuillez saisir les langs à supprimer au format: nbr1, nbr2, nbr3,... ");
        String[] inpTxtArr2Del =   input.nextLine().replace(" ", "").toLowerCase().split(",");


        System.out.println("Avant suppression");
        System.out.println(nbrSet);

        nbrSet.removeAll( List.of(inpTxtArr2Del) );
        System.out.println("Apres suppression");
        System.out.println(nbrSet);

    }



    public static void percentAdressTP25(){

        System.out.println("TP24: ");

        System.out.println("Veuillez saisir les adress@ au format: addr1, addr2, addr3... ");
        String[] inpTxtArr = input.nextLine().replace(" ", "").toLowerCase().split(",");

        HashMap<String,Double> occurences=new HashMap<String,Double>();

        for(String elt: inpTxtArr){
            String adrresType = elt.split("@")[1];  //christian@gmail ==> [ chrastian, gmail]

            if(occurences.containsKey(adrresType)){
                occurences.replace(adrresType,   occurences.get(adrresType) + 1);

            }else{
                occurences.put(adrresType, 1.0);
            }

        }


        for(String key : occurences.keySet()){

            occurences.replace(key, occurences.get(key) / (double) inpTxtArr.length );
        }

        System.out.println(occurences);


      //  christian.lisangola@gmail.com, jean.paul@gmail.com, alain@gmail.com, lydie@yahoo.fr, josephine.lajoie@yahoo.com, luise@hotmail.fr, philemon.turion@gmail.com, jules.cesar@hotmail.fr


    }



}
