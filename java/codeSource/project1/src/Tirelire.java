public class Tirelire {

    private double montant;

    public Tirelire(double montant){this.montant = montant; }

    public Tirelire(){this(0);}



    public double getMontant(){return montant;}

    public void afficher(){ if(montant == 0){ System.out.println("Vous êtes sans le sou 😢😢😢"); }else{ System.out.printf( "Vous avez :  %f€ dans votre tirelire.\n", montant); } ;
    }


    public void secouer(){ if (montant !=0) System.out.println("Bing bing");  }



    public void remplir(double montant){ if(montant>0) this.montant+= montant ;}


    public void vider(){ this.montant = 0 ;}


    public void puiser(double montant){

        if(montant <= 0){
            return;
        }else{
            this.montant = Math.max(0, this.montant - montant);
        }
    }


    public double calculerSolde(double montant){

        if(montant<=0){
            return this.montant;
        }else {

             double solde = this.montant - montant;

             if(solde >=0){
                 System.out.printf("Vous êtes assez riche $$$$$$ 💰💰💰 pour partir en vacances ! il vous restera %f € euros à la rentrée \n", solde);
             }else {
                 System.out.println("Dommage pas assez de cash $$$$$$ !");
             }

            return solde;
        }
    }

}
