package com.myblog.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //отвечает за опредеоенную таблицу в базе данных -->для манипуляции данными в табл новый файл repo.
public class Post {
    // id
    @Id //для уникального id (javax.persistence)
    @GeneratedValue (strategy = GenerationType.AUTO)  //для генерации каждый раз нового id автоматически
    private  Long id;

    //создаем переменные для статей (заголовок, анонсы, полный текст)
    private String title, anons, full_text;
    private int views; //кол-во просмотров статей

//конструетор с параметрами
    public Post (String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }
//конструктор без параметров
    public Post() {
    }



    //создаем модель --> для каждой модели свой репозиторий
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

    public String getAnons() {

        return anons;
    }

    public void setAnons(String anons) {

        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
