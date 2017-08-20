package com.example.gogodr.edhlifecounter.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gogodr.edhlifecounter.R;
import com.example.gogodr.edhlifecounter.lifecounter.components.counter.CounterFragment;
import com.example.gogodr.edhlifecounter.lifecounter.players_2.IPlayer2View;
import com.example.gogodr.edhlifecounter.models.IPlayerActions;
import com.example.gogodr.edhlifecounter.models.Player;
import com.example.gogodr.edhlifecounter.models.Player.State;

import java.util.ArrayList;
import java.util.List;

import static com.example.gogodr.edhlifecounter.models.Player.State.COMMANDER_DAMAGE;
import static com.example.gogodr.edhlifecounter.models.Player.State.LIFE;
import static com.example.gogodr.edhlifecounter.models.Player.State.POISON;

public class Players2Activity extends AppCompatActivity implements IPlayer2View {

    CounterFragment player1Fragment, player2Fragment;
    List<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players2);
        this.initialize();
    }

    @Override
    public void initialize() {
        players = new ArrayList<>();
        players.add(new Player("player 1", 40, 0, new ArrayList<Integer>()));
        players.add(new Player("player 2", 40, 0, new ArrayList<Integer>()));

        player1Fragment = CounterFragment.newInstance(0, new IPlayerActions() {
            @Override
            public void add(int playerId, int amount) {
                Player player = players.get(playerId);
                switch (player.getState()) {
                    case LIFE:
                        player.setLife(player.getLife() + amount);
                        break;
                    case POISON:
                        player.setPoison(player.getPoison() + amount);
                        break;
                    case COMMANDER_DAMAGE:
                        List<Integer> cd = players.get(player1Fragment.getPlayerId()).getCommanderDamage();
                        cd.set(playerId, cd.get(playerId) + amount);
                        break;
                }
            }

            @Override
            public void toggleState(int playerId, State state) {
                switch (state) {
                    case LIFE:
                        for (int i = 0; i < players.size(); i++) {
                            Player player = players.get(i);
                            player.setState(i == playerId ? POISON : COMMANDER_DAMAGE);
                        }
                        break;
                    case POISON:
                        for (int i = 0; i < players.size(); i++) {
                            Player player = players.get(i);
                            player.setState(LIFE);
                        }
                        break;
                    default:
                        break;
                }
            }
        }, true);

        player2Fragment = CounterFragment.newInstance(1, new IPlayerActions() {
            @Override
            public void add(int playerId, int amount) {
                Player player = players.get(playerId);
                switch (player.getState()) {
                    case LIFE:
                        player.setLife(player.getLife() + amount);
                        break;
                    case POISON:
                        player.setPoison(player.getPoison() + amount);
                        break;
                    case COMMANDER_DAMAGE:
                        List<Integer> cd = players.get(player1Fragment.getPlayerId()).getCommanderDamage();
                        cd.set(playerId, cd.get(playerId) + amount);
                        break;
                }
            }

            @Override
            public void toggleState(int playerId, State state) {
                switch (state) {
                    case LIFE:
                        for (int i = 0; i < players.size(); i++) {
                            Player player = players.get(i);
                            player.setState(i == playerId ? POISON : COMMANDER_DAMAGE);
                        }
                        break;
                    case POISON:
                        for (int i = 0; i < players.size(); i++) {
                            Player player = players.get(i);
                            player.setState(LIFE);
                        }
                        break;
                    default:
                        break;
                }
            }
        }, false);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.player1, this.player1Fragment);
        transaction.replace(R.id.player2, this.player2Fragment);
        transaction.commit();

    }
}
