
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

//Metodo principal de conexion    
public static com.mysql.jdbc.Connection GetConnection(){
    //Inicialización de variable
    com.mysql.jdbc.Connection conexion = null;
    try {
      //Driver SQL a usar
      Class.forName("com.mysql.jdbc.Driver");
      //Datos de conexión
      String servidor = "jdbc:mysql://localhost:3306/comentarios";
      String usuario = "root";
      String passwordDB = "";
      
      //Asignación de parametros de conexión
      conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(servidor, usuario, passwordDB);
      //Mensajes de error para conexiones, datos y servidor
    }catch (ClassNotFoundException ex){
      JOptionPane.showMessageDialog(null, ex, "Error 1\n\nEjecución del programa falló." + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
      //Cierre de conexión
      conexion = null;
    }catch (SQLException ex){
      JOptionPane.showMessageDialog(null, ex, "Error 2\n\nInformación no encontrada." + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
      //Cierre de conexión
      conexion = null;
    }catch (Exception ex){
      JOptionPane.showMessageDialog(null, ex, "Error 3\n\nPrograma colapsado." + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
      //Cierre de conexión
      conexion = null;
    }finally{
    //Resultado de conexión final
    return conexion;
    }
  }
}
