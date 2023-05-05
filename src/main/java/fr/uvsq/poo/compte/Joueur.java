package fr.uvsq.poo.compte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur {

    enum Position { Ouest, Est, Nord, Sud, NordEst }

    private final String name;
    private List<Carte> cartes = new ArrayList<>();
    private final Position position;

    public Joueur(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    @Override
    public String toString() {
        return name + " " + position + " " + nombreDeBouts() + " bouts" + cartes;
    }

    public void trierCartes() {
        Collections.sort(cartes);
    }

    public int nombreDeBouts() {
        int compteur = 0;
        for(Carte carte : cartes) {
            if(carte.estUnBout()) {
                compteur++;
            }
        }
        return compteur;
    }

    public void poserCarte(Carte carte) {
        cartes.remove(carte);
    }

}
