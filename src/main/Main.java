package main;

import caretaker.History;
import memento.Memento;
import originator.Editor;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("Hola");
        System.out.println("Current content: \"" + editor.getContent() + "\"");
        history.saveState(editor.save());
        System.out.println("State saved.");

        editor.setContent("Hola, mundo");
        System.out.println("Current content: \"" + editor.getContent() + "\"");
        history.saveState(editor.save());
        System.out.println("State saved.");

        editor.setContent("Hola, mundo. Adios");
        System.out.println("Current content: \"" + editor.getContent() + "\"");

        if (!history.isEmpty()) {
            Memento last = history.getLastState();
            editor.restore(last);
            System.out.println("Last saved state restored.");
        }
        System.out.println("Current content: \"" + editor.getContent() + "\"");

        editor.setContent(editor.getContent() + ". New change after restoring");
        System.out.println("Current content: \"" + editor.getContent() + "\"");
    }
}