package model.listToy;

import model.toy.Toy;
import model.toy.ToyIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListToy<E extends Toy> implements Iterable<E>, Serializable{//extends Tree <E>
    public List<E> list;
    private int id = 1;


    //Конструктор для создания списка игрушек
    public ListToy(List<E> list) {

        this.list = list;
    }


    //Пустой конструктор
    public ListToy() {

        list = new ArrayList<>();
    }

    //Метод добавления игрушки в список
    public void addToy(String nameToy, int countToy, int toyDropRate) {
        if (nameToy != "") {
            E toy = (E) new Toy(id++, nameToy, countToy, toyDropRate);
            System.out.println(toy);
            if (!list.contains(toy)) {
                list.add(toy);
            }
        }
    }

    public boolean addToy (E toy) {
            if (toy == null) {
                return false;
            }
            if (!list.contains(toy)) {
                list.add(toy);
                return true;
            }
            return false;
        }

    //Возвращает весь список
    public List<E> getList() {

        return list;
    }

    public Toy getByToy (int idToy){
        for (E toy1 : list) {
            if (toy1.getId() == idToy) {
                return toy1;
            }
        }
        return null;
    }
    public String searchToy(String nameToy){
        StringBuilder sb = new StringBuilder();
        E toy = (E) new Toy(nameToy);
        sb.append("Результаты поиска: \n");
        for (E toy1 : list) {
            if (toy1.equals(toy)) {
                sb.append("Игрушка:");
                sb.append(toy1.getNameToy());
                sb.append(".\n");
                sb.append("Количество:");
                sb.append(toy1.getCountToy());
                sb.append(".\n");
                sb.append("Частота выпадения:");
                sb.append(toy1.getToyDropRate());
                sb.append(".\n");
            } else {
                sb.append("игрушка не найдена!");
            }
        }
        return sb.toString();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имеются в наличии игрушки в количестве: ");
        sb.append(list.size());
        sb.append(":\n");
        for (E hum: list){
            sb.append(hum.getInfo());
        }
        return sb.toString();
    }

    public boolean editCountToy(int idToy, int newCount){
        Toy toy1 = getByToy(idToy);
        if (toy1 != null){
            toy1.setCountToy(newCount);
            return true;
        }
        return false;
    }

    public boolean editDropRateToy(int idToy, int newDropRate){
        Toy toy1 = getByToy(idToy);
        if (toy1 != null){
            toy1.setToyDropRate(newDropRate);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    @Override
    public Iterator<E> iterator() {

        return new ToyIterator<E>(list);
    }
    public boolean deleteToy(int idToy){
        Toy toy1 = getByToy(idToy);
        if (toy1 != null){
            list.remove(toy1);
            return true;
        }
        return false;
    }


    public void clearListToy(){

        list.clear();
    }
}
