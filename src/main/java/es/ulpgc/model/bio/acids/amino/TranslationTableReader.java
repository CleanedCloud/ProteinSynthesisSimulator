package es.ulpgc.model.bio.acids.amino;

import es.ulpgc.model.bio.helixes.CodonDeserializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static es.ulpgc.model.bio.helixes.ARNm.Codon;

public record TranslationTableReader(CodonDeserializer codonDeserializer, AminoAcidDeserializer aminoAcidDeserializer) {
    private final static String separator = "\t";

    public Map<Codon, AminoAcid> read(String route) {
        Map<Codon, AminoAcid> result = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(route))) {
            String line;
            while ((line = br.readLine()) != null)
                result.put(codon(line), aminoAcid(line));
        } catch (IOException e) { e.printStackTrace(); }
        return result;
    }

    private Codon codon(String string) {
        return codonDeserializer.deserialize(split(string)[0]);
    }

    private AminoAcid aminoAcid(String string) {
        return aminoAcidDeserializer.deserialize(split(string)[1]);
    }

    private static String[] split(String line) {
        return line.split(separator);
    }
}

