package es.ulpgc.model;

public interface Action {
    void act(Object object);

    static Action NullAction() {
        return object -> { };
    }
}
