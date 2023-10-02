package twisk.mondeIG;

import javafx.concurrent.Task;
import twisk.ClientTwisk;
import twisk.exceptions.*;
import twisk.monde.*;
import twisk.outils.*;
import twisk.simulation.Simulation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG> {
    private HashMap<String,EtapeIG> etapeIG = new HashMap<>();
    private HashMap<String,ArcIG> arcs = new HashMap<>();
    private boolean changementDansLeMonde = false;
    private ArrayList<PointDeControleIG> pointDeControleIGSSelectione = new ArrayList<>();
    private HashMap<String,EtapeIG> etapeSelectionee = new HashMap<>();
    private HashMap<String,ArcIG> arcsSelectioner = new HashMap<>();
    private HashMap<String,EtapeIG> entree = new HashMap<>();
    private HashMap<String,EtapeIG> sortie = new HashMap<>();
    private ClassLoaderPerso classLoaderPerso;



    public MondeIG(){
    }

    public void ajouter(String type)
    {
        FabriqueIdentifiant fabrique = FabriqueIdentifiant.getInstance();
        TailleComposants tailleComposants = TailleComposants.getInstance();
        if (type.equals("Activité"))
        {
            EtapeIG e = new ActiviteIG("activite "+fabrique.numActivite(),fabrique.getIdentifiantEtape(),tailleComposants.getLargeurActivite(),tailleComposants.getHauteurActivite());
            etapeIG.put(e.getIdentifiant(),e);
            this.changementDansLeMonde = true ;
            this.notifierObservateur();
        }

        if (type.equals("Guichet"))
        {
            EtapeIG e = new GuichetIG("Guichet "+fabrique.numGuichet(),fabrique.getIdentifiantEtape(),tailleComposants.getLargeurActivite(),tailleComposants.getHauteurActivite());
            etapeIG.put(e.getIdentifiant(),e);
            this.changementDansLeMonde = true ;
            this.notifierObservateur();
        }
    }

    @Override
    public Iterator<EtapeIG> iterator() {
        return etapeIG.values().iterator();
    }

    public int nbrEtapeIG()
    {
        return this.etapeIG.values().size();
    }

    public EtapeIG getEtapeIGKey(String key) { return etapeIG.get(key); }

    public boolean estChangementDansLeMonde() {
        return changementDansLeMonde;
    }

    public void setChangementDansLeMonde(boolean changementDansLeMonde) { this.changementDansLeMonde = changementDansLeMonde; }

    public int nbrArcCreer() { return this.arcs.size(); }

    public void ajouter(PointDeControleIG point) throws TwiskException {
        this.pointDeControleIGSSelectione.add(point);
        if (!estUnPointDeControleIGDuneEtape(getPointDeControleIGSSelectioneIndex(0)) || (nbrPointDeControleIGSSelectione() > 4 && estUnPointDeControleIGDuneEtape(point))){
            this.pointDeControleIGSSelectione.clear();
        }
        if (nbrPointDeControleIGSSelectione() >= 2 && sontLesDeuxPointDeControleIGDuneEtape(getPointDeControleIGSSelectioneIndex(0), getPointDeControleIGSSelectioneIndex(nbrPointDeControleIGSSelectione() - 1))) {
            this.verifierSiLaArcExisteDeja();
            this.creerUnArc();
        }
    }

    public void verifierSiLaArcExisteDeja() throws TwiskException
    {
            PointDeControleIG depart = getPointDeControleIGSSelectioneIndex(0);
            PointDeControleIG arrivee = getPointDeControleIGSSelectioneIndex(nbrPointDeControleIGSSelectione()-1);
            if (depart.getEtapeIG().getIdentifiant().equals(arrivee.getEtapeIG().getIdentifiant()))
            {
                pointDeControleIGSSelectione.clear();
                throw  new AjouterArcsSurLaMemeEtape("on ne peut pas ajouter un arc sur la meme Etape");
            }
            else if (this.estEtapesSontRelier(depart.getEtapeIG(),arrivee.getEtapeIG())){
                pointDeControleIGSSelectione.clear();
                throw  new AjouterArcEntreDeuxEtapeRelierException("on ne peut pas ajouter un au autre arc si les etapes sont deja reliées");
            }
    }


    public  void creerUnArc()
    {
        String idfArc = this.identifiantPointDansEtape(getPointDeControleIGSSelectioneIndex(0)) +"_"+ this.identifiantPointDansEtape(getPointDeControleIGSSelectioneIndex(nbrPointDeControleIGSSelectione() - 1));
        if (this.nbrPointDeControleIGSSelectione() == 2)
            this.arcs.put(idfArc, new LigneDroiteIG(idfArc, getPointDeControleIGSSelectioneIndex(0), getPointDeControleIGSSelectioneIndex(nbrPointDeControleIGSSelectione() - 1)));
        else if (this.nbrPointDeControleIGSSelectione() == 4)
            this.arcs.put(idfArc, new CourbeIG(idfArc, this.pointDeControleIGSSelectione));
        this.setChangementDansLeMonde(true);
        this.notifierObservateur();
        this.setChangementDansLeMonde(false);
        this.pointDeControleIGSSelectione.clear();
        this.ajouterLesSuccesseurAuxEtapeIG();

    }

    public Boolean estEtapesSontRelier(EtapeIG etape1 ,EtapeIG etape2)
    {
        Iterator<ArcIG> ite = this.iteratorArcs();
        while(ite.hasNext())
            { ArcIG arcIG = ite.next();
                if (arcIG.getIdfArcIG().contains(etape1.getIdentifiant()) && arcIG.getIdfArcIG().contains(etape2.getIdentifiant()))
                    return true;
            }
        return false;
    }


    public Iterator<ArcIG>  iteratorArcs()
    {
        return this.arcs.values().iterator();
    }

    public EtapeIG getEtapeIGIndice(String key)
    {
        return this.etapeIG.get(key);
    }


    public Boolean estUnPointDeControleIGDuneEtape(PointDeControleIG point) {
        TailleComposants tailleComposants = TailleComposants.getInstance();
        double rayon =  tailleComposants.getRaduinPointDeControl();
        CalculatriceDeFromuleGeometrique calc = CalculatriceDeFromuleGeometrique.getInstance();
        for (EtapeIG e : this) {
            for (PointDeControleIG p : e) {
                if (calc.calcLongeurLigne(point.getPosCentreX(),p.getPosCentreX(),point.getPosCentreY(),p.getPosCentreY()) <= rayon){
                    point.setEtapeIG(e);
                    point.setPosCentreX(p.getPosCentreX());
                    point.setPosCentreY(p.getPosCentreY());
                    point.setIdfPointCrl(p.getIdfPointCrl());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean sontLesDeuxPointDeControleIGDuneEtape(PointDeControleIG p1, PointDeControleIG p2)
    {
        return estUnPointDeControleIGDuneEtape(p1) && estUnPointDeControleIGDuneEtape(p2);
    }

    public String identifiantPointDansEtape(PointDeControleIG point)
    {
        TailleComposants tailleComposants = TailleComposants.getInstance();
        CalculatriceDeFromuleGeometrique calcul = CalculatriceDeFromuleGeometrique.getInstance();
        int rayon = (int) tailleComposants.getRaduinPointDeControl();
        for (EtapeIG e : this) {
            for (PointDeControleIG p : e) {
                if (calcul.calcLongeurLigne(point.getPosCentreX(),p.getPosCentreX(),point.getPosCentreY(),p.getPosCentreY()) <= rayon)
                    return p.getIdfPointCrl();
            }
        }
        return "";
    }


    public int nbrPointDeControleIGSSelectione()
    {
        return this.pointDeControleIGSSelectione.size();
    }

    public PointDeControleIG getPointDeControleIGSSelectioneIndex(int i)
    {
        return this.pointDeControleIGSSelectione.get(i);
    }

    public void ajouterEtapeSectione(EtapeIG etapeIG)
    {
         this.etapeSelectionee.put(etapeIG.getIdentifiant(),etapeIG);
         this.notifierObservateur();
    }


    public void selectioneOuDesectionEtapeIG(EtapeIG etapeIG)
    {
        etapeIG.setDejaSelectionee(!etapeIG.estSelectionee());
        if(etapeIG.estSelectionee())
            this.ajouterEtapeSectione(etapeIG);
        else
            this.enleverUneEtapeSelectione(etapeIG);
    }

    public void enleverUneEtapeSelectione(EtapeIG etapeIG)
    {
         this.etapeSelectionee.remove(etapeIG.getIdentifiant());
         this.notifierObservateur();
    }



     public void supprimerLesEtapeSelectionerEtArcsAttaches() {
        for (EtapeIG e : etapeSelectionee.values()) {
            Iterator<ArcIG> ite = this.iteratorArcs();
            while(ite.hasNext()) {
                ArcIG a = ite.next();
                if (a.getIdfArcIG().contains(e.getIdentifiant())) {
                    arcs.remove(a.getIdfArcIG());
                    ite = this.iteratorArcs();
                }
            }
            etapeIG.remove(e.getIdentifiant());
        }
        etapeSelectionee.clear();
        pointDeControleIGSSelectione.clear();
        this.setChangementDansLeMonde(true);
        this.notifierObservateur();
        this.setChangementDansLeMonde(false);
        }


        public int nbrEtapesSelectionee()
        {
            return this.etapeSelectionee.size();
        }


        public Iterator<EtapeIG> iteratorEtapeSelectionnee()
        {
            return this.etapeSelectionee.values().iterator();
        }


        public void renommerNomEtapeSelectioner(String str)
        {
            Iterator<EtapeIG> ite = this.iteratorEtapeSelectionnee();
            EtapeIG e = ite.next();
            e.setNom(str);
            this.deselectionerLesEtapeSelctioner();
            this.changementDansLeMonde = true;
            this.notifierObservateur();
            this.changementDansLeMonde = false;
        }

        public ArcIG getArcsIndex(String identifiant) { return this.arcs.get(identifiant); }
        public void deplacerEtape(String identifiant,int x ,int y) {
            TailleComposants taille = TailleComposants.getInstance();
            EtapeIG etapeIG= this.getEtapeIGIndice(identifiant);
            Iterator<ArcIG> ite = this.iteratorArcs();
            this.getEtapeIGIndice(identifiant).depalacerEtape(x - taille.getLargeurActivite() / 2, y - taille.getHauteurActivite() / 2);
            while(ite.hasNext())
            {
                ArcIG arcIG = ite.next();
                if(etapeIG.estArcsRelierAEtapeAvecLePointDepard(arcIG))
                    arcIG.deplacerLePointDeDepartDeArc(etapeIG.pointDeControleDEtapeRelierAArc(arcIG));
                else if(etapeIG.estArcsRelierAEtapeAvecLePointArrivee(arcIG))
                    arcIG.deplacerLePointDArriveeDeArc(etapeIG.pointDeControleDEtapeRelierAArc(arcIG));
            }
            this.changementDansLeMonde = true;
            this.notifierObservateur();
            this.changementDansLeMonde = false;
        }


        public void selectioneOuDesectiondUnArc(ArcIG arcIG)
        {
            arcIG.setEstSelectionner(!arcIG.estSelectionner());
            if (arcIG.estSelectionner)
                this.ajouterArcsSelectioner(arcIG);
            else
                this.enleverArcSelectioner(arcIG);
        }

        public void ajouterArcsSelectioner(ArcIG arcIG)
        {
            this.changementDansLeMonde = true;
            this.arcsSelectioner.put(arcIG.getIdfArcIG(),arcIG);
            this.notifierObservateur();
            this.changementDansLeMonde = false;
        }


        public void enleverArcSelectioner(ArcIG arcIG)
        {
            this.changementDansLeMonde = true;
            this.arcsSelectioner.remove(arcIG.getIdfArcIG(),arcIG);
            this.notifierObservateur();
            this.changementDansLeMonde = false;
        }

        public void supprimerLaListeDesElementsSelectioner()
        {
            this.changementDansLeMonde = true;
            for(ArcIG a : this.arcsSelectioner.values())
            {
                this.arcs.remove(a.getIdfArcIG());
            }
            this.arcsSelectioner.clear();
            this.supprimerLesEtapeSelectionerEtArcsAttaches();
            this.notifierObservateur();
            this.changementDansLeMonde = false ;
        }
        public  int nbrArcsSelectioner() { return  this.arcsSelectioner.size();}

        public void ajouterCommeEntree(EtapeIG etapeIG) { this.entree.put(etapeIG.getIdentifiant(),etapeIG); }

        public void ajouterCommeSortie(EtapeIG etapeIG)
        {
            this.sortie.put(etapeIG.getIdentifiant(),etapeIG);
        }

        public void enleverCommeEntree(EtapeIG etapeIG)
        {
            this.entree.remove(etapeIG.getIdentifiant());
        }

        public void enleverCommeSortie(EtapeIG etapeIG)
        {
            this.sortie.remove(etapeIG.getIdentifiant());
        }

        public void changerLesEntree()
        {
            Iterator<EtapeIG> ite = this.iteratorEtapeSelectionnee();
            EtapeIG etapeIG;
            while(ite.hasNext())
            {
                etapeIG=ite.next();
                if (etapeIG.estUneEntree())
                    this.enleverCommeEntree(etapeIG);
                else
                    this.ajouterCommeEntree(etapeIG);
                etapeIG.setEstUneEntree(!etapeIG.estUneEntree());
            }
            deselectionerLesEtapeSelctioner();
            this.changementDansLeMonde = true;
            this.notifierObservateur();
            this.changementDansLeMonde = false;

        }
        public void changerLesSortie()
        {
            for (EtapeIG etapeIG : etapeSelectionee.values())
            {
                if (etapeIG.estUneSortie())
                    this.enleverCommeSortie(etapeIG);
                else
                    this.ajouterCommeSortie(etapeIG);
                etapeIG.setEstUneSortie(!etapeIG.estUneSortie());
            }
            deselectionerLesEtapeSelctioner();
            this.changementDansLeMonde = true;
            this.notifierObservateur();
            this.changementDansLeMonde = false;
        }

        public void changerLeTempDeLetapeSelectione(String temp) throws TwiskException
        {

            try {
                int resultat = Integer.parseInt(temp);
                if (resultat<1)
                    throw new SaisiIncorrecteTwiskException("Le delai ne doit pas etre inferieur a 1 ");
                Iterator<EtapeIG> ite = iteratorEtapeSelectionnee();
                ite.next().setTemp(resultat);
                deselectionerLesEtapeSelctioner();
                this.changementDansLeMonde = true;
                this.notifierObservateur();
                this.changementDansLeMonde = false;
            }catch(NumberFormatException e)
            {
                throw new SaisiIncorrecteTwiskException("il faut saisir que des chiffre");
            }

        }


        public void changerLeDeltaTempDeLetapeSelectione(String entered) throws TwiskException
        {
            try {
                int resultat = Integer.parseInt(entered);
                if (resultat<1)
                    throw new SaisiIncorrecteTwiskException("L'écart temp ne doit pas etre inferieur a 1");
                Iterator<EtapeIG> ite = iteratorEtapeSelectionnee();
                ite.next().setDeltaTemp(resultat);
                deselectionerLesEtapeSelctioner();
                this.changementDansLeMonde = true;
                this.notifierObservateur();
                this.changementDansLeMonde = false;
            }catch(NumberFormatException e)
            {
                throw new SaisiIncorrecteTwiskException("il faut saisir que des chiffre");
            }
        }
        public void changerNbJetonsDuGuichetSelectione(String entered) throws TwiskException
        {
            try {
                int resultat = Integer.parseInt(entered);
                if (resultat<1)
                    throw new SaisiIncorrecteTwiskException("Le nombre de jetons doit etre >=1");
                Iterator<EtapeIG> ite = iteratorEtapeSelectionnee();
                ite.next().setNbJetons(resultat);
                deselectionerLesEtapeSelctioner();
                this.changementDansLeMonde = true;
                this.notifierObservateur();
                this.changementDansLeMonde = false;
            }catch(NumberFormatException e)
            {
                throw new SaisiIncorrecteTwiskException("il faut saisir que des chiffre");
            }
        }

        public void deselectionerLesEtapeSelctioner()
        {
            Iterator<EtapeIG> ite = iteratorEtapeSelectionnee();
            while (ite.hasNext())
            {
                ite.next().setDejaSelectionee(false);
            }
            this.etapeSelectionee.clear();
        }


        public void ajouterLesSuccesseurAuxEtapeIG(){
            Iterator<ArcIG> ite = this.iteratorArcs();
            while (ite.hasNext()){
                ArcIG arcIG = ite.next();
                int index = arcIG.getPointDepart().getIdfPointCrl().indexOf("-");
                String idfSource = arcIG.getPointDepart().getIdfPointCrl().substring(0,index);
                index = arcIG.getPointArrivee().getIdfPointCrl().indexOf("-");
                String idfDestination = arcIG.getPointArrivee().getIdfPointCrl().substring(0,index);
                this.getEtapeIGIndice(idfSource).ajouterSuccesseur(this.getEtapeIGIndice(idfDestination));
                System.out.println(this.getEtapeIGIndice(idfSource).toString());
            }
        }


        private void verifierMondeIG() throws MondeException {
            if (this.entree.isEmpty())
                throw new MondeException("le monde ne contient pas d'entrer ");
            if (this.sortie.isEmpty())
                throw new MondeException("le monde ne contient pas de sortie ");
            for(EtapeIG etapeIG : this)
            {
                if(etapeIG.nbSuccesseur() == 0 && !etapeIG.estUneSortie())
                    throw new MondeException("<"+etapeIG.getNom()+"> n'est pas reliée a une sortie");
                if(etapeIG.estUneSortie() && etapeIG.nbSuccesseur() >0)
                    throw new MondeException("la sortie <"+etapeIG.getNom()+"> ne doit etre relier avec d'autre activité suivante");
                if (etapeIG.estUnGuichet()){
                    if (etapeIG.estUneSortie)
                        throw new MondeException("le guichet <" + etapeIG.getNom() + "> ne pas etre une sortie");
                    else if (etapeIG.nbSuccesseur() > 1)
                        throw new MondeException("le guichet <" + etapeIG.getNom() + "> ne doit pas   etre reliser plusieur etapes");
                    else if (etapeIG.getSucceesseurIndex(0).estUnGuichet()) {
                        throw new MondeException("le guichet <" + etapeIG.getNom() + "> ne doit pas etre reliser plusieur etapes");
                        }else{
                            etapeIG.getSucceesseurIndex(0).setEstUneActiviteRestreinte(true);
                        }
                }
            }
        }

        private Monde creerMonde(){
            Monde monde = new Monde();
            CorrespondanceEtapes correspondance = new CorrespondanceEtapes();
            //ajouter les etape
            for (EtapeIG etapeIG : this)
            {
                Etape newEtape = null;// pour initialiser !!!!
                if (etapeIG.estUnGuichet())
                    newEtape = new Guichet(etapeIG.getNom(),etapeIG.getNbJetons());
                if (etapeIG.estUneActivite())
                {
                    if (etapeIG.estUneActiviteRestreinte())
                        newEtape = new ActiviteRestreinte(etapeIG.getNom(),etapeIG.getTemp(),etapeIG.getDeltaTemp());
                    else
                        newEtape = new Activite(etapeIG.getNom(),etapeIG.getTemp(),etapeIG.getDeltaTemp());
                }
                monde.ajouter(newEtape);
                if(etapeIG.estUneSortie())
                    monde.aCommeSortie(newEtape);
                if(etapeIG.estUneEntree())
                    monde.aCommeEntree(newEtape);
                correspondance.ajouter(etapeIG,newEtape);
            }
            //ajouter les successeur
            for(EtapeIG etapeIG: this)
            {
                Etape etape = correspondance.get(etapeIG);
                Iterator<EtapeIG> ite = etapeIG.iteratorDesSuccesseurDeEtapeIG();
                while (ite.hasNext())
                {
                    etape.ajouterSuccesseur(correspondance.get(ite.next()));
                }
            }
            return  monde;
        }

        public void simuler()  throws MondeException
        {

            this.verifierMondeIG();
            Monde monde = this.creerMonde();
            System.out.println(monde.toString());
            // utilisation du classLoaderPerso

            //Simulation simul  =new Simulation();
            //simul.setNbClients(1);
            //simul.simuler(monde);

            classLoaderPerso = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
            try {
                Class classSimuler = classLoaderPerso.loadClass("twisk.simulation.Simulation");
                classLoaderPerso = null;
                System.gc();
                Runtime.getRuntime().gc();
                Object objet = classSimuler.newInstance();
                System.out.println(objet.getClass().getName());
                objet.getClass().getMethod("setNbClients", int.class).invoke(objet, 3);
                objet.getClass().getMethod("simuler", Monde.class).invoke(objet, monde);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

}

