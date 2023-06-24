package model;

import model.listToy.ListToy;
import model.toy.Toy;

public interface Service {
    ListToy<Toy> getListToy();

    void addToy(String nameToy, int countToy, int toyDropRate);
//    void sortByName();
    public String searchToy(String nameToy);
    public void clearListToy();
    public String deleteToy(int idToy);
}
