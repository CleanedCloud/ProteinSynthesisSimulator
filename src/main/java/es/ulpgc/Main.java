package es.ulpgc;

import es.ulpgc.model.bio.Chromatin;
import es.ulpgc.model.bio.enzymes.DNAPolymerase;
import es.ulpgc.model.bio.enzymes.Helicase;
import es.ulpgc.model.bio.helixes.Helix;

import java.util.List;

import static es.ulpgc.model.bio.acids.nucleic.NucleicAcid.*;

public class Main {
    public static void main(String[] args) {
        Tuple<Helix, Helix> helixTuple = new Helicase().splitDNA(Chromatin.DNA.from(new Helix(List.of(Adenine, Guanine, Cytosine, Adenine, Guanine, Adenine, Guanine, Adenine, Guanine, Adenine, Guanine))));
        Tuple<Chromatin.DNA, Chromatin.DNA> replicatedDNA = new DNAPolymerase().replicate(helixTuple);
        System.out.println(replicatedDNA.first().conductorHelix().equals(replicatedDNA.second().conductorHelix()));
        System.out.println();
    }
}
