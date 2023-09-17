package es.ulpgc.model;

public class Chromatin {
    public final Helix delayedHelix;
    public final Helix conductorHelix;

    public Chromatin(Helix delayedHelix, Helix conductorHelix) {
        this.delayedHelix = delayedHelix;
        this.conductorHelix = conductorHelix;
    }
}
