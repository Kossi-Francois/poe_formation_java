package partIII;


import java.util.ArrayList;

class OptionVoyage{
    protected String nom;
    protected double prix;

    public OptionVoyage(String _nom, double _prix){
        nom = _nom;
        prix= _prix;
    }

    public String getNom() {
        return nom;
    }

    public double prix() {
        return prix;
    }


    @Override
    public String toString() {
        return "\t" + getNom() + "-->" + prix() + "CHF ";
    }
}



class Sejour extends OptionVoyage{

    protected int nbrNuits;
    protected int prixParNuit;

    public Sejour(String _nom, double _prix,  int _nbrNuits, int _prixParNuit) {
        super(_nom, _prix);

        nbrNuits =  _nbrNuits;
        prixParNuit =  _prixParNuit;
    }

    @Override
    public double prix() {
        return nbrNuits * prixParNuit + prix;
    }

    @Override
    public String toString() {
        String out = super.toString();
        out += "\t||\t Nombre Nuits: " + nbrNuits + "\t||\t Prix par Nuit" +  prixParNuit  + "\n";
        return    out;
    }
}


class Transport extends OptionVoyage{

    public final static double TARIF_LONG  = 1500.0;
    public final static double TARIF_BASE  = 200.0;

    protected boolean isLongTravel = false;


    public Transport(String _nom, double _prix, boolean _isLongTravel) {
        super(_nom, _prix);
        isLongTravel = _isLongTravel;
    }

    @Override
    public double prix() { return (isLongTravel ? TARIF_LONG : TARIF_BASE)  + prix; }

    @Override
    public String toString() {
        String out = super.toString();
        out += "\t||\t Type de Trajet: " + (isLongTravel? "Long" : "Court") + "\n";
        return    out;
    }
}




class KitVoyage {

    protected ArrayList<OptionVoyage >  optionVoyages;
    protected String depart, destination;

    public KitVoyage(String _depart, String _destination){
        optionVoyages = new ArrayList<OptionVoyage >();

        depart = _depart;
        destination = _destination;

    }

    public KitVoyage(String _depart, String _destination, ArrayList<OptionVoyage > _optionVoyages){
        this(_depart,  _destination);
        optionVoyages = (ArrayList<OptionVoyage>) _optionVoyages.clone();
    }




    public double prix(){
        double sum = 0;
        for(OptionVoyage elt : optionVoyages) sum += elt.prix();
        return sum;
    }


    @Override
    public String toString() {
        String out = "Voyage 🚓 ✈ 🚀 🛸 de " + depart + " à "  +destination + "\n";
        for(OptionVoyage elt : optionVoyages) out += elt.toString();
        out += "Prix total : " + prix() + " CHF";

        return  out;
    }


    public void ajouterOption(OptionVoyage unVoyage){ if(unVoyage != null) optionVoyages.add(unVoyage);}

    public void annuler(){ optionVoyages.clear();}

    public int getNbOptions(){return optionVoyages.size();}
}





public class AgenceDeVoyage {

    public static void main(String[] args) {
        testKit();
    }

    public static void testKit(){
        KitVoyage kit = new KitVoyage("Los Angeles", "Las Vegas");

        kit.ajouterOption( new Sejour(   "Sejour0 🗼", 20,  3, 50) );
        kit.ajouterOption( new Transport("Transp0 🛴", 10, false) );

        kit.ajouterOption( new Sejour(   "Sejour1 🌄", 15,  7, 50) );
        kit.ajouterOption( new Transport("Transp1 🏍", 10, true) );


        System.out.println(kit);
        System.out.printf("Nombre total voyage %d", kit.getNbOptions());
    }
}
