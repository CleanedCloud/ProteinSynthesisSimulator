import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.cells.germ.Oogania;
import es.ulpgc.model.bio.cells.germ.Spermatogonia;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;

public class MeiosisTest {
    private Oogania oogania;
    private Spermatogonia spermatogonia;
    private final Helix helix = new Helix(List.of(Adenine, Guanine, Cytosine, Adenine, Guanine, Adenine, Guanine,
            Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Cytosine,
            Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Adenine,
            Guanine, Adenine, Adenine, Guanine, Cytosine, Adenine, Guanine,
            Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Adenine,
            Guanine, Cytosine, Adenine, Guanine, Adenine, Guanine, Adenine,
            Guanine, Adenine, Guanine, Adenine));


    @Before
    public void setUp() throws Exception {
        oogania = new Oogania(new Nucleus(new Chromatin(Chromatin.DNA.from(helix),
                new CodonBasedPromoterDiscoverer().discover(helix))));
        spermatogonia = new Spermatogonia(new Nucleus(new Chromatin(Chromatin.DNA.from(helix),
                new CodonBasedPromoterDiscoverer().discover(helix))));
    }

    @Test
    public void meiosis() {
        System.out.println(oogania.createGermCells());
        System.out.println(spermatogonia.createGermCells());
    }
}
