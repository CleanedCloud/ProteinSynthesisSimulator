package discoverers;

import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.Chromatin.Promoter;
import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer.startComplementaryCodon;
import static es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer.stopComplementaryCodons;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CodonBasedPromoterDiscovererTest {
    CodonBasedPromoterDiscoverer discoverer;

    @Before
    public void setUp() {
        discoverer = new CodonBasedPromoterDiscoverer();
    }

    @Test
    public void should_return_promoter_0_to_8() {
        Helix helix = new Helix(List.of(startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                                        Adenine, Guanine, Cytosine,
                                        stopComplementaryCodons.get(0).a(), stopComplementaryCodons.get(0).b(), stopComplementaryCodons.get(0).c()));
        assertThat(discoverer.discover(helix)).isEqualTo(List.of(new Promoter(0,9)));
    }

    @Test
    public void should_return_promoter_0_to_8_without_stop_codon() {
        Helix helix = new Helix(List.of(startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                                        Adenine, Guanine, Cytosine,
                                        Adenine, Guanine, Cytosine));
        assertThat(discoverer.discover(helix)).isEqualTo(List.of(new Promoter(0,9)));
    }

    @Test
    public void should_return_two_promoters() {
        Helix helix = new Helix(List.of(startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                                        Adenine, Guanine, Cytosine,
                                        Adenine, Guanine, Cytosine,
                                        startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                                        stopComplementaryCodons.get(0).a(), stopComplementaryCodons.get(0).b(), stopComplementaryCodons.get(0).c(),
                                        Adenine, Guanine, Cytosine));
        assertThat(discoverer.discover(helix)).isEqualTo(List.of(new Promoter(0, 15), new Promoter(9, 15)));
    }

    @Test
    public void should_return_two_promoters_without_stop_codon() {
        Helix helix = new Helix(List.of(startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                Adenine, Guanine, Cytosine,
                Adenine, Guanine, Cytosine,
                startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                Adenine, Guanine, Cytosine));
        assertThat(discoverer.discover(helix)).isEqualTo(List.of(new Promoter(0,15), new Promoter(9,15)));
    }

    @Test
    public void should_return_no_promoters() {
        Helix helix = new Helix(List.of(Adenine, Guanine, Cytosine,
                                        Adenine, Guanine, Cytosine,
                                        Adenine, Guanine, Cytosine,
                                        Adenine, Guanine, Cytosine,
                                        Adenine, Guanine, Cytosine));
        assertThat(discoverer.discover(helix)).isEqualTo(List.of());
    }
}
