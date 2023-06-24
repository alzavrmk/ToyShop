package ui.commands;

import ui.Console;

public class DeleteToy extends Command{
    public DeleteToy(Console console) {
        super(console);
        description = "Удалить игрушку";
    }

    @Override
    public void execute() {
        console.deleteToy();
    }
}