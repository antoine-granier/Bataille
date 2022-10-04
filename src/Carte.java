import java.util.Objects;

public class Carte implements Comparable {

    static final String [] cardColor = {"Pique", "Coeur", "Carreau", "Trèfle"};
    private static final int [] cardValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private final String color;
    private final int value;

    public Carte(String color, int value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return value == carte.value && Objects.equals(color, carte.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, value);
    }

    @Override
    public int compareTo(Object o) {
        Carte card = (Carte) o;
        return Integer.compare(value, card.value);
    }

    public String textValue() {
        switch (value) {
            case 14: return "As";
            case 11: return "Valet";
            case 12: return "Dame";
            case 13: return "Roi";
        }
        return String.valueOf(value);
    }

    @Override
    public  String toString() {
        String cardValue = textValue();
        return "Carte : " + cardValue + " " + color;
    }
}
