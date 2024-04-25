package com.example.androidvocab;

public class VocabModel {
    String term;
    String def;
    String ipa;
    int id;

    public VocabModel(int id, String term, String def, String ipa) {
        this.id = id;
        this.term = term;
        this.def = def;
        this.ipa = ipa;
    }
}
