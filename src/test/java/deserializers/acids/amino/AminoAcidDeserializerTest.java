package deserializers.acids.amino;

import es.ulpgc.model.bio.acids.amino.AminoAcid;
import es.ulpgc.model.bio.acids.amino.AminoAcidDeserializer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static es.ulpgc.model.bio.acids.amino.AminoAcid.NativeAminoAcidDeserializer;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AminoAcidDeserializerTest {
    AminoAcidDeserializer deserializer;
    List<AminoAcid> aminoAcids = Arrays.asList(AminoAcid.values());
    List<String> StringAminoAcids = List.of("Phe", "Leu", "Iso", "Met", "Val", "Ser", "Pro", "Thr", "Ala",
                                             "Tyr", "Stop", "His", "Gln", "Asn", "Lys", "Asp", "Glu", "Cys", "Try",
                                             "Arg", "Gly");

    @Before
    public void setUp() {
        deserializer = new NativeAminoAcidDeserializer();
    }

    @Test
    public void should_return_Phe() {
        List<AminoAcid> list = StringAminoAcids.stream().map(s -> deserializer.deserialize(s)).toList();
        assertThat(list).isEqualTo(aminoAcids);
    }
}
