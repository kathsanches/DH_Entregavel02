package br.com.digitalhouse.entregavel02.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.entregavel02.Interface.RecyclerViewOnClick;
import br.com.digitalhouse.entregavel02.R;
import br.com.digitalhouse.entregavel02.adapter.RestauranteAdapter;
import br.com.digitalhouse.entregavel02.model.Pratos;
import br.com.digitalhouse.entregavel02.model.Restaurantes;

public class HomeActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recyclerHome;
    private RestauranteAdapter restauranteAdapter;
    public static final String RESTAURANTE_KEY = "restaurante";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();

        restauranteAdapter = new RestauranteAdapter(popularRestaurantes(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerHome.setAdapter(restauranteAdapter);
        recyclerHome.setLayoutManager(linearLayoutManager);

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();


        if (id == R.id.action_settings) {
            Intent intent = new Intent(HomeActivity.this, CadastroActivity.class);
            startActivity(intent);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public List<Restaurantes> popularRestaurantes() {
        List<Restaurantes> listaDeRestaurantes = new ArrayList<>();
        listaDeRestaurantes.add(new Restaurantes(R.drawable.cabana_logo, "Cabana Burguer", "R. Leopoldo Couto de Magalhães Júnior, 753 - Itaim Bibi", "Fecha às 23:00", popularListaPratos()));
        listaDeRestaurantes.add(new Restaurantes(R.drawable.capital_burguer, "Capital Burguer", "Av. Sport Club Corinthians Paulista, 366 - Km 18 - Osasco", "Fecha às 23:00", popularListaPratos()));
        listaDeRestaurantes.add(new Restaurantes(R.drawable.bullguer_logo, "Bullguer", "R. Fradique Coutinho, 1136 - Vila Madalena", "Fecha às 00:00", popularListaPratos()));
        listaDeRestaurantes.add(new Restaurantes(R.drawable.burguer_happens, "Burguer Happens", "R. Alcindo Guanabara, 27 - Jardim da Gloria", "Fecha às 22:00", popularListaPratos()));

        return listaDeRestaurantes;
    }

    public List<Pratos> popularListaPratos() {
        List<Pratos> listaDePratos = new ArrayList<>();
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.bullguer_burguer, "Bullguer", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.cabana_burguer, "Cabana", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new Pratos(R.drawable.all_in_burguer, "Good Stuff", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        return listaDePratos;
    }

    private void initViews() {
        recyclerHome = findViewById(R.id.recyclerHome);
    }

    @Override
    public void onClick(Restaurantes restaurantes) {
        Intent intent = new Intent(HomeActivity.this, CardapioRestauranteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_KEY, restaurantes);
        intent.putExtra(RESTAURANTE_KEY, restaurantes);
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}