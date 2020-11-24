package modeloDAO;

import interfaces.CRUD;
import config.bd.ConectaBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Biblioteca;


public class bibliotecaDAO implements CRUD {
ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Biblioteca e = new Biblioteca();
    @Override
    public List listarbiblioteca() {
         ArrayList<Biblioteca> bibliotecas = new ArrayList<>();
        String consulta = " select * from quinteros ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {                
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdbiblioteca(rs.getInt("idbiblioteca"));
                biblioteca.setNombre(rs.getString("nombre"));
                biblioteca.setCodigo(rs.getString("codigo"));
                biblioteca.setDireccion(rs.getString("direccion"));
                biblioteca.setTelefono(rs.getString("telefono"));
                biblioteca.setEstado(rs.getString("estado"));
                bibliotecas.add(biblioteca);
            }
        } catch (SQLException e) {
            System.out.println("Error: Problemas con el LISTAR");
            System.out.println(e.getMessage());
        }
        return bibliotecas;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Biblioteca buscarbiblioteca(int idbiblioteca) {
        
        String consulta = " select *  "
                       + " from quinteros  "
                        + " where idbiblioteca = " + idbiblioteca ;
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdbiblioteca(rs.getInt("idcurso"));
                e.setNombre(rs.getString("nombre"));
                e.setCodigo(rs.getString("codigo"));
                e.setDireccion(rs.getString("direccion"));
                e.setTelefono(rs.getString("telefono"));              
                e.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        
        return e;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregarbiblioteca(Biblioteca biblioteca) {
        
        Boolean agregado = false;
    	
    	String consulta = "INSERT INTO quinteros (nombre ,codigo, direccion,telefono, estado) values( '" + biblioteca.getNombre() +
    	"' , '" + biblioteca.getCodigo()+ "', '" + biblioteca.getDireccion()+ "' , '" + biblioteca.getTelefono()+ "' , '" +
    	biblioteca.getEstado()+"' );";
    	
    	try {
    		
    	con = cn.getConnection();
        pst = con.prepareStatement(consulta);
        pst.executeUpdate();
    	con.close();
        pst.close();
            agregado = true;
    		
		} catch (Exception e) {
			System.out.println("Something were wrong in Insert");
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
    	return agregado;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editarbiblioteca(Biblioteca biblioteca) {
         String consulta = " update quinteros "
                        + " set "
                        + " nombre = '"+ biblioteca.getNombre() +"', "
                        + " codigo = '"+ biblioteca.getCodigo()+"', "
                        + " direccion = '"+ biblioteca.getDireccion()+"', "
                        + " telefono = '"+ biblioteca.getTelefono()+"', "
                        + " estado = '"+ biblioteca.getEstado()+"' "
                        + " where "
                        + " idbiblioteca = " + biblioteca.getIdbiblioteca()+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception error) {
            System.out.println("Error con el Lsitar");
            System.out.println(error.getMessage());
            return false;
        }
        return true;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarbiblioteca(int idbiblioteca) {
        
       String consulta = " delete from quinteros "
                        + " where "
                        + " idbiblioteca = " + idbiblioteca + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
