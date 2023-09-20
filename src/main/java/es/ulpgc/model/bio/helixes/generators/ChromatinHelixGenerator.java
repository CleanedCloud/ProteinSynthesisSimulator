package es.ulpgc.model.bio.helixes.generators;

import es.ulpgc.model.bio.acids.NucleicAcid;
import es.ulpgc.model.bio.helixes.Helix;
import es.ulpgc.model.bio.helixes.HelixGenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static es.ulpgc.model.bio.acids.NucleicAcid.*;

public class ChromatinHelixGenerator extends HelixGenerator {
    public static List<NucleicAcid> acids = List.of(Adenine, Thymine, Guanine, Cytosine);
    public final Random randomizer;

    public ChromatinHelixGenerator(int seed) {
        this.randomizer = new Random(seed);
    }

    @Override
    public Helix generateHelixOfSize(int n) {
        return new Helix(IntStream.range(0,n).mapToObj(i -> acids.get(getRandomIndex())).toList());
    }

    private int getRandomIndex() {
        return randomizer.nextInt(acids.size());
    }
}
