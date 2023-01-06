package com.example.recyclview.fragments;


import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recyclview.CharacterAPI;
import com.example.recyclview.CharacterModel;
import com.example.recyclview.MyData;
import com.example.recyclview.R;

import org.w3c.dom.Text;

import java.util.Optional;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterDescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterDescriptionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CharacterAPI data;

    public CharacterDescriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterDescriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterDescriptionFragment newInstance(String param1, String param2) {
        CharacterDescriptionFragment fragment = new CharacterDescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_description, container, false);

        data = new CharacterAPI();

        ImageView charImageView = view.findViewById(R.id.charImage);
        TextView charDescView = view.findViewById(R.id.charDesc);

        Integer charId = getArguments().getInt("id");


        Optional<CharacterModel> characterModelOptional = data.getCharacterById(charId);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            characterModelOptional.ifPresent(characterModel -> {
                charImageView.setImageResource(characterModel.getImage());
                charDescView.setText(characterModel.getDescription());
            });
        }

        return view;
    }
}