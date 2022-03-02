public class Exemplaire {

    private Oeuvre oeuvre;


    private void afficherGenerique(String sms){

        System.out.println(sms);
        this.oeuvre.afficher();
        System.out.println("");
    }

    public Exemplaire(Oeuvre oeuvre){
        this.oeuvre = oeuvre;
        afficherGenerique(" Nouvel exemplaire -> ");
    }



    public Exemplaire(Exemplaire exemplaire){
        this.oeuvre = new Oeuvre( exemplaire.getOeuvre() );
        afficherGenerique(" Copie d’un exemplaire de -> ");
    }


    public Oeuvre getOeuvre(){ return oeuvre; }


    public void afficher(){
        afficherGenerique(" Un exemplaire -> ");
    }


}
