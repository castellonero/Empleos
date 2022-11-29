package net.sytes.ximo.empleos.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal.replace(" ", "-");
		String nombreFinal = cadenaAleatoria(8) + nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File imageFile = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + imageFile.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}

	public static String cadenaAleatoria(int longitud) {
	    // El banco de caracteres
	    String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    // La cadena en donde iremos agregando un carácter aleatorio
	    String cadena = "";
	    for (int x = 0; x < longitud; x++) {
	        int indiceAleatorio = (int) (Math.random() * banco.length() - 1);
	        char caracterAleatorio = banco.charAt(indiceAleatorio);
	        cadena += caracterAleatorio;
	    }
	    return cadena;
	}
	
}
