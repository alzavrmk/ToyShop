package model.toy;

import java.util.Comparator;

public class HumanComporatorByName implements Comparator<Toy> {
    @Override
    public int compare(Toy human1, Toy human2) {

        return human1.getName().compareTo(human2.getName());
    }
}
