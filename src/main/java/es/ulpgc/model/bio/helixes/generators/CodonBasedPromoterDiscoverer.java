package es.ulpgc.model.bio.helixes.generators;

import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.PromoterDiscoverer;

import java.util.ArrayList;
import java.util.List;

import static es.ulpgc.model.bio.Chromatin.Promoter;
import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public class CodonBasedPromoterDiscoverer implements PromoterDiscoverer {
    public static final Codon startCodon = new Codon(Adenine.complementary(), Uracil.complementary(), Cytosine.complementary());
    public static final List<Codon> stopCodons = List.of(
            new Codon(Uracil.complementary(), Adenine.complementary(), Adenine.complementary()),
            new Codon(Uracil.complementary(), Adenine.complementary(), Guanine.complementary()),
            new Codon(Uracil.complementary(), Guanine.complementary(), Adenine.complementary()));

    @Override
    public List<Promoter> discover(Helix helix) {
        return discover(ARNm.createCodonsFrom(helix.nucleicAcids()));
    }

    private List<Promoter> discover(List<Codon> codons) {
        ArrayList<Promoter> result = new ArrayList<>();
        for (int index = 0; index < codons.size(); index++)
            if (isStartCodon(codons.get(index))) result.add(promoter(index, stopIndex(codons, index)));
        return result;
    }

    private static boolean isStartCodon(Codon codon) {
        return codon.equals(startCodon);
    }

    private boolean isStopCodon(Codon codon) {
        return stopCodons.contains(codon);
    }

    private Promoter promoter(int startIndex, int stopIndex) {
        return new Promoter(index(startIndex), index(stopIndex));
    }

    private int index(int index) {
        return index != 0 ? index * Codon.size - 1 : 0;
    }

    private int stopIndex(List<Codon> codons, int startIndex) {
        for (int index = startIndex; index < codons.size(); index++)
            if (isStopCodon(codons.get(index))) return index + 1;
        return codons.size();
    }
}
