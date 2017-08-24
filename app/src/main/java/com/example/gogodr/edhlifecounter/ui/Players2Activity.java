package com.example.gogodr.edhlifecounter.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.example.gogodr.edhlifecounter.R;
import com.example.gogodr.edhlifecounter.lifecounter.components.counter.CounterFragment;
import com.example.gogodr.edhlifecounter.lifecounter.players_2.IPlayer2View;
import com.example.gogodr.edhlifecounter.lifecounter.players_2.Player2Presenter;
import com.example.gogodr.edhlifecounter.models.IPlayerActions;

import java.util.ArrayList;
import java.util.List;

public class Players2Activity extends AppCompatActivity implements IPlayer2View {
    List<CounterFragment> playerFragments;
    Player2Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players2);
        this.initialize();
    }

    @Override
    public void initialize() {
        presenter = new Player2Presenter(this);
        playerFragments = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            boolean flip = i < 1;
            playerFragments.add(CounterFragment.newInstance(i, new IPlayerActions() {
                @Override
                public void add(int playerId, int amount) {
                    presenter.add(playerId,amount);
                }

                @Override
                public void toggleState(int playerId) {
                    presenter.toggleState(playerId);
                }

                @Override
                public void playerPrompt(int playerId) {

                }
            }, flip));
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.player1, playerFragments.get(0));
        transaction.replace(R.id.player2, playerFragments.get(1));
        transaction.commit();

    }

    @Override
    public void updateValue(int playerId, String value) {
        playerFragments.get(playerId).setText(value);
        Animation animation = new AlphaAnimation(0.5f,1);
        animation.setDuration(300);
        animation.setInterpolator(new AccelerateInterpolator(0.5f));
        playerFragments.get(playerId).counterTxt.setAnimation(animation);
    }
}
