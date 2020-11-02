import java.util.ArrayList;

public class Produccion {
	ArrayList<Character[]> Transformaciones;
	
	public Produccion(String[] Producciones) {
		this.Transformaciones=new ArrayList<Character[]>();
		for (int i = 0; i < Producciones.length; i++) {
			char[] ts=Producciones[i].toCharArray();
			Character[] TS=new Character[ts.length];
			for (int j = 0; j < TS.length; j++) {
				TS[j]=ts[j];
			}
			this.Transformaciones.add(TS);
		}
	}
	
	public Produccion(ArrayList<Character[]> Products) {
		this.Transformaciones=Products;
	}
	
	public void reemplazarProduccion(String[] Producciones) {
		this.Transformaciones=new ArrayList<Character[]>();
		for (int i = 0; i < Producciones.length; i++) {
			char[] ts=Producciones[i].toCharArray();
			Character[] TS=new Character[ts.length];
			for (int j = 0; j < TS.length; j++) {
				TS[j]=ts[i];
			}
			this.Transformaciones.add(TS);
		}
	}
	
	public void cambiarProduccion(int ind, Character[] Transformacion) {
		if(ind<this.Transformaciones.size()) {
			this.Transformaciones.remove(ind);
			this.Transformaciones.add(ind,Transformacion);
		}
	}
	
	public void removerEpsilon() {
		for (int i = 0; i < this.Transformaciones.size(); i++) {
			for (int j = 0; j < this.Transformaciones.get(i).length; j++) {
				if(this.Transformaciones.get(i)[j]=='ɛ'
						||
				   this.Transformaciones.get(i)[j]=='Ɛ') {
					this.Transformaciones.get(i)[j]=null;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("ɛƐ");
	}
}
