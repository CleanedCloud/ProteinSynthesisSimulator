package es.ulpgc.model.bio.helixes;

public interface HelixGenerator {
    Helix generateHelixOfSize(int n);
    Helix generateComplementaryOf(Helix helix);

}
