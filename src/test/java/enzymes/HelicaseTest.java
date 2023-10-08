package enzymes;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.enzymes.Helicase;
import es.ulpgc.model.bio.helixes.Helix;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.Thymine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HelicaseTest {
    private Helicase helicase;
    private Chromatin.DNA dna;

    @Before
    public void setUp() throws Exception {
        helicase = new Helicase();
        dna = Chromatin.DNA.from(new Helix(List.of(Adenine, Guanine, Cytosine, Thymine)));
    }

    @Test
    public void replication_should_be_the_same_as_father() {
        assertThat(helicase.splitDNA(dna)).isEqualTo(new Tuple<>(new Helix(
                List.of(Adenine, Guanine, Cytosine, Thymine)),
                new Helix(List.of(Adenine, Guanine, Cytosine, Thymine)).complementary())
        );
    }

}
