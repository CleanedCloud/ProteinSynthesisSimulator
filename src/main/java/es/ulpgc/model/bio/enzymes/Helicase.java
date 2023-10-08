package es.ulpgc.model.bio.enzymes;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.helixes.Helix;

public class Helicase implements Enzyme {
    public Tuple<Helix, Helix> splitDNA(Chromatin.DNA dna) {
        return new Tuple<>(dna.conductorHelix(), dna.delayedHelix());
    }
}
