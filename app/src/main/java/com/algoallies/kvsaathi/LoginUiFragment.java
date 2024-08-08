package com.algoallies.kvsaathi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginUiFragment extends Fragment {

    int progress = 0;
    private OnButtonClickListener listener;




    public interface OnButtonClickListener {
        void onButtonClicked();
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonClickListener) {
            listener = (OnButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_ui2, container, false);

        TextView  tv = view.findViewById(R.id.PBText);
        ImageView img = view.findViewById(R.id.illustration_image);
        TextView t1 = view.findViewById(R.id.text1);
        TextView t2 = view.findViewById(R.id.text2);
        TextView t3 = view.findViewById(R.id.text3);
        EditText editText = view.findViewById(R.id.inputMobile);
        Button btn = view.findViewById(R.id.btn1);
        ProgressBar progressBar = view.findViewById(R.id.progress_bar);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = editText.getText().toString();
                    if (isValidPhoneNumber(phoneNumber)) {
                        if (listener != null) {
                            listener.onButtonClicked();
                        }

                    } else {
                        Toast.makeText(getContext(), "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                    }
            }
        });


        return view;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        char fn = phoneNumber.charAt(0);
        int fn1 = Character.getNumericValue(fn);

        if(fn1 < 6){
            if (!TextUtils.isEmpty(phoneNumber) && phoneNumber.length() == 10) {
                TextUtils.isDigitsOnly(phoneNumber) ;
            }
            return false;
        }
        else{
            return !TextUtils.isEmpty(phoneNumber) && phoneNumber.length() == 10 && TextUtils.isDigitsOnly(phoneNumber) ;
        }


    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
