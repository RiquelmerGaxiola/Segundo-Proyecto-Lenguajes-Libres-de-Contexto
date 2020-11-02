import java.util.ArrayList;

public class FnCH extends GramaticaLC{
	
	public FnCH() {
		super();
		nuevoInicio();
		eTransiciones();
	}
	
	private void nuevoInicio() {
		for(Character c:this.Generadores) {
			if(c.equals('S')) {
				this.Generadores.add(0,'α');
				Character[] cha=new Character[]{'S'};
				ArrayList<Character[]> charA=new ArrayList<Character[]>();
				charA.add(cha);
				this.Producciones.put(this.Generadores.get(0), new Produccion(charA));
				break;
			}
		}	
	}
	
	private void eTransiciones() {
		for(Character c:this.Generadores) {
			this.Producciones.get(c).removerEpsilon();
		}
	}
	
	public static void main(String[] args) {
		FnCH Chomsky= new FnCH();
		Chomsky.recorrido();
		System.out.println("ɛƐ");
	}
}
