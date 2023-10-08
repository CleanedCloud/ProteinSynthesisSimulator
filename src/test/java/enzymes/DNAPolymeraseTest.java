package enzymes;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.enzymes.DNAPolymerase;
import es.ulpgc.model.bio.enzymes.Helicase;
import es.ulpgc.model.bio.helixes.Helix;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DNAPolymeraseTest {
    private DNAPolymerase dnaPolymerase;
    private Tuple<Helix, Helix> helixTuple;

    @Before
    public void setUp() throws Exception {
        dnaPolymerase = new DNAPolymerase();
        helixTuple = new Helicase().splitDNA(
                        Chromatin.DNA.from(new Helix(List.of(Adenine, Guanine, Cytosine, Thymine))));
    }

    @Test
    public void replication_should_be_the_same_as_father() {
        Tuple<Chromatin.DNA, Chromatin.DNA> replicated = dnaPolymerase.replicate(helixTuple);
        assertThat(tupleOf(replicated)).isEqualTo(helixTuple);
    }

    private static Tuple<Helix, Helix> tupleOf(Tuple<Chromatin.DNA, Chromatin.DNA> replicated) {
        return new Tuple<>(replicated.first().conductorHelix(), replicated.first().delayedHelix());
    }

    @Test
    public void replications_should_be_the_same() {
        Tuple<Chromatin.DNA, Chromatin.DNA> replicated = dnaPolymerase.replicate(helixTuple);
        assertThat(replicated.first()).isEqualTo(replicated.second());
    }
}
