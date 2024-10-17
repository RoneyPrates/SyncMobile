package com.example.syncmobile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class OrdensDeComprasActivity extends AppCompatActivity {

    private List<Ordem> ordens;
    private ListView ordensListView;
    private TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordensdecompras);

        ordensListView = findViewById(R.id.ordensListView);
        errorMessageTextView = findViewById(R.id.error_message);

        ordens = new ArrayList<>();
        fetchOrders();
    }

    private void fetchOrders() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.3.52:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Ordem>> call = apiService.getOrdens();

        call.enqueue(new Callback<List<Ordem>>() {
            @Override
            public void onResponse(Call<List<Ordem>> call, Response<List<Ordem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ordens.clear();
                    ordens.addAll(response.body());
                    OrdemAdapter ordemAdapter = new OrdemAdapter(OrdensDeComprasActivity.this, ordens);
                    ordensListView.setAdapter(ordemAdapter);
                    errorMessageTextView.setVisibility(View.GONE);
                } else {
                    Log.e("OrdensDeCompras", "Erro ao carregar ordens: " + response.message());
                    showError("Erro ao carregar ordens.");
                }
            }

            @Override
            public void onFailure(Call<List<Ordem>> call, Throwable t) {
                Log.e("OrdensDeCompras", "Falha na conexão: ", t);
                showError("Erro ao carregar ordens.");
            }
        });
    }

    private void showError(String message) {
        errorMessageTextView.setText(message);
        errorMessageTextView.setVisibility(View.VISIBLE);
    }
}
