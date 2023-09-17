package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.bio.acids.AminoAcid;
import es.ulpgc.model.bio.helixes.ARNm;

import java.util.List;

public class Ribosome {
    public static final List<ARNt> arntList = createArntList();

    private static List<ARNt> createArntList() {
        return null;
    }

    public List<AminoAcid> traduce(ARNm arnm) {
        return null;
    }

    public static class ARNt {
        public final ARNm.Codon anticodon;

        public ARNt(ARNm.Codon anticodon) {
            this.anticodon = anticodon;
        }
    }
}
