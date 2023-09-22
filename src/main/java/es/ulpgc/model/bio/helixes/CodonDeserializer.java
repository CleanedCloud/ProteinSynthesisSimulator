package es.ulpgc.model.bio.helixes;

import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public interface CodonDeserializer {
    Codon deserialize(String codon);
}
