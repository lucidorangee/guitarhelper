package com.example.guitarhelper.ui.transpose;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.guitarhelper.R;

public class TransposeFragment extends Fragment {

    private TransposeViewModel transposeViewModel;
    private Button transposeBtn;
    private EditText n1, n2, n3, n4, transpose_n;
    private TextView result;


    private String[] notes = {"C", "C#", "D", "D#", "E", "F",
            "F#", "G", "G#", "A", "A#", "B"};
    private String[] minor_notes = {"Cm", "C#m", "Dm", "D#m", "Em", "Fm",
            "F#m", "Gm", "G#m", "Am", "A#m", "Bm"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        transposeViewModel =
                ViewModelProviders.of(this).get(TransposeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_transpose, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        transposeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        this.transposeBtn = (Button)root.findViewById(R.id.transposeBtn);
        this.result = (TextView)root.findViewById(R.id.transposednotes);
        this.n1 = (EditText)root.findViewById(R.id.note1);
        this.n2 = (EditText)root.findViewById(R.id.note2);
        this.n3 = (EditText)root.findViewById(R.id.note3);
        this.n4 = (EditText)root.findViewById(R.id.note4);
        this.transpose_n = (EditText)root.findViewById(R.id.transposePitch);


        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.transposeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = "Transposed:";
                int transpose = 0;
                String str = transpose_n.getText().toString();

                if(str.isEmpty() || !str.matches("[0-9]+?")){
                    output = "Error; transpose value is not a number";
                    result.setText(output);
                    return;
                }
                else{
                    transpose = Integer.valueOf(str);
                }

                // first note
                if(n1.getText().toString().contains("m")){
                    int index = -1;
                    for(int i = 0; i < minor_notes.length; i++){
                        if(n1.getText().toString().equals(minor_notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " "+minor_notes[index];
                    }
                }
                else{
                    int index = -1;
                    for(int i = 0; i < notes.length; i++){
                        if(n1.getText().toString().equals(notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " " + notes[index];
                    }
                }

                // second note
                if(n2.getText().toString().contains("m")){
                    int index = -1;
                    for(int i = 0; i < minor_notes.length; i++){
                        if(n2.getText().toString().equals(minor_notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " "+minor_notes[index];
                    }
                }
                else{
                    int index = -1;
                    for(int i = 0; i < notes.length; i++){
                        if(n2.getText().toString().equals(notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " " + notes[index];
                    }
                }

                // third note
                if(n3.getText().toString().contains("m")){
                    int index = -1;
                    for(int i = 0; i < minor_notes.length; i++){
                        if(n1.getText().toString().equals(minor_notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " "+minor_notes[index];
                    }
                }
                else{
                    int index = -1;
                    for(int i = 0; i < notes.length; i++){
                        if(n3.getText().toString().equals(notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " " + notes[index];
                    }
                }

                // first note
                if(n4.getText().toString().contains("m")){
                    int index = -1;
                    for(int i = 0; i < minor_notes.length; i++){
                        if(n4.getText().toString().equals(minor_notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " "+minor_notes[index];
                    }
                }
                else{
                    int index = -1;
                    for(int i = 0; i < notes.length; i++){
                        if(n4.getText().toString().equals(notes[i])){
                            index = i;
                            break;
                        }
                    }

                    if(index == -1){
                        output = "Error; a note is not valid";
                        result.setText(output);
                        return;
                    }
                    else{
                        index -= transpose;

                        while(index < 0){
                            index += 12;
                        }

                        while(index >= 12){
                            index -= 12;
                        }

                        output += " " + notes[index];
                    }
                }

                result.setText(output);
            }
        });
    }
}