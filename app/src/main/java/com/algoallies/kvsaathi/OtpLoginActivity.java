package com.algoallies.kvsaathi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class OTPVerificationActivity extends AppCompatActivity {

    private EditText etOtp1, etOtp2, etOtp3, etOtp4;
    private Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_login);

        etOtp1 = findViewById(R.id.et_otp_1);
        etOtp2 = findViewById(R.id.et_otp_2);
        etOtp3 = findViewById(R.id.et_otp_3);
        etOtp4 = findViewById(R.id.et_otp_4);
        btnVerify = findViewById(R.id.btn_verify);

        etOtp1.addTextChangedListener(new GenericTextWatcher(etOtp1));
        etOtp2.addTextChangedListener(new GenericTextWatcher(etOtp2));
        etOtp3.addTextChangedListener(new GenericTextWatcher(etOtp3));
        etOtp4.addTextChangedListener(new GenericTextWatcher(etOtp4));

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = etOtp1.getText().toString() +
                        etOtp2.getText().toString() +
                        etOtp3.getText().toString() +
                        etOtp4.getText().toString();
                // Handle OTP verification logic here
            }
        });
    }

    private class GenericTextWatcher implements TextWatcher {

        private final View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) { }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()) {
                case R.id.et_otp_1:
                    if (s.length() == 1)
                        etOtp2.requestFocus();
                    break;
                case R.id.et_otp_2:
                    if (s.length() == 1)
                        etOtp3.requestFocus();
                    else if (s.length() == 0)
                        etOtp1.requestFocus();
                    break;
                case R.id.et_otp_3:
                    if (s.length() == 1)
                        etOtp4.requestFocus();
                    else if (s.length() == 0)
                        etOtp2.requestFocus();
                    break;
                case R.id.et_otp_4:
                    if (s.length() == 0)
                        etOtp3.requestFocus();
                    break;
            }
        }
    }
}
