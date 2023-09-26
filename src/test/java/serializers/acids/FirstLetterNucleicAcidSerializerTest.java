package serializers.acids;

import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;
import es.ulpgc.model.bio.acids.nucleic.NucleicAcidSerializer;
import es.ulpgc.model.bio.acids.nucleic.serializers.FirstLetterNucleicAcidSerializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstLetterNucleicAcidSerializerTest {
    List<NucleicAcid> acids = Arrays.asList(NucleicAcid.values());
    List<String> stringNucleicAcids = List.of("A", "T", "G", "C", "U");
    NucleicAcidSerializer serializer;

    @Before
    public void setUp() {
        serializer = new FirstLetterNucleicAcidSerializer();
    }

    @Test
    public void should_return_serialized_nucleic_acids_list() {
        assertThat(acids.stream().map(acid -> serializer.serialize(acid)).toList()).isEqualTo(stringNucleicAcids);
    }
}
