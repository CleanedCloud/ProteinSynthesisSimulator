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

    public Protein translate(ARNm arnm) {
        return new Protein(arnm.codons().stream().map(c -> arntFor(c).aminoAcid).toList());
    }

    private ARNt arntFor(Codon codon) {
        for (ARNt arnt : arntList)
            if (codon.equals(arnt.codon)) return arnt;
        throw new RuntimeException("Not arnt found for " + codon.toString());
    }

    private static List<ARNt> createArntList() {
        return AminoAcid.TranslationMapper.translationMap().keySet().stream()
                .map(k -> new ARNt(k, AminoAcid.TranslationMapper.translationMap().get(k)))
                .toList();
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

    }

}
