/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codepack;

/**
 *
 * @author arios
 */
import static codepack.SHA256Crypt.getSHA256;
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
            System.out.println();
            System.out.println("Su usuario : " + UsuarioGenerado);
            System.out.println(" ");

            for (int i = 1; i <= 1; i++) {
                // System.out.print("" + (int) (Math.random() * 100));
                password = ((int) (Math.random() * 100));

            }
            String passwordString = Integer.toString(password);

            passwordFinal = apellidoUsuario.substring(0, (apellidoUsuario.length() - 2)) + nombreUsuario.charAt(0) + passwordString;
         
            System.out.println("Esta seria la version sin encriptar: " + passwordFinal);
   
///------------------------------------------------------
            ///SHA2

            String passwordEnc = getSHA256(passwordFinal);

            System.out.println("La version encriptada en SHA256 seria: \"" + passwordEnc + "\" ");
      
///------------------------------------------------------
            ///AES
            //System.out.println("plain pass=" + password);
          
            String encryptedPassword = AESCrypt.encrypt(passwordString);
           
            System.out.println("La version encriptada en AES seria:" + encryptedPassword);
           
            String decryptedPassword = AESCrypt.decrypt(encryptedPassword);
       
            System.out.println("La version desencriptada en AES seria: " + decryptedPassword);
         
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    } 
}
