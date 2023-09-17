package es.ulpgc.model.bio;

import es.ulpgc.model.bio.helixes.Helix;

public record Chromatin(Helix conductorHelix, Helix delayedHelix) {
}
