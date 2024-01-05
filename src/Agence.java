import java.util.*;

public class Agence {
    private String nom;
    private ListVoitures vs;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.vs = new ListVoitures();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void ajoutVoiture(Voiture v) throws VoitureException {
        vs.ajoutVoiture(v);
    }

    public void suppVoiture(Voiture v) throws VoitureException {
        vs.supprimeVoiture(v);
        for (ListVoitures listeVoitures : clientVoitureLoue.values()) {
            listeVoitures.supprimeVoiture(v);
        }
    }

    public void loueClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (!clientVoitureLoue.containsKey(cl)) {
            clientVoitureLoue.put(cl, new ListVoitures());
        }
        clientVoitureLoue.get(cl).ajoutVoiture(v);
    }

    public void retourClientVoiture(Client cl, Voiture v) throws VoitureException {
        if (clientVoitureLoue.containsKey(cl)) {
            clientVoitureLoue.get(cl).supprimeVoiture(v);
        } else {
            throw new VoitureException("Le client n'a pas de voiture en location.");
        }
    }

    public List<Voiture> selectVoitureSelonCritere(Critere c) {
        List<Voiture> result = new ArrayList<>();
        for (Voiture v : vs.getVoitures()) {
            if (c.estSatisfaitPar(v)) {
                result.add(v);
            }
        }
        return result;
    }

    public Set<Client> ensembleClientsLoueurs() {
        return clientVoitureLoue.keySet();
    }

    public Collection<ListVoitures> collectionVoituresLouees() {
        return clientVoitureLoue.values();
    }

    public void afficheLesClientsEtLeursListesVoitures() {
        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            Client client = entry.getKey();
            ListVoitures listeVoitures = entry.getValue();
            System.out.println(client.getNom() + " " + client.getPrenom() + " (" + client.getCode() + "): " + listeVoitures.getVoitures());
        }
    }

    public Map<Client, ListVoitures> triCodeCroissant() {
        return new TreeMap<>(clientVoitureLoue);
    }

    public Map<Client, ListVoitures> triNomCroissant() {
        Map<Client, ListVoitures> sortedMap = new TreeMap<>(Comparator.comparing(Client::getNom));
        sortedMap.putAll(clientVoitureLoue);
        return sortedMap;
    }

}
