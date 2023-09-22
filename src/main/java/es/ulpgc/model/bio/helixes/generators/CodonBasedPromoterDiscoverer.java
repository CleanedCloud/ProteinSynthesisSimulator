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
    public static final Codon startComplementaryCodon = new Codon(Thymine, Adenine, Cytosine);
    public static final List<Codon> stopComplementaryCodons = List.of(
            new Codon(Adenine, Thymine, Thymine),
            new Codon(Adenine, Thymine, Cytosine),
            new Codon(Adenine, Cytosine, Thymine));

    @Override
    public List<Promoter> discover(Helix helix) {
        return discover(ARNm.createCodonsFrom(helix.nucleicAcids()));
    }

    private List<Promoter> discover(List<Codon> codons) {
        ArrayList<Promoter> result = new ArrayList<>();
        for (int index = 0; index < codons.size(); index++)
            if (isComplementaryStartCodon(codons.get(index))) result.add(promoter(index, stopIndex(codons, index)));
        return result;
    }

    private static boolean isComplementaryStartCodon(Codon codon) {
        return codon.equals(startComplementaryCodon);
    }

    private boolean isComplementaryStopCodon(Codon codon) {
        return stopComplementaryCodons.contains(codon);
    }

    private Promoter promoter(int startIndex, int stopIndex) {
        return new Promoter(index(startIndex), index(stopIndex));
    }

    private int index(int index) {
        return index * Codon.size;
    }

    private int stopIndex(List<Codon> codons, int startIndex) {
        for (int index = startIndex; index < codons.size(); index++)
            if (isComplementaryStopCodon(codons.get(index))) return index + 1;
        return codons.size();
    }
}
