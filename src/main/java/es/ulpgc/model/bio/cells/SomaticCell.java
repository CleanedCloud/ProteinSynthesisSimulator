package es.ulpgc.model.bio.cells;

import es.ulpgc.model.bio.Chromatin;

import java.util.List;

public abstract class SomaticCell {
    public final List<Chromatin.Chromosome.Chromatid> chromatids;

    public SomaticCell(List<Chromatin.Chromosome.Chromatid> chromatids) {
        this.chromatids = chromatids;
    }
}
