package model.toy;

import java.util.Comparator;

public class ToyComporatorByName implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {

        return toy1.getNameToy().compareTo(toy2.getNameToy());
    }
}
