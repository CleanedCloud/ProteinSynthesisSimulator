package es.ulpgc.model;

import java.util.List;

public class Ribosome {
    public static final List<ARNt> arntList = createArntList();

    private static List<ARNt> createArntList() {
        return null;
    }

    public List<Aminoacid> traduce(ARNm arnm) {
        return null;
    }

    public static class ARNt {
        public final ARNm.Codon anticodon;

        public ARNt(ARNm.Codon anticodon) {
            this.anticodon = anticodon;
        }
    }
}
