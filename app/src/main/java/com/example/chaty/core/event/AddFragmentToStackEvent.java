package com.example.chaty.core.event;

import com.example.chaty.core.base.BaseFragment;

public class AddFragmentToStackEvent {
    public BaseFragment fragment;
    public int positionMain;
    public int fromPosition;

    public AddFragmentToStackEvent(BaseFragment fragment) {
        this.fragment = fragment;
        positionMain = 0;
        fromPosition = 0;
    }

    public AddFragmentToStackEvent(BaseFragment fragment, int positionMain) {
        this.fragment = fragment;
        this.positionMain = positionMain;
        fromPosition = positionMain;
    }

    public AddFragmentToStackEvent(BaseFragment fragment, int positionMain, int fromPosition) {
        this.fragment = fragment;
        this.positionMain = positionMain;
        this.fromPosition = fromPosition;
    }
}
