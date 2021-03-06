package com.example.gogodr.edhlifecounter.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.example.gogodr.edhlifecounter.R;
import com.example.gogodr.edhlifecounter.lifecounter.components.counter.CounterFragment;
import com.example.gogodr.edhlifecounter.lifecounter.players_2.IPlayer2View;
import com.example.gogodr.edhlifecounter.lifecounter.players_2.Player2Presenter;
import com.example.gogodr.edhlifecounter.lifecounter.players_6.IPlayer6View;
import com.example.gogodr.edhlifecounter.lifecounter.players_6.Player6Presenter;
import com.example.gogodr.edhlifecounter.models.IPlayerActions;

import java.util.ArrayList;
import java.util.List;

public class Players6Activity extends AppCompatActivity implements IPlayer6View {
    List<CounterFragment> playerFragments;
    Player6Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players6);
        this.initialize();
    }

    @Override
    public void initialize() {
        presenter = new Player6Presenter(this);
        playerFragments = new ArrayList<>();

        for (int i = 0; i <= 6; i++) {
            boolean flip = i % 2 == 0;
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
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                }
            }, flip));
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.player1, playerFragments.get(0));
        transaction.replace(R.id.player2, playerFragments.get(1));
        transaction.replace(R.id.player3, playerFragments.get(2));
        transaction.replace(R.id.player4, playerFragments.get(3));
        transaction.replace(R.id.player5, playerFragments.get(4));
        transaction.replace(R.id.player6, playerFragments.get(5));
        transaction.commit();

    }

    @Override
    public void updateValue(int playerId, String value) {
        playerFragments.get(playerId).setText(value);
        AnimationSet animationset = new AnimationSet(true);
        Animation animation = new AlphaAnimation(0.5f,1);
        animation.setDuration(200);
        animation.setInterpolator(new DecelerateInterpolator(0.5f));
        Animation animation2 = new ScaleAnimation(0.9f,1,0.9f,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation2.setDuration(200);
        animation2.setInterpolator(new DecelerateInterpolator(0.5f));
        animationset.addAnimation(animation);
        animationset.addAnimation(animation2);

        playerFragments.get(playerId).counterTxt.setAnimation(animationset);
    }
}
