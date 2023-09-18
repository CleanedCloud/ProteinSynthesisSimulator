package es.ulpgc.model.bio.acids;


import java.util.HashMap;
import java.util.Map;

import static es.ulpgc.model.bio.acids.NucleicAcid.*;
import static es.ulpgc.model.bio.helixes.ARNm.*;

public enum AminoAcid {
    Phe, Leu, Iso, Met, Val, Ser, Pro, Thr, Ala, Tyr, Stop, His, Gln, Asn, Lys, Asp, Glu, Cys, Try, Arg, Gly;

    public static final Map<Codon, AminoAcid> aminoAcidMap = new HashMap<>();

    static {
        aminoAcidMap.put(new Codon(Uracil,Uracil,Uracil), Phe);
        aminoAcidMap.put(new Codon(Uracil,Uracil,Cytosine), Phe);
        aminoAcidMap.put(new Codon(Uracil,Uracil,Adenine), Leu);
        aminoAcidMap.put(new Codon(Uracil,Uracil,Guanine), Leu);
        aminoAcidMap.put(new Codon(Cytosine,Uracil,Uracil), Leu);
        aminoAcidMap.put(new Codon(Cytosine,Uracil,Cytosine), Leu);
        aminoAcidMap.put(new Codon(Cytosine,Uracil,Adenine), Leu);
        aminoAcidMap.put(new Codon(Cytosine,Uracil,Guanine), Leu);
        aminoAcidMap.put(new Codon(Adenine,Uracil,Uracil), Iso);
        aminoAcidMap.put(new Codon(Adenine,Uracil,Cytosine), Iso);
        aminoAcidMap.put(new Codon(Adenine,Uracil,Adenine), Iso);
        aminoAcidMap.put(new Codon(Adenine,Uracil,Guanine), Met);
        aminoAcidMap.put(new Codon(Guanine,Uracil,Uracil), Val);
        aminoAcidMap.put(new Codon(Guanine,Uracil,Cytosine), Val);
        aminoAcidMap.put(new Codon(Guanine,Uracil,Adenine), Val);
        aminoAcidMap.put(new Codon(Guanine,Uracil,Guanine), Val);
        aminoAcidMap.put(new Codon(Uracil,Cytosine,Uracil), Ser);
        aminoAcidMap.put(new Codon(Uracil,Cytosine,Cytosine), Ser);
        aminoAcidMap.put(new Codon(Uracil,Cytosine,Adenine), Ser);
        aminoAcidMap.put(new Codon(Uracil,Cytosine,Guanine), Ser);
        aminoAcidMap.put(new Codon(Cytosine,Cytosine,Uracil), Pro);
        aminoAcidMap.put(new Codon(Cytosine,Cytosine,Cytosine), Pro);
        aminoAcidMap.put(new Codon(Cytosine,Cytosine,Adenine), Pro);
        aminoAcidMap.put(new Codon(Cytosine,Cytosine,Guanine), Pro);
        aminoAcidMap.put(new Codon(Adenine,Cytosine,Uracil), Thr);
        aminoAcidMap.put(new Codon(Adenine,Cytosine,Cytosine), Thr);
        aminoAcidMap.put(new Codon(Adenine,Cytosine,Adenine), Thr);
        aminoAcidMap.put(new Codon(Adenine,Cytosine,Guanine), Thr);
        aminoAcidMap.put(new Codon(Guanine,Cytosine,Uracil), Ala);
        aminoAcidMap.put(new Codon(Guanine,Cytosine,Cytosine), Ala);
        aminoAcidMap.put(new Codon(Guanine,Cytosine,Adenine), Ala);
        aminoAcidMap.put(new Codon(Guanine,Cytosine,Guanine), Ala);
        aminoAcidMap.put(new Codon(Uracil,Adenine,Uracil), Tyr);
        aminoAcidMap.put(new Codon(Uracil,Adenine,Cytosine), Tyr);
        aminoAcidMap.put(new Codon(Uracil,Adenine,Adenine), Stop);
        aminoAcidMap.put(new Codon(Uracil,Adenine,Guanine), Stop);
        aminoAcidMap.put(new Codon(Cytosine,Adenine,Uracil), His);
        aminoAcidMap.put(new Codon(Cytosine,Adenine,Cytosine), His);
        aminoAcidMap.put(new Codon(Cytosine,Adenine,Adenine), Gln);
        aminoAcidMap.put(new Codon(Adenine,Adenine,Uracil), Gln);
        aminoAcidMap.put(new Codon(Adenine,Adenine,Cytosine), Asn);
        aminoAcidMap.put(new Codon(Adenine,Adenine,Adenine), Lys);
        aminoAcidMap.put(new Codon(Adenine,Adenine,Guanine), Lys);
        aminoAcidMap.put(new Codon(Guanine,Adenine,Uracil), Asp);
        aminoAcidMap.put(new Codon(Guanine,Adenine,Cytosine), Asp);
        aminoAcidMap.put(new Codon(Guanine,Adenine,Adenine), Glu);
        aminoAcidMap.put(new Codon(Guanine,Adenine,Guanine), Glu);
        aminoAcidMap.put(new Codon(Uracil,Guanine,Uracil), Cys);
        aminoAcidMap.put(new Codon(Uracil,Guanine,Cytosine), Cys);
        aminoAcidMap.put(new Codon(Uracil,Guanine,Adenine), Stop);
        aminoAcidMap.put(new Codon(Uracil,Guanine,Guanine), Try);
        aminoAcidMap.put(new Codon(Cytosine,Guanine,Uracil), Arg);
        aminoAcidMap.put(new Codon(Cytosine,Guanine,Cytosine), Arg);
        aminoAcidMap.put(new Codon(Cytosine,Guanine,Adenine), Arg);
        aminoAcidMap.put(new Codon(Cytosine,Guanine,Guanine), Arg);
        aminoAcidMap.put(new Codon(Adenine,Guanine,Uracil), Ser);
        aminoAcidMap.put(new Codon(Adenine,Guanine,Guanine), Ser);
        aminoAcidMap.put(new Codon(Adenine,Guanine,Adenine), Arg);
        aminoAcidMap.put(new Codon(Adenine,Guanine,Cytosine), Arg);
        aminoAcidMap.put(new Codon(Guanine,Guanine,Uracil), Gly);
        aminoAcidMap.put(new Codon(Guanine,Guanine,Cytosine), Gly);
        aminoAcidMap.put(new Codon(Guanine,Guanine,Adenine), Gly);
        aminoAcidMap.put(new Codon(Guanine,Guanine,Guanine), Gly);
    }
}
