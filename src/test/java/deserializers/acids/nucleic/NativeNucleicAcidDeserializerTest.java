package deserializers.acids.nucleic;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;
import es.ulpgc.model.bio.acids.nucleic.NucleicAcidDeserializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NativeNucleicAcidDeserializerTest {
    private NucleicAcidDeserializer deserializer;
    List<NucleicAcid> nucleicAcids = Arrays.asList(NucleicAcid.values());
    List<String> stringNucleicAcids = List.of("Adenine", "Thymine", "Guanine", "Cytosine", "Uracil");

    @Before
    public void setUp() {
        deserializer = new NucleicAcid.NativeNucleicAcidDeserializer();
    }

    @Test
    public void should_return_nucleic_acid() {
        List<NucleicAcid> list = stringNucleicAcids.stream().map(s -> deserializer.deserialize(s)).toList();
        assertThat(list).isEqualTo(nucleicAcids);
    }
}
