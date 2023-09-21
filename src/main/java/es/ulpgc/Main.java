package es.ulpgc;

import es.ulpgc.model.AminoAcidFileReader;
import es.ulpgc.model.bio.enzymes.codon_deserializers.TupleCodonDeserializer;

public class Main {
    public static void main(String[] args) {
        new AminoAcidFileReader(new TupleCodonDeserializer());
        System.out.println("Hello world!");
    }
}
