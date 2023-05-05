package fr.uvsq.poo.compte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paquet {

    private List<Carte> cartes;

    public Paquet() {
        this.cartes = new ArrayList<>();
        creerPaquet();
    }

    public List<Carte> getPaquet() {
        return cartes;
    }

    public void melanger() {
        Collections.shuffle(this.cartes);
    }

    public void creerCartesSimples() {
        Carte.Valeur[] valeurs = Carte.Valeur.values();

        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            if (couleur != Carte.Couleur.ATOUT && couleur != Carte.Couleur.EXCUSE) {
                for (int i = 1; i < valeurs.length && i < 15; i++) {
                    this.cartes.add(new Carte(couleur, valeurs[i]));
                }
            }
        }
    }

    public void creerAtouts() {
        Carte.Valeur[] valeurs = Carte.Valeur.values();

        for (int i = 1; i < valeurs.length && i < 11; i++) {
            this.cartes.add(new Carte(Carte.Couleur.ATOUT, valeurs[i]));
        }
        for (int i = 15; i < valeurs.length; i++) {
            this.cartes.add(new Carte(Carte.Couleur.ATOUT, valeurs[i]));
        }

    }

    public void creerExcuse() {
        this.cartes.add(new Carte(Carte.Couleur.EXCUSE, Carte.Valeur.O));
    }

    public void creerPaquet() {
        creerCartesSimples();
        creerAtouts();
        creerExcuse();
    }

    @Override
    public String toString() {
        return "Paquet{" + cartes + "}";
    }

}
