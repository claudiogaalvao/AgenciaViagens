package br.com.claudiogalvao.agenciaviagens.util;

public class DiasUtil {

    public static String formataEmTexto(int dias) {
        if(dias > 1) {
            return dias + " dias";
        }
        return dias + " dia";
    }

}
