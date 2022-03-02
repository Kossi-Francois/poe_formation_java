import java.util.Objects;

public class Oeuvre {

    private String titre;
    final private Auteur auteur;
    private String langue ;


    public Oeuvre(String titre,  Auteur auteur, String langue) {
        this.titre = titre;
        this.auteur = auteur;
        this.langue = langue;

    }

    public Oeuvre(String titre,  Auteur auteur) { this(titre,  auteur, "francais");}


    public Oeuvre(Oeuvre oeuvre){
        this.titre = oeuvre.titre;
        this.auteur = oeuvre.auteur;
        this.langue = oeuvre.langue;
    }


    public void afficher(){

        System.out.println("*** Description de l'oeuvre 📗📘📚📃📜 ***");
        System.out.printf("\t           titre: \t %s \n", titre);
        System.out.printf("\t nom de l'auteur: \t %s \n", auteur.getNom());
        System.out.printf("\t          langue: \t %s \n", langue);


    }


    public boolean equals(Oeuvre _oeuvre){

        return (Objects.equals(titre, _oeuvre.getTitre())) && (auteur == _oeuvre.getAuteur()) && (Objects.equals(langue, _oeuvre.getLangue()));
    }


    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public String getLangue() {
        return langue;
    }
}
