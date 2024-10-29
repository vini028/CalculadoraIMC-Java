package com.example.imcjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.imcjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.botao.setOnClickListener(view -> {
            String peso = binding.peso.getText().toString();
            String altura = binding.altura.getText().toString();

            if (peso.isEmpty() || altura.isEmpty()) {
                binding.resultado.setText("Preencha todos os campos");
            } else {
                float pesoDouble = Float.parseFloat(peso);
                float alturaDouble = Float.parseFloat(altura);
                float imc = pesoDouble / (alturaDouble * alturaDouble);

                if (imc < 18.5) {
                    binding.resultado.setText(String.format("Abaixo do peso %.2f", imc));
                } else if (imc >= 18.5 && imc <= 24.9) {
                    binding.resultado.setText(String.format("Peso ideal %.2f", imc));
                } else {
                    binding.resultado.setText(String.format("Acima do peso %.2f", imc));
                }
            }
        });
    }
}