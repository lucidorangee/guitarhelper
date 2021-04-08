package com.example.guitarhelper.ui.transpose;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TransposeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TransposeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is transpose fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}