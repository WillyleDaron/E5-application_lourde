package com.example.mangamanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Manga> mangaList = new ArrayList<>();
    private MangaAdapter mangaAdapter;
    private RecyclerView mangaRecyclerView;
    private EditText searchEditText;
    private Spinner genreSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mangaRecyclerView = findViewById(R.id.mangaRecyclerView);
        searchEditText = findViewById(R.id.searchEditText);
        genreSpinner = findViewById(R.id.genreSpinner);

        // Initialisation de l'adaptateur et du RecyclerView
        mangaAdapter = new MangaAdapter(mangaList, this);
        mangaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mangaRecyclerView.setAdapter(mangaAdapter);

        // Remplir la liste de manga avec des données de test
        mangaList.add(new Manga(1, R.drawable.solo, "Solo leveling", "Chu-Gong","Webtoon"));
        mangaList.add(new Manga(2, "https://example.com/manga2.jpg", "Manga 2", "Genre 2"));
        mangaList.add(new Manga(3, "https://example.com/manga3.jpg", "Manga 3", "Genre 1"));
        mangaList.add(new Manga(4, "https://example.com/manga4.jpg", "Manga 4", "Genre 2"));
        mangaAdapter.notifyDataSetChanged();

        // Gestionnaire d'événements pour la recherche par titre
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String searchText = charSequence.toString().toLowerCase();
                List<Manga> filteredMangaList = new ArrayList<>();

                for (Manga manga : mangaList) {
                    if (manga.getTitle().toLowerCase().contains(searchText)) {
                        filteredMangaList.add(manga);
                    }
                }

                mangaAdapter = new MangaAdapter(filteredMangaList, MainActivity.this);
                mangaRecyclerView.setAdapter(mangaAdapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        // Gestionnaire d'événements pour la recherche par genre
        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedGenre = adapterView.getItemAtPosition(i).toString();
                List<Manga> filteredMangaList = new ArrayList<>();

                for (Manga manga : mangaList) {
                    if (manga.getGenre().equals(selectedGenre)) {
                        filteredMangaList.add(manga);
                    }
                }

                mangaAdapter = new MangaAdapter(filteredMangaList, MainActivity.this);
                mangaRecyclerView.setAdapter(mangaAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}

