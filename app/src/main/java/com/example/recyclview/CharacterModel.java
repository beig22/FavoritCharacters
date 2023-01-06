package com.example.recyclview;

public class CharacterModel {
    Integer id;
    String name;
    String description;
    Integer image;

    public CharacterModel() {
    }

    public CharacterModel(Integer id, String name, String description, Integer image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImage() {
        return this.image;
    }
}
