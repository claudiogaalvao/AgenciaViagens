package br.com.claudiogalvao.agenciaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.claudiogalvao.agenciaviagens.R;
import br.com.claudiogalvao.agenciaviagens.dao.PacoteDAO;
import br.com.claudiogalvao.agenciaviagens.model.Pacote;
import br.com.claudiogalvao.agenciaviagens.ui.adapter.ListaPacotesAdapter;

public class PacotesViagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacotes_viagem);

        configuraLista();
    }

    private void configuraLista() {
        List<Pacote> pacotes = new PacoteDAO().lista();
        ListView listaPacotes = findViewById(R.id.activity_pacotes_viagem_listview);
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
