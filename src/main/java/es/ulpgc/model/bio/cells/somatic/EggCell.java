package es.ulpgc.model.bio.cells.somatic;

import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.cells.SomaticCell;

import java.util.List;

public class EggCell extends SomaticCell {
    public EggCell(List<Chromatin.Chromosome.Chromatid> chromatids) {
        super(chromatids);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return chromatids.toString();
    }
}
