package twisk.simulation;

import twisk.monde.Etape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GestionnaireClients implements  Iterable<Client>{
    private HashMap<Integer,Client> clients;

    public GestionnaireClients(){
        this.clients = new HashMap<>();
    }

    public GestionnaireClients(int nbClients){
        this.clients = new HashMap<>(nbClients);
    }

    public void setClients(int... tabClients)
    {
        for(int id : tabClients)
        {
            this.clients.put(id,new Client(id));
        }
    }

    public void reset()
    {
        this.clients.clear();
    }

    public Iterator<Client> iterator()
    {
        return clients.values().iterator();
    }

    public Client getClientsIndex(int id)
    {
        return clients.get(id);
    }

    public void allerA(int numemoClient, Etape etape, int rang)
    {
        this.clients.get(numemoClient).allerA(etape,rang);
    }

}
