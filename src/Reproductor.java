/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NucleoInformativo
 */
import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;

public class Reproductor {


public Reproductor(){

player = new BasicPlayer();

}
public void Play() throws Exception {
    do{
    player.play();
    }while(player.getStatus()!=0);
}
public void AbrirFichero(String ruta) throws Exception {
player.open(new File(ruta));
}
public void Pausa() throws Exception {
player.pause();
}
public void Continuar() throws Exception {
player.resume();
}
public void Stop() throws Exception {
player.stop();
}
private BasicPlayer player;
}