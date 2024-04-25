package com.example.androidvocab;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DatabaseManager databaseManager = new DatabaseManager(this);
        databaseManager.open();

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        addVocabToSqlite(databaseManager);
        getAndShowVocabs(databaseManager);
    }

    private void getAndShowVocabs(DatabaseManager databaseManager) {
        List<VocabModel> dataList = databaseManager.getAllData();

        ArrayList<VocabModel> listVocab = new ArrayList<>();

        for (VocabModel vocab : dataList) {
            listVocab.add(new VocabModel(vocab.id, vocab.term, vocab.def, vocab.ipa));
        }
        MyAdapter adapter = new MyAdapter(this, listVocab);
        recyclerView.setAdapter(adapter);
    }

    private void addVocabToSqlite(DatabaseManager databaseManager) {
        databaseManager.addData("Cat", "Mèo", "[kæt]");
        databaseManager.addData("Tiger", "Hổ", "[ˈtaɪɡər]");
        databaseManager.addData("Fish", "Cá", "[fɪʃ]");
        databaseManager.addData("Bird", "Chim", "[bɜrd]");
        databaseManager.addData("Elephant", "Voi", "[ˈɛlɪfənt]");
        databaseManager.addData("Snake", "Rắn", "[sneɪk]");
        databaseManager.addData("Monkey", "Khỉ", "[ˈmʌŋki]");
        databaseManager.addData("Bear", "Gấu", "[bɛr]");
        databaseManager.addData("Cow", "Bò", "[kaʊ]");
        databaseManager.addData("Horse", "Ngựa", "[hɔrs]");
        databaseManager.addData("Duck", "Vịt", "[dʌk]");
        databaseManager.addData("Sheep", "Cừu", "[ʃiːp]");
        databaseManager.addData("Goat", "Dê", "[ɡoʊt]");
        databaseManager.addData("Wolf", "Sói", "[wʊlf]");
        databaseManager.addData("Fox", "Cáo", "[fɑks]");
        databaseManager.addData("Rabbit", "Thỏ", "[ˈræbɪt]");
    }
}