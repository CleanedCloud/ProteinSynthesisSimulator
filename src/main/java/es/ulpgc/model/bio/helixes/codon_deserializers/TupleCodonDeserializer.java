package es.ulpgc.model.bio.helixes.codon_deserializers;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcidDeserializer;
import es.ulpgc.model.bio.helixes.CodonDeserializer;

import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public record TupleCodonDeserializer(NucleicAcidDeserializer nucleicAcidDeserializer) implements CodonDeserializer {

    @Override
    public Codon deserialize(String codon) {
        if (isNotValid(codon)) throw new IllegalArgumentException("Invalid string format");
        return codon(parseCodon(codon));
    }

    private Codon codon(String[] nucleicAcids) {
        return new Codon(nucleicAcidDeserializer.deserialize(nucleicAcids[0]),
                         nucleicAcidDeserializer.deserialize(nucleicAcids[1]),
                         nucleicAcidDeserializer.deserialize(nucleicAcids[2]));
    }

    private static boolean isNotValid(String codon) {
        return parseCodon(codon).length > 3;
    }

    private static String[] parseCodon(String codon) {
        return codon.replaceAll("[()]", "").split(",");
    }
}
