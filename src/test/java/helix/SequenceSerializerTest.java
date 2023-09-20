package helix;

import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.serializers.SequenceSerializer;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

import static es.ulpgc.model.bio.acids.NucleicAcid.*;
import static es.ulpgc.model.bio.acids.NucleicAcid.Cytosine;

public class SequenceSerializerTest {

    @Test
    public void should_return_serialized_sequence() {
        Helix helix = new Helix(List.of(Guanine, Thymine, Adenine, Cytosine));
        String serializedHelix = new SequenceSerializer().serialize(helix);
        assertThat(serializedHelix).isEqualTo("GTAC");
    }
}
