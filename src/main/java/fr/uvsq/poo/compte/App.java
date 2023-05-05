package fr.uvsq.poo.compte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static final int NOMBRE_DE_JOUEURS = 5;
    public static final int TAILLE_DU_CHIEN = 3;

    public static void main(String[] args) {
        Joueur pedro = new Joueur("Pedro", Joueur.Position.Est);
        Joueur pablo = new Joueur("Pablo", Joueur.Position.Ouest);
        Joueur sandro = new Joueur("Sandro", Joueur.Position.Nord);
        Joueur diego = new Joueur("Diego", Joueur.Position.NordEst);
        Joueur moi = new Joueur("moi", Joueur.Position.Sud);

        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add(pedro); joueurs.add(pablo); joueurs.add(sandro); joueurs.add(moi);

        Table table = new Table(joueurs);

        Paquet paquet = new Paquet();
        System.out.println(paquet);
        paquet.melanger();
        System.out.println(paquet);

        List<Carte> chien = new ArrayList<>();

        int nombreDeCartes= paquet.getPaquet().size();
        System.out.println(nombreDeCartes);
        int nombreDeCartesParJoueur = (nombreDeCartes-TAILLE_DU_CHIEN)/NOMBRE_DE_JOUEURS;
        System.out.println(nombreDeCartesParJoueur);
        for (int i = 0; i < nombreDeCartes; i++) {
            Carte carte = paquet.getPaquet().get(i);
            if (i < nombreDeCartesParJoueur * 1) {
                pedro.getCartes().add(carte);
            } else if (i < nombreDeCartesParJoueur * 2) {
                pablo.getCartes().add(carte);
            } else if (i < nombreDeCartesParJoueur * 3) {
                sandro.getCartes().add(carte);
            } else if (i < nombreDeCartesParJoueur * 4) {
                diego.getCartes().add(carte);
            } else if (i < nombreDeCartesParJoueur * 5) {
                moi.getCartes().add(carte);
            }
            else {
                chien.add(carte);
            }
        }

        pedro.trierCartes();
        pablo.trierCartes();
        sandro.trierCartes();
        diego.trierCartes();
        moi.trierCartes();

        System.out.println(pedro);
        System.out.println(pablo);
        System.out.println(sandro);
        System.out.println(diego);
        System.out.println(moi);

        Collections.sort(chien);
        System.out.println("Chien : " + chien);

    }

}
