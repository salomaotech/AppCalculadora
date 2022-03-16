package com.example.calculadora;

import static java.util.Objects.isNull;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

/**
 * @autor: Salomão Francisco da Silva (salomao@taimber.com)
 */
public class MainActivity extends AppCompatActivity {

    private String numerosDigitadosTemporarios = "";
    private String valorAntesOperador = "";
    private String valorAposOperador = "";
    private String sinalOperador = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Insere um número
     *
     * @param numero Número
     * @param v      View
     */
    private void insereNumero(String numero, View v) {

        /* atualiza os números que foram digitados */
        this.numerosDigitadosTemporarios += numero;

        /* atualiza no visor */
        TextView visor = findViewById(R.id.textVisor);
        visor.setText(visor.getText() + numero);

    }

    /**
     * Add o número 0
     *
     * @param v View
     */
    public void add0(View v) {

        insereNumero("0", v);

    }

    /**
     * Add o número 1
     *
     * @param v View
     */
    public void add1(View v) {

        insereNumero("1", v);

    }

    /**
     * Add o número 2
     *
     * @param v View
     */
    public void add2(View v) {

        insereNumero("2", v);

    }

    /**
     * Add o número 3
     *
     * @param v View
     */
    public void add3(View v) {

        insereNumero("3", v);

    }

    /**
     * Add o número 4
     *
     * @param v View
     */
    public void add4(View v) {

        insereNumero("4", v);

    }

    /**
     * Add o número 5
     *
     * @param v View
     */
    public void add5(View v) {

        insereNumero("5", v);

    }

    /**
     * Add o número 6
     *
     * @param v View
     */
    public void add6(View v) {

        insereNumero("6", v);

    }

    /**
     * Add o número 7
     *
     * @param v View
     */
    public void add7(View v) {

        insereNumero("7", v);

    }

    /**
     * Add o número 8
     *
     * @param v View
     */
    public void add8(View v) {

        insereNumero("8", v);

    }

    /**
     * Add o número 9
     *
     * @param v View
     */
    public void add9(View v) {

        insereNumero("9", v);

    }

    /**
     * Add vírgula
     *
     * @param v View
     */
    public void addVirgula(View v) {

        /* verifica se no visor já tem uma vírgula */
        if (!numerosDigitadosTemporarios.contains(".")) {

            insereNumero(".", v);

        }

    }

    /**
     * Apaga números
     *
     * @param v View
     */
    public void apagarNumeros(View v) {

        /* pega os dados do visor */
        TextView visor = findViewById(R.id.textVisor);

        /* texto do visor */
        String textoVisor = (String) visor.getText();

        /* sinal divisor */
        String sinalDivisor = null;

        /* verifica se no visor já tem um operador */
        if (textoVisor.contains("+")) {

            /* sinal divisor */
            sinalDivisor = "\\+";

            /* atualiza o sinal operador */
            this.sinalOperador = "+";

        }

        /* verifica se no visor já tem um operador */
        if (textoVisor.contains("-")) {

            /* sinal divisor */
            sinalDivisor = "\\-";

            /* atualiza o sinal operador */
            this.sinalOperador = "-";

        }

        /* verifica se no visor já tem um operador */
        if (textoVisor.contains("*")) {

            /* sinal divisor */
            sinalDivisor = "\\*";

            /* atualiza o sinal operador */
            this.sinalOperador = "*";

        }

        /* verifica se no visor já tem um operador */
        if (textoVisor.contains("/")) {

            /* sinal divisor */
            sinalDivisor = "\\/";

            /* atualiza o sinal operador */
            this.sinalOperador = "/";

        }

        /* valida o sinal divisor */
        if (!isNull(sinalDivisor)) {

            /* separa as partes antes e depois do sinal */
            String[] separar = textoVisor.split(sinalDivisor);

            /* partes */
            String parteA = separar[0];
            String parteB = separar[1];
            parteB = parteB.substring(0, parteB.length() - 1);

            /* seta o texto do visor */
            visor.setText(parteA + this.sinalOperador + parteB);

            /* atualiza valores */
            valorAntesOperador = parteA;
            valorAposOperador = "";
            numerosDigitadosTemporarios = parteB;

        } else {

            /* apaga o texto do visor da direita para a esquerda */
            textoVisor = textoVisor.substring(0, textoVisor.length() - 1);

            /* atualiza o texto do visor */
            visor.setText(textoVisor);

            /* atualiza os números digitados */
            numerosDigitadosTemporarios = textoVisor;


        }

    }

