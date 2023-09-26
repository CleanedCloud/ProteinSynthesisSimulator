package enzymes;

import es.ulpgc.model.bio.Protein;
import es.ulpgc.model.bio.enzymes.Ribosome;
import es.ulpgc.model.bio.helixes.ARNm;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.amino.AminoAcid.*;
import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RibosomeTest {
    Ribosome ribosome;

    @Before
    public void setUp() throws Exception {
        ribosome = new Ribosome();
    }

    @Test
    public void should_return_protein() {
        ARNm arnm = new ARNm(List.of(Adenine, Guanine, Cytosine, Uracil, Adenine, Guanine));
        assertThat(ribosome.translate(arnm)).isEqualTo(new Protein(List.of(Arg, Stop)));
    }
}
