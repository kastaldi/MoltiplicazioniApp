package com.mc74.moltiplicazioniapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mDomanda, mTimer, mResult;
    private Button bRisp1,bRisp2,bRisp3,bRisp4;
    private CountDownTimer countDownTimer;
    private Random random;
    private Integer ris = 0, point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDomanda =findViewById(R.id.domanda);
        mTimer = findViewById(R.id.timer);
        mResult = findViewById(R.id.result);

        bRisp1 = findViewById(R.id.bRisp1);
        bRisp2 = findViewById(R.id.bRisp2);
        bRisp3 = findViewById(R.id.bRisp3);
        bRisp4 = findViewById(R.id.bRisp4);

        random = new Random();

        countDownTimer = new CountDownTimer(/* tempo di partenza*/ 30000L, /* intervallo */ 1000L) {
            @Override
            public void onTick(long millisUntilFinished) {
                //codice eseguito ogni secondo
            }

            @Override
            public void onFinish() {
                //codice eseguito alla scadenza del timer
            }
        };

    }

    public void rispostaClick (View view){
        int id = view.getId();
        Button b = null;
        List<Integer> lista = generaNumero();
        setTextButton(lista);
        switch (id){
            case R.id.bRisp1:
                b = bRisp1;
                break;

            case R.id.bRisp2:
                b = bRisp2;
                break;

            case R.id.bRisp3:
                b = bRisp3;
                break;

            case R.id.bRisp4:
                b = bRisp4;
                break;
        }
    }

    private List<Integer> generaNumero(){
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<4; i++){
            int randNum1 = random.nextInt(10)+1;
            int randNum2 = random.nextInt(10)+1;
            list.add(randNum1+randNum2);

            if (i == 0){
                mDomanda.setText("Quale è il risultato di " + randNum1 + " per " + randNum2);
                ris = randNum1 * randNum2;
            }
        }
        return list;
    }

    private boolean isCorrectAnswer(Button b){
        if (b.getText().toString().equals(String.valueOf(ris))){
            point++;
            return true;
        }
        return false;
    }

    private void setTextButton(List<Integer> list)
    {
        // prepara le risposte dei bottoni
        bRisp1.setText(String.valueOf(list.get(0)));
        bRisp2.setText(String.valueOf(list.get(1)));
        bRisp3.setText(String.valueOf(list.get(2)));
        bRisp4.setText(String.valueOf(list.get(3)));
    }

}
