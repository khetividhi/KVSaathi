package com.algoallies.kvsaathi;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity  implements LoginUiFragment.OnButtonClickListener {
     ProgressBar progressBar;
     TextView tv;
    int progressStatus = 10;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, LoginUiFragment.class);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);





        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.FrameLayout, new LoginUiFragment())
                    .commit();
        }



    }
    public void navigateToOtpFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.FrameLayout, new OtpUiFragment())
                .addToBackStack(null)
                .commit();
    }

    public void onButtonClicked() {
        navigateToOtpFragment();
        progressStatus += 10;
        progressBar.setProgress(progressStatus);
    }

}
