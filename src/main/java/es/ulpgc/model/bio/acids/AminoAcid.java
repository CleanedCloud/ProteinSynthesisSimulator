package es.ulpgc.model.bio.acids;

import es.ulpgc.model.AminoAcidFileReader;
import es.ulpgc.model.bio.enzymes.codon_deserializers.TupleCodonDeserializer;

import java.util.Map;

import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public enum AminoAcid {
    Phe, Leu, Iso, Met, Val, Ser, Pro, Thr, Ala, Tyr, Stop, His, Gln, Asn, Lys, Asp, Glu, Cys, Try, Arg, Gly;

    public static class FromCodonConverter {
        private final static Map<Codon, AminoAcid> map = createMap();
        private static AminoAcidFileReader reader = new AminoAcidFileReader(new TupleCodonDeserializer());

        private static Map<Codon, AminoAcid> createMap() {
            reader.read("");
            return null;
        }

        public static Map<Codon, AminoAcid> map() {
            return map;
        }
    }

}

