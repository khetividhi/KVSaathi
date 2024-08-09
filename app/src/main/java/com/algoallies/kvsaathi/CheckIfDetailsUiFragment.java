package com.algoallies.kvsaathi;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CheckIfDetailsUiFragment extends Fragment {
    private ProgressBar progressBar;
    private Handler handler;
    private Runnable runnable;
    private int progress = 0;
    private final int MAX_PROGRESS = 100;
    private final int UPDATE_INTERVAL = 50; // Update interval in milliseconds
    private final int TOTAL_DURATION = 10000; // Total duration in milliseconds

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_if_details_ui, container, false);

        progressBar = view.findViewById(R.id.loadingProgressBar);

        handler = new Handler();
        startProgressBar();

        return view;
    }

    private void startProgressBar() {
        runnable = new Runnable() {
            @Override
            public void run() {
                progress += 5;
                if (progress > MAX_PROGRESS) {
                    progress = 0;
                }
                progressBar.setProgress(progress);

                handler.postDelayed(this, UPDATE_INTERVAL);
            }
        };

        // Start the progress bar update
        handler.post(runnable);

        // Stop the progress bar after TOTAL_DURATION milliseconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacks(runnable);
                progressBar.setProgress(0);
                navigateToDetails2();
            }
        }, TOTAL_DURATION);
    }

    private void navigateToDetails2() {
        Fragment detailsFragment = new details2();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.FrameLayout, detailsFragment); // Replace with your container ID
        transaction.commit();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Remove callbacks to prevent memory leaks
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }

}





// TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public CheckIfDetailsUiFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment CheckIfDetailsUiFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static CheckIfDetailsUiFragment newInstance(String param1, String param2) {
//        CheckIfDetailsUiFragment fragment = new CheckIfDetailsUiFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }