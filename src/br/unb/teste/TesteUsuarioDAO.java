package br.unb.teste;

import br.unb.model.Usuario;
import br.unb.jdbc.UsuarioDAO;
import java.util.List;
import java.util.Scanner;

public class TesteUsuarioDAO {
	public static void main(String[] args) {
		testeCadastrar();
		testeBuscarTodos();
		testeAlterarUsuario();
		testeBuscarTodos();
		limparBanco();
	}
	
	private static void testeCadastrar() {
		Usuario usu = new Usuario();
		Usuario usu2 = new Usuario();
		usu.setNome("Carlos");
		usu.setSobrenome("Augusto");
		
		usu2.setNome("Maria");
		usu2.setSobrenome("Eduarda");
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.cadastrar(usu);
		usuDao.cadastrar(usu2);
	}
	
	private static void testeBuscarTodos() {
		UsuarioDAO usuDao = new UsuarioDAO();
		
		List<Usuario> listaResultado = usuDao.buscarTodos();
		
		System.out.println("NOME\tSOBRENOME");
		System.out.println("========================================");
		
		for(Usuario usuario: listaResultado) {
			System.out.println(usuario.getNome() + " " + usuario.getSobrenome());
		}
	}
	
	private static void testeAlterarUsuario() {
		UsuarioDAO usuDao = new UsuarioDAO();
		Usuario usu =  new Usuario();
		usu.setNome("Marcos");
		usu.setSobrenome("Antonio");
		
		usuDao.atualizarRegistro("Carlos", usu);
		
	}
	
	private static void testeBuscarUsuario() {
		Scanner leitor = new Scanner(System.in);
	}
	
	private static void limparBanco() {
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.limparBanco();
	}
}
