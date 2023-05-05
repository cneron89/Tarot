package fr.uvsq.poo.compte;

public class Carte implements Comparable<Carte> {

    public enum Couleur { PIQUE, TREFLE, COEUR, CARREAU, ATOUT, EXCUSE }
    public enum Valeur {
        O(0), I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10),
        VALET(11), CAVALIER(12), DAME(13), ROI(14),
        XI(11), XII(12), XIII(13), XIV(14), XV(15), XVI(16), XVII(17), XVIII(18), XIX(19), XX(20), XXI(21);

        private final int valeur;

        Valeur(int valeur) {
            this.valeur = valeur;
        }
    }

    private final Couleur couleur;
    private final Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "{" + valeur + " " + couleur + "}";
    }

    @Override
    public int compareTo(Carte carte) {
        int comparaisonCouleur = this.couleur.compareTo(carte.couleur);
        if (comparaisonCouleur == 0) {
            return this.valeur.compareTo(carte.valeur);
        }
        return comparaisonCouleur;
    }

    public boolean estUnAtout() {
        return Couleur.ATOUT == this.getCouleur();
    }

    public boolean estUnBout() {
        return (this.couleur == Couleur.EXCUSE || this.estUnAtout() && (this.getValeur() == Valeur.I || this.getValeur() == Valeur.XXI));
    }

}
