package com.example.androidvocab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class VocabFragment extends Fragment {

    VocabModel vocab;

    public VocabFragment() {
        // Required empty public constructor
    }
    VocabFragment(VocabModel vocab){
        this.vocab = vocab;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vocab, container, false);
        TextView defTextView = rootView.findViewById(R.id.defTextView);
        TextView ipaTextView = rootView.findViewById(R.id.ipaTextView);

        // Check if vocab is not null before accessing its fields
        if (vocab != null) {
            if (vocab.def != null) {
                defTextView.setText(vocab.def);
            }
            if (vocab.ipa != null) {
                ipaTextView.setText(vocab.ipa);
            }
        }

        return rootView;
    }
}