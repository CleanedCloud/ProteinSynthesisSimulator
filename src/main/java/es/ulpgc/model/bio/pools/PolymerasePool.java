package es.ulpgc.model.bio.pools;

import es.ulpgc.model.bio.EnzymePool;
import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.enzymes.Polymerase;

import java.util.List;

public class PolymerasePool extends EnzymePool<Polymerase> {

    protected PolymerasePool(Class<Polymerase> aClass) {
        super(aClass);
    }

    @Override
    public void notify(Object object) {
        randomEnzyme().transcript((List<NucleicAcid>) object);
    }
}
