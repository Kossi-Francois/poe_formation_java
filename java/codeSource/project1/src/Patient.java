public class Patient {

    private double poids;
    private double taille;

    public Patient(double poids, double taille){
        this.poids = poids;
        this.taille = taille;
    }

    public Patient(){ this(0, 1); }


    public double computeIMC(){return this.poids/Math.pow(this.taille, 2);}

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }


    public void displayPatientInfo(){
        System.out.printf("Patient a un poids << %f kg>> , une taille << %f m>> et donc un IMC de << %f >>", poids, taille, computeIMC());
    }
}
