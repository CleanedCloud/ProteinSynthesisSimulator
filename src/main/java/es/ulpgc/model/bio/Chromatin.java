package es.ulpgc.model.bio;

import es.ulpgc.Tuple;
import es.ulpgc.model.bio.acids.nucleic.NucleicAcid;
import es.ulpgc.model.bio.helixes.Helix;

import java.util.ArrayList;
import java.util.List;

import static es.ulpgc.model.bio.Chromatin.Chromosome.*;
import static es.ulpgc.model.bio.helixes.Helix.*;
import static java.lang.Math.*;

public final class Chromatin {
    public final DNA dna;
    public final List<Promoter> promoters;


    public Chromatin(DNA dna, List<Promoter> promoters) {
        this.dna = dna;
        this.promoters = promoters;
    }

    public Helix conductorHelix() {
        return dna.conductorHelix();
    }

    public Helix delayedHelix() {
        return dna.delayedHelix();
    }

    public Gen getGen(int index) {
        return new Gen(this.conductorHelix().from(startIndex(index)).to(stopIndex(index)).get(),
                       this.delayedHelix().from(startIndex(index)).to(stopIndex(index)).get());
    }

    public static List<Chromosome> condense(Tuple<DNA, DNA> dnaTuple) {
        return new ChromosomeList(dnaTuple).get();
    }

    private int stopIndex(int genIndex) {
        return promoters.get(genIndex).stopIndex;
    }

    private int startIndex(int genIndex) {
        return promoters.get(genIndex).startIndex;
    }

    public record DNA(Helix conductorHelix, Helix delayedHelix) {
        public static DNA from(Helix conductorHelix) {
            return new DNA(conductorHelix, conductorHelix.complementary());
        }

        public int size() {
            return conductorHelix.size();
        }
    }

    public record Promoter(int startIndex, int stopIndex) {
    }


    private static class ChromosomeList {
        private final List<Chromosome> chromosomes;

        public ChromosomeList(Tuple<DNA, DNA> dnaTuple) {
            if (dnaTuple.first().size() % humanChromosomeNumber != 0)
                throw new RuntimeException("The size of the dna helix must be a multiple of 23");
            this.chromosomes = chromosomes(dnaTuple);
        }

        private List<Chromosome> chromosomes(Tuple<DNA, DNA> dnaTuple) {
            List<Chromosome> chromosomes = new ArrayList<>();
            for (int startIndex = 0; startIndex < humanChromosomeNumber; startIndex+=getIncrement(dnaTuple.first()))
                chromosomes.add(chromosome(dnaTuple, startIndex));
            return chromosomes;
        }

        private Chromosome chromosome(Tuple<DNA, DNA> dnaTuple, int startIndex) {
            return new Chromosome(chromatid(dnaTuple.first(), startIndex), chromatid(dnaTuple.second(), startIndex));
        }

        private Chromatid chromatid(DNA dna, int startIndex) {
            return new Chromatid(dna.conductorHelix.from(startIndex).to(endIndex(dna, startIndex)).get(),
                                 dna.delayedHelix.from(startIndex).to(endIndex(dna, startIndex)).get());
        }

        private static int endIndex(DNA dna, int startIndex) {
            return min(startIndex + getIncrement(dna), dna.size());
        }

        private static int getIncrement(DNA dna) {
            return dna.size() / humanChromosomeNumber;
        }

        public List<Chromosome> get() {
            return this.chromosomes;
        }
    }

    public record Chromosome(Chromatid firstChromatid, Chromatid secondChromatid) {
        public static int humanChromosomeNumber = 46;

        public record Chromatid(List<NucleicAcid> conductor, List<NucleicAcid> delayed) {
        }
    }
}
