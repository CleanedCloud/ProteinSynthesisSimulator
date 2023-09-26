package es.ulpgc.model;

public interface Observer {
    void with(Action action);
    void notify(Object object);
}
