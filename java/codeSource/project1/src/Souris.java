public class Souris {

    final public static int ESPERANCE_VIE_DEFAUT = 36;

    private double poids;
    private String couleur;
    private int age;
    private int esperanceVie ;
    private boolean clonee;

    public Souris(double poids, String couleur, int age, int esperanceVie){
        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        this.esperanceVie = esperanceVie;

    }


    public Souris(double poids, String couleur, int age){

        this(poids, couleur,  age,  ESPERANCE_VIE_DEFAUT);
    }




    public Souris(Souris oldSouris){

        this.poids = oldSouris.getPoids();
        this.couleur = oldSouris.getCouleur();
        this.age = oldSouris.getAge();
        this.esperanceVie = oldSouris.esperanceVie * 4/5;

    }


    public String toString(){return "Une souris " +couleur+  (clonee ? "[clonée]" : "" )  +"de" +age+ "mois et pesant <poids> grammes";
    }


    public void vieillir(){
        age++;
        if(clonee && age>=esperanceVie/2) couleur = "verte";
    }


    public void evolue(){
        age = esperanceVie;
        couleur = "verte";
    }


    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEsperanceVie() {
        return esperanceVie;
    }

    public void setEsperanceVie(int esperanceVie) {
        this.esperanceVie = esperanceVie;
    }
}
