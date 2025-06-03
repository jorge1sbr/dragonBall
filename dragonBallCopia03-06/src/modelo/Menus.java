package modelo;

import java.util.Scanner;

import daoDragonBall.*;

import java.sql.*;

public class Menus {

	public Menus() {

	}

	public String menuLogin() throws SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué quieres hacer?" + "\n 1.Registrarme" + "\n 2.Log in");
		int eleccion = sc.nextInt();
		sc.nextLine();
		DaoUsuario dao = DaoUsuario.getInstance();
		if (eleccion == 1) {
			System.out.println("Introcuce el nombre de usuario que desees");
			String nombreUsuario = sc.nextLine();
			System.out.println("Elige tu contraseña");
			String password = sc.nextLine();

			dao.registrarUsuario(nombreUsuario, password);
			
			return nombreUsuario;
		} else {
			System.out.println("Introduce tu nombre de usuario");
			String nombreUsuario = sc.nextLine();
			System.out.println("Introduce tu contraseña");
			String password = sc.nextLine();

			dao.loginUsuario(nombreUsuario, password);
			return nombreUsuario;
		}
		
	}
}
