package presenter;

import model.Datatable;
import model.TreeFamily.ServiceData;
import model.TreeFamily.ServiceTree;
import model.TreeFamily.TreeFamily;
import ui.View;

import java.io.IOException;

public class Presenter {
    //создаем методы под каждое действие - добавить человека, добавить родственные связи
    private View view;
    private ServiceTree service;
    private ServiceData data;

    public Presenter(View view, ServiceTree service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        //сообщаем view  с каким презентером она будет работать
    }
    public Presenter(View view, ServiceTree service, ServiceData data) {
        this.view = view;
        this.service = service;
        this.data = data;
        view.setPresenter(this);
        //сообщаем view  с каким презентером она будет работать
    }

    public void addHuman(String family, String name) {
        service.addHuman(family, name);
    }
    public void addMother(int id, String family, String name) {
        service.addMother(id, family, name);

    }
    public void addFather(int id, String family, String name) {
        service.addFather(id, family, name);

    }
    public void addChild(int id, String family, String name) {
        service.addChild(id, family, name);

    }
    public String deleteHuman(int id){

        return service.deleteHuman(id);
    }
    public void clearTree(){

        service.clearTree();
    }

    public TreeFamily getTree(){
        return service.getTree();
    }

    public String searchHuman(String family, String name) {
        return service.searchHuman(family, name);
    }

    public String searchParents(String family, String name) {

        return service.searchParents(family, name);
    }
    public String searchChild(String family, String name) {

        return service.searchChild(family, name);
    }


    public String save(){

        return  service.save(data);

}
    public String printFile(){
        try {
            if (service.read(data) != null) {
                TreeFamily read = (TreeFamily) service.read(data);
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
