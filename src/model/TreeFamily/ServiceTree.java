package model.TreeFamily;

import model.Datatable;
import model.Service;
import model.human.Human;
import model.human.HumanComporatorByName;

import java.io.*;
import java.util.Collections;

public class ServiceTree implements Service{
    private TreeFamily<Human> tree;
    private Datatable datatable;

    public void setDatatable(Datatable datatable) {
        this.datatable = datatable;
    }

    public ServiceTree(TreeFamily<Human> tree) {

        this.tree = tree;
    }

    public TreeFamily<Human> getTree() {
        return tree;
    }
    @Override
    public void addHuman(String family, String name){
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
    public String searchHuman(String family, String name) {

        return tree.getByHuman(family,name);

    }
    @Override
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

    public void save(Datatable datatable) throws IOException {
        datatable.save(tree);
    }

    public Object read (Datatable datatable) throws IOException {
        return datatable.read();
    }

}


