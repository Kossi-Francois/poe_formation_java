import java.util.*;

public class IntroVIMethodes {

    final private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

       // isPrefixTP26Test();
       // indexOfValTP27Test();
       // aleterneCaseTP28Test();

       // executeMvtTP29Test();

       // findSameCharTP30Test();

        //splitTabTP31Test();

       // isSommeTP33Test();

        isSommeTP33V2Test();

        //assert false : "assertion false";

    }

    public static boolean isPrefixTP26(String mot, String prefix){return (mot.startsWith(prefix));}

    public static void isPrefixTP26Test(){
        assert !isPrefixTP26("banner", "bang"): " assertion isPrefixTP26('banner', 'bang') failed";
        assert  isPrefixTP26("hugging", "hug"): " assertion isPrefixTP26('hugging', 'hug') failed";;

        System.out.println("TP6 : isPrefixTP26, test ok");

    }



    public static int indexOfValTP27(int[][] tab, int val){

        int nbrOcc = 0;
        ArrayList<int[]> index= new ArrayList<int[]>();

        String outTxt = "";

        for(int i =0; i< tab.length; i++){

            for(int j=0; j<tab[i].length; j++){

                if(tab[i][j] == val){
                    nbrOcc++;
                    index.add( new int[]{i, j});

                    outTxt += "(" +i+ "," +j+ ")";

                }
            }
        }

        System.out.printf("La valeur << %d >> se retrouve << %d >> fois dans les emplacements suivants : %s \n", val, nbrOcc, outTxt);

        return nbrOcc;

    }

    public static void indexOfValTP27Test(){
        int[][] tab = {
                {1, 4, 2, 1},
                {6, 3, 8, 9},
                {1, 5, 1, 0}
        };


        assert indexOfValTP27(tab, 1) == 4 : "assertion indexOfValTP27(tab) failed";
        System.out.println("TP27 indexOfValTP27, test ok");



    }






    public static Character[] aleterneCaseTP28( Character[] tab){

        System.out.println(List.of(tab));

        for(int i =1; i<tab.length; i+=2){
            tab[i] = Character.toUpperCase(tab[i]);
        }

        System.out.println(List.of(tab));
        return tab;
    }

    public static void aleterneCaseTP28Test(){
        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f'};

        Character[] alphabetCase = {'a', 'B', 'c', 'D', 'e', 'F'};

        assert Arrays.equals(alphabetCase, aleterneCaseTP28(alphabet)): "TP28 aleterneCaseTP28Test assertion failed";
        System.out.println("TP28 aleterneCaseTP28Test, assertion ok");

    }





    public static int[] executeMvtTP29(String[] tab){

        final int[] position = {0, 0};

        final String gauche = "gauche", droite = "droite", haut = "haut", bas = "bas";

        for(String elt: tab){
            switch (elt) {
                case gauche -> position[0] -= 1;
                case droite -> position[0] += 1;
                case haut ->   position[1] += 1;
                case bas ->    position[1] -= 1;
                default -> {
                }
                // code block
            }
        }

        return position;
    }


    public static void executeMvtTP29Test(){
        String[] tab = {"haut", "haut", "bas", "gauche", "gauche", "droite", "haut"};


        assert Arrays.equals( executeMvtTP29(tab), new int[]{-1, 2} );
        System.out.println("TP29 executeMvtTP29Test, test ok");



    }






    public static boolean findSameCharTP30(String word){
        boolean res = false;

        for(int i = 0; i<word.length()-1; i++){
            if( word.charAt(i) == word.charAt(i +1)){
                res = true;
                break;
            }
        }
        return res;
    }


    public static void findSameCharTP30Test(){

        String wordTest1 = "terrific";
        String wordTest2 = "chats";
        String wordTest3 = "chats !!";

        assert  findSameCharTP30(wordTest1): "TP30 findSameCharTP30 assertion failed with  terrific" ;
        assert !findSameCharTP30(wordTest1): "TP30 findSameCharTP30 assertion failed with  chats" ;
        assert  findSameCharTP30(wordTest1): "TP30 findSameCharTP30 assertion failed with  chats !!" ;

        System.out.println( "TP30 findSameCharTP30, test ok");
    }




    public static ArrayList<ArrayList<Integer>> splitTabTP31(int[] tab, int morceauSize){

        // maMthode([1, 2, 3, 4], 2) --> [ [ 1, 2] , [3, 4] ]

        int quotient = tab.length / morceauSize;
        int reste    = tab.length % morceauSize;

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int tabIter = 0;

        for(int i =0; i< quotient; i++){
            //int[] temp = new int[morceauSize];

            ArrayList<Integer> temp = new ArrayList<Integer>();


            for(int j=0; j<morceauSize; j++){
                temp.add( tab[tabIter] );
                tabIter++;
            }

            result.add(temp);

        }

        ArrayList<Integer> otherTemp = new ArrayList<Integer>();

        for(int k =0; k<reste; k++){
            otherTemp.add(tab[tabIter]);
            tabIter++;
        }

        result.add(otherTemp);

        System.out.println( result );

        return result;
    }




    public static void splitTabTP31Test(){

        int[] tab = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 };

      splitTabTP31(tab, 3);

      assert true  ;
    }


    public static void displayPath(int n){

        String out = "#";
        for (int i =0; i<n; i++){
            System.out.println(out);

            out += "#";

        }

    }




    public static int[] isSommeTP33(int[] tab, int s){

        int[] res = new int[2];

        for(int i=0; i<tab.length; i++){
            for(int j=i+1; j<tab.length; j++){

                if( tab[i] + tab[j] == s){
                    res[0] = tab[i];
                    res[1] = tab[j];
                    break;
                }
            }
        }

        System.out.println(List.of(res));

        System.out.println( "["  + res[0] + ", " + res[1] + "]");

        return res;

    }


    public static void isSommeTP33Test(){

        int[] tab = new int[]{ 2,7,11,15 };
        int s = 9;

        assert isSommeTP33(tab, s).equals( new int[]{2, 7} );


    }


    public static ArrayList<ArrayList<Integer> > isSommeTP33V2(int[] tab, int s){

       // int[] res = new int[2];
        ArrayList< ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int elt : tab) map.put(s-elt, elt);

        for( var entry : map.entrySet() ){
           if(Objects.equals(map.get(entry.getValue()), entry.getKey())){
               res.add(  new ArrayList<>( List.of ( entry.getKey(),  entry.getValue() )  ) )    ;

           }
        }


        System.out.println(res);

        return res;
    }


    public static void isSommeTP33V2Test(){

        int[] tab1 = new int[]{ 2,7,11,15 };
        int s1 = 9;
        int[] res1 = new int[]{2, 7};


        int[] tab2 = new int[]{3, 2, 4, 7, 5, -1};
        int s2 = 6;
        int[][] res2 = new int[][]{ {2,4}, {7, -1} };


        isSommeTP33V2(tab1, s1);
        isSommeTP33V2(tab2, s2);

      //  assert isSommeTP33(tab, s).equals( new int[]{2, 7} );


    }

}
