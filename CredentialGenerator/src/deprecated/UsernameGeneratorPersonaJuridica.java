/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deprecated;

import java.util.Scanner;

/**
 *
 * @author arios
 */
public class UsernameGeneratorPersonaJuridica {
    public static void main (String [] args)
	{
		String apellidoUsuario, nombreUsuario, fechaNacimientoUsuario, UsuarioGenerado;
		Scanner in = new Scanner(System.in);
		try 
		{
			System.out.println("Ingresar nombre completo: ");
			nombreUsuario = in.next();
			apellidoUsuario = in.next();
			
			System.out.println("Por favor , insertar fecha de nacimiento , Formato: (DD/MM/YY): ");
			fechaNacimientoUsuario = in.next();
			
			int num1 = (Integer.parseInt(fechaNacimientoUsuario.substring(0,2))+Integer.parseInt(fechaNacimientoUsuario.substring(3,5))/Integer.parseInt(fechaNacimientoUsuario.substring(7)));
			//day + month / year in order to give unique digit 
			
			int num2 = Integer.parseInt(fechaNacimientoUsuario.substring(1,2));
			//to ensure UsuarioGenerado is unique
			
			UsuarioGenerado = apellidoUsuario.substring(0,(apellidoUsuario.length()-0)) + nombreUsuario.charAt(0) + num1 + num2;
			System.out.println("Su usuario : " + UsuarioGenerado);
		} catch(Exception e) 
		{
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
