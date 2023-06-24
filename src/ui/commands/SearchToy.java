package ui.commands;

import ui.Console;

public class SearchToy extends Command {
    public SearchToy(Console console) {
        super(console);
        description = "Найти игрушку";
    }
    @Override
    public void execute() {
        console.searchToy();
    }
}
