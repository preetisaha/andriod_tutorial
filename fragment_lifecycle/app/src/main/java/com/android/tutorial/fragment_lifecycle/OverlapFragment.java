package com.android.tutorial.fragment_lifecycle;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class OverlapFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(this.getClass().getName(), " =============================== onCreate is running");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(this.getClass().getName(), " =============================== onCreateView is running");
        return inflater.inflate(R.layout.fragment_overlap, container, false);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v(this.getClass().getName(), " =============================== onAttach is running");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(this.getClass().getName(), " =============================== onActivityCreated is running");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(this.getClass().getName(), " =============================== onStart is running");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(this.getClass().getName(), " =============================== onResume is running");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(this.getClass().getName(), " =============================== onPause is running");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(this.getClass().getName(), " =============================== onStop is running");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(this.getClass().getName(), " =============================== onDestroyView is running");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(this.getClass().getName(), " =============================== onDestroy is running");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(this.getClass().getName(), " =============================== onDetach is running");
    }
}
