package com.example.guitarhelper.ui.tuning;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.guitarhelper.R;

public class TuningFragment extends Fragment {

    private TuningViewModel tuningViewModel;
    private ToggleButton tuning_btn;
    private boolean playing = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        tuningViewModel =
                ViewModelProviders.of(this).get(TuningViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tuning, container, false);
        final TextView textView = root.findViewById(R.id.text_tuning);
        tuningViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        this.tuning_btn = (ToggleButton)root.findViewById(R.id.toggleButton);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        final MediaPlayer mp = MediaPlayer.create(view.getContext(), R.raw.tuning_note);

        this.tuning_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked) {
                    if (!playing){
                        mp.setLooping(true);
                        mp.start();
                        playing = true;
                    }
                }
                else {
                    if(playing){
                        mp.pause();
                        playing = false;
                    }
                }
            }
        });
    }
}