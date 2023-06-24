package model.listToy;

import model.Datatable;
import model.Service;
import model.toy.Toy;

import java.io.*;

public class ServiceListToy implements Service{
    private ListToy<Toy> listToy;
    private Datatable datatable;

    public void setDatatable(Datatable datatable) {
        this.datatable = datatable;
    }

    public ServiceListToy(ListToy<Toy> listToy) {

        this.listToy = listToy;
    }
    @Override
    public void addToy(String nameToy, int countToy, int toyDropRate){
        listToy.addToy(nameToy, countToy, toyDropRate);

    }

//    @Override
//    public void sortByName(){
//        listToy.getList().sort(new ToyComporatorByName());
//
//    }
    @Override
    public String searchToy(String nameToy) {

        return listToy.searchToy(nameToy);

    }

    @Override
    public void clearListToy(){

        listToy.clearListToy();
    }

    @Override
    public String deleteToy(int id){
        if (listToy.deleteToy(id)){
            return "Игрушка удалена";
        }
        return "Игрушки с таким id нет в списке";
    }

    @Override
    public ListToy<Toy> getListToy() {
        return listToy;
    }


    public String save(Datatable datatable){
        if (datatable.save(listToy)){
            return "Список игрушек сохранен в файл";
        }
        else {
            return "Ошибка сохранения";
        }


    }

    public Object read (Datatable datatable) throws IOException {
        listToy = (ListToy<Toy>) datatable.read();
        return datatable.read();
    }

}



