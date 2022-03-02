package partIV;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

abstract class Produit{

    protected String nom;
    protected double prixBase;


    public String getNom() {
        return nom;
    }

    public Produit(String _nom, double _prixBase){
        nom = _nom;
        prixBase = _prixBase;
    }

    public double calculerPrix(){
        return prixBase;
    }


    public void afficherProduit(){
        System.out.printf("Nom : %s || Prix: %f \n", getNom(), calculerPrix());
    }

}




class Accessoire extends Produit{

    final static String bracelet = "bracelet";
    final static String fermoir =  "fermoir";
    final static String boitier =  "boitier";
    final static String vitre =    "vitre";



    static enum TypeAcces {
        Bracelet,
        Fermoir,
        Boitier,
        Vitre
    }


    TypeAcces typeAccessoir ;

    public Accessoire(String _nom, double _prixBase, TypeAcces _typeAccessoir ) {
        super(_nom, _prixBase);

        typeAccessoir = _typeAccessoir;

    }

    @Override
    public String getNom() {
        return  typeAccessoir + " " + nom ;
    }


    @Override
    public void afficherProduit() {
        System.out.print("Accessoire --> \t");
        super.afficherProduit();
    }


}










class Mecanisme extends Produit{

    protected boolean mecanismeType;

    enum TypeMeca{
        Analogique,
        Digital,
        Double,
    }

    TypeMeca typeMeca;

    public Mecanisme(String _nom, double _prixBase, TypeMeca _typeMeca) {

        super(_nom, _prixBase);
         typeMeca = _typeMeca;
    }


    public String getCurrenTime(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }


    public void  affichageCadran(){
        System.out.printf("Heure --> %s\n", getCurrenTime());
    }

    @Override
    public String getNom() {
        return  typeMeca + " " + nom ;
    }


    @Override
    public void afficherProduit() {
        System.out.print("Mecanisme --> \t");
        super.afficherProduit();
    }


}


interface IMeca{

    default void  affichageCadran(String name){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.printf("%s --> %s \n", name, dateFormat.format(cal.getTime()));
    };


}


interface IanalogMeca extends IMeca{

    //date
    default void  affichageCadranAnalog(){
        affichageCadran("Heure ");
    };

}

interface IdigitalMeca extends IMeca{

    //heure reveil
    default void  affichageCadranDigital(){
        affichageCadran("Heure de Reveil ");
    };
}




class AnalogiqueMeca extends Mecanisme implements  IanalogMeca{

    public AnalogiqueMeca(String _nom, double _prixBase) {
        super(_nom, _prixBase, TypeMeca.Analogique);
    }



    @Override
    public void  affichageCadran(){
        super.affichageCadran();
        IanalogMeca.super.affichageCadranAnalog();
    }

}


class DigitalMeca extends Mecanisme implements IdigitalMeca{

    public DigitalMeca(String _nom, double _prixBase) {
        super(_nom, _prixBase, TypeMeca.Digital);
    }



    @Override
    public void  affichageCadran(){
        super.affichageCadran();
        IdigitalMeca.super.affichageCadranDigital();
    }
}




class DoubleMeca extends Mecanisme implements IdigitalMeca, IanalogMeca{

    public DoubleMeca(String _nom, double _prixBase ) {
        super(_nom, _prixBase, TypeMeca.Double);
    }


    @Override
    public void  affichageCadran(){

        super.affichageCadran();
        IanalogMeca.super.affichageCadranAnalog();
        IdigitalMeca.super.affichageCadranDigital();
    }


}












class Montre extends Produit{

    Accessoire bracelet;
    Accessoire fermoir;
    Accessoire boitier;
    Accessoire vitre;
    Mecanisme  mecanisme;

    UiMontre ui = new UiMontre();

    public Montre(String _nom, double _prixBase, Accessoire _bracelet, Accessoire _fermoir, Accessoire _boitier, Accessoire _vitre, Mecanisme  _mecanisme) {

        super(_nom, _prixBase);

        assert _bracelet.typeAccessoir == Accessoire.TypeAcces.Bracelet;

        bracelet = _bracelet;
        fermoir = _fermoir;
        boitier = _boitier;
        vitre = _vitre;
        mecanisme=  _mecanisme;

    }

    @Override
    public double calculerPrix(){

        return prixBase  + bracelet.calculerPrix() + fermoir.calculerPrix()
                + boitier.calculerPrix() + vitre.calculerPrix() + mecanisme.calculerPrix();
    }

    public void afficheMontreAvecAcces() {
            afficherProduit();
            bracelet.afficherProduit();
            fermoir.afficherProduit();
            boitier.afficherProduit();
            vitre.afficherProduit();
            mecanisme.afficherProduit();
    }



    @Override
    public String toString() {
        return "Montre{" +
                "bracelet=" + bracelet +
                ", fermoir=" + fermoir +
                ", boitier=" + boitier +
                ", vitre=" + vitre +
                ", mecanisme=" + mecanisme +
                '}';
    }

