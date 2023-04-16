package ui;

import model.TreeFamily.TreeFamily;
import model.human.Human;
import presenter.Presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Desctop extends JFrame implements View {

    private JLabel lTitle;//Текстовые надписи
    private JLabel lTitleAddHuman;
    private JLabel lTitleAddFamily;
    private JLabel lTitleAddName;
    private JLabel lTitleBirth;
    private JLabel lTitleDateBirth;
    private JLabel lTitleMonthBirth;
    private JLabel lTitleYearBirth;


    private JTextArea inputFamily;//Поле ввода текста
    private JTextArea inputName;
    private JTextArea inputDateBirth;
    private JTextArea inputMonthBirth;
    private JTextArea inputYearBirth;
    private JTextField city;
    private JButton showTree;
    private JButton buttonAddHuman;
    private Presenter presenter;


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        setSize(800, 800);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lTitle = new JLabel("Родословное древо семьи Базаровых");
        showTree = new JButton("Показать родословное древо");
        lTitleAddHuman = new JLabel("Введите данные, чтобы добавить человека");
        lTitleAddFamily = new JLabel("Фамилия");
        inputFamily = new JTextArea();
        lTitleAddName = new JLabel("Имя");
        inputName = new JTextArea();
        lTitleBirth = new JLabel("Дата рождения");
        lTitleDateBirth = new JLabel("Число");
        // inputBirthdate = new JTextArea();
        buttonAddHuman = new JButton("Добавить");


        city = new JTextField();
        setLayout(null);
        add(lTitle);
        add(city);
        add(showTree);
        add(inputFamily);
        add(lTitleAddHuman);
        add(lTitleAddFamily);
        add(inputName);
        add(lTitleAddName);
        // add(lTitleAddBirthdate);
        //add(inputBirthdate);
        lTitle.setBounds(40, 10, 400, 25);
        showTree.setBounds(20, 45, 300, 40);
        lTitleAddHuman.setBounds(20, 95, 350,25);
        lTitleAddFamily.setBounds(20,130,150, 25);
        inputFamily.setBounds(150,130,200,25);
        lTitleAddName.setBounds(20, 170, 150, 25);
        inputName.setBounds(150, 170, 200,25);
//        lTitleAddBirthdate.setBounds(20, 210, 150, 25);
//        inputBirthdate.setBounds(150, 210,150,25);

        findInfo.addActionListener(new ActionListener() {//При нажатии на кнопку происходит оповещение слушателей
            //ActionListener()-интерфейс
            @Override
            public void actionPerformed(ActionEvent e) {
                Human human = new Human(family.getText(), name.getText());
                presenter.addHuman(human);
                //при нажатии на кнопу в презентер передается информация из текстового поля
            }
        });

        setVisible(true);//делает окно видимым
    }

    @Override
    public void print(Human human) {
        //пишет text  в поле для ответов
        answer.setText(human.toString());
    }

    @Override
    public void printTree(TreeFamily tree) {


    }
}
