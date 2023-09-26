package es.ulpgc.model.bio.acids.amino;

import es.ulpgc.model.Action;
import es.ulpgc.model.bio.Protein;

public class ProteinStoreAction implements Action {
    private final ProteinStore store;
    private String path;

    public ProteinStoreAction(ProteinStore store) {
        this.store = store;
    }

    public ProteinStoreAction in(String path) {
        this.path = path;
        return this;
    }

    @Override
    public void act(Object object) {
        store.store(path, (Protein) object);
    }
}