    @Override
    public void afficherProduit() {
        System.out.print("Montre  --> \t");
        super.afficherProduit();
    }

    public void afficherCadran(){
        mecanisme.affichageCadran();
    }

    public void afficherCadranUi(){
        ui.buildNewMontre();
    }
}









public class Horlogerie {

    public static void main(String[] args) {

        testMontre();
    }


    public static void testMontre(){
       // Mecanisme mec = new Mecanisme("nom", 10, Mecanisme.TypeMeca.Double);
        Mecanisme mec = new DigitalMeca("meca", 10);

        Accessoire bracelet = new Accessoire("cuir", 15, Accessoire.TypeAcces.Bracelet );
        Accessoire fermoir = new Accessoire("vv", 15, Accessoire.TypeAcces.Fermoir );
        Accessoire boitier = new Accessoire("String _nom", 15, Accessoire.TypeAcces.Boitier );
        Accessoire vitre  = new Accessoire("String _nom", 15, Accessoire.TypeAcces.Vitre );



        Montre montre = new Montre("GG", 5, bracelet, fermoir, boitier, vitre, mec);

       // montre.afficheMontreAvecAcces();
       // montre.afficherCadran();
        montre.afficherCadranUi();
    }
}







class UiMontre{

    public static int longBracelet = 50;
    public static int largBracelet = 1;

    public static int longCadran = 20;
    public static int largCadran = 5;



    public static String[][] montreUI;
    public static String[][] cadranUI;

    public static String braceletElt = "-";
    public static String cadranElt = "-";
    public static String separateur = "|";
    public static String space = " ";
    public static String trou = "0";


    public static void buildNewMontre(){
        initArray();
        buildNewBracelet();
        buildNewCadran();
        addCadran2Montre();

        String out = array2StringMontre();
        System.out.println(out);
        testDynamisme();
    }

    public static int nbrCol(){return 2*longBracelet + longCadran + 2; }

    public static void initArray(){
        montreUI = new String[largCadran][nbrCol()];
        cadranUI = new String[largCadran][longCadran];
    }

    public static void buildNewBracelet(){

        //cadran
        for(int i = longBracelet; i < longBracelet + longCadran; i++){
            montreUI[0][i] = cadranElt;
            montreUI[largCadran-1][i] = cadranElt;
        }



        //bracelet
        int indexCentre = largCadran/2;

        for(int j= 0; j<nbrCol(); j++){

            montreUI[indexCentre + largBracelet][j] = braceletElt;
            montreUI[indexCentre - largBracelet][j] = braceletElt;

            if(j>1 && j<=10) montreUI[indexCentre][j] = braceletElt;
            if(j>= longBracelet + longCadran +1 ) montreUI[indexCentre][j] = (j%3 == 0)? trou: space;
        }
        

        //bracelet border
        montreUI[indexCentre + largBracelet][0] = "";
        montreUI[indexCentre][0] = "";
        montreUI[indexCentre - largBracelet][0] = "";


        //cadran border
        for(int k = 0; k<largCadran; k++){
            montreUI[k][longBracelet] = separateur;
            montreUI[k][longBracelet + longCadran  -1] = separateur;
        }



    }

    public static void buildNewCadran(){

    }


    public static void addCadran2Montre(){


        for(int i = 1; i< largCadran -1; i++){
            for (int j = 1; j<longCadran-1; j++ ){

                montreUI[i][longBracelet + j ] = cadranUI[i][j];

            }


        }
    }


    public static String array2StringMontre(){
        String out = "";

        for(int i = 0; i<largCadran; i++){
            for(int j= 0; j<nbrCol(); j++){
                out += (montreUI[i][j] != null) ? montreUI[i][j] : " ";
            }
            out += "\n";
        }
        return out;
    }





    public static void testDynamisme(){
        boolean pause =true;
        int nbrSecond = 15;
        int i = 0;

        String[] out = new String[]{"|", "/" , "--",  "\\"}; // "|", "/", "--", "\\", "|"};

        while (pause && i< nbrSecond) {
            try {
                System.out.print(out[(i+4)%4]);
                Thread.currentThread().sleep(600);
                System.out.flush();
                Runtime.getRuntime().exec("cls");
                Runtime.getRuntime().exec("clear");
                clrscr();

            } catch (Exception e) {}

            i++;
        }
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }


    public String buildMontre(){
        String out = "\t\t                                     |-----T---------------T-----|\n" +
                "  |-------------------------------------------|                           |-----------------------------------------|\n" +
                "   ---------|                                 |                           | 0    0    0    0    0    0    0    0    0  |\n" +
                "  |-------------------------------------------|                           |-----------------------------------------|\n" +
                "                                              |---------------------------|\n";

        return out;
    }
}
