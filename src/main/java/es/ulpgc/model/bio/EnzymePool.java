package es.ulpgc.model.bio;

import es.ulpgc.model.Observer;

import java.util.List;
import java.util.stream.IntStream;

public abstract class EnzymePool<T extends Enzyme> implements Observer {
    protected List<T> enzymes;
    public final Class<T> aClass;

    protected EnzymePool(Class<T> aClass) {
        this.aClass = aClass;
    }

    public void generate(int n) {
        enzymes = IntStream.range(0,n)
                .mapToObj(i -> createObject())
                .toList();
    }

    private T createObject() {
        try { return (T) aClass.getConstructors()[0].newInstance();}
        catch (Exception e) { throw new RuntimeException(e); }
    }

    @Override
    public void notify(Object object) {
    }
}
