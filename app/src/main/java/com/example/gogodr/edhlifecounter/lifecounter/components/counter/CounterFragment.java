package com.example.gogodr.edhlifecounter.lifecounter.components.counter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gogodr.edhlifecounter.R;
import com.example.gogodr.edhlifecounter.models.IPlayerActions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class CounterFragment extends Fragment {

    private IPlayerActions actions;
    private int id;
    private boolean flip;

    @BindView(R.id.playerContainer)
    ConstraintLayout playerContainer;


    public CounterFragment() {
    }

    public static CounterFragment newInstance(int id, IPlayerActions actions, boolean flip) {
        CounterFragment fragment = new CounterFragment();
        fragment.setActions(actions);
        fragment.setId(id);
        fragment.setFlip(flip);
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
        ButterKnife.bind(this, rootView);
        if (this.flip) {
            this.playerContainer.setRotation(180);
        }
        return rootView;
    }

    @OnClick(R.id.leftArea)
    void minus() {
        actions.add(this.id, -1);
    }

    @OnClick(R.id.rightArea)
    void add() {
        actions.add(this.id, 1);
    }

    public void setActions(IPlayerActions actions) {
        this.actions = actions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public int getPlayerId() {
        return this.id;
    }

    ;
}
