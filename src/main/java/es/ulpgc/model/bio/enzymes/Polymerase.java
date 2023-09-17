package es.ulpgc.model.bio.enzymes;

import es.ulpgc.model.Action;
import es.ulpgc.model.Observer;
import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.Nucleus;
import es.ulpgc.model.bio.helixes.ARNm;

import java.util.List;

import static es.ulpgc.model.bio.helixes.Helix.*;

public class Polymerase implements Observer<Nucleus> {
    private List<NucleicAcid> acids;
    private Action action = Action.NullAction();

    public Polymerase(List<NucleicAcid> acids) {
        this.acids = acids;
    }

    public void with(Action action) {
        this.action = action;
    }

    public ARNm transcript() {
        return new ARNm(transcriptAcids());
    }

    private List<NucleicAcid> transcriptAcids() {
        return acids.stream()
                .map(NucleicAcid::transcript)
                .toList();
    }

    @Override
    public void notify(Object object) {
        this.acids = ((Gen) object).nucleicAcids();
        action.act(this.acids);
    }
}
