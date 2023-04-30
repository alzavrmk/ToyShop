package model;

import model.TreeFamily.TreeFamily;
import model.human.Human;
import model.human.HumanComporatorByName;

import java.io.*;
import java.util.Collections;

public class ServiceTree implements Service {
    private TreeFamily<Human> tree;

// Конструктор для создания объекта класса ServiceTree для дерева
    public ServiceTree(TreeFamily<Human> tree) {

        this.tree = tree;
    }

    public TreeFamily<Human> getTree() {
        return tree;
    }
    @Override
    public void addHuman(String family, String name){
       // tree.addHuman(new Human(family, name));
        tree.addHuman(family, name);

    }
    @Override
    public void sortByFamily(){
        //tree.getList().sort();
        Collections.sort(tree.getList());
    }
    @Override
    public void sortByName(){
        tree.getList().sort(new HumanComporatorByName());

    }

    @Override
    public void save(Object object) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("file.txt"));
        objectOutputStream.writeObject(object);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

    }

    @Override
    public Object read() throws ClassNotFoundException, IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("file.txt"));
        Object read = objectInputStream.readObject();
        objectInputStream.close();
        return read;

    }

    public String searchHuman(String family, String name) {

        return tree.getByHuman(family,name);

    }
    public String searchMather(String family, String name) {

        return tree.getByMather(family,name);

    }
    public String searchParents(String family, String name){
        return tree.searchParents(family,name);

    }
    public String searchChild(String family, String name){
        return tree.searchChild(family,name);

    }
    public void clearTree(){
        tree.clearTree();
    }
            ;
}



