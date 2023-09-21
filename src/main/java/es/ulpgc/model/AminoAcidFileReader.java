package es.ulpgc.model;


import es.ulpgc.model.bio.acids.AminoAcid;
import es.ulpgc.model.bio.enzymes.CodonDeserializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static es.ulpgc.model.bio.helixes.ARNm.Codon;


public class AminoAcidFileReader {
    public final CodonDeserializer codonDeserializer;

    public AminoAcidFileReader(CodonDeserializer codonDeserializer) {
        this.codonDeserializer = codonDeserializer;
    }


    public Map<Codon, AminoAcid> read(String route) {
        Map<Codon, AminoAcid> result = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(route))) {
            String line;
            while ((line = br.readLine()) != null)
                result.put(codon(line), aminoAcid(line));
        } catch (IOException e) { e.printStackTrace(); }
        return result;
    }

    private AminoAcid aminoAcid(String line) {
        return parseLineToAminoAcid(Split(line)[1]);
    }

    private Codon codon(String line) {
        return codonDeserializer.deserialize(Split(line)[0]);
    }

    private static String[] Split(String line) {
        return line.split("\t");
    }

    private AminoAcid parseLineToAminoAcid(String str) {
        return AminoAcid.valueOf(str);
    }
}
