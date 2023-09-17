package es.ulpgc.model;

public interface Observable<T extends Observable> {
    void add(Observer<T> observer);
}
