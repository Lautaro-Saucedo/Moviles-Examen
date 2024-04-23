package com.laucha.examen.ui.gallery;

public class Configuracion {
    public static int tipoMapa=1;
    public static int idioma=1;

    public static int getTipoMapa() {
        return tipoMapa;
    }

    public static void setTipoMapa(int tipoMapa) {
        Configuracion.tipoMapa = tipoMapa;
    }

    public static int getIdioma() {
        return idioma;
    }

    public static void setIdioma(int idioma) {
        Configuracion.idioma = idioma;
    }
}
