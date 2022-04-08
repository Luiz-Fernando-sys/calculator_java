/*
EQUIPE:
- Bruno Domingues dos Santos
- Eiryan Mayk Alves de Almeida
- Leandro Lemos Pinotti
- Luiz Fernando Adami dos Reis
- Marcos Vinicius Freitas Silva
- Paulo Sérgio da Silva Batista
- Thadeu Henrique dos Anjos

TURMA: ADS PA/SL - 3º E 5º Período
*/

package com.example.calculadora_faculdade;

import android.support.v7.app.AppCompatActivity;
// Importando bibliotecas responsáveis para bem utilizarmos determinadas chamadas dentro do código
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Declarando as variáveis
    EditText numero1EditText;
    EditText numero2EditText;
    Button adicaoButton;
    Button subtracaoButton;
    Button multiplicacaoButton;
    Button divisaoButton;
    TextView resultadoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincularComponentes();
        criarListeners();
    }
    private void vincularComponentes() {
        // vinculando as variáveis criadas no código Java para cada id do layout da Activity Main
        numero1EditText = findViewById(R.id.numero1EditText);
        numero2EditText = findViewById(R.id.numero2EditText);
        adicaoButton = findViewById(R.id.adicaoButton);
        subtracaoButton = findViewById(R.id.subtracaoButton);
        multiplicacaoButton = findViewById(R.id.multiplicacaoButton);
        divisaoButton = findViewById(R.id.divisaoButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);
    }
    private void criarListeners() {
        // Fazendo a chamada de ação para as suas respectivas funções de operações!
        // Entre outras palavras, o Listeners
        adicaoButton.setOnClickListener(evt -> somar());
        subtracaoButton.setOnClickListener(evt -> subtrair());
        multiplicacaoButton.setOnClickListener(evt -> multiplicar());
        divisaoButton.setOnClickListener(evt -> dividir());
    }
    private void somar() {
        // O usuário digita os valores e então guardamos nas respectivas variáveis aqui criadas no início do código.
        String numero1String = numero1EditText.getText().toString();
        String numero2String = numero2EditText.getText().toString();
        // Cas alguma das variáveis forem vazia, teremos uma mensagem de alerta para o usuário solicitando-o para que digite dois números.
        if (numero1String.isEmpty() || numero2String.isEmpty()) {
            Toast.makeText(this, "Digite dois números",
                    Toast.LENGTH_LONG).show();
            return;
        }
        // Pegamos os valores inseridos e convertemos em double (ponto flutuante), realizamos a operação com os dois valores e guardamos na variável de resultado.
        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(numero2String);

        double resultado = numero1 + numero2;
        // Após termos o resultado já guardado na variável, podemos referenciá-lo na para dentro da variável de resultado, que por sua vez é o textView que exibe o resultado.
        resultadoTextView.setText(String.valueOf(resultado));
        numero1EditText.setText(String.valueOf(resultado));
        numero2EditText.setText(String.valueOf(""));
    }
    private void subtrair() {
        String numero1String = numero1EditText.getText().toString();
        String numero2String = numero2EditText.getText().toString();
        if (numero1String.isEmpty() || numero2String.isEmpty()) {
            Toast.makeText(this, "Digite dois números",
                    Toast.LENGTH_LONG).show();
            return;
        }

        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(numero2String);

        double resultado = numero1 - numero2;

        resultadoTextView.setText(String.valueOf(resultado));
        numero1EditText.setText(String.valueOf(resultado));
        numero2EditText.setText(String.valueOf(""));
    }
    private void multiplicar() {
        String numero1String = numero1EditText.getText().toString();
        String numero2String = numero2EditText.getText().toString();
        if (numero1String.isEmpty() || numero2String.isEmpty()) {
            Toast.makeText(this, "Digite dois números",
                    Toast.LENGTH_LONG).show();
            return;
        }

        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(numero2String);

        double resultado = numero1 * numero2;

        resultadoTextView.setText(String.valueOf(resultado));
        numero1EditText.setText(String.valueOf(resultado));
        numero2EditText.setText(String.valueOf(""));
    }
    private void dividir() {
        String numero1String = numero1EditText.getText().toString();
        String numero2String = numero2EditText.getText().toString();
        if (numero1String.isEmpty() || numero2String.isEmpty()) {
            Toast.makeText(this, "Digite dois números",
                    Toast.LENGTH_LONG).show();
            return;
        }
        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(numero2String);
        if (numero2 == 0) {
            Toast.makeText(this, "Não é possível dividir por 0",
                    Toast.LENGTH_LONG).show();
            return;
        }

        double resultado = numero1 / numero2;
        resultadoTextView.setText(String.valueOf(resultado));
        numero1EditText.setText(String.valueOf(resultado));
        numero2EditText.setText(String.valueOf(""));
    }
}