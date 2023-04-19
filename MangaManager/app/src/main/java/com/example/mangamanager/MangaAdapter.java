package com.example.mangamanager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {
    private List<Manga> mangaList;
    private Context context;

    // Constructeur
    public MangaAdapter(List<Manga> mangaList, Context context) {
        this.mangaList = mangaList;
        this.context = context;
    }

    // Méthodes de RecyclerView.Adapter
    @Override
    public MangaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga, parent, false);
        return new MangaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MangaViewHolder holder, int position) {
        Manga manga = mangaList.get(position);
        Picasso.get().load(manga.getCoverUrl()).into(holder.coverImageView);
        holder.titleTextView.setText(manga.getTitle());
        holder.genreTextView.setText(manga.getGenre());
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    // ViewHolder pour les éléments de la liste
    public class MangaViewHolder extends RecyclerView.ViewHolder {
        public ImageView coverImageView;
        public TextView titleTextView;
        public TextView genreTextView;

        public MangaViewHolder(@NonNull View itemView) {
            super(itemView);

            coverImageView = itemView.findViewById(R.id.coverImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
        }
    }
}
