package model.listToy;

import model.Datatable;
import model.Service;
import model.toy.Toy;
import model.toy.ToyComporatorByName;

import java.io.*;
import java.util.Collections;

public class ServiceTree implements Service{
    private TreeFamily<Toy> tree;
    private Datatable datatable;

    public void setDatatable(Datatable datatable) {
        this.datatable = datatable;
    }

    public ServiceTree(TreeFamily<Toy> tree) {

        this.tree = tree;
    }

    public TreeFamily<Toy> getTree() {
        return tree;
    }
    @Override
    public void addHuman(String family, String name){
        tree.addHuman(family, name);

    }
    @Override
    public void addMother(int id, String family, String name){
        tree.addMother(id, family, name);

    }

    @Override
    public void addFather(int id, String family, String name){
        tree.addFather(id, family, name);

    }
    @Override
    public void addChild(int id, String family, String name){
        tree.addChild(id, family, name);

    }

    @Override
    public void sortByFamily(){
        //tree.getList().sort();
        Collections.sort(tree.getList());
    }
    @Override
    public void sortByName(){
        tree.getList().sort(new ToyComporatorByName());

    }
    @Override
    public String searchHuman(String family, String name) {

        return tree.getByHuman(family,name);

    }

    public String searchMather(String family, String name) {

        return tree.getByMather(family,name);

    }
    @Override
    public String searchParents(String family, String name){
        return tree.searchParents(family,name);

    }
    @Override
    public String searchChild(String family, String name){
        return tree.searchChild(family,name);

    }
    @Override
    public void clearTree(){

        tree.clearTree();
    }

    @Override
    public String deleteHuman(int id){
        if (tree.deleteHuman(id)){
            return "Человек удален";
        }
        return "Человека с таким id нет в дереве";
    }
    public String save(Datatable datatable){
        if (datatable.save(tree)){
            return "Дерево сохранено в файл";
        }
        else {
            return "Ошибка сохранения";
        }


    }

    public Object read (Datatable datatable) throws IOException {
        tree = (TreeFamily<Toy>) datatable.read();
        return datatable.read();
    }

}



