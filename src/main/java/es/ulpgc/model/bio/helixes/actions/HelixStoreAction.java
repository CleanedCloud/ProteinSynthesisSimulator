package es.ulpgc.model.bio.helixes.actions;

import es.ulpgc.model.Action;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.HelixStore;

public class HelixStoreAction implements Action {
    private final HelixStore store;
    private String path;

    public HelixStoreAction(HelixStore store) {
        this.store = store;
    }

    public HelixStoreAction in(String path) {
        this.path = path;
        return this;
    }

    @Override
    public void act(Object object) {
        store.store(path, (Helix) object);
    }
}
