package es.ulpgc.model.bio;

import es.ulpgc.model.bio.acids.AminoAcid;

import java.util.List;

public record Protein(List<AminoAcid> acids) {
}
