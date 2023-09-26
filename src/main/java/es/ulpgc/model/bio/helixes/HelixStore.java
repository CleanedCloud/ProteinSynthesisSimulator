package es.ulpgc.model.bio.helixes;

import es.ulpgc.model.Writer;

public interface HelixStore {
    void store(String path, Helix helix);

    static HelixStore create(Writer writer, HelixSerializer serializer) {
        return (path, helix) -> writer.write(path, serializer.serialize(helix));
    }
}
