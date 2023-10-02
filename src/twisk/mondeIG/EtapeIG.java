package twisk.mondeIG;

import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class EtapeIG implements Iterable<PointDeControleIG>{
    protected String nom ;
    protected String identifiant;
    protected int posX;
    protected int posY;
    protected HashMap<String,PointDeControleIG> pointDeControls =new HashMap<>(4);
    protected boolean dejaSelectionee = false;
    protected boolean estUneSortie = false;
    protected boolean estUneEntree = false;
    //tp10
    //protected HashMap<String,EtapeIG> successeurs = new HashMap<>();
    protected ArrayList<EtapeIG> successeurs = new ArrayList<>();

    public EtapeIG(String nom, String identifiant, int largeur, int hauteur) {
        Random rand = new Random();
        TailleComposants tailleComposants = TailleComposants.getInstance();
        tailleComposants.setSizeActivite(largeur,hauteur);
        this.posX = rand.nextInt(1400);
        this.posY = rand.nextInt(550);
        this.nom = nom;
        this.identifiant = identifiant;
        this.definirPointDeControls();
    }

    public EtapeIG(String nom, String identifiant, int posX, int posY, int largeur, int hauteur) {
        TailleComposants tailleComposants = TailleComposants.getInstance();
        tailleComposants.setSizeActivite(largeur,hauteur);
        this.posX = posX;
        this.posY = posY;
        this.nom = nom;
        this.identifiant = identifiant;
        this.definirPointDeControls();
    }

    public String getIdentifiant(){ return identifiant; }

    public String getNom() {
        return nom;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    public void definirPointDeControls(){
        TailleComposants taille = TailleComposants.getInstance();
        int largeur = taille.getLargeurActivite();
        int hauteur = taille.getHauteurActivite();
        pointDeControls.put(this.identifiant+"-PointCtrlBas",new PointDeControleIG(this.getIdentifiant()+"-PointCtrlBas",this,posX+largeur/2,posY+hauteur));
        pointDeControls.put(this.getIdentifiant()+"-PointCtrlHaut",new PointDeControleIG(this.getIdentifiant()+"-PointCtrlHaut",this,posX+largeur/2,posY));
        pointDeControls.put(this.getIdentifiant()+"-PointCtrlGauche",new PointDeControleIG(this.getIdentifiant()+"-PointCtrlGauche",this,posX,posY+hauteur/2));
        pointDeControls.put(this.getIdentifiant()+"-PointCtrlDroite",new PointDeControleIG(this.getIdentifiant()+"-PointCtrlDroite",this,posX+largeur,posY+hauteur/2));
    }


    @Override
    public Iterator<PointDeControleIG> iterator() {
        return this.pointDeControls.values().iterator();
    }
    public PointDeControleIG getPointDeControlIndice(String key)
    {
        return this.pointDeControls.get(key);
    }

    public boolean estSelectionee() {
        return dejaSelectionee;
    }

    public void setDejaSelectionee(boolean dejaSelectionee) {
        this.dejaSelectionee = dejaSelectionee;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void depalacerEtape(int x ,int y)
    {
        this.posX = x;
        this.posY = y;
        this.pointDeControls.clear();
        this.definirPointDeControls();
    }


    public boolean estArcsRelierAEtape(ArcIG arcIG)
    {
        for(PointDeControleIG point : this)
        {
            if(arcIG.getIdfArcIG().contains(point.getIdfPointCrl()))
            {
                return true;
            }
        }
        return false ;
    }

    public EtapeIG getEtapeIGApartirDunPointDeControle(PointDeControleIG point){
        if ( this.pointDeControls.containsKey(point.getIdfPointCrl()))
            return this;
        return null;
    }

    public PointDeControleIG pointDeControleDEtapeRelierAArc(ArcIG arcIG)
    {
        for(PointDeControleIG point : this)
        {
            if(arcIG.getIdfArcIG().contains(point.getIdfPointCrl()))
            {
                return point;
            }
        }
        return null;
    }

    public boolean estArcsRelierAEtapeAvecLePointDepard(ArcIG arcIG)
    {
        for(PointDeControleIG point : this)
        {
            if(arcIG.getIdfArcIG().substring(0,point.getIdfPointCrl().length()).equals(point.getIdfPointCrl()))
            {
                return true;
            }
        }

        return false ;
    }

    public boolean estArcsRelierAEtapeAvecLePointArrivee(ArcIG arcIG)
    {
        if(estArcsRelierAEtape(arcIG))
            if(!estArcsRelierAEtapeAvecLePointDepard(arcIG))
                return true;
        return false ;
    }

    public boolean estUneSortie() {
        return estUneSortie;
    }

    public void setEstUneSortie(boolean estUneSortie) {
        this.estUneSortie = estUneSortie;
    }

    public boolean estUneEntree() {
        return estUneEntree;
    }

    public boolean estUneActivite(){ return  false ;}
    public boolean estUnGuichet(){ return  false ;}

    public void setEstUneEntree(boolean estUneEntree) {
        this.estUneEntree = estUneEntree;
    }

    public void setTemp(int temp){};
    public void setDeltaTemp(int temp){};

    public int getTemp() {
        return 0;
    }

    public int getDeltaTemp() {
        return 0;
    }

    public int getNbJetons() { return 0; }

    public void setNbJetons(int nbJetons) { }

    //tp10
    public void ajouterSuccesseur(EtapeIG etapeIG){
        if (!this.successeurs.contains(etapeIG))
            this.successeurs.add(etapeIG);
    }

    //tp10
    public int nbSuccesseur() {
        return this.successeurs.size();
    }
    //tp10
    Iterator<EtapeIG> iteratorDesSuccesseurDeEtapeIG() {
        return this.successeurs.iterator();
    }

    public EtapeIG getSucceesseurIndex(int index){ return this.successeurs.get(index);}
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(this.getIdentifiant()+":  ");
        for (EtapeIG e : this.successeurs)
        {
            str.append(" "+e.getIdentifiant()+",");
        }
        str.append("\n");
        return str.toString();
    }

    public boolean estUneActiviteRestreinte(){ return  false; }
    public void setEstUneActiviteRestreinte(boolean bool){ }

}

