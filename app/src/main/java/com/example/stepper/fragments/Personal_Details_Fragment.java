package com.example.stepper.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.stepper.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Personal_Details_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Personal_Details_Fragment extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  TextInputLayout nameTextInput;
   public TextInputEditText nameEditText;
    private TextInputEditText number;
    private TextInputEditText email;
    private  TextInputEditText zipcode;

    boolean checked = false;

    public Personal_Details_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Personal_Details_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Personal_Details_Fragment newInstance(String param1, String param2) {
        Personal_Details_Fragment fragment = new Personal_Details_Fragment();
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

        View v = inflater.inflate(R.layout.fragment_personal__details_, container, false);
       nameTextInput = v.findViewById(R.id.name_text_input);
        nameEditText = (TextInputEditText) v.findViewById(R.id.name_edit_text);
       number =(TextInputEditText) v.findViewById(R.id.number_edit_text);
       email = (TextInputEditText) v.findViewById(R.id.Email_edit_text);
       zipcode = (TextInputEditText) v.findViewById(R.id.Zipcode_edit_text);

        return v;

    }



    public boolean Validations(){
        if (nameEditText.length() == 0) {
            nameEditText.setError("This field is required");
            return false;
        }else if(!(nameEditText.getText().toString().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")))
        {
            nameEditText.requestFocus();
            nameEditText.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        }
        if (email.length() == 0) {
            email.setError("Email is required");
            return false;
        } else if(!email.getText().toString().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
        {
            email.requestFocus();
            email.setError("ENTER VALID EMAIL ADDRESS");
            return false;
        }if (number.length() == 0) {
            number.setError("This field is required");
            return false;
        } else if (number.length() < 10) {
            number.setError("This field requires minimum 10 digits");
            return false;
        } else if (number.length() > 10) {
            number.setError("This field can't extend the length of 10 digits");
            return false;
        } else if(!number.getText().toString().matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$"))
        {
            number.requestFocus();
            number.setError("ENTER VALID MOBILE NUMBER");
            return false;
        }  if (zipcode.length() == 0) {
            zipcode.setError("This field is required");
            return false;
        } else if (zipcode.length() < 6) {
            zipcode.setError("Invalid zipcode");
            return false;
        } else if (zipcode.length() > 6) {
            zipcode.setError("Invalid zipcode");
            return false;
        }else if(!zipcode.getText().toString().matches("[0-9]+"))
        {
            zipcode.requestFocus();
            zipcode.setError("PLEASE ENTER VALID ZIP CODE");
            return false;
        }

        else
            return true;

    }



}