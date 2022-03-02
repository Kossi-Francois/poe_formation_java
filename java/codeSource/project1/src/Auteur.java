public class Auteur {


    private String nom;
    private boolean isPrime;

    public Auteur(String nom, boolean isPrime){
        this.nom = nom;
        this.isPrime = isPrime;
    }

    public String getNom() { return nom; }

    public boolean getPrix () { return isPrime; }
}
