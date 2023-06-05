package com.example.stepper.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.stepper.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Hobby_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Hobby_Fragment extends Fragment {





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public TextInputEditText hobby_edit_text;


    public Hobby_Fragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Hobby_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Hobby_Fragment newInstance(String param1, String param2) {
        Hobby_Fragment fragment = new Hobby_Fragment();
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

        View v = inflater.inflate(R.layout.fragment_hobby_, container, false);
        hobby_edit_text = (TextInputEditText) v.findViewById(R.id.hobby_edit_text);


        return v;
    }

public boolean Validations() {
    if (hobby_edit_text.length() == 0) {
        hobby_edit_text.setError("This field is required");
        return false;
    } else if (!(hobby_edit_text.getText().toString().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$"))) {
        hobby_edit_text.requestFocus();
        hobby_edit_text.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        return false;
    } else
        return true;
}
}