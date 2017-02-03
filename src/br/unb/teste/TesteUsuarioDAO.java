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
		testeBuscarUsuario();
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
		UsuarioDAO usuDao = new UsuarioDAO();
		System.out.println("Digite o nome do usuário que deseja buscar: ");
		String nome = leitor.next();
		
		List<Usuario> resultadoBusca = usuDao.buscarUsuario(nome);
		
		System.out.println("Resultado(s): ");
		
		for(Usuario usuario: resultadoBusca) {
			System.out.println(usuario.getNome() +  " "  + usuario.getSobrenome());
		}
		
		leitor.close();
	}
	
	private static void limparBanco() {
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.limparBanco();
	}
}
