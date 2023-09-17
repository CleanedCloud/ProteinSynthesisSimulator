package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.bio.acids.NucleicAcid;

import java.util.List;

public class ARNm extends Helix {
    public ARNm(List<NucleicAcid> acids) {
        super(acids);
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


