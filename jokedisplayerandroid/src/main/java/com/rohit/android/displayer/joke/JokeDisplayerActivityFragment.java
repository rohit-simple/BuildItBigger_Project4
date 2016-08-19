package com.rohit.android.displayer.joke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeDisplayerActivityFragment extends Fragment {

    public JokeDisplayerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke_displayer, container, false);

        Intent intent = getActivity().getIntent();
        if(intent != null){
            if(intent.hasExtra(Intent.EXTRA_TEXT)){
                TextView textView = (TextView) view.findViewById(R.id.jokeTextView);
                textView.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
        return view;
    }
}
