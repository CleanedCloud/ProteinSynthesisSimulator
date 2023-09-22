package helix;

import es.ulpgc.model.bio.helixes.ARNm;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ARNmTest {
    private ARNm arnm;

    @Before
    public void setUp() {
        arnm = new ARNm(List.of(Adenine, Guanine, Cytosine, Uracil, Adenine, Guanine));
    }

    @Test
    public void should_return_a_list_of_two_codons() {
        List<ARNm.Codon> expected = List.of(new ARNm.Codon(Adenine, Guanine, Cytosine),
                                            new ARNm.Codon(Uracil, Adenine, Guanine));
        assertThat(arnm.codons()).isEqualTo(expected);
    }
}
