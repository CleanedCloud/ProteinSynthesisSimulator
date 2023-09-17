package es.ulpgc.model;

import java.util.List;

public class ARNm extends Helix{
    public ARNm(List<NucleicAcid> nucleicAcids) {
        super(nucleicAcids);
    }

    public static class Codon {
        public final NucleicAcid a;
        public final NucleicAcid b;
        public final NucleicAcid c;

        public Codon(NucleicAcid a, NucleicAcid b, NucleicAcid c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public static Codon from(List<NucleicAcid> acids) {
            return new Codon(acids.get(0), acids.get(1), acids.get(2));
        }

        public Codon anticodon(Codon codon) {
            return null;
        }
    }
}


