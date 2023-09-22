package es.ulpgc.model.bio.acids.nucleic;

public enum NucleicAcid {
    Adenine {
        public NucleicAcid complementary() { return Thymine; }
        public NucleicAcid transcript() { return Uracil; }
    },
    Thymine {
        public NucleicAcid complementary() { return Adenine; }
        public NucleicAcid transcript() { return Adenine; }
    },
    Guanine {
        public NucleicAcid complementary() { return Cytosine; }
        public NucleicAcid transcript() { return Cytosine; }
    },
    Cytosine {
        public NucleicAcid complementary() { return Guanine; }
        public NucleicAcid transcript() { return Guanine; }
    },
    Uracil {
        public NucleicAcid complementary() { return Thymine; }
        public NucleicAcid transcript() { return Thymine; }
    };

    public abstract NucleicAcid complementary();
    public abstract NucleicAcid transcript();

    public static class NativeNucleicAcidDeserializer implements NucleicAcidDeserializer {
        @Override
        public NucleicAcid deserialize(String string) {
            return NucleicAcid.valueOf(string);
        }
    }
}
