package twisk.outils;

import javafx.concurrent.Task;

import java.util.ArrayList;

public class GestionnaireThreads {
    private ArrayList<Thread> lesThread = new ArrayList<>();
    private static GestionnaireThreads instance = new GestionnaireThreads();
    private GestionnaireThreads() { }

    public static GestionnaireThreads getInstance() {
        return instance;
    }

    public void lancer(Task task)
    {
        Thread newThread = new Thread(task);
        this.lesThread.add(newThread);
        newThread.start();
    }

    public void detruireTout(){
        for (Thread thread : lesThread)
            thread.interrupt();
    }


}
