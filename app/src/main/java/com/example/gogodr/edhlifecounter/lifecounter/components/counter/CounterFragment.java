package com.example.gogodr.edhlifecounter.lifecounter.components.counter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gogodr.edhlifecounter.R;
import com.example.gogodr.edhlifecounter.models.IPlayerActions;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class CounterFragment extends Fragment {

    private IPlayerActions actions;
    private int id;


    public CounterFragment() {
    }

    public CounterFragment newInstance(int id, IPlayerActions actions) {
        CounterFragment fragment = new CounterFragment();
        fragment.setActions(actions);
        fragment.setId(id);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_counter, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @OnClick(R.id.leftArea) void minus(){
        actions.minus();
    }
    @OnClick(R.id.rightArea) void add(){
        actions.add();
    }

    public void setActions(IPlayerActions actions) {
        this.actions = actions;
    }

    public void setId(int id) {
        this.id = id;
    }
}
