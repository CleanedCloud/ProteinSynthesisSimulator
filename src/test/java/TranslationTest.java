import es.ulpgc.model.bio.acids.amino.AminoAcid;
import es.ulpgc.model.bio.acids.amino.ProteinSerializer;
import es.ulpgc.model.bio.acids.amino.ProteinStore;
import es.ulpgc.model.bio.acids.amino.ProteinStoreAction;
import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.pools.RibosomePool;
import es.ulpgc.model.writers.FileWriter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.Adenine;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TranslationTest {
    static String resourcePath = "./protein.txt";

    @Before
    public void setUp() throws Exception {
        RibosomePool ribosomePool = new RibosomePool();
        ribosomePool.generateEnzymes(50);
        ribosomePool.with(storeAction());
        ARNm.staticAdd(ribosomePool);
    }

    private static ProteinStoreAction storeAction() {
        return new ProteinStoreAction(
                        ProteinStore.create(
                                    new FileWriter(),
                                    ProteinSerializer.create(
                                                new AminoAcid.NativeAminoAcidSerializer()))).in(resourcePath);
    }

    @Test
    public void should_create_Protein() {
        new ARNm(List.of(Adenine, Adenine, Adenine,
                                     Adenine, Adenine, Adenine,
                                     Adenine, Adenine, Adenine));
        assertThat(readLineOf(resourcePath)).isEqualTo("LysLysLys");

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
