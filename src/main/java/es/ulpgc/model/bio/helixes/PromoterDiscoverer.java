package es.ulpgc.model.bio.helixes;

import java.util.List;

import static es.ulpgc.model.bio.Chromatin.Promoter;

public interface PromoterDiscoverer {
    List<Promoter> discover(Helix helix);
}
