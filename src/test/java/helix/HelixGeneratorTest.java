package helix;

import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.generators.ChromatinHelixGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelixGeneratorTest {
    ChromatinHelixGenerator helixGenerator;

    @Before
    public void setUp() {
        helixGenerator = new ChromatinHelixGenerator(4);
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

    @Test
    public void test_if_generates_complementary_helix() {
        Helix helix = new Helix(List.of(Guanine, Thymine, Adenine, Cytosine));
        Helix complementaryHelix = new Helix(List.of(Cytosine, Adenine, Thymine, Guanine));
        assertThat(helixGenerator.generateComplementaryOf(helix)).isEqualTo(complementaryHelix);
    }
}
