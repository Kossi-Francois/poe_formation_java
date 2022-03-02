import com.sun.jdi.IntegerValue;
import jdk.dynalink.beans.StaticClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class IntroIVString {

    public static void main(String[] args) {



        //inverseChaine17();
        //palindromeTP18();

        //inverseNombreTP19();

       // annagrammesTP20();

       // capitalizeTP21();

        doublonTP22();
    }


    public static void testHasMap(){

        String phrase="When I am Myself, I am hAppy and have a goOd Result";

       // phrase = phrase.replace(" ", "").replace(",", "").toLowerCase();
        phrase = phrase.replaceAll("[\s,]", "").toLowerCase();

        HashMap<Character,Integer> occurences=new HashMap<>();
        for(int i=0;i<phrase.length();i++){
            char lettre=phrase.charAt(i);
            if(occurences.containsKey(lettre)){
                occurences.replace(lettre,occurences.get(lettre)+1);
            }else{
                occurences.put(lettre,1);
            }
        }
        System.out.println(occurences);



        Character maxVal = phrase.charAt(0);
        int max = occurences.get( maxVal );

        for (Character key : occurences.keySet()) {
            if( occurences.get(key) >= max ){
                max = occurences.get(key);
                maxVal = key;
            }
        }


        System.out.printf(" le char le plus frequent est << %s >> avec << %d >> occurences \nApres c'est en general le cas lorsqu'il s'agit de l'anglais", maxVal, max);

    }


    public static void inverseChaine17() {

        System.out.println("TP17: Veuillez saisir kle mot à inverser");
        Scanner input = new Scanner(System.in);

        String reversedWord = "";

        for(String elt: input.nextLine().split("")) reversedWord = elt+reversedWord;

        System.out.printf("La chaîne inversée: %s", reversedWord);

    }


    public static void palindromeTP18(){

        System.out.println("TP18: Veuillez saisir le mot à tester le caractere palin..");
        Scanner input = new Scanner(System.in);

        String inpWord = input.nextLine();

        String temp = inpWord.replaceAll("[\s,]", "").toLowerCase();
        String[] inpArr = temp.split("");

        String reversedWord = "";

        for(String elt: inpArr) reversedWord = elt+reversedWord;

        System.out.printf("Resultat: << %s >> " +   ((temp.equals(reversedWord)) ? ("est un") : ("n'est pas un") )   +  "palindrome", inpWord);



    }


    public static void inverseNombreTP19() {

        System.out.println("TP19: Veuillez saisir le nombre à inverser");
        Scanner input = new Scanner(System.in);
        int inpNbr = input.nextInt();

        String inpString = String.valueOf( Math.abs( inpNbr ) );

        String reversedWord = "";

        for(String elt: inpString.split("")) reversedWord = elt+reversedWord;

        System.out.printf("La nombre inversée: %d",  ( (inpNbr<0)? -1 :  1) * Integer.valueOf( reversedWord) );

    }


    public static HashMap<String, Integer> getOcc(String[] inpTxtArr){
        HashMap<String, Integer> occMap = new HashMap<String, Integer>();

        for(String elt: inpTxtArr){

            if( occMap.containsKey(elt)  ){
                occMap.put(elt, occMap.get(elt) + 1);
            }else{
                occMap.put(elt, 1);
            }

        }

        return occMap;
    }


    public static void annagrammesTP20(){

        Scanner input = new Scanner(System.in);

        System.out.println("TP20 annagrammes: ");

        System.out.println("Veuillez saisir le premier mot ");
        String inpTxt0 = input.nextLine();

        System.out.println("Veuillez saisir le deuxieme mot ");
        String inpTxt1 = input.nextLine();

        String[] temp0 = inpTxt0.replaceAll("[\s,]", "").toLowerCase().split("");
        String[] temp1 = inpTxt1.replaceAll("[\s,]", "").toLowerCase().split("");

        if(temp0.length != temp1.length){
            System.out.printf("Resultat: << %s >>  et << %s>> ne sont pas des", inpTxt0, inpTxt1);
            return;
        }


        HashMap<String, Integer> occTxt0 = getOcc( temp0  );
        HashMap<String, Integer> occTxt1 = getOcc( temp1  );


        boolean res = true;

        for(String elt0 : occTxt0.keySet()){

            if ( (!occTxt1.containsKey(elt0))  ||  ( !occTxt0.get(elt0).equals( occTxt1.get(elt0))  ) ){
                res  = false;
                break;
            }
        }


        System.out.printf("Resultat: << %s >>  et << %s>>  %s  des anagrams", inpTxt0, inpTxt1, (res ? ("sont") : ("ne sont pas") ) );

    }


    public static void capitalizeTP21(){

        Scanner input = new Scanner(System.in);

        System.out.println("TP21 To capital: ");

        System.out.println("Veuillez saisir le premier mot ");
        String inpTxt = input.nextLine();

        String[] inpTxtArr = inpTxt.split(" ");

        String outTxt = "";

        for(String elt: inpTxtArr) outTxt+= elt.substring(0, 1).toUpperCase() + elt.substring(1) + " ";


        outTxt = outTxt.substring(0, outTxt.length()-1);

        System.out.printf("Laversion capitale de << %s >> est << %s >>", inpTxt, outTxt );


    }



    public static void doublonTP22(){

        Scanner input = new Scanner(System.in);

        System.out.println("TP22 Doublons: ");

        System.out.println("Veuillez saisir le  mot ");
        String inpTxt = input.nextLine();

        HashMap<String, Integer> nbrOcc =  getOcc(inpTxt.replace(" ", "").toLowerCase().split(""));

        String outTxt = "";

        HashMap<String, Integer> nbrOccDoublon =  new HashMap<String, Integer>();

        for(String key: nbrOcc.keySet() ) {
            if (nbrOcc.get(key) == 1) {
                outTxt += key;
            }else{
                //nbrOcc.remove(key);
                nbrOccDoublon.put(key, nbrOcc.get(key));
            }
        }

        System.out.printf("La cahine de depart << %s >>", inpTxt );

        System.out.printf("La chaine sans doublons << %s>>", outTxt );

        System.out.printf("La map<char, nbrOcc>   << %s >>", nbrOccDoublon );

    }

}
