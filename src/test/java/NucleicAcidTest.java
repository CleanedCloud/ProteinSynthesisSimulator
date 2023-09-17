import org.junit.Test;

import static es.ulpgc.model.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NucleicAcidTest {

    @Test
    public void test_adenine_complementary() {
        assertThat(Adenine.complementary()).isEqualTo(Thymine);
    }

    @Test
    public void test_uracil_complementary() {
        assertThat(Uracil.complementary()).isEqualTo(Thymine);
    }

    @Test
    public void test_thymine_complementary() {
        assertThat(Thymine.complementary()).isEqualTo(Adenine);
    }

    @Test
    public void test_cytosine_complementary() {
        assertThat(Cytosine.complementary()).isEqualTo(Guanine);
    }

    @Test
    public void test_guanine_complementary() {
        assertThat(Guanine.complementary()).isEqualTo(Cytosine);
    }

    @Test
    public void test_adenine_transcript() {
        assertThat(Adenine.transcript()).isEqualTo(Uracil);
    }

    @Test
    public void test_uracil_transcript() {
        assertThat(Uracil.transcript()).isEqualTo(Thymine);
    }

    @Test
    public void test_thymine_transcript() {
        assertThat(Thymine.transcript()).isEqualTo(Adenine);
    }

    @Test
    public void test_cytosine_transcript() {
        assertThat(Cytosine.transcript()).isEqualTo(Guanine);
    }

    @Test
    public void test_guanine_transcript() {
        assertThat(Guanine.transcript()).isEqualTo(Cytosine);
    }
}
