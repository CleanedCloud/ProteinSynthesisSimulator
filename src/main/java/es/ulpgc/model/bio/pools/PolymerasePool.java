package es.ulpgc.model.bio.pools;

import es.ulpgc.model.bio.EnzymePool;
import es.ulpgc.model.bio.enzymes.Polymerase;

import static es.ulpgc.model.bio.helixes.Helix.Gen;

public class PolymerasePool extends EnzymePool<Polymerase> {

    public PolymerasePool() {
        super(Polymerase.class);
    }

    @Override
    public void notify(Object object) {
        action.act(randomEnzyme().transcript((Gen) object));
    }
}
