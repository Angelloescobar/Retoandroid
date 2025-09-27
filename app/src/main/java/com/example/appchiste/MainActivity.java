package com.example.appchiste;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView jokeTextView;
    private Button newJokeButton;
    private JokeApiService jokeApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        jokeTextView = findViewById(R.id.jokeTextView);
        newJokeButton = findViewById(R.id.newJokeButton);

        jokeApiService = RetrofitClient.getClient().create(JokeApiService.class);

        newJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });

        fetchJoke(); // Cargar un chiste al iniciar

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void fetchJoke() {
        jokeApiService.getJoke().enqueue(new Callback<JokeResponse>() {
            @Override
            public void onResponse(Call<JokeResponse> call, Response<JokeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    JokeResponse jokeResponse = response.body();
                    if (!jokeResponse.isError()) {
                        String jokeText;
                        if ("single".equals(jokeResponse.getType())) {
                            jokeText = jokeResponse.getJoke();
                        } else {
                            jokeText = jokeResponse.getSetup() + "\n\n" + jokeResponse.getDelivery();
                        }
                        jokeTextView.setText(jokeText);
                    } else {
                        jokeTextView.setText("Error al obtener el chiste.");
                    }
                } else {
                    jokeTextView.setText("Error al obtener el chiste.");
                }
            }

            @Override
            public void onFailure(Call<JokeResponse> call, Throwable t) {
                jokeTextView.setText("Fallo en la conexión. Inténtalo de nuevo.");
                Toast.makeText(MainActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}