package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;
import es.ulpgc.model.bio.helixes.ARNm;
import es.ulpgc.model.bio.helixes.Helix.Gen;

import java.util.List;

public class Polymerase implements Enzyme {
    public ARNm transcript(Gen gen) {
        return new ARNm(transcript(gen.conductorNucleicAcids()));
    }

    private List<NucleicAcid> transcript(List<NucleicAcid> acids) {
        return acids.stream().map(NucleicAcid::transcript).toList();
    }
}
