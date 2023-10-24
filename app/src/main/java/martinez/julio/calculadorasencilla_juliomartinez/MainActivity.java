package martinez.julio.calculadorasencilla_juliomartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.resultado);

        View.OnClickListener operacionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1, num2;
                try {
                    num1 = Double.parseDouble(numero1.getText().toString());
                    num2 = Double.parseDouble(numero2.getText().toString());
                } catch (NumberFormatException e) {
                    resultado.setText("Error: Ingresa números válidos");
                    return;
                }

                double resultadoOperacion = 0.0;

                int operation = -1; // Initialize with an invalid value

                if (view.getId() == R.id.suma) {
                    operation = 0;
                } else if (view.getId() == R.id.resta) {
                    operation = 1;
                } else if (view.getId() == R.id.multiplicacion) {
                    operation = 2;
                } else if (view.getId() == R.id.division) {
                    operation = 3;
                }

                switch (operation) {
                    case 0: // Suma
                        resultadoOperacion = num1 + num2;
                        break;
                    case 1: // Resta
                        resultadoOperacion = num1 - num2;
                        break;
                    case 2: // Multiplicación
                        resultadoOperacion = num1 * num2;
                        break;
                    case 3: // División
                        if (num2 != 0) {
                            resultadoOperacion = num1 / num2;
                        } else {
                            resultado.setText("Error: División por 0");
                            return;
                        }
                        break;
                    default:

                        break;
                }
                        resultado.setText("Resultado: " + resultadoOperacion);
            }
        };

        Button suma = findViewById(R.id.suma);
        Button resta = findViewById(R.id.resta);
        Button multiplicacion = findViewById(R.id.multiplicacion);
        Button division = findViewById(R.id.division);

        suma.setOnClickListener(operacionClickListener);
        resta.setOnClickListener(operacionClickListener);
        multiplicacion.setOnClickListener(operacionClickListener);
        division.setOnClickListener(operacionClickListener);
    }
}