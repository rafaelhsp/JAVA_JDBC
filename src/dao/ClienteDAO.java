package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import model.Cliente;

public class ClienteDAO {
    private DataSource dataSource;
    
    public ClienteDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public ArrayList<Cliente>readAll(){
        try{
            String SQL = "SELECT * from Cliente";
            PreparedStatement ps = dataSource.getConnection().prepareStatement (SQL);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            while (rs.next ()){
                Cliente cli = new Cliente();
                    cli.setId(rs.getInt("id"));
                    cli.setNome(rs.getString("nome"));
                    cli.setEmail(rs.getString("email"));
                    cli.setTelefone(rs.getString("telefone"));
                    lista.add(cli);
            }
            ps.close();	
            return lista;
        }
try
    {
          
      //mysql update preparedstatement
      String query = "update Cliente set id = ? where nome = ?";
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setInt   (1, 100);
      preparedStmt.setString(2, "Paulo");

      // execute preparedstatement
      preparedStmt.executeUpdate();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Possui execeção! ");
      System.err.println(e.getMessage());
    }
   try
    {
      // create mysql delete statement.
      String query = "delete from users where id = ?";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt(1, 3);

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Tem uma exceção! ");
      System.err.println(e.getMessage());
    }

            catch(SQLException ex){
            System.err.println("Erro ao recuperar " +ex.getMessage());
        }
         return null;
    
    }   
}
