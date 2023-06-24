package ui.commands;

import ui.Console;

public class ClearListToy extends Command{
    public ClearListToy(Console console) {
        super(console);
        description = "Очистить список игрушек";
    }

    @Override
    public void execute() {
        console.clearListToy();
    }
}