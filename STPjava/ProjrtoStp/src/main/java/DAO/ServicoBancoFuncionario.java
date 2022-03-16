package DAO;

import classes.Funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class ServicoBancoFuncionario {

private final Conection conexao = new Conection();
	
	public void insert(Funcionarios funcionario) throws SQLException{
		 
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"insert into funcionario (id_funcionario, nome, cpf, rg, valorHora)" + 
		"values (0,?,?,?,?,?)")){
			
                        pst.setInt(1, funcionario.getId());
			pst.setString(2, funcionario.getNome());
			pst.setString(3, funcionario.getCpf());
			pst.setString(4, funcionario.getRg());
			pst.setDouble(5, funcionario.getValorHora());
			
			pst.executeUpdate();
		}
		conexao.close();
		
		this.setIdBancoFuncionario(funcionario);
	}
	
	public void update(Funcionarios funcionario)throws SQLException {
		 
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"update funcionario set id_funcionario = ?, nome = ?, cpf = ?, rg = ?, valorHora = ? where (id_funcionario = ?)")){
			pst.setInt(1, funcionario.getId());
			pst.setString(2, funcionario.getNome());
			pst.setString(3, funcionario.getCpf());
			pst.setString(4, funcionario.getRg());
			pst.setDouble(5, funcionario.getValorHora());
			
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void delete (Funcionarios funcionario) throws SQLException{
		try(PreparedStatement pst = conexao.getConexao().prepareStatement(
				"delete from funcionario where (id_funcionario = ?)")){
			pst.setInt(1, funcionario.getId());
			pst.executeUpdate();
		}
		conexao.close();
	}
	
	public void setIdBancoFuncionario(Funcionarios funcionario)throws SQLException{
		Statement st = conexao.getConexao().createStatement();
		
		ResultSet rs = st.executeQuery("select las_insert_id() id_funcionario");
		
		while(rs.next()) {
			funcionario.setId(rs.getInt("id_funcionario"));
		}
		conexao.close();
	}
	
	public Funcionarios getCadastroById(int id)throws SQLException{
		try(Statement st = conexao.getConexao().createStatement();
				ResultSet rs = st.executeQuery("select * from cadastro where (id_funcionario = " + id + ")")){
			rs.first();
			return new Funcionarios(rs.getInt("id_funcionario"),
                                                    rs.getString("nome"),
			                            rs.getString("cpf"),
			                            rs.getString("rg"),
                                                    rs.getDouble("valorHora")); 
                                
					            
		}
	}
        
        
        public ArrayList getFuncionariobyQuery()throws SQLException{
            ArrayList dados = new ArrayList();
            try(Statement st = conexao.getConexao().createStatement();
                    ResultSet rs = st.executeQuery("select * from funcionario order by nome")){
                
                while (rs.next()){
          dados.add(new String [] { rs.getString(1),  
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6) 
                                   }); 
        }
            
            }
            
            
            return dados;
        
        }
        
        
        public ArrayList getBuscarFuncionario(String a)throws SQLException{
                   ArrayList dados = new ArrayList();
        
            try(Statement st = conexao.getConexao().createStatement();
                     ResultSet rs = st.executeQuery("select * from funcionario  where nome =  \'"  + a + "\'"   )){
                
                while (rs.next()){
          dados.add(new String [] { rs.getString(1),  
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6) 
                                   }); 
        }
            
            }
            
            
            return dados;
        }
        
        
         public ArrayList<Funcionarios> getFuncionarioByLista()throws SQLException{
      ArrayList<Funcionarios> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from funcionario order by nome ")) {
         
        while (rs.next()){
          lista.add(new Funcionarios(rs.getInt("id_funcionario"),
                                     rs.getString("nome"),
			             rs.getString("cpf"),
			             rs.getString("rg"),
                                     rs.getDouble("valorHora"))); 
        }
    }
    
     return lista;
 }
	
	
}
