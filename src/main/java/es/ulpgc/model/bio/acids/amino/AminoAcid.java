package es.ulpgc.model.bio.acids.amino;

import es.ulpgc.model.bio.helixes.codon_deserializers.TupleCodonDeserializer;
import java.util.Map;
import java.util.Objects;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public enum AminoAcid {
    Phe, Leu, Iso, Met, Val, Ser, Pro, Thr, Ala, Tyr, Stop, His, Gln, Asn, Lys, Asp, Glu, Cys, Try, Arg, Gly;

    public static class TranslationMapper {
        public final static TranslationTableReader reader = aminoAcidFileReader();
        private final static Map<Codon, AminoAcid> translationMap = createMap();

        private static Map<Codon, AminoAcid> createMap() {
            return reader.read(route());
        }

        private static TranslationTableReader aminoAcidFileReader() {
            return new TranslationTableReader(codonDeserializer(), aminoAcidDeserializer());
        }

        private static NativeAminoAcidDeserializer aminoAcidDeserializer() {
            return new NativeAminoAcidDeserializer();
        }

        private static TupleCodonDeserializer codonDeserializer() {
            return new TupleCodonDeserializer(new NativeNucleicAcidDeserializer());
        }

        private static String route() {
            return Objects.requireNonNull(AminoAcid.class.getClassLoader()
                                                         .getResource("AminoAcidMap.txt"))
                                                         .getPath()
                                                         .replaceAll("%20", " ");
        }

        public static Map<Codon, AminoAcid> translationMap() {
            return translationMap;
        }
    }


    public static class NativeAminoAcidDeserializer implements AminoAcidDeserializer {
        @Override
        public AminoAcid deserialize(String aminoAcid) {
            return AminoAcid.valueOf(aminoAcid);
        }
    }
}

