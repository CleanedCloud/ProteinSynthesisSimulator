package helix;

import es.ulpgc.model.bio.helixes.Helix;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static es.ulpgc.model.bio.acids.NucleicAcid.*;

public class HelixTest {
    Helix helix;


    @Before
    public void setUp() {
        helix =  new Helix(List.of(Guanine, Thymine, Adenine, Cytosine));
    }

    @Test
    public void test_if_generates_complementary_helix() {
        Helix complementaryHelix = new Helix(List.of(Cytosine, Adenine, Thymine, Guanine));
        assertThat(helix.complementary()).isEqualTo(complementaryHelix);
    }
}
