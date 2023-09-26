package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.Observable;
import es.ulpgc.model.Observer;
import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ARNm extends Helix implements Observable {
    private List<Codon> codons = null;
    private static final List<Observer> observers = new ArrayList<>();

    public ARNm(List<NucleicAcid> acids) {
        super(acids);
        notifyObservers();
    }

    public List<Codon> codons() {
        if (codons == null) codons = createCodonsFrom(acids);
        return codons;
    }

    public static List<Codon> createCodonsFrom(List<NucleicAcid> acids) {
        return IntStream.iterate(0, i -> i + Codon.size).limit(acids.size() / Codon.size)
                .mapToObj(i -> Codon.from(acids.subList(i, i + Codon.size)))
                .toList();
    }

    @Override
    public void add(Observer observer) {
        staticAdd(observer);
    }

    public static void staticAdd(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        observers.forEach(observer -> observer.notify(this));
    }

    public record Codon(NucleicAcid a, NucleicAcid b, NucleicAcid c) {
        public final static int size = 3;

        public static Codon from(List<NucleicAcid> acids) {
            if (isInvalid(acids)) throw new RuntimeException("Invalid acids list to create a Codon object");
            return new Codon(acids.get(0), acids.get(1), acids.get(2));
        }

        private static boolean isInvalid(List<NucleicAcid> acids) {
            return acids.size() != 3;
        }

        public Codon anticodon() {
            return new Codon(a.complementary(), b.complementary(), c.complementary());
        }

        @Override
        public int hashCode() {
            return list().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Codon codon = (Codon) o;
            return a == codon.a && b == codon.b && c == codon.c;
        }

        public List<NucleicAcid> list() {
            return java.util.List.of(a, b, c);
        }
    }
}


