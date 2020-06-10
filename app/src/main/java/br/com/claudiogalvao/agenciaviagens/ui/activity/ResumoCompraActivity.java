package br.com.claudiogalvao.agenciaviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.claudiogalvao.agenciaviagens.R;
import br.com.claudiogalvao.agenciaviagens.model.Pacote;
import br.com.claudiogalvao.agenciaviagens.util.DiasUtil;
import br.com.claudiogalvao.agenciaviagens.util.MoedaUtil;
import br.com.claudiogalvao.agenciaviagens.util.ResourcesUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);
    }

    private void mostraData(Pacote pacoteSaoPaulo) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataPacote = DiasUtil.periodoEmTexto(pacoteSaoPaulo.getDias());
        data.setText(dataPacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_valor);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        Drawable drawableDoPacote = ResourcesUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }
}
