import java.util.ArrayList;
import java.util.Objects;

public class Joueur {

    private int points;
    private final ArrayList<Carte> cardList;

    public Joueur(ArrayList<Carte> list) {
        this.points = 0;
        this.cardList = list;
    }

    public Carte playCard() {
        if(cardList.size() != 0) {
            return cardList.remove(0);
        }
        return null;
    }

    public void addCard(Carte card) {
        cardList.add(card);
    }

    public void addAllCard(ArrayList<Carte> bataille1, ArrayList<Carte> bataille2) {
        for(Carte carte: bataille1) {
            cardList.add(carte);
        }
        for(Carte carte: bataille2) {
            cardList.add(carte);
        }
    }

    public void addPoint() {
        points++;
    }

    public boolean win(int maxPoint) {
        return points == maxPoint ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return points == joueur.points && Objects.equals(cardList, joueur.cardList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, cardList);
    }

    @Override
    public String toString() {
        return "Joueur : \nmain : " + cardList.toString() + "\npoints : " + points;
    }
}
