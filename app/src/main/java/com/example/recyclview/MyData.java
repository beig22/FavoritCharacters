package com.example.recyclview;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MyData {

    private DatabaseReference mDatabase;

    public MyData() {

//        mDatabase = FirebaseDatabase.getInstance().getReference("characters");
    }

    public List<CharacterModel> getCharacterData() {
        List<CharacterModel> characterModelList = new ArrayList<>();
        CharacterModel aladin = new CharacterModel(1, "aladin", "desc of aladin", R.drawable.download);
        CharacterModel mufasa = new CharacterModel(2, "mufasa", "desc of mufasa", R.drawable.download);
        CharacterModel simba = new CharacterModel(3, "simba", "desc of simba", R.drawable.download);

        characterModelList.add(aladin);
        characterModelList.add(mufasa);
        characterModelList.add(simba);

        return characterModelList;
    }
//
//    public void fetchCharacters() {
//        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                // Get the data from the snapshot
//                CharacterModel data = snapshot.getValue(CharacterModel.class);
//                System.out.println(data);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Handle error
//            }
//        });
//    }

}
