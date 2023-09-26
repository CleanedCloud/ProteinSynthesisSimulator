package es.ulpgc.model.bio;

import es.ulpgc.model.bio.helixes.Helix;

import java.util.List;

import static es.ulpgc.model.bio.helixes.Helix.*;

public final class Chromatin {
    private final DNA dna;
    private final List<Promoter> promoters;


    public Chromatin(DNA dna, List<Promoter> promoters) {
        this.dna = dna;
        this.promoters = promoters;
    }

    public Helix conductorHelix() {
        return dna.conductorHelix();
    }

    public Helix delayedHelix() {
        return dna.delayedHelix();
    }

    public Gen getGen(int index) {
        return new Gen(this.conductorHelix().from(startIndex(index)).to(stopIndex(index)).get(),
                       this.delayedHelix().from(startIndex(index)).to(stopIndex(index)).get());
    }

    private int stopIndex(int genIndex) {
        return promoters.get(genIndex).stopIndex;
    }

    private int startIndex(int genIndex) {
        return promoters.get(genIndex).startIndex;
    }

    public record DNA(Helix conductorHelix, Helix delayedHelix) {
        public static DNA from(Helix conductorHelix) {
            return new DNA(conductorHelix, conductorHelix.complementary());
        }
    }

    public record Promoter(int startIndex, int stopIndex) {
    }
}
