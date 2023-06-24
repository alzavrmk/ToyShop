package ui.commands;

import ui.Console;

public class GetListToy extends Command{
        public GetListToy(Console console) {
            super(console);
            description = "Вывести список игрушек";
        }

        @Override
        public void execute() {
            console.getListToy();
        }
}
