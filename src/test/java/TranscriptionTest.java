import es.ulpgc.model.bio.Cell;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.acids.nucleic.serializers.FirstLetterNucleicAcidSerializer;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.HelixStore;
import es.ulpgc.model.bio.helixes.actions.HelixStoreAction;
import es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer;
import es.ulpgc.model.bio.helixes.serializers.helix.SequenceHelixSerializer;
import es.ulpgc.model.bio.pools.PolymerasePool;
import es.ulpgc.model.writers.FileWriter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer.startComplementaryCodon;
import static es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer.stopComplementaryCodons;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TranscriptionTest {
    Cell cell;
    static String resourcePath = "./arnm.txt";

    @Before
    public void setUp() {
        Helix conductor = new Helix(List.of(startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                                            Adenine, Guanine, Cytosine,
                                            Adenine, Guanine, Cytosine,
                                            startComplementaryCodon.a(), startComplementaryCodon.b(), startComplementaryCodon.c(),
                                            stopComplementaryCodons.get(0).a(), stopComplementaryCodons.get(0).b(), stopComplementaryCodons.get(0).c(),
                                            Adenine, Guanine, Cytosine));
        cell = new Cell(new Nucleus(new Chromatin(Chromatin.DNA.from(conductor), new CodonBasedPromoterDiscoverer().discover(conductor))));
        cell.nucleus().add(polymerase());
    }

    private static PolymerasePool polymerase() {
        PolymerasePool polymerasePool = new PolymerasePool();
        polymerasePool.generateEnzymes(50);
        polymerasePool.with(new HelixStoreAction(helixStore()).in(resourcePath));
        return polymerasePool;
    }

    private static HelixStore helixStore() {
        return HelixStore.create(new FileWriter(), new SequenceHelixSerializer(new FirstLetterNucleicAcidSerializer()));
    }

    @Test
    public void activate_and_return_ARNm() {
        cell.nucleus().activate(0);
        assertThat(readLineOf(resourcePath)).isEqualTo("AACUCGUCGAACAA");
    }


    private String readLineOf(String textFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            return br.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void afterClass() {
        new File(resourcePath).delete();
    }
}
