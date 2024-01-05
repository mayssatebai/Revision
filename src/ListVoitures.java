import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures(List<Voiture> voitures) {
        this.voitures = new ArrayList<>(voitures);
    }
    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }

    // Méthode pour obtenir la liste de voitures
    public List<Voiture> getVoitures() {
        return voitures;
    }

    // Méthode pour définir la liste de voitures
    public void setVoitures(List<Voiture> voitures) {
        this.voitures = new ArrayList<>(voitures);
    }

    // Méthode pour ajouter une voiture à la liste
    public void ajoutVoiture(Voiture v) throws VoitureException {
        if (!voitures.contains(v)) {
            voitures.add(v);
        } else {
            throw new VoitureException("La voiture existe déjà dans la liste.");
        }
    }

    // Méthode pour supprimer une voiture de la liste
    public void supprimeVoiture(Voiture v) throws VoitureException {
        if (voitures.contains(v)) {
            voitures.remove(v);
        } else {
            throw new VoitureException("La voiture n'existe pas dans la liste.");
        }
    }


    public Iterator<Voiture> iterateur() {
        return voitures.iterator();
    }

    public int size() {
        return voitures.size();
    }


    public void affiche() {
        for (Voiture voiture : voitures) {
            System.out.println(voiture.toString());
        }
    }
}
