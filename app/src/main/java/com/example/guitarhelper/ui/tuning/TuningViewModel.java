package com.example.guitarhelper.ui.tuning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TuningViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TuningViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tuning fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}