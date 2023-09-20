package es.ulpgc.model.bio;

import es.ulpgc.model.Observable;
import es.ulpgc.model.Observer;
import es.ulpgc.model.bio.helixes.Helix.Gen;

import java.util.ArrayList;
import java.util.List;

public class Nucleus implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    public final Chromatin chromatin;

    public Nucleus(Chromatin chromatin) {
        this.chromatin = chromatin;
    }

    @Override
    public void add(Observer observer) {
        this.observers.add(observer);
    }

    public void activate(int startIndex, int endIndex) {
        notifyObservers(this.chromatin.conductorHelix().from(startIndex).to(endIndex).get());
    }

    private void notifyObservers(Gen gen) {
        observers.forEach(observer -> observer.notify(gen));
    }
}
