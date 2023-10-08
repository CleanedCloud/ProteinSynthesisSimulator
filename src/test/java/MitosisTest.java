import es.ulpgc.Tuple;
import es.ulpgc.model.bio.enzymes.DNAPolymerase;
import es.ulpgc.model.bio.enzymes.Helicase;
import es.ulpgc.model.bio.helixes.Helix;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.Chromatin.*;
import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;

public class MitosisTest {
    private Helicase helicase;
    private DNA dna;
    private DNAPolymerase dnaPolymerase;
    private final Helix helix = new Helix(List.of(Adenine, Guanine, Cytosine, Adenine, Guanine, Adenine, Guanine,
                                                  Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Cytosine,
                                                  Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Adenine,
                                                  Guanine, Adenine));


    @Before
    public void setUp() throws Exception {
        helicase = new Helicase();
        dnaPolymerase = new DNAPolymerase();
        dna = DNA.from(helix);
    }

    @Test
    public void name() {
        Tuple<Helix, Helix> helixTuple = helicase.splitDNA(dna);
        Tuple<DNA, DNA> replicatedDNA = dnaPolymerase.replicate(helixTuple);
        List<Chromosome> condense = condense(replicatedDNA);
        System.out.println(condense);
    }
}
