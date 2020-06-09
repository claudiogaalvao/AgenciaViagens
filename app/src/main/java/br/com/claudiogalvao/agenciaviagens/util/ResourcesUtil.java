package br.com.claudiogalvao.agenciaviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.claudiogalvao.agenciaviagens.model.Pacote;

public class ResourcesUtil {

    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawable = resources
                .getIdentifier(
                        drawableEmTexto,
                        "drawable",
                        context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }

}
