package ui;

import model.listToy.ListToy;
import model.toy.Toy;
import presenter.Presenter;

import java.util.Scanner;

import static java.awt.SystemColor.control;
import static java.awt.SystemColor.text;

public class Console implements View {

    private Presenter presenter;//куда отправлять информацию
    private Scanner scanner;
//    private Scanner scannerId;
    private boolean work;
    private Menu menu;


    public Console() {
        scanner = new Scanner(System.in);
        work = true;


        menu = new Menu(this);
    }



    @Override
    public void start() {
//        while (work) {
//            System.out.println(menu.print());
//            int choice = Integer.parseInt(scan());
//            menu.execute(choice);
//        }
        while (work) {
            System.out.println(menu.print());
            String text = scan();
            if (check(text)) {
                int choice = Integer.parseInt(text);
                menu.execute(choice);
            } else {
                System.out.println("Ошибка ввода! Введите число");
            }
        }
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    public Presenter getPresenter() {
        return presenter;
    }



    private  boolean check(String text){
        return text.matches("[0-9]+");//Метод проверки что введено именно целое число из [0-9]
    }
    private  boolean writeInt(String text){
        return text.matches("\\d+");//Метод проверки что введено именно целое число
    }
    private String scan() {

        return scanner.nextLine();
    }
    private int intId() {
        int idToy = 0;
        boolean flag = true;

        while (flag) {
            String text = scanId();
            if (writeInt(text)) {
                idToy = Integer.parseInt(text);
                flag = false;
            } else {
                System.out.println("Ошибка ввода! Введите число");
            }
        }
        return idToy;
    }
    private int intCountToy() {
        boolean flag = true;

        int countToy = 0;
        while (flag) {
            String text = scanCountToy();
            if (writeInt(text)) {
                countToy = Integer.parseInt(text);
                flag = false;
            } else {
                System.out.println("Ошибка ввода! Введите число");
            }
        }
        return countToy;
    }
    private int intDropRateToy() {
        boolean flag = true;
        int dropRateToy = 0;
        while (flag) {
            String text = scanDropRateToy();
            if (writeInt(text)) {
                int dropRateToy1 = Integer.parseInt(text);
                if ((dropRateToy1 <= 100) && (dropRateToy1 > 0)){
                    dropRateToy = dropRateToy1;
                    flag = false;
                } else {
                    System.out.println("Введите целое число в диапозоне от 0 до 100!");
                }
            } else {
                System.out.println("Ошибка ввода! Введите число! ");
            }
        }
        return dropRateToy;
    }
    private String scanId() {
        System.out.println("Введите id игрушки: ");
        return scanner.nextLine();
    }

    private String scanNameToy() {
        System.out.println("Введите название игрушки: ");
        return scanner.nextLine();
    }

    private String scanCountToy() {
        System.out.println("Введите количество игрушек: ");
        return scanner.nextLine();
    }
    private String scanDropRateToy() {
        System.out.println("Введите частоту выпадения игрушки: ");
        return scanner.nextLine();
    }
    @Override
    public void printToy(Toy toy) {

        System.out.println(toy);
    }

    @Override
    public void addToy(){
        String nameToy = scanNameToy();
        int countToy = intCountToy();
        int dropRateToy = intDropRateToy();
        presenter.addToy(nameToy, countToy, dropRateToy);
    }


    public void finish(){

        work = false;
    }
    @Override
    public void printListToy() {
        System.out.println(presenter.getListToy().getInfo());
    }


    public void searchToy() {
        String nameToy = scanNameToy();
        System.out.println(presenter.searchToy(nameToy));
    }

    @Override
    public void save() {

        System.out.println(presenter.save());
    }

    @Override
    public void printFile() {

        System.out.println(presenter.printFile());
    }
    @Override
    public void deleteToy(){
        int idToy = intId();
//        scanner.nextLine();
        System.out.println(presenter.deleteToy(idToy));

    }
    @Override
    public void clearListToy() {
        presenter.clearListToy();
        System.out.println("Список очищен!");
    }
//    @Override
    public void getListToy() {
        System.out.println("Список игрушек:");
        System.out.println(presenter.getListToy().getInfo());


    }


}
