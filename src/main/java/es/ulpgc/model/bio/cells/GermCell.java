package es.ulpgc.model.bio.cells;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Cell;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Nucleus;

import java.util.List;

public abstract class GermCell<T extends SomaticCell> extends Cell {
    public GermCell(Nucleus nucleus) {
        super(nucleus);
    }
    public abstract List<T> createGermCells();

    protected Tuple<Nucleus, Nucleus> createNucleus() {
        Tuple<Cell, Cell> replicatedCells = selfReplicate();
        return new Tuple<>(replicatedCells.first().nucleus, replicatedCells.second().nucleus);
    }

    protected List<Chromatin.Chromosome.Chromatid> getSecondChromatidList(Nucleus nucleus) {
        return Cell.chromosomes(nucleus).stream().map(Chromatin.Chromosome::secondChromatid).toList();
    }

    protected static List<Chromatin.Chromosome.Chromatid> getFirstChromatidList(Nucleus nucleus) {
        return Cell.chromosomes(nucleus).stream().map(Chromatin.Chromosome::firstChromatid).toList();
    }
}
