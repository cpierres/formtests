package com.cpi.formtests;

import java.util.Random;
import java.util.stream.IntStream;

public class MouseHole {
    private final Random rand = new Random();
    private int mouseRemaining = 10;

    /**
     * Question : pourquoi retourner un IntStream alors qu'on réduit le résultat
     * à une seule valeur (un seul int) ?<br>
     * et même ... pourquoi utiliser un IntStream pour ce calcul ??<br>
     * Sauf erreur de ma part, cela ne sert à rien ...<br>
     * Réponse : getMouses() retourne le nb de souris toujours présentes dans le trou.<br>
     * ceci en réduisant le nb de souris selon selon un nb aléatoire qui correspond à un nb de souris
     * qui sera transmis au chat pour actualiser le compteur des souris attrapées.<br>
     * Ainsi, ce stream permet à l'appelant (House.cleanHouse) de soumettre successivement
     * à Cat.catchMouse(xx) le nb de souris à attraper en transmettant ce retour en paramètre pour
     * cat::catchMouse.
     * @param maxMouses
     * @return nb de souris dans le trou
     */
    public IntStream getMouses(int maxMouses) {
        //generate prend un Supplier pour générer des int
        IntStream intStream = IntStream.generate(() -> {
            if (mouseRemaining == 0) {
                return -1;//veut dire que c un babyMouse qui sera déduit ?
            }
            //on détermine un nb de souris mangées par le chat (nb aléatoire inférieur à 10)
            int nbMousesRandom = rand.nextInt(maxMouses + 1);
            // on garde le plus petit nb entre nbMouseRandom et mouseRemaining
            // (on ne peut pas attraper plus que ce qu'il reste)
            int nbMouse = Math.min(nbMousesRandom, this.mouseRemaining);
            mouseRemaining -= nbMouse;
            System.out.println("    MouseHole.getMouses(maxMouses=" + maxMouses + ") ; nbMousesRandom: " + nbMousesRandom + " ; nbMouse (attrapées): " + nbMouse + " ; mouseRemaining: " + mouseRemaining);
            return nbMouse;
        });
        return intStream;
    }

    public int refill(int babyMouses) {
        mouseRemaining += babyMouses;
        System.out.println("    MouseHole.refill(babyMouses=" + babyMouses + ") ; mouseRemaining=" + mouseRemaining);
        return mouseRemaining;
    }
}