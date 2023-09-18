package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.Action;
import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.Protein;
import es.ulpgc.model.bio.acids.AminoAcid;
import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.helixes.ARNm.Codon;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static es.ulpgc.model.bio.acids.AminoAcid.aminoAcidMap;

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
        return aminoAcidMap.keySet().stream().map(c -> new ARNt(c, aminoAcidMap.get(c))).toList();
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

        public Codon complementaryCodon() {
            return codon.anticodon();
        }
    }

}
