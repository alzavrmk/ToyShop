package ui.commands;

import ui.Console;

public class PrintFile extends Command {
    public PrintFile(Console console) {
        super(console);
        description = "Вывести список игрушек из файла";
    }

    @Override
    public void execute() {
        console.printFile();
    }
}