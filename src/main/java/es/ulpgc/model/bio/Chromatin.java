package es.ulpgc.model.bio;

import es.ulpgc.model.bio.helixes.Helix;

public record Chromatin(Helix conductorHelix, Helix delayedHelix) {

    public static Chromatin from(Helix conductorHelix) {
        return new Chromatin(conductorHelix, conductorHelix.complementary());
    }
}
