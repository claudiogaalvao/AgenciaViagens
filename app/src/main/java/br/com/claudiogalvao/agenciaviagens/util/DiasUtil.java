package br.com.claudiogalvao.agenciaviagens.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DiasUtil {

    public static String formataEmTexto(int dias) {
        if(dias > 1) {
            return dias + " dias";
        }
        return dias + " dia";
    }

    public static String periodoEmTexto(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoBr = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = formatoBr.format(dataIda.getTime());
        String dataVoltaFormatada = formatoBr.format(dataVolta.getTime());
        return dataIdaFormatada
                + " - " + dataVoltaFormatada + " de "
                + dataVolta.get(Calendar.YEAR);
    }

}
