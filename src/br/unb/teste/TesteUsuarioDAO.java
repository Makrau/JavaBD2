package br.unb.teste;

import br.unb.model.Usuario;
import br.unb.jdbc.UsuarioDAO;
import java.util.List;
import java.util.Scanner;

public class TesteUsuarioDAO {
	public static void main(String[] args) {
		int opcao = 0;
		
		imprimirMenu();
		
		testeCadastrar();
		testeBuscarTodos();
		limparBanco();
	}
	
	private static void imprimirMenu() {
		System.out.println("Escolha a opcao desejada:");
		System.out.println("1) Cadastrar usuário");
		System.out.println("2) Buscar usuário");
		System.out.println("3) Apagar usuário");
		System.out.println("4) Listar todos usuários");
		System.out.println("5) Limpar base de dados");
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
	
	private static void limparBanco() {
		UsuarioDAO usuDao = new UsuarioDAO();
		usuDao.limparBanco();
	}
}
