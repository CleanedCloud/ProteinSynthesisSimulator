package es.ulpgc.model.bio.helixes.serializers.helix;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcidSerializer;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.HelixSerializer;

public class SequenceHelixSerializer implements HelixSerializer {
    private final NucleicAcidSerializer serializer;

    public SequenceHelixSerializer(NucleicAcidSerializer serializer) {
        this.serializer = serializer;
    }

    @Override
    public String serialize(Helix helix) {
        StringBuilder builder = new StringBuilder();
        helix.nucleicAcids().forEach(acid -> builder.append(serializer.serialize(acid)));
        return builder.toString();
    }
}
