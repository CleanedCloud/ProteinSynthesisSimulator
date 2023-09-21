package enzymes;

import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.enzymes.Polymerase;
import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.helixes.Helix;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.NucleicAcid.*;
import static es.ulpgc.model.bio.acids.NucleicAcid.Cytosine;
import static es.ulpgc.model.bio.helixes.Helix.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PolymeraseTest {
    private Polymerase polymerase;
    private Gen gen;

    @Before
    public void setUp() {
        this.polymerase = new Polymerase();
        List<NucleicAcid> nucleicAcidsFromConductorHelix = new Helix(List.of(Guanine, Thymine, Adenine, Cytosine)).nucleicAcids();
        List<NucleicAcid> nucleicAcidsFromDelayedHelix = new Helix(List.of(Cytosine, Adenine, Thymine, Guanine)).nucleicAcids();
        this.gen = new Gen(nucleicAcidsFromConductorHelix, nucleicAcidsFromDelayedHelix);
    }

    @Test
    public void should_return_transcribed_helix() {
        assertThat(polymerase.transcript(gen)).isEqualTo(new ARNm(List.of(Cytosine, Adenine, Uracil, Guanine)));
    }
}
