package caretaker;

import memento.Memento;

import java.util.Stack;

public class History {

    private final Stack<Memento> states = new Stack<>();

    public void saveState(Memento memento) {
        states.push(memento);
    }

    public Memento getLastState() {
        if (states.isEmpty()) {
            return null;
        }
        return states.pop();
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }
}