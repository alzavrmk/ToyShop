package presenter;

import model.listToy.ListToy;
import model.listToy.ServiceData;
import model.listToy.ServiceListToy;
import ui.View;

import java.io.IOException;

public class Presenter {
    //создаем методы под каждое действие
    private View view;
    private ServiceListToy service;
    private ServiceData data;

    public Presenter(View view, ServiceListToy service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        //сообщаем view  с каким презентером она будет работать
    }
    public Presenter(View view, ServiceListToy service, ServiceData data) {
        this.view = view;
        this.service = service;
        this.data = data;
        view.setPresenter(this);
        //сообщаем view  с каким презентером она будет работать
    }

    public void addToy(String nameToy, int countToy, int toyDropRate) {
        service.addToy(nameToy, countToy, toyDropRate);
    }

    public String deleteToy(int id){

        return service.deleteToy(id);
    }
    public void clearListToy(){

        service.clearListToy();
    }

    public ListToy getListToy(){

        return service.getListToy();
    }

    public String searchToy(String nameToy) {

        return service.searchToy(nameToy);
    }


    public String save(){

        return  service.save(data);

}
    public String printFile(){
        try {
            if (service.read(data) != null) {
                ListToy read = (ListToy) service.read(data);
                return read.toString();
            }
            return "Файл пуст";

        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return "Ошибка печати данных из файла";

        }

    }

}
