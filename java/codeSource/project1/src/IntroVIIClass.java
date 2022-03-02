import java.util.Scanner;

public class IntroVIIClass {

    final private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //testPatient();

       // testTirelire();

        testBibliotheque();

    }


    public static void testPatient(){
        Patient patient = new Patient(63,1.70);
        patient.displayPatientInfo();
    }

    public static void testTirelire(){
        Tirelire tirelire = new Tirelire();

        tirelire.afficher();
        tirelire.afficher();

        tirelire.remplir( 5);
        tirelire.secouer();

        System.out.println("Ajouter un montant dans votre tirelire");
        tirelire.remplir(input.nextDouble() );

        tirelire.afficher();

        tirelire.puiser(20);
        tirelire.afficher();

        System.out.println("Donnez le budget de vos vacances");
        tirelire.calculerSolde( input.nextDouble() );




    }


    public static void testSouris(){
        Souris souris0 = new Souris(50, "blanche", 2, 20);

        Souris souris1 = new Souris(50, "blanche", 2, 20);

    }



    public static void testBibliotheque(){
        Bibliotheque bib = new Bibliotheque("municipale");

        Auteur hugo = new Auteur("Victor Hugo", false);

        bib.stocker(  new Oeuvre("Les Miserables", hugo, "français"), 2 );

        bib.stocker(  new Oeuvre("L’Homme qui rit", hugo, "français"), 1 );



        Auteur alex = new Auteur("Alexandre Dumas", false);
        Oeuvre monteCristo  = new Oeuvre("Le Comte de Monte-Cristo", alex, "français");
        bib.stocker( monteCristo , 3 );



        Auteur ray = new Auteur("Raymond Queneau", true);

        bib.stocker(  new Oeuvre("Zazie dans le metro", ray, "français"), 1 );


        bib.stocker(  new Oeuvre("Le Comte de Monte-Cristo", alex, "anglais"), 1 );

        System.out.println("************tous les exemplaires ***************");
        bib.listeretAfficherExemplaires("");

        System.out.println("************tous les exemplaires en anglais***************");
        bib.listeretAfficherExemplaires("anglais");


        bib.afficherAuteur(true);


        bib.compterExemplaires(monteCristo);


    }

}
