package com.example.recyclview;

import android.os.Build;

import java.util.List;
import java.util.Optional;

public class CharacterAPI {

    MyData characterData;

    public CharacterAPI() {
        characterData = new MyData();
    }

    public List<CharacterModel> getAllCharacter() {
        return characterData.getCharacterData();
    }

    public Optional<CharacterModel> getCharacterById(Integer characterId) {
        return characterData.getCharacterData().stream()
                .filter(character -> character.getId() == characterId)
                .findFirst();

    }
}
