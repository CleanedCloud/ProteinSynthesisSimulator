package es.ulpgc.model.bio.enzymes;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.Enzyme;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.OkazakiFragment;

import java.util.ArrayList;
import java.util.List;

public class DNAPolymerase implements Enzyme {
    private int OkazakiFragmentSize;
    private static final int desiredPartitions = 10;

    public Tuple<Chromatin.DNA, Chromatin.DNA> replicate(Tuple<Helix, Helix> helixes) {
        OkazakiFragmentSize = helixes.second().size() / partitionsOf(helixes.second());
        return new Tuple<>(replicate(helixes.first()),
                           replicate(okazakiFragmentsOf(helixes.second())));
    }

    private int partitionsOf(Helix helix) {
        return Math.min(desiredPartitions, helix.size());
    }

    private List<OkazakiFragment> okazakiFragmentsOf(Helix helix) {
        List<OkazakiFragment> okazakiFragments = new ArrayList<>();
        for (int i = 0; i < helix.size(); i += OkazakiFragmentSize)
            okazakiFragments.add(new OkazakiFragment(helix.from(i).to(endIndex(i, helix.size())).get()));
        return okazakiFragments;
    }

    private int endIndex(int index, int maxSize) {
        return Math.min(index + OkazakiFragmentSize, maxSize);
    }

    private Chromatin.DNA replicate(List<OkazakiFragment> fragments) {
        return replicate(new Helix(fragments.stream()
                                            .map(Helix::nucleicAcids)
                                            .flatMap(List::stream)
                                            .toList()).complementary());
    }

    private Chromatin.DNA replicate(Helix helix) {
        return new Chromatin.DNA(helix, helix.complementary());
    }
}
