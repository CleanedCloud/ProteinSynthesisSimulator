package es.ulpgc.model.bio.acids.amino;


import es.ulpgc.model.bio.Protein;

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
