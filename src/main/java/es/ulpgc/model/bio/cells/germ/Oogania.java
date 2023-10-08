package es.ulpgc.model.bio.cells.germ;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.cells.GermCell;
import es.ulpgc.model.bio.cells.somatic.EggCell;

import java.util.List;

public class Oogania extends GermCell<EggCell> {
    public Oogania(Nucleus nucleus) {
        super(nucleus);
    }

    @Override
    public List<EggCell> createGermCells() {
        Tuple<Nucleus, Nucleus> nucleus = createNucleus();
        return List.of(new EggCell(getFirstChromatidList(nucleus.first())),
                       new EggCell(getFirstChromatidList(nucleus.second())),
                       new EggCell(getSecondChromatidList(nucleus.second())),
                       new EggCell(getSecondChromatidList(nucleus.second())));
    }
}
