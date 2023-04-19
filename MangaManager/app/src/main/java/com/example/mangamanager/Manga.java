package com.example.mangamanager;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class Manga {
    private int id;
    private int coverUrl;
    private String title;
    private String author;
    private String genre;

    // Constructeur
    public Manga(int id, int coverUrl, String title, String author,String genre) {
        this.id = id;
        this.coverUrl = coverUrl;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public int getCoverUrl() {
        return coverUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
