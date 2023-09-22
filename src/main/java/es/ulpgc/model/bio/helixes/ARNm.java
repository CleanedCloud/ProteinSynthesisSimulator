package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;

import java.util.List;
import java.util.stream.IntStream;

public class ARNm extends Helix {
    private List<Codon> codons = null;

    public ARNm(List<NucleicAcid> acids) {
        super(acids);
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

        public List<NucleicAcid> list() {
            return java.util.List.of(a, b, c);
        }
    }
}


