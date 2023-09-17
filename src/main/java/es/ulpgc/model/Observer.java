package es.ulpgc.model;

public interface Observer<T extends Observable> {
    void notify(Object object);
}
