import java.util.ArrayList;
import java.util.Collections;

public class Bataille {

    public static void main(String[] args) {

        String [] cardColor = {"Pique", "Coeur", "Carreau", "Trèfle"};
        ArrayList<Carte> cardList = new ArrayList<Carte>();

        for(int i = 0; i < cardColor.length; i++) {
            for(int j = 1; j < 14; j++) {
                cardList.add(new Carte(cardColor[i], j));
            }
        }
        Collections.shuffle(cardList);

        ArrayList<Carte> list1 = new ArrayList<Carte>(cardList.subList(0, cardList.size()/2));
        ArrayList<Carte> list2 = new ArrayList<Carte>(cardList.subList(cardList.size()/2, cardList.size()));
        ArrayList<Carte> bataille1 = new ArrayList<Carte>();
        ArrayList<Carte> bataille2 = new ArrayList<Carte>();

        Joueur j1 = new Joueur(list1);
        Joueur j2 = new Joueur(list2);

        while(!j1.win() && !j2.win()) {
            Carte c1 = j1.playCard();
            Carte c2 = j2.playCard();
            int i = c1.compareTo(c2);
            if(i > 0) {
                j1.addCard(c1);
                j1.addCard(c2);
                j1.addPoint();
                System.out.println("Joueur 1 gagne la manche ! " + "(Joueur 1 joue " + c1.toString() + " | Joueur 2 joue " + c2.toString());
            } else if(i < 0) {
                j2.addCard(c1);
                j2.addCard(c2);
                j2.addPoint();
                System.out.println("Joueur 2 gagne la manche ! " + "(Joueur 1 joue " + c1.toString() + " | Joueur 2 joue " + c2.toString());
            } else {
                //j1.addCard(c1);
                //j2.addCard(c2);
                bataille1.add(c1);
                bataille2.add(c2);
                bataille1.add(j1.playCard());
                bataille2.add(j2.playCard());
                int j = bataille1.get(bataille1.size()-1).compareTo(bataille2.get(bataille2.size()-1));
                while (j == 0) {
                    bataille1.add(j1.playCard());
                    bataille2.add(j2.playCard());
                    j = bataille1.get(bataille1.size()-1).compareTo(bataille2.get(bataille2.size()-1));
                }
                if(j > 0) {
                    System.out.println("Joueur 1 gagne la manche ! " + "(Joueur 1 joue " + bataille1.get(bataille1.size()-1).toString() + " | Joueur 2 joue " + bataille2.get(bataille2.size()-1).toString());
                    j1.addAllCard(bataille1, bataille2);
                } else {
                    System.out.println("Joueur 2 gagne la manche ! " + "(Joueur 1 joue " + bataille1.get(bataille1.size()-1).toString() + " | Joueur 2 joue " + bataille2.get(bataille2.size()-1).toString());
                    j2.addAllCard(bataille1, bataille2);
                }
                //System.out.println("Egalité");
            }
        }
        if(j2.win()) {
            System.out.println("Joueur 2 a gagné !\nj1 : " + j1.toString() + "\nj2 : " + j2.toString());
        } else {
            System.out.println("Joueur 1 a gagné !\nj1 : " + j1.toString() + "\nj2 : " + j2.toString());
        }
    }
}