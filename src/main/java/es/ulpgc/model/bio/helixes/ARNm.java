package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;

import java.util.List;

public class ARNm extends Helix {
    public ARNm(List<NucleicAcid> acids) {
        super(acids);
    }

    public record Codon(NucleicAcid a, NucleicAcid b, NucleicAcid c) {

        public static Codon from(List<NucleicAcid> acids) {
                return new Codon(acids.get(0), acids.get(1), acids.get(2));
            }

            public Codon anticodon() {
                return new Codon(a.complementary(), b.complementary(), c.complementary());
            }

            @Override
            public int hashCode() {
                return list().hashCode();
            }

            public List<NucleicAcid> list() {
                return List.of(a, b, c);
            }
        }
}


