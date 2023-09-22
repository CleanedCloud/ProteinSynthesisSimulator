package es.ulpgc.model.bio.acids.nucleic.serializers;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcidSerializer;
import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;

public class FirstLetterNucleicAcidSerializer implements NucleicAcidSerializer {
    @Override
    public String serialize(NucleicAcid acid) {
        return String.valueOf(acid.toString().charAt(0));
    }
}
