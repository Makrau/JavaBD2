package br.unb.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.unb.model.Usuario;

public class UsuarioDAO {
	private Connection con = null;
	
	public void cadastrar(Usuario usuario) {
		//Montando String SQL
		String sql = "INSERT INTO javaweb.usuario (nome, sobrenome) VALUES(?,?)";
		
		con = Conexao.getConnection();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getSobrenome());
			preparador.execute();
			// Verificar retorno importante
			preparador.close();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.print("Problema com BD!\n" + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão. ");
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
	}
	
	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM javaweb.usuario";
		List<Usuario> lista = new ArrayList<Usuario> ();
		con = Conexao.getConnection();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Usuario usu = new Usuario();
				
				usu.setNome(resultado.getString("nome"));
				usu.setSobrenome(resultado.getString("sobrenome"));
				
				lista.add(usu);
			}
		}catch (SQLException e) {
				System.out.print("Problema com BD!\n" + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão. ");
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
		
		return lista;
	}
	
	public void limparBanco() {
		String sql = "DELETE FROM javaweb.usuario";
		
		con = Conexao.getConnection();
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.execute();
			preparador.close();
			System.out.println("Banco limpado com sucesso!");
		}
		catch (SQLException e) {
			System.out.print("Problema com BD!\n" + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão. ");
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
	}
}
