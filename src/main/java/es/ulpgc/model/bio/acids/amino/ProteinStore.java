package es.ulpgc.model.bio.acids.amino;

import es.ulpgc.model.Writer;
import es.ulpgc.model.bio.Protein;

public interface ProteinStore {
    void store(String path, Protein protein);

    static ProteinStore create(Writer writer, ProteinSerializer serializer) {
        return (path, protein) -> writer.write(path, serializer.serialize(protein));
    }
}
