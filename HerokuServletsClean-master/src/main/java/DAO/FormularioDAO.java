/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import Formulario.Formulario;
import com.crunchify.jsp.servlet.Conexion;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class FormularioDAO {
       private Connection connection;

    public FormularioDAO(){
       
    }

    public void addCampos(Formulario formulario) {
        try {
            Connection connection = Conexion.getConnection();
            /// sentencia para insertar en la tabla
            PreparedStatement preparedStatement = connection.prepareStatement("insert into formulario(titulo, descripcion) values (?,?)");

            // parametros de inicio para agregar...
            preparedStatement.setString(1, formulario.getTitulo());
            preparedStatement.setString(2, formulario.getDescripcion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Formulario> getAllCampos() {
        
        List<Formulario> ListaCampos = new ArrayList<Formulario>();
        try {
            Connection connection = Conexion.getConnection();
            
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from formulario");

            while (rs.next()) {
                Formulario newCampo = new Formulario();
                newCampo.setTitulo(rs.getString("titulo"));
                newCampo.setDescripcion(rs.getString("descripcion"));

                ListaCampos.add(newCampo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ListaCampos;
    }

}
