import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Cell;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.Chromatin.*;
import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MitosisTest {
    private Cell cell;
    private final Helix helix = new Helix(List.of(Adenine, Guanine, Cytosine, Adenine, Guanine, Adenine, Guanine,
                                                  Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Cytosine,
                                                  Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Adenine,
                                                  Guanine, Adenine, Adenine, Guanine, Cytosine, Adenine, Guanine,
                                                  Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Adenine,
                                                  Guanine, Cytosine, Adenine, Guanine, Adenine, Guanine, Adenine,
                                                  Guanine, Adenine, Guanine, Adenine));


    @Before
    public void setUp() throws Exception {
        cell = new Cell(new Nucleus(new Chromatin(DNA.from(helix), new CodonBasedPromoterDiscoverer().discover(helix))));
    }

    @Test
    public void mitosis() {
        Tuple<Cell, Cell> cellTuple = cell.selfReplicate();
        assertThat(cellTuple.first().nucleus().chromatin.dna).isEqualTo(cellTuple.second().nucleus().chromatin.dna);
    }
}
