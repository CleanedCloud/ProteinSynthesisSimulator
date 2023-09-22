package helix;

import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.generators.RandomDNAHelixGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelixGeneratorTest {
    RandomDNAHelixGenerator helixGenerator;

    @Before
    public void setUp() {
        helixGenerator = new RandomDNAHelixGenerator(4);
    }

    @Test
    public void test_if_generates_helix_of_size_50() {
        assertThat(helixGenerator.generateHelixOfSize(50).size()).isEqualTo(50);
    }

    @Test
    public void test_if_generates_helix_of_size_4_and_content() {
        Helix helix = new Helix(List.of(Guanine, Cytosine, Cytosine, Cytosine));
        assertThat(helixGenerator.generateHelixOfSize(4)).isEqualTo(helix);
    }
}
