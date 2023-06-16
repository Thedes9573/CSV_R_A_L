package com.example.demo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		leector();
	}
	public static void lector() {
		BufferedReader csvReader;
		List<String> usuarios=new ArrayList<>();;
		try {
			csvReader = new BufferedReader(new FileReader("/home/gabriel_espino/Documents/workspace-spring-tool-suite-4-4.18.1.RELEASE/demo (2)/demo/src/main/java/com/example/demo/aqui.csv"));
			String row="";
			try {
				while((row=csvReader.readLine())!=null) {
					String[] data = row.split(",");
					
					usuarios.add(row);
					System.out.println(data[0]);
					System.out.println(data[1]);
					System.out.println(data[2]);
					System.out.println(data[3]);
				}
				csvReader.close();
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String des ="";
				System.out.println("¿Quiere agregar a un usuario?");
				des = br.readLine();
				if(des.equals("Si")){
				do {
					System.out.println("Inserte nombre");
					String nombre =br.readLine();
					System.out.println("Inserte apellido paterno");
					String apellidoP =br.readLine();
					System.out.println("Inserte apellido Materno");
					String apellidoM =br.readLine();
					System.out.println("Inserte id");
					String id =br.readLine();
					usuarios.add(nombre+","+apellidoP+","+apellidoM+","+id);
					System.out.println("¿Quiere agregar a otro usuario?");
					des = br.readLine();
				}while(des.equals("Si"));
				}
				escritor(usuarios);
				System.out.println(usuarios);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public static void escritor(List<String> usuarios) {
			try {
				String usuario;
				FileWriter csvWritter = new FileWriter("/home/gabriel_espino/Documents/workspace-spring-tool-suite-4-4.18.1.RELEASE/demo (2)/demo/src/main/java/com/example/demo/aqui.csv");
				for(int i=0;i<usuarios.size();i++) {
					usuario=usuarios.get(i);
					csvWritter.append(usuario+"\n");
				}
				csvWritter.flush();
				csvWritter.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

}
