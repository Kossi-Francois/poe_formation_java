import java.util.ArrayList;
import java.util.Objects;

public class Bibliotheque {

    private String nom;
    private ArrayList<Exemplaire> exemplaires = new ArrayList<Exemplaire>();


    public Bibliotheque(String _nom){
        nom = _nom;

        System.out.printf("La bibliotheque 🏫 %s est ouverte ! \n", _nom);
    }

    public String getNom() { return nom; }



    public int getNbExemplaires(){return exemplaires.size();}



    public void stocker(Oeuvre oeuvre, int n){
        for(int i=0; i<n; i++) exemplaires.add(  new Exemplaire(oeuvre) );
    }


    public void stocker(Oeuvre oeuvre){ stocker( oeuvre, 1); }


    public ArrayList<Exemplaire> listerExemplaires(String langue) {

        if(langue == ""){
            return new ArrayList<Exemplaire>( exemplaires );
        }else{

            ArrayList<Exemplaire> res = new ArrayList<Exemplaire>();

            for(Exemplaire ex: exemplaires){

                if(Objects.equals(ex.getOeuvre().getLangue(), langue)){

                    res.add( new Exemplaire(ex.getOeuvre() ));
                }
            }
            return  res;

        }


    }

    public void listeretAfficherExemplaires(String langue){

        System.out.printf("La bibliotheque %s offre %s: \n", nom, (langue == "" ? "" : "en " + langue));

       for(Exemplaire ex:  listerExemplaires(langue)){
           ex.afficher();
       }

    }


    public int compterExemplaires(Oeuvre oeuvre){
        int nbr = 0;
        for(Exemplaire ex: exemplaires){

            if(ex.getOeuvre().equals(oeuvre)){   //;
                nbr++;
            }
        }

        return nbr;
    }


    public void afficherAuteur(boolean isPrime){

        String primeAuter = "";
        String notPrimeAuter = "";

        for(Exemplaire ex: exemplaires){

           if( ex.getOeuvre().getAuteur().getPrix()) {
               primeAuter += (ex.getOeuvre().getAuteur().getNom() + "; ");
           }else{
               notPrimeAuter += (ex.getOeuvre().getAuteur().getNom() + "; ");
           }
        }


        System.out.printf("Liste des noms d'auteur(s) %s primé(s) -> \n \t %s", (isPrime? "" :"non"),  (isPrime? primeAuter : notPrimeAuter) );
    }



}