    /**
     * Add o operador matemático (+, -, *, /)
     *
     * @param v     View
     * @param sinal Operador (+, -, *, /)
     */
    private void addOperador(View v, String sinal) {

        /* pega os dados do visor */
        TextView visor = findViewById(R.id.textVisor);

        /* texto do visor */
        String textoVisor = (String) visor.getText();

        /* verifica se o último caractere não é ponto */
        if (!textoVisor.endsWith(".")) {

            /* verifica se no visor já tem um operador */
            if (textoVisor.contains("+") || textoVisor.contains("-") || textoVisor.contains("*") || textoVisor.contains("/")) {

                /* calcula */
                calcular(v);

            }

            /* valor antes do operador */
            this.valorAntesOperador = this.numerosDigitadosTemporarios;

            /* limpa os números digitados */
            this.numerosDigitadosTemporarios = "";

            /* pega o sinal */
            this.sinalOperador = sinal;

            /* atualiza o texto do visor */
            visor.setText(visor.getText() + this.sinalOperador);

        }

    }

    /**
     * Add addSomar
     *
     * @param v View
     */
    public void addSomar(View v) {

        /* atualiza o operador */
        addOperador(v, "+");

    }

    /**
     * Add addSubtrair
     *
     * @param v View
     */
    public void addSubtrair(View v) {

        /* atualiza o operador */
        addOperador(v, "-");

    }

    /**
     * Add multiplica
     *
     * @param v View
     */
    public void addMultiplicar(View v) {

        /* atualiza o operador */
        addOperador(v, "*");

    }

    /**
     * Add divide
     *
     * @param v View
     */
    public void addDividir(View v) {

        /* atualiza o operador */
        addOperador(v, "/");

    }

    /**
     * Limpa
     *
     * @param v View
     */
    public void limpar(View v) {

        /* limpa variáveis */
        this.numerosDigitadosTemporarios = "";
        this.valorAntesOperador = "";
        this.valorAposOperador = "";
        this.sinalOperador = "";

        /* atualiza no visor */
        TextView visor = findViewById(R.id.textVisor);
        visor.setText("");

    }

    /**
     * Realiza os calculos
     *
     * @param v View
     */
    public void calcular(View v) {

        /* números que vem depois do operador */
        this.valorAposOperador = this.numerosDigitadosTemporarios;

        /* resultado */
        BigDecimal resultado = new BigDecimal("0");

        /* valida o valor anterior */
        if (!this.valorAntesOperador.isEmpty() && !this.valorAposOperador.isEmpty()) {

            /* valida o sinal */
            switch (this.sinalOperador) {

                case "+":
                    resultado = new BigDecimal(this.valorAntesOperador).add(new BigDecimal(this.valorAposOperador));
                    break;

                case "-":
                    resultado = new BigDecimal(this.valorAntesOperador).subtract(new BigDecimal(this.valorAposOperador));
                    break;

                case "*":
                    resultado = new BigDecimal(this.valorAntesOperador).multiply(new BigDecimal(this.valorAposOperador));
                    break;

                case "/":
                    resultado = new BigDecimal(this.valorAntesOperador).divide(new BigDecimal(this.valorAposOperador));
                    break;

            }

            /* valida se o sinal operador é nulo */
            if(!this.sinalOperador.isEmpty()) {

                /* atualiza os números digitados */
                this.numerosDigitadosTemporarios = resultado.toString();

                /* limpa valores e sinal */
                this.valorAntesOperador = resultado.toString();
                this.valorAposOperador = "";
                this.sinalOperador = "";

                /* atualiza no visor */
                TextView visor = findViewById(R.id.textVisor);
                visor.setText(resultado.toString());

            }

        }

    }

}