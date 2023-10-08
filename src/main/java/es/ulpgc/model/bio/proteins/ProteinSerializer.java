package es.ulpgc.model.bio.proteins;


import es.ulpgc.model.bio.Protein;
import es.ulpgc.model.bio.acids.amino.AminoAcidSerializer;

public interface ProteinSerializer {
    String serialize(Protein protein);

    static ProteinSerializer create(AminoAcidSerializer serializer) {
        return protein -> {
            StringBuilder stringBuilder = new StringBuilder();
            protein.acids().forEach(a -> stringBuilder.append(serializer.serialize(a)));
            return stringBuilder.toString();
        };
    }
}
