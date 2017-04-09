package linearnestrukture.nizoviiliste;

import linearnestrukture.CvorDSListe;

public class DSLista {

	private CvorDSListe prvi;
	
	public boolean jePrazna(){
		return prvi == null;
	}
	
	public void ubaciUSort(int podatak){
		if(prvi == null){
			CvorDSListe c = new CvorDSListe(podatak, null, null);
			prvi = c;
			return;
		}
		
		if(prvi.podatak > podatak){
			CvorDSListe c = new CvorDSListe(podatak, null, prvi);
			prvi = c;
			return;
		}
		
		CvorDSListe pom = prvi.sledeci;
		boolean ubacen = false;
		
		while(pom.sledeci != null){
			if(pom.podatak > podatak){
				CvorDSListe c = new CvorDSListe(podatak, pom.prethodni,pom);
				c.prethodni.sledeci = c;
				pom.prethodni = c;
				ubacen = true;
			}
		}
		
		if(!ubacen){
			CvorDSListe c = new CvorDSListe(podatak, pom, null);
			pom.sledeci = c;
		}
	}
}
