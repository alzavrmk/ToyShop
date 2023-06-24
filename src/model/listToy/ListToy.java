package model.TreeFamily;

import model.toy.Toy;
import model.toy.HumanIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFamily<E extends Toy> implements Iterable<E>, Serializable{//extends Tree <E>
    public List<E> list;
    private int id;


    //Конструктор для создания дерева
    public TreeFamily(List<E> list) {

        this.list = list;
    }


    //Пустой конструктор
    public TreeFamily() {

        list = new ArrayList<>();
    }

    //Метод добавления человека в дерево по имени и фамилии
    public void addHuman(String family, String name) {
        if ((family != "") && (name != "")) {
            E human = (E) new Toy(id++, family, name);
            if (!list.contains(human)) {
                list.add(human);
            }

        }
    }

    public boolean addMother (int idhum, String family, String name) {
        Toy human = getByHuman(idhum);//
        E mother = (E) new Toy(id++, family, name);
        if ((human != null) && human.setMother(mother)){
            list.add(mother);
            mother.addChildrenList(human);
            return true;
        }
        return false;
    }
    public boolean addFather (int idhum, String family, String name) {
        Toy human = getByHuman(idhum);//
        E father = (E) new Toy(id++, family, name);
        if ((human != null) && human.setFather(father)){
            list.add(father);
            father.addChildrenList(human);
            return true;
        }
        return false;
    }
    public boolean addChild (int idhum, String family, String name) {
        Toy human = getByHuman(idhum);//
        E child = (E) new Toy(id++, family, name);
        if ((human != null) && (addHum(child))){
            human.addChildrenList(child);
            child.setMother(human);
            return true;
        }
        return false;
    }

    public void addKid(E kid) {
        for (E hum : list) {
            if (kid.getMother().equals(hum)
                    || kid.getFather().equals(hum)) {
                hum.addChildrenList(kid);
            }
        }
    }


    public boolean addHum (E human) {
            if (human == null) {
                return false;
            }
            if (!list.contains(human)) {
                list.add(human);
                if (human.getFather() != null) {
                    human.getFather().addChildrenList(human);
                }
                if (human.getMother() != null) {
                    human.getMother().addChildrenList(human);
                }
                return true;
            }
            return false;
        }

    //Возвращает дерево
    public List<E> getList() {
        return list;
    }

    public String getByMather(String family, String name) {
        StringBuilder sb = new StringBuilder();
        E human = (E) new Toy(family, name);
        sb.append("Результаты поиска: \n");
        for (E hum : list) {
            if (hum.equals(human)) {
                sb.append(hum.getMotherInfo());
            }
        }
        return sb.toString();
    }

    public String getByHuman (String family, String name){
        StringBuilder sb = new StringBuilder();
        E human = (E) new Toy(family, name);
        sb.append("Результаты поиска: \n");
        if (list.contains(human)) {
            for (E hum : list) {
                if (human.equals(hum)) {
                    sb.append(hum.getInfo());
                }
            }
        }
        else {
            sb.append("Человек не найден!");
        }
        return sb.toString();
    }

    public Toy getByHuman (int id){
        for (E hum : list) {
            if (hum.getId() == id) {
                return hum;
            }
        }
        return null;
    }


    public String searchParents(String family, String name){
        StringBuilder sb = new StringBuilder();
        E human = (E) new Toy(family, name);
        sb.append("Результаты поиска: \n");
        //    if (list.contains(human)) {
        for (E hum : list) {
            if (hum.equals(human)) {
                sb.append(hum.getMotherInfo());
                sb.append("\n");
                sb.append(hum.getFatherInfo());
            }
        }

        return sb.toString();

    }

    public String searchChild(String family, String name){
        StringBuilder sb = new StringBuilder();
        E human = (E) new Toy(family, name);
        sb.append("Результаты поиска: \n");
        //    if (list.contains(human)) {
        for (E hum : list) {
            if (hum.equals(human)) {
                sb.append(hum.getСhildrenList());
            }
        }

        return sb.toString();

    }




    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве объектов - ");
        sb.append(list.size());
        sb.append(":\n");
        for (E hum: list){
            sb.append(hum.getInfo());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
//        return "model.TreeFamily.model.TreeFamily{" +
//                "list=" + list +
//                '}';
        return this.getInfo();
    }

    @Override
    public Iterator<E> iterator() {

        return new HumanIterator<E>(list);
    }
    public boolean deleteHuman(int idhum){
        Toy human = getByHuman(idhum);
        if (human!=null){
            list.remove(human);
            for (E hum : list) {
                if ((hum.getMother()!=null) && (hum.getMother().equals(human))){
                    hum.setMother(null);
                }
                if ((hum.getFather() != null) && (hum.getFather().equals(human))){
                    hum.setFather(null);
                }
                if ((hum.getСhildrenList() != null) && (hum.getChild().contains(human))){
                    hum.getChild().remove(human);
                }
            }
            return true;
        }
        return false;

    }
    public void clearTree(){
        list.clear();
    }
}
