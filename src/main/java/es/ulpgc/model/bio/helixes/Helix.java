package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.bio.acids.NucleicAcid;

import java.util.List;

public class Helix {
    protected List<NucleicAcid> acids;
    private int from;
    private int to;

    public Helix(List<NucleicAcid> acids) {
        this.acids = acids;
    }

    public Helix from(int startIndex) {
        this.from = startIndex;
        return this;
    }

    public Helix to(int EndIndex) {
        this.to = EndIndex;
        return this;
    }

    public Gen get() {
        return new Gen(acids.subList(from, to));
    }

    public record Gen(List<NucleicAcid> nucleicAcids) {

    }
}
