package es.ulpgc.model.bio;

import es.ulpgc.model.Action;
import es.ulpgc.model.Observer;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class EnzymePool<T extends Enzyme> implements Observer {
    protected List<T> enzymes;
    public final Class<T> aClass;
    protected Action action = Action.NullAction();

    protected EnzymePool(Class<T> aClass) {
        this.aClass = aClass;
    }

    @Override
    public void with(Action action) {
        this.action = action;
    }

    public EnzymePool<T> generateEnzymes(int n) {
        enzymes = IntStream.range(0,n)
                .mapToObj(i -> createEnzyme())
                .toList();
        return this;
    }

    private T createEnzyme() {
        try { return enzyme();}
        catch (Exception e) { throw new RuntimeException(e); }
    }

    private T enzyme() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        return (T) aClass.getConstructors()[0].newInstance();
    }

    public T randomEnzyme() {
        return enzymes.get(randomIndex());
    }

    private int randomIndex() {
        return new Random().nextInt(enzymes.size());
    }

    @Override
    public abstract void notify(Object object);
}
