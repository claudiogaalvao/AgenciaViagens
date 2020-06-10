package br.com.claudiogalvao.agenciaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.claudiogalvao.agenciaviagens.R;
import br.com.claudiogalvao.agenciaviagens.dao.PacoteDAO;
import br.com.claudiogalvao.agenciaviagens.model.Pacote;
import br.com.claudiogalvao.agenciaviagens.ui.adapter.ListaPacotesAdapter;

import static br.com.claudiogalvao.agenciaviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PacotesViagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacotes_viagem);

        configuraLista();


    }

    private void configuraLista() {
        final List<Pacote> pacotes = new PacoteDAO().lista();
        ListView listaPacotes = findViewById(R.id.activity_pacotes_viagem_listview);
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vaiParaResumoPacote(position, pacotes);
            }
        });
    }

    private void vaiParaResumoPacote(int position, List<Pacote> pacotes) {
        Intent intent = new Intent(PacotesViagemActivity.this,
                ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacotes.get(position));
        startActivity(intent);
    }
}
