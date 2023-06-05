package com.example.stepper.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stepper.R;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Qualification_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Qualification_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public TextInputEditText secondary_edit_text;
    private TextInputEditText higher_secondary_edit_text;
    private TextInputEditText graduation_edit_text;
    private  TextInputEditText postgrad_edit_text;

    public Qualification_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Qualification_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Qualification_Fragment newInstance(String param1, String param2) {
        Qualification_Fragment fragment = new Qualification_Fragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_qualification_, container, false);

        secondary_edit_text = (TextInputEditText) v.findViewById(R.id.secondary_edit_text);
        higher_secondary_edit_text =(TextInputEditText) v.findViewById(R.id.highersecondary_edit_text);
        graduation_edit_text = (TextInputEditText) v.findViewById(R.id.graduation_edit_text);
        postgrad_edit_text = (TextInputEditText) v.findViewById(R.id.postgrad_edit_text);
        return v;
    }
    public boolean Validations(){
        if (secondary_edit_text.length() == 0) {
            secondary_edit_text.setError("This field is required");
            return false;
        }
        else if (higher_secondary_edit_text.length() == 0) {
            higher_secondary_edit_text.setError("Email is required");
            return false;
        } else if (graduation_edit_text.length() == 0) {
            graduation_edit_text.setError("This field is required");
            return false;
        } else if (postgrad_edit_text.length() == 0) {
            postgrad_edit_text.setError("This field is required");
            return false;
        }

        else
            return true;

    }
}