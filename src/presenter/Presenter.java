package presenter;

import model.ServiceTree;
import model.TreeFamily.TreeFamily;
import model.human.Human;
import ui.View;

public class Presenter {
    //создаем методы под каждое действие - добавить человека, добавить родственные связи
    private View view;
    private ServiceTree service;

    public Presenter(View view, ServiceTree service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        //сообщаем view  с каким презентером она будет работать
    }
//    public void addName(String name) {
//        String answerName = service.getName(name);
//        view.print(answerName);
//
//    }
//
//    public void addFamily(String family) {
//        String answerFamily = service1.getName(family);
//        view.print(answerFamily);
//    }

    public void addHuman(String family, String name) {

        service.addHuman(family, name);
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

    public String searchMather(String family, String name) {
        return service.searchMather(family, name);
    }
    public String searchParents(String family, String name) {
        return service.searchParents(family, name);
    }
    public String searchChild(String family, String name) {
        return service.searchChild(family, name);
    }
//    public Hu getTree(){
//        return service.getTree();
//    }

    //передаем в модель данные от презентера
}
