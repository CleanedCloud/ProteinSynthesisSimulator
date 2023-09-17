package es.ulpgc.model;

import java.util.List;

public class Helix {
    private final List<NucleicAcid> nucleicAcids;
    private final List<Gen> gens;

    public Helix(List<NucleicAcid> nucleicAcids) {
        this.nucleicAcids = nucleicAcids;
        this.gens = null;
    }

    public Gen gen(int i) {
        return this.gens().get(i);
    }

    public List<Gen> gens() {
        if (this.gens == null) createGens();
        return this.gens;
    }

    private void createGens() {
    }

    public static class Gen {
    }
}
