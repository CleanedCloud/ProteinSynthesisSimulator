package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.Action;
import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.Protein;
import es.ulpgc.model.bio.helixes.ARNm;

import java.util.List;

public class Ribosome implements Enzyme {
    public static final List<ARNt> arntList = createArntList();
    private Action action = Action.NullAction();

    @Override
    public void with(Action action) {
        this.action = action;
    }

    public Protein traduce(ARNm arnm) {
        return null;
    }

    private static List<ARNt> createArntList() {
        return null;
    }

    public static class ARNt {
        public final ARNm.Codon anticodon;

        public ARNt(ARNm.Codon anticodon) {
            this.anticodon = anticodon;
        }
    }
}
