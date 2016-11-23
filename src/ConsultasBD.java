/*
 * To change this license header, choose License Headedatosusuario in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.util.ArrayList;


public class ConsultasBD {
    MySqlBD baseDatos = new MySqlBD().conectar("localhost", "traductor", "root", "1234");
    public ArrayList<Mensaje> obtenerMsgAdmin(){
        ArrayList<Mensaje> msg=new ArrayList<>();
        ResultSet datosusuario = baseDatos.consultar("select m.id_mensaje,m.id_usuario,m.asunto,m.mensaje,m.tipo,u.nombre,u.apellido,u.alias,u.contrasena,u.alias from mensajes as m inner join usuarios as u where m.id_usuario=u.id_usuario;");
        if (datosusuario != null) {
            try {
                while (datosusuario.next()) {
                    
                   msg.add(new Mensaje(datosusuario.getInt("id_mensaje"),new Usuario(datosusuario.getInt("id_usuario"), datosusuario.getString("nombre"),  datosusuario.getString("apellido"),  datosusuario.getString("alias"),  datosusuario.getString("contrasena"),  
                           datosusuario.getString("tipo")),datosusuario.getString("asunto"),datosusuario.getString("mensaje"),datosusuario.getString("tipo")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return msg;
    }
    public Juego obtenerJuegousuario(int id, String cat,Usuario u){
        ResultSet datosusuario = baseDatos.consultar("SELECT * FROM juego where id_usuario="+id+" and categoria='"+cat+"'");
        Juego j = null;
        if (datosusuario != null) {
            try {
                while (datosusuario.next()) {
                    
                   j=new Juego(cat,datosusuario.getString("level"),datosusuario.getString("puntuation"),"",u);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }
    public ArrayList<Preguntas> consultarPreguntas(String cat) {
    ArrayList<Preguntas> preguntas = new ArrayList<>();
        ResultSet datosusuario = baseDatos.consultar("SELECT * FROM preguntas where categoria='"+cat+"'");
        if (datosusuario != null) {
            try {
                while (datosusuario.next()) {
                    
                   preguntas.add(new Preguntas(datosusuario.getInt("id_pregunta"),
                            datosusuario.getString("pregunta")
                           , datosusuario.getString("respuesta1"), datosusuario.getString("respuesta2"),
                             datosusuario.getString("respuesta3"),datosusuario.getInt("correcta"),datosusuario.getString("categoria"),datosusuario.getString("imagen")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return preguntas;
    }
    public ArrayList<Usuario> consultarUsuarios() {
    ArrayList<Usuario> usuario = new ArrayList<>();
        ResultSet datosusuario = baseDatos.consultar("SELECT * FROM usuarios order by id_usuario");
        if (datosusuario != null) {
            try {
                while (datosusuario.next()) {
                    
                   usuario.add(new Usuario(datosusuario.getInt("id_usuario"),
                            datosusuario.getString("nombre")
                           , datosusuario.getString("apellido"), datosusuario.getString("alias"),
                             datosusuario.getString("contrasena"),datosusuario.getString("tipo")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
    public boolean nuevoNivel(Juego j){
        int nivel=Integer.parseInt(j.getLevel());
        
    String sql="UPDATE `juego` SET `level`="+(nivel+1)+" WHERE `id_usuario`="+j.getId_usuario()+" and `categoria`='"+j.getCategory()+"'";
        boolean insertaUsuario=baseDatos.ejecutar(sql);
        return insertaUsuario;
    }
    public boolean insertaMensaje(String sql){
        boolean datosusuario = baseDatos.ejecutar(sql);
        return datosusuario;
    }
    public boolean insertaUsuario(Usuario User){
        String sql="insert into usuarios(nombre,apellido,alias,contrasena)values('"+User.getNombre()+"','"+User.getApellido()+"','"+User.getAlias()+"','"+User.getContrasena()+"')";
        boolean insertaUsuario=baseDatos.ejecutar(sql);
        return insertaUsuario;
    }
    public boolean insertaJuego(Usuario User,String categoria,int nivel){
        String sql="INSERT INTO `juego` (`id_usuario`, `categoria`, `level`, `puntuation`, `tipo_juego`) "
                + "VALUES ('"+User.getId_usuario()+"', '"+categoria+"', "+nivel+", '"+100+"', '"+"');";
        boolean insertaUsuario=baseDatos.ejecutar(sql);
        return insertaUsuario;
    }
 }
