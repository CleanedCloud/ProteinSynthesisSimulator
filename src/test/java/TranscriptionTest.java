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
import static es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer.startCodon;
import static es.ulpgc.model.bio.helixes.generators.CodonBasedPromoterDiscoverer.stopCodons;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TranscriptionTest {
    Cell cell;
    static String resourcePath = "./arnm.txt";

    @Before
    public void setUp() {
        Helix conductor = new Helix(List.of(startCodon.a(), startCodon.b(), startCodon.c(),
                                            Adenine, Guanine, Cytosine,
                                            Adenine, Guanine, Cytosine,
                                            startCodon.a(), startCodon.b(), startCodon.c(),
                                            stopCodons.get(0).a(), stopCodons.get(0).b(), stopCodons.get(0).c(),
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
