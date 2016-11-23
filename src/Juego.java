/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NucleoInformativo
 */
public class Juego extends Usuario{
    private String category;
    private String level;
    private String puntuationMax;
    private String tipoDeJuego;
    public Juego(String category, String level, String puntuationMax, String tipoDeJuego, Usuario u) {
        super(u);
        this.category = category;
        this.level = level;
        this.puntuationMax = puntuationMax;
        this.tipoDeJuego = tipoDeJuego;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPuntuationMax() {
        return puntuationMax;
    }

    public void setPuntuationMax(String puntuationMax) {
        this.puntuationMax = puntuationMax;
    }

    public String getTipoDeJuego() {
        return tipoDeJuego;
    }

    public void setTipoDeJuego(String tipoDeJuego) {
        this.tipoDeJuego = tipoDeJuego;
    }
    
    
}
