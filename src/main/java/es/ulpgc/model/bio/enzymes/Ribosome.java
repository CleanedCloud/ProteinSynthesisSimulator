package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.Protein;
import es.ulpgc.model.bio.acids.amino.AminoAcid;
import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.helixes.ARNm.Codon;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

public class Ribosome implements Enzyme {
    public static final List<ARNt> arntList = createArntList();

    public Protein traduce(ARNm arnm) {
        return null;
    }

    private static List<ARNt> createArntList() {
        return null;
    }

    public static class ARNt {
        public final SimpleEntry<Codon, AminoAcid> mapper;
        private final AminoAcid aminoAcid;
        private final Codon codon;

        public ARNt(Codon codon, AminoAcid aminoAcid) {
            this.codon = codon;
            this.aminoAcid = aminoAcid;
            this.mapper = new SimpleEntry<>(codon, aminoAcid);
        }

        public static ARNt from(SimpleEntry<Codon, AminoAcid> mapper) {
            return new ARNt(mapper.getKey(), mapper.getValue());
        }

        public Codon complementaryCodon() {
            return codon.anticodon();
        }
    }

}
