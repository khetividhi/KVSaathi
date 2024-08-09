package com.algoallies.kvsaathi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class OtpUiFragment extends Fragment {

    private OtpUiFragment.OnButtonClickListener listener;

    public interface OnButtonClickListener {
        void navigateToCheckDetailsFragment();
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OtpUiFragment.OnButtonClickListener) {
            listener = (OtpUiFragment.OnButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnButtonClickListener");
        }
    }


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_otp_ui, container, false);

        ImageView img = view.findViewById(R.id.illustration_image);
        TextView t1 = view.findViewById(R.id.text1);
        TextView t2 = view.findViewById(R.id.text2);
        EditText et1 = view.findViewById(R.id.et_otp_1);
        EditText et2 = view.findViewById(R.id.et_otp_2);
        EditText et3 = view.findViewById(R.id.et_otp_3);
        EditText et4 = view.findViewById(R.id.et_otp_4);
        EditText et5 = view.findViewById(R.id.et_otp_5);
        EditText et6 = view.findViewById(R.id.et_otp_6);
        Button btn = view.findViewById(R.id.btn2);

        // Add TextWatchers to move cursor to next EditText
        setUpOtpEditTexts(et1, et2, et3, et4, et5, et6);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.navigateToCheckDetailsFragment();
                }


            }
        });
        return view;
    }


    private void setUpOtpEditTexts(EditText... editTexts) {
        for (int i = 0; i < editTexts.length; i++) {
            final int currentIndex = i;
            final EditText currentEditText = editTexts[i];

            currentEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 1 && currentIndex < editTexts.length - 1) {
                        editTexts[currentIndex + 1].requestFocus();
                    }
                }
            });
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}



//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private static final String ARG_PARAM1 = "param1";
//private static final String ARG_PARAM2 = "param2";
//
//// TODO: Rename and change types of parameters
//private String mParam1;
//private String mParam2;
//
//public OtpUiFragment() {
//    // Required empty public constructor
//}
//
///**
// * Use this factory method to create a new instance of
// * this fragment using the provided parameters.
// *
// * @param param1 Parameter 1.
// * @param param2 Parameter 2.
// * @return A new instance of fragment OtpUiFragment.
// */
//// TODO: Rename and change types and number of parameters
//public static OtpUiFragment newInstance(String param1, String param2) {
//    OtpUiFragment fragment = new OtpUiFragment();
//    Bundle args = new Bundle();
//    args.putString(ARG_PARAM1, param1);
//    args.putString(ARG_PARAM2, param2);
//    fragment.setArguments(args);
//    return fragment;
//}
//
//@Override
//public void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    if (getArguments() != null) {
//        mParam1 = getArguments().getString(ARG_PARAM1);
//        mParam2 = getArguments().getString(ARG_PARAM2);
//    }
//}
//
