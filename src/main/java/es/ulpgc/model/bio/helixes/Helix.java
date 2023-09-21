package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.bio.acids.NucleicAcid;

import java.util.List;
import java.util.Objects;

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

    public List<NucleicAcid> get() {
        return acids.subList(from, to);
    }

    public List<NucleicAcid> nucleicAcids() {
        return acids;
    }

    public Helix complementary() {
        return new Helix(this.nucleicAcids().stream().map(NucleicAcid::complementary).toList());
    }

    public int size() {
        return this.acids.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Helix helix = (Helix) o;
        return Objects.equals(acids, helix.acids);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acids);
    }

    public record Gen(List<NucleicAcid> conductorNucleicAcids, List<NucleicAcid> nucleicAcidsDelayed) {

    }
}
