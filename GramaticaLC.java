import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.JFileChooser;

public class GramaticaLC {
	HashMap<Character, Produccion> Producciones;
	ArrayList<Character> Generadores;
	
	public GramaticaLC() {
		this.Producciones=new HashMap<Character, Produccion>();
		this.Generadores=new ArrayList<Character>();
		
		try {
			JFileChooser File=new JFileChooser();
			int f=File.showOpenDialog(null);
			if(f==JFileChooser.APPROVE_OPTION) {
				BufferedReader Read= new BufferedReader(new FileReader(File.getSelectedFile()));
				String Line=Read.readLine();
				while(Line!=null) {
					String[] Linea=Line.split(" ");
					String[] Prods=new String[Linea.length-1];
					for (int i = 0; i < Prods.length; i++) {
						Prods[i]=Linea[i+1];
					}
					this.Generadores.add(Linea[0].charAt(0));
					this.Producciones.put(Linea[0].charAt(0), new Produccion(Prods));
					Line=Read.readLine();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException ioe) {
			// TODO: handle exception
		}
	}
	
	public void recorrido() {
		//Recorrer las Producciones
		for(Character c:this.Generadores) {
			//Generador Actual
			System.out.print("Gen: "+c+"->");
			//Producciones Actuales
			for (int i = 0; i < this.Producciones.get(c).Transformaciones.size(); i++) {
				for (int j = 0; j < this.Producciones.get(c).Transformaciones.get(i).length; j++) {
					System.out.print(this.Producciones.get(c).Transformaciones.get(i)[j]+" ");
				}
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		GramaticaLC glc=new GramaticaLC();
		glc.recorrido();
		System.out.println("ɛƐ");
	}
}
