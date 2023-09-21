package es.ulpgc.model.bio.enzymes.codon_deserializers;

import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.enzymes.CodonDeserializer;

import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public class TupleCodonDeserializer implements CodonDeserializer {
    @Override
    public Codon deserialize(String codon) {
        isNotCodon(parseCodon(codon));
        return codon(parseCodon(codon));
    }

    private static Codon codon(String[] nucleicAcids) {
        return new Codon(NucleicAcid.valueOf(nucleicAcids[0]),
                         NucleicAcid.valueOf(nucleicAcids[1]),
                         NucleicAcid.valueOf(nucleicAcids[2]));
    }

    private static void isNotCodon(String[] nucleicAcids) {
        if (isNotValid(nucleicAcids)) throw new IllegalArgumentException("Invalid string format");
    }

    private static boolean isNotValid(String[] nucleicAcids) {
        return nucleicAcids.length >= 3;
    }

    private static String[] parseCodon(String codon) {
        return codon.replaceAll("[()]", "").split(",");
    }
}
