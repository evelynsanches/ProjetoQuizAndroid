package com.example.aluno.projetoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Perg2Activity extends AppCompatActivity {
    private RadioGroup alternativas;
    private Button proxima;
    private int alternativaCorreta = R.id.perg2_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perg2);

        alternativas = (RadioGroup) findViewById(R.id.perg2_alternativas);
        proxima = (Button) findViewById(R.id.perg2_proxima);

        proxima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opcaoEscolhida = alternativas.getCheckedRadioButtonId();

                //Pega acertos e erros passados para o Bundle desta activity
                int contaAcertos = getIntent().getIntExtra("acertos", -1);
                int contaErros = getIntent().getIntExtra("erros", -1);

                if (opcaoEscolhida == alternativaCorreta) {
                    contaAcertos++;
                } else {
                    contaErros++;
                }


                enviaDados(v, contaAcertos, contaErros);
            }
        });
    }

    private void enviaDados(View v, int contaAcertos, int contaErros) {
        Intent intent = new Intent(Perg2Activity.this, Perg3Activity.class);
        intent.putExtra("acertos", contaAcertos);
        intent.putExtra("erros", contaErros);

        Toast.makeText(this, "Acertos: " + contaAcertos + ", Erros: " + contaErros, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


}
