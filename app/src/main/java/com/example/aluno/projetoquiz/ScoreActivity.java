package com.example.aluno.projetoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private TextView erros;
    private TextView acertos;
    private Button jogarNovamente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        erros = (TextView) findViewById(R.id.score_erros);
        acertos = (TextView) findViewById(R.id.score_acertos);
        jogarNovamente = (Button) findViewById(R.id.sobre_jogar_novameente);



        int contaAcertos = getIntent().getIntExtra("acertos", -1);
        int contaErros = getIntent().getIntExtra("erros", -1);

        Log.e("", "ACERTOS: " + contaAcertos + "  ERROS: " + contaErros);

        erros.setText(String.valueOf(contaErros));
        acertos.setText(String.valueOf(contaAcertos));

        jogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScoreActivity.this, MenuPrincipal.class));

            }
        });
    }
}
