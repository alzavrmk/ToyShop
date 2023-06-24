package ui;

import ui.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private  List<Command> commands;
    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new AddToy(console));
        commands.add(new GetListToy(console));
        commands.add(new SearchToy(console));
        commands.add(new Save(console));
        commands.add(new PrintFile(console));
        commands.add(new DeleteToy(console));
        commands.add(new ClearListToy(console));
        commands.add(new Finish(console));


    }
    public void execute(int choice) {
        commands.get(choice - 1).execute();

    }
    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append((commands.get(i).getDescription()));
            stringBuilder.append(" \n");
        }
        stringBuilder.append("Введите номер команды: ");
        return stringBuilder.toString();
    }
}
