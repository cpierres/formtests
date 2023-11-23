package com.cpi.formtests;

public class House {
    private final MouseHole mouseHole;

    public House(MouseHole mouseHole) {
        System.out.println("Création d'une maison avec un trou de souris");
        this.mouseHole = mouseHole;
    }

    /**
     * Pour nettoyer la maison ayant un trou de souris, on y met
     * un chat.
     * Dans ce trou de souris, on considère qu'on peut avoir 10 souris.
     *
     * @return
     */
    public int cleanHouse() {
        System.out.println("House.cleanHouse()");
        var cat = new Cat("Minnie");
        // ce test veut dire que geMouses() (nb de souris de départ) est fixé à 10
        // getMouses(x) retourne un intStream (flux) donnant le nb de souris à un instant t
        // pour lequel on se limite à 3 passages de chat (après chaque catchMouse, le nb de souris
        // diminue).
        // Le forEach permet de transmettre la valeur de chaque passage de IntStream
        // (souris restantes) à l'argument de catchMouse(nbSouris) pour l'instance du chat
        // lequel totalise les souris attrapées à chaque passage
        mouseHole.getMouses(10).limit(3).forEach(cat::catchMouse);
        //sachant qu'on considère que les souris faisant des bébés tout le temps et qu'il
        //faut un mâle et une femelle (donc division par 2), on considère que chaque couple a eu le temps
        //de faire un bébé avant de se faire attraper !
        mouseHole.refill(cat.getEatenMouseTotal() / 2);
        return cat.getEatenMouseTotal();
    }
}
