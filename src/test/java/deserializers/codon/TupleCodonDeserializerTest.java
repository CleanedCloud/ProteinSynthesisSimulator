package deserializers.codon;

import es.ulpgc.model.bio.helixes.ARNm.Codon;
import es.ulpgc.model.bio.helixes.CodonDeserializer;
import es.ulpgc.model.bio.helixes.codon_deserializers.TupleCodonDeserializer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TupleCodonDeserializerTest {
    List<Codon> codons = List.of(Codon.from(List.of(Uracil, Uracil, Cytosine)),
                                 Codon.from(List.of(Uracil, Uracil, Adenine)),
                                 Codon.from(List.of(Uracil,Uracil,Uracil)),
                                 Codon.from(List.of(Uracil,Uracil,Guanine)),
                                 Codon.from(List.of(Cytosine,Uracil,Uracil)));
    List<String> stringTupleCodons = List.of("(Uracil,Uracil,Cytosine)", "(Uracil,Uracil,Adenine)",
                                             "(Uracil,Uracil,Uracil)",  "(Uracil,Uracil,Guanine)",
                                             "(Cytosine,Uracil,Uracil)");
    CodonDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new TupleCodonDeserializer(new NativeNucleicAcidDeserializer());
    }

    @Test
    public void should_return_codons() {
        List<Codon> list = stringTupleCodons.stream().map(s -> deserializer.deserialize(s)).toList();
        assertThat(list).isEqualTo(codons);
    }
}
