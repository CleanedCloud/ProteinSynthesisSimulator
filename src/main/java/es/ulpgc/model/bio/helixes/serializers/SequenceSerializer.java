package es.ulpgc.model.bio.helixes.serializers;

import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.HelixSerializer;

public class SequenceSerializer implements HelixSerializer {
    @Override
    public String serialize(Helix helix) {
        StringBuilder builder = new StringBuilder();
        helix.nucleicAcids().forEach(acid -> builder.append(getFirstLetter(acid)));
        return builder.toString();
    }

    private static char getFirstLetter(NucleicAcid acid) {
        return acid.toString().charAt(0);
    }
}
