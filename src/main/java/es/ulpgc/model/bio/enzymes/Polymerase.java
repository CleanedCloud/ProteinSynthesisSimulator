package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.Action;
import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.helixes.ARNm;

import java.util.List;

public class Polymerase implements Enzyme {
    private Action action = Action.NullAction();

    @Override
    public void with(Action action) {
        this.action = action;
    }

    public ARNm transcript(List<NucleicAcid> acids) {
        return new ARNm(transcriptAcids(acids));
    }

    private List<NucleicAcid> transcriptAcids(List<NucleicAcid> acids) {
        return acids.stream()
                .map(NucleicAcid::transcript)
                .toList();
    }
}
