package es.ulpgc.model.bio.cells.germ;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.cells.GermCell;
import es.ulpgc.model.bio.cells.somatic.SpermCell;

import java.util.List;

public class Spermatogonia extends GermCell<SpermCell> {
    public Spermatogonia(Nucleus nucleus) {
        super(nucleus);
    }

    @Override
    public List<SpermCell> createGermCells() {
        Tuple<Nucleus, Nucleus> nucleus = createNucleus();
        return List.of(new SpermCell(getFirstChromatidList(nucleus.first())),
                       new SpermCell(getFirstChromatidList(nucleus.second())),
                       new SpermCell(getSecondChromatidList(nucleus.second())),
                       new SpermCell(getSecondChromatidList(nucleus.second())));
    }
}
