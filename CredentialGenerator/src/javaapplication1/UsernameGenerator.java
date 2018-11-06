/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author arios
 */
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

public class UsernameGenerator {

    public static void main(String[] args) {
        String apellidoUsuario, nombreUsuario, fechaNacimientoUsuario, UsuarioGenerado, passwordFinal;
        int password = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Ingresar nombre completo: ");
            nombreUsuario = in.next();
            apellidoUsuario = in.next();

            System.out.println("Por favor , insertar fecha de nacimiento , Formato: (DD/MM/YY): ");
            fechaNacimientoUsuario = in.next();

            int num1 = (Integer.parseInt(fechaNacimientoUsuario.substring(0, 2)) + Integer.parseInt(fechaNacimientoUsuario.substring(3, 5)) / Integer.parseInt(fechaNacimientoUsuario.substring(7)));
            //day + month / year in order to give unique digit 

            int num2 = Integer.parseInt(fechaNacimientoUsuario.substring(1, 2));
            //to ensure UsuarioGenerado is unique

            UsuarioGenerado = apellidoUsuario.substring(0, (apellidoUsuario.length() - 0)) + nombreUsuario.charAt(0) + num1 + num2;
            System.out.println("Su usuario : " + UsuarioGenerado);
            System.out.println(" ");
            
            for (int i = 1; i <= 1; i++) {
                System.out.print("" + (int) (Math.random() * 100));
                password = ((int) (Math.random() * 100));

            }
            String passwordString = Integer.toString(password);

            passwordFinal = apellidoUsuario.substring(0, (apellidoUsuario.length() - 2)) + nombreUsuario.charAt(0) + passwordString;
            System.out.println(" ");
            System.out.print("Esta seria la version sin encriptar: "+passwordFinal);
            System.out.println(" ");
///------------------------------------------------------
            ///SHA2
             
            
            
            
            
            String passwordEnc = getSHA256(passwordFinal);
            System.out.println(" ");
            System.out.println("La version encriptada en SHA256 seria: \"" + passwordEnc + "\" ");
           // System.out.println(passwordEnc);
            //System.out.println();

            
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static String getSHA256(String input) {

        String toReturn = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return toReturn;
    }
}
