
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Intro {

    public static  void main(String[] args){

        System.out.println("Hello Word");


        //userInfoTp2();

        //ageTP4();

        //Degre3Tp5();

        //tableTP10();

       // factorielleTP11();


        //depreciationTP14();

        //anneDeprecTP15();


        maisonWassefTP16();

    }

    private static void vitesse(double rayon){
        Scanner clavier = new Scanner(System.in);

        System.out.println("Entrez la distance parcourue: ");
        double nombre1 = clavier.nextDouble();
        System.out.println("Entrez le temps de parcours: ");
        double nombre2 = clavier.nextDouble();

        System.out.printf("vitesse = %f / %f = %f m/s", nombre1, nombre2, nombre1/nombre2);
    }



    private static void circleDim(){

        Scanner clavier = new Scanner(System.in);
        double rayon = clavier.nextDouble();
        System.out.printf("Les dimensions du cercle sont:\ndiametre %f\nperimetre = %f \naire= %f", rayon*2, 2*Math.PI*rayon, Math.PI * Math.pow(rayon,2));

    }


    private static void userInfoTp2(){

        Scanner clavier = new Scanner(System.in);
        System.out.println("TP2\nVeuillez saisir vos infos");

        System.out.println("nom:");
        String nom   = clavier.next();
        System.out.println("prenom:");
        String prenom   = clavier.next();
        System.out.println("age:");
        int age   = clavier.nextInt();

        System.out.printf("Vous vous appelez %s %s, et vous avez %d ans", nom, prenom, age);


    }



    private static void permutationTp3(){
        System.out.println("TP2\nVeuillez saisir les 3 valeurs à permuter");

        Scanner clavier = new Scanner(System.in);
        System.out.println("val 1:");
        int a   = clavier.nextInt();
        System.out.println("val 1:");
        int b   = clavier.nextInt();
        System.out.println("val 1:");
        int c   = clavier.nextInt();

        int temp = b;
        b = a;
        a = c;
        c = temp;

    }


    private static void ageTP4(){
        System.out.println("TP4\nVeuillez saisir votre age");

        Scanner clavier = new Scanner(System.in);
        int age   = clavier.nextInt();


        System.out.printf("Votre année de naissance est %d",  Calendar.getInstance().get(Calendar.YEAR) -age);
    }



    private static void Degre3Tp5(){

        System.out.println("TP5\nVeuillez saisir les coefficients du polynome: ((a+b)/2)x^3 + (a+b)²x² + a + b + c");

        Scanner clavier = new Scanner(System.in);
        System.out.println("coef a:");
        double a   = clavier.nextDouble();
        System.out.println("coef b:");
        double b   = clavier.nextDouble();
        System.out.println("coef c:");
        double c   = clavier.nextDouble();

        System.out.println("variable x");
        double x   =  clavier.nextDouble();

        double res = ( (a+b)/2) * Math.pow(x, 3) + Math.pow( (a+b), 2) * Math.pow(x, 2) + a + b + c;

        System.out.printf("La valeur du polynôme est : %f", res);
    }


    private static void Tp6(){
        System.out.println("TP2\nVeuillez saisir les 2 valeurs à permuter");

        Scanner clavier = new Scanner(System.in);
        System.out.println("val 1:");
        int a   = clavier.nextInt();
        System.out.println("val 1:");
        int b   = clavier.nextInt();


        int temp = b;
        b = a;
        a = temp;

    }


    private static void resEqu2Tp8(){

        System.out.println("TP8\nVeuillez saisir les coefficients du polynome: ax² + bx + c = 0");

        Scanner clavier = new Scanner(System.in);
        System.out.println("coef a:");
        double a   = clavier.nextDouble();
        System.out.println("coef b:");
        double b   = clavier.nextDouble();
        System.out.println("coef c:");
        double c   = clavier.nextDouble();


        double delta = Math.pow(b, 2) - 4 * a * c;


        System.out.printf("Resolution du polynome du 2nd degre: %fx² + %fx + %f = 0", a, b, c);

        if(a == 0){
            if(b == 0){
                System.out.println("a = b = 0, Error, pas d'equation");
            }else{
                System.out.printf("Warning !, a = 0 => polynome du premier degre, il existe un unique solution:\nx = %f", (-c)/(b));
            }

        }

        else if(delta > 0){
            System.out.printf("Delta > 0, il existe deux solutions :\nx0 = %f \nx1= %f", (-b - Math.sqrt(delta))/(2*a),  (-b + Math.sqrt(delta))/(2*a));

        }else if(delta == 0){
            System.out.printf("Delta = 0, il existe un unique solution:\nx0 = %f", (-b)/(2*a));

        }else{
            System.out.println("Delta <0,  n'admet pas de solution dans R");
        }


    }

    private static void MoisTp9(){

        Map<String, String> map = new HashMap<>();

    }

    private static void tableTP10(){

        System.out.println("TP10\nVeuillez saisir les valeurs des tables tab1 et tab2");

        Scanner clavier = new Scanner(System.in);
        System.out.println("tab1: ");
        int tab1    = clavier.nextInt();

        System.out.println("tab2: ");
        int tab2    = clavier.nextInt();



        int coef1 = 1;
        int coef2 = 5;

        if(tab2 < tab1){
            System.out.println("Warnin tab2 < tab1; swap ");

            int temp = tab2;
            tab2 = tab1;
            tab1 = temp;
        }

        String out = "";

        for(int i= tab1; i< tab2; i++){

            out+= "Table de " + Integer.toString(i) + "\n";

            for(int j=coef1; j<coef2; j++){

                out+= Integer.toString(j) + " * " + Integer.toString(i) + " = " + Integer.toString(i *j) + "\n";

            }

        }

        System.out.println(out);

    }



    private static void factorielleTP11(){

        System.out.println("TP11\nVeuillez saisir le nombre dont vous voulez la factorielle");

        Scanner clavier = new Scanner(System.in);
        System.out.println("nbr ");
        int nbr    = clavier.nextInt();

        if(nbr == 0) System.out.printf("factorielle de %d = %d", nbr, 1);


        else {

            int res = 1;

            while (nbr !=0){
                res *= nbr;
                nbr--;
            }

            System.out.printf("factorielle de %d = %d", nbr, res);
        }

    }





    private static int recFactorielleTP11( int nbr){



        if (nbr == 0) return 1;
        else{
            return nbr * recFactorielleTP11(nbr -1);
        }
    }



  public static void depreciationTP14(){

      double t0 = 40000;

      int anneeEntree = 2015;
      int anneeArrive = 2024;

      int t = anneeArrive - anneeEntree;

      double taux = 0.07;

      double tr =  t0 * (double) Math.pow((1.0-taux), t);

      System.out.printf("La valeur tr est : %f", tr);


  }


  public static void anneDeprecTP15(){

      // t = log(tr/t0)/log((1-i))


      double t0 = 40000;
      double tr = 5000;

      double anneeEntree = 2015;


      double taux = 0.07;

      double t = Math.log(tr/t0)/Math.log( (1.0-taux))   ;

      System.out.printf("L'année à laquelle la voiture vaudra : %d", (int) (anneeEntree + t));


  }



  public static void maisonWassefTP16(){
        //to = tr/(1+i)^t


      double tr = 225000;


      int anneeEntree = 2002;
      int anneeSortie = 2015;
      double t = anneeSortie - anneeEntree;


      double taux = 0.04;

      double t0 = tr  /  (  Math.pow(  (1.0+taux), t ));

      System.out.printf("Le prix payer en 2002 est  : %f",  t0);

  }


}
