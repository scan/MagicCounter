package de.functional_games.magic_counter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_HP_PLAYER = "hpPlayer";
    private static final String KEY_HP_OPPONENT = "hpOpponent";
    private static final String KEY_ENERGY_PLAYER = "energyPlayer";
    private static final String KEY_ENERGY_OPPONENT = "energyOpponent";

    @BindView(android.R.id.text1)
    TextView counterPlayer;
    @BindView(android.R.id.text2)
    TextView counterOpponent;
    @BindView(R.id.energyText1)
    TextView energyCounterPlayer;
    @BindView(R.id.energyText2)
    TextView energyCounterOpponent;

    private int hpPlayer = 20;
    private int hpOpponent = 20;
    private int energyPlayer = 0;
    private int energyOpponent = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            hpPlayer = savedInstanceState.getInt(KEY_HP_PLAYER);
            hpOpponent = savedInstanceState.getInt(KEY_HP_OPPONENT);
            energyPlayer = savedInstanceState.getInt(KEY_ENERGY_PLAYER);
            energyOpponent = savedInstanceState.getInt(KEY_ENERGY_OPPONENT);
        }

        setTextViews();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(KEY_HP_PLAYER, hpPlayer);
        outState.putInt(KEY_HP_OPPONENT, hpOpponent);
        outState.putInt(KEY_ENERGY_PLAYER, energyPlayer);
        outState.putInt(KEY_ENERGY_OPPONENT, energyOpponent);

        super.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        hpPlayer = savedInstanceState.getInt(KEY_HP_PLAYER);
        hpOpponent = savedInstanceState.getInt(KEY_HP_OPPONENT);
        energyPlayer = savedInstanceState.getInt(KEY_ENERGY_PLAYER);
        energyOpponent = savedInstanceState.getInt(KEY_ENERGY_OPPONENT);
        setTextViews();
    }

    @OnClick(R.id.buttonMinus1)
    public void onPlayerMinus() {
        hpPlayer--;
        if(hpPlayer < 0) {
            hpPlayer = 0;
        }
        setTextViews();
    }

    @OnClick(R.id.buttonMinus2)
    public void onOpponentMinus() {
        hpOpponent--;
        if(hpOpponent < 0) {
            hpOpponent = 0;
        }
        setTextViews();
    }

    @OnClick(R.id.buttonPlus1)
    public void onPlayerPlus() {
        hpPlayer++;
        setTextViews();
    }

    @OnClick(R.id.buttonPlus2)
    public void onOpponentPlus() {
        hpOpponent++;
        setTextViews();
    }

    @OnClick(R.id.buttonEnergyMinus1)
    public void onPlayerEnergyMinus() {
        energyPlayer--;
        if(energyPlayer < 0) {
            energyPlayer = 0;
        }
        setTextViews();
    }

    @OnClick(R.id.buttonEnergyMinus2)
    public void onOpponentEnergyMinus() {
        energyOpponent--;
        if(energyOpponent < 0) {
            energyOpponent = 0;
        }
        setTextViews();
    }

    @OnClick(R.id.buttonEnergyPlus1)
    public void onPlayerEnergyPlus() {
        energyPlayer++;
        setTextViews();
    }

    @OnClick(R.id.buttonEnergyPlus2)
    public void onOpponentEnergyPlus() {
        energyOpponent++;
        setTextViews();
    }

    @OnClick(R.id.reset_button)
    public void onResetButton() {
        hpOpponent = 20;
        hpPlayer = 20;
        energyOpponent = 0;
        energyPlayer = 0;
        setTextViews();
    }

    @SuppressLint("SetTextI18n")
    private void setTextViews() {
        counterOpponent.setText(Integer.toString(hpOpponent, 10));
        counterPlayer.setText(Integer.toString(hpPlayer, 10));

        energyCounterOpponent.setText(Integer.toString(energyOpponent, 10));
        energyCounterPlayer.setText(Integer.toString(energyPlayer, 10));
    }
}
