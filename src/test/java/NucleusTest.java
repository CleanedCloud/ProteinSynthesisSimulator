import es.ulpgc.model.bio.Cell;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.HelixStore;
import es.ulpgc.model.bio.helixes.actions.HelixStoreAction;
import es.ulpgc.model.bio.helixes.generators.ChromatinHelixGenerator;
import es.ulpgc.model.bio.helixes.serializers.SequenceSerializer;
import es.ulpgc.model.bio.pools.PolymerasePool;
import es.ulpgc.model.writers.FileWriter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NucleusTest {
    Cell cell;
    static String resourcePath = "./arnm.txt";

    @Before
    public void setUp() {
        Helix conductor = new ChromatinHelixGenerator(43).generateHelixOfSize(50);
        cell = new Cell(new Nucleus(Chromatin.from(conductor)));
        cell.nucleus().add(polymerase());
    }

    private static PolymerasePool polymerase() {
        PolymerasePool polymerasePool = new PolymerasePool();
        polymerasePool.generateEnzymes(50);
        polymerasePool.with(new HelixStoreAction(helixStore()).in(resourcePath));
        return polymerasePool;
    }

    private static HelixStore helixStore() {
        return HelixStore.create(new FileWriter(), new SequenceSerializer());
    }

    @Test
    public void activate_and_return_gen() {
        cell.nucleus().activate(0, 10);
        assertThat(readLineOf(resourcePath)).isEqualTo("CAGGGCUUUU");
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
