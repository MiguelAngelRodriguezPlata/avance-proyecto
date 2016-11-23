
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 */
public interface Interface {
    public interface Usuario {
        int getId_usuario();
        void setId_usuario(int id_usuario);
        String getNombre();
        void setNombre(String nombre);
        String getApellido();
        void setApellido(String apellido);
        String getAlias();
        void setAlias(String alias);
        String getContrasena();
        void setContrasena(String contrasena);
        String getTipo();
        void setTipo(String tipo);
    }
    public interface Juego extends  Usuario{
        String getCategory();
        void setCategory(String category);
        String getLevel();
        void setLevel(String level);
        String getPuntuationMax();
        void setPuntuationMax(String puntuationMax);
        String getTipoDeJuego();
        void setTipoDeJuego(String tipoDeJuego);
               
        
    }
    public interface Reproductor {
        void play();
        void AbrirFichero(String ruta);
        void Pausa();
        void continuar();
        void stop();
    }
    public interface Preguntas{
        String getCategoria();
        void setCategoria(String categoria);
        int getIdPregunta();
        void setIdPregunta(int idPregunta);
        String getPregunta();
        void setPregunta(String pregunta);
        String getRespuesta1();
        void setRespuesta1(String respuesta1) ;
        String getRespuesta2();
        void setRespuesta2(String respuesta2);
        String getRespuesta3();
        void setRespuesta3(String respuesta3);
        int getCorrecta();
        void setCorrecta(int correcta);
    }
    public interface ConsultasBD{
        ArrayList<Mensaje> obtenerMsgAdmin();
        ArrayList<Preguntas> consultarPreguntas(String cat);
        ArrayList<Usuario> consultarUsuarios();
        boolean insertaMensaje(String sql);
        boolean insertaUsuario(Usuario User);
        boolean insertaJuego(Usuario User,String categoria,int nivel);
    }
}
