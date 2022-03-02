package partII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Personne {

    protected String nom;
    protected String anneeArrivee;

    public Personne(String _nom, String _anneeArrivee){
        nom = _nom;
        anneeArrivee = _anneeArrivee;
    }

    /* public void afficher(){
         System.out.printf("Cette personne s'appelle %s", nom);
     }

     */

    public abstract void afficher();

}


class Personnel extends Personne{

    protected double salaire;
    protected String labName;

    protected final static int AGE_RETRAITE = 50;

    public Personnel(String _nom, String _anneeArrivee, String _labName, double _salaire) {
        super(_nom, _anneeArrivee);

        labName = _labName;
        salaire = _salaire;
    }





    public void afficher(String personnelType){
        System.out.printf("\t *** Description de %s *** \n \t\tNom:\t%s  \n   \t\tAnnée:\t%s  \t\tLabo:\t%s Salaire: %f €/mois",personnelType, nom, anneeArrivee, labName, salaire);
    }

    @Override
    public void afficher(){afficher(""); };

}



class Secrétaire extends Personnel{

    public Secrétaire(String _nom, String _anneeArrivee, String _labName, double _salaire) {
        super(_nom, _anneeArrivee,  _labName, _salaire);
    }


    public void afficher(){

        super.afficher("La secretaire ");
        System.out.println("");
    }

}




class Enseignant extends Personnel{

    protected String teachingSection;


    public Enseignant(String _nom,String _anneeArrivee, String _labName, String _teachingSection, double _salaire) {
        super(_nom, _anneeArrivee,  _labName , _salaire);

        teachingSection = _teachingSection;

    }


    public void afficher(){


        super.afficher("L'enseigant ");
        System.out.printf("Section d'enseignement : %s \n", teachingSection);

    }
}



class Etudiant extends Personne{
    private String studyingSection;

    public Etudiant(String _nom, String _anneeArrivee, String _studyingSection) {
        super(_nom, _anneeArrivee);

        studyingSection = _studyingSection;
    }


     public void afficher(String etudiantType){
         System.out.printf( "\t *** Description de l'etudiant %s *** \n     \t\tNom:\t%s  \n   \t\tAnnée:\t%s \n \t\tSection:\t%s \n", etudiantType, this.nom, this.anneeArrivee, this.studyingSection);
    }

    @Override
    public void afficher(){

        afficher("");
    }

}


class EtudiantExc extends Etudiant{

     private String origineUniversity;

    public EtudiantExc(String _nom, String _anneeArrivee, String _studyingSection, String _origineUniversity) {
        super(_nom, _anneeArrivee, _studyingSection);

        origineUniversity = _origineUniversity;
    }

    public void afficher(){
        super.afficher("d’échange " );
        System.out.printf("\t\tUniversité d'origine: %s \n",  origineUniversity);
    }


}


class EtdudiantStatic extends Etudiant{

     private double notMoy;

    public EtdudiantStatic(String _nom, String _anneeArrivee, String _studyingSection, double _notMoy) {
        super(_nom, _anneeArrivee, _studyingSection);
        notMoy =_notMoy;
    }

    public void afficher(){
        super.afficher("régulier" );
        System.out.printf("\t\tMoyenne: %f  \n",  notMoy);
    }
}



public class GestionPersonne{

    public static void main(String[] args) {
        testPersonnel();
    }


    public static void testPersonnel(){



        EtdudiantStatic etud0 = new EtdudiantStatic( "Nicolas TOUBOUL",  "2019", "Computer Science", 18.5);
        EtdudiantStatic etud1 = new EtdudiantStatic( "Salma HISTANE",  "2018", "Philosométrie ", 18.5);

        EtudiantExc etud2 = new EtudiantExc( "Salma HISTANE",  "2018", "Philosométrie ", "Tambuktu");



        etud0.afficher();
        etud1.afficher();
        etud2.afficher();


        Enseignant enseig0 = new Enseignant( "Djiby BALDE",  "2012", "des Mathématiques Extrêmement Pure(LMEP)", "Astrophysique", 20000);


        Secrétaire secret0 = new Secrétaire ("Christiane LISANGOLIANNE", "2017", "de Chimie", 5000);

        enseig0.afficher();
        secret0.afficher();

        ArrayList<Personne> personnes = new ArrayList<Personne>( Arrays.asList(etud0, etud1, etud2, enseig0, secret0) );

        int nbrEtud = 0;
        for(Personne aPersonne: personnes){
            if (aPersonne instanceof Etudiant) nbrEtud++;
        }
        System.out.printf("Nombre d'étudiants à CLBIT : %d", nbrEtud);


    }

}