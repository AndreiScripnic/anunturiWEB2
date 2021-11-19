package com.example.anunturi.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Ad {
    //Modelul tabelului in baza de date
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    private String title, category, fullText;
    private int views;

    public Ad() {
    //Modelul anuntului
    }
    public Ad(String title, String category, String fullText) {
        this.title = title;
        this.category = category;
        this.fullText = fullText;
    }

    //Getterii si setterii
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
