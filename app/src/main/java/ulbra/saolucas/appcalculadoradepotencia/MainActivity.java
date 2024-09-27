package ulbra.saolucas.appcalculadoradepotencia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edPotencia, edHoras, edPreco;
    TextView txResultado;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPotencia = findViewById(R.id.edtPotencia);
        edHoras = findViewById(R.id.edtHoras);
        edPreco = findViewById(R.id.edtPreco);
        txResultado = findViewById(R.id.txtResultado);
        btCalcular = findViewById(R.id.btnCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                calcularConsumo();
            }
        });

    }
    public void calcularConsumo() {
        // Obter valores de entrada e garantir que o usuário forneceu dados válidos
        try {
            double potencia = Double.parseDouble(edPotencia.getText().toString());
            double horas = Double.parseDouble(edHoras.getText().toString());
            double precoKwh = Double.parseDouble(edPreco.getText().toString());

            // Cálculo do consumo de energia
            double consumoEnergia = (potencia * horas) / 1000;

            // Cálculo do custo
            double custo = consumoEnergia * precoKwh;

            // Exibir os resultados no TextView
            txResultado.setText(String.format("Consumo: %.2f kWh\nCusto: R$ %.2f", consumoEnergia, custo));
        } catch (NumberFormatException e) {
            // Caso algum campo esteja vazio ou contenha valores inválidos, exibimos uma mensagem de erro
            txResultado.setText("Por favor, insira valores válidos.");
        }
    }

}


