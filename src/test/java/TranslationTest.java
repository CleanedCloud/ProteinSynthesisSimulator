import es.ulpgc.model.bio.acids.amino.AminoAcid;
import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.pools.RibosomePool;
import es.ulpgc.model.bio.proteins.ProteinSerializer;
import es.ulpgc.model.bio.proteins.ProteinStore;
import es.ulpgc.model.bio.proteins.ProteinStoreAction;
import es.ulpgc.model.writers.FileWriter;
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
        new File(resourcePath).delete();
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
        new ARNm(List.of(Adenine, Adenine, Adenine, Adenine, Adenine, Adenine, Adenine, Adenine, Adenine));
        assertThat(readLineOf(resourcePath)).isEqualTo("LysLysLys");
    }

    private String readLineOf(String textFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            return br.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
