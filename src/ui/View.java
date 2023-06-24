package ui;

import model.toy.Toy;
import presenter.Presenter;

public interface View {
    void start();//метод открытие и создание графического окна или печать меню в консоли
    void setPresenter(Presenter presenter);
    void printToy(Toy human);//
    void printListToy();
    void addToy();
    void searchToy();
    void save();
    void printFile();
    void deleteToy();
    void clearListToy();


}
