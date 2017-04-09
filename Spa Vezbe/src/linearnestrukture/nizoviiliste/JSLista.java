package linearnestrukture.nizoviiliste;

import linearnestrukture.CvorJSListe;

public class JSLista {

	CvorJSListe prvi;
	
	public boolean jePrazna(){
		return prvi == null;
	}
	
	public CvorJSListe vratiMin(){
		if(jePrazna()){
			return null;
		}
		
		CvorJSListe pom = prvi;
		CvorJSListe min = prvi;
		
		while(pom.sledeci != null){
			
			if(pom.podatak < min.podatak){
				min = pom;
			}
			
			pom = pom.sledeci;
		}
		
		return min;
	}
	
	public int zbirUCiklicnoj() throws Exception{
		if(prvi == null){
			throw new Exception();
		}
		
		int zbir = prvi.podatak;
		CvorJSListe pom = prvi.sledeci;
		
		while(pom.sledeci != prvi){
			
			zbir = zbir + pom.podatak;
			
			pom = pom.sledeci;
		}
		
		return zbir;
	}
	
	public int izbaciTrenutni(CvorJSListe trenutni) throws Exception{
		if(prvi == null){
			throw new Exception();
		}
		if(trenutni == null){
			throw new Exception();
		}
		if(prvi == trenutni){
			prvi = prvi.sledeci;
			return trenutni.podatak;
		}
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci != trenutni || pom.sledeci != null){
			
			pom = pom.sledeci;
		}
		
		if(pom.sledeci == trenutni){
			pom.sledeci = trenutni.sledeci;
			return trenutni.podatak;
		}
		
		throw new Exception("Cvor nije u listi.");
	}
	
	public void invertovanjeSaPomocnom() throws Exception{
		if(prvi == null || prvi.sledeci == null){
			throw new Exception();
		}
		
		CvorJSListe pom = prvi;
		CvorJSListe l1 = null;
		
		while(pom != null){
			l1 = new CvorJSListe(pom.podatak, l1);
			pom = pom.sledeci;
		}
		prvi = l1;
		
	}
	
	public void invertovanjeBezPomocne() throws Exception{
		if(prvi == null || prvi.sledeci == null){
			throw new Exception();
		}
		
		CvorJSListe pom = prvi;
		CvorJSListe p = prvi;
		
		while(p.sledeci != null){
			pom = p.sledeci;
			p.sledeci = pom.sledeci;
			pom.sledeci = prvi;
			prvi = pom;
		}
	}
	
	public void ispisiListuObrnuto(){
		try {
			invertovanjeBezPomocne();
			
			CvorJSListe pom = prvi;
			
			while(pom.sledeci != null){
				System.out.println(pom.podatak);
				pom = pom.sledeci;
			}
			
			invertovanjeBezPomocne();
		} catch (Exception e) {
			if(prvi != null){
				System.out.println(prvi.podatak);
			}
			else{
				System.out.println("Lista je prazna.");
			}
		}
	}
	
	public int brojVecihOdPrvog() throws Exception{
		
		if(prvi == null){
			throw new Exception();
		}
		
		if(prvi.sledeci == null){
			return 0;
		}
		
		CvorJSListe pom = prvi.sledeci;
		int brojac = 0;
		
		while(pom != null){
			
			if(pom.podatak > prvi.podatak){
				brojac++;
			}
			
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	public int brojPonavljanja(int podatak) throws Exception{
		
		if(prvi == null){
			throw new Exception();
		}
		
		CvorJSListe pom = prvi;
		int brojac = 0;
		
		while(pom != null){
			
			if(pom.podatak == podatak){
				brojac++;
			}
			
			pom = pom.sledeci;
		}
		return brojac;
	}
	
	public int izbaciElementNakonNajmanjeg() throws Exception{
		if(prvi == null || vratiMin().sledeci == null){
			throw new Exception();
		}

		CvorJSListe pom = prvi;
		CvorJSListe p;
		
		while(pom != vratiMin()){
			
			pom = pom.sledeci;
		}
		
		p = pom.sledeci;
		pom.sledeci = p.sledeci;
		
		return p.podatak;
	}
	
	public int brojPozitivnihRekurzivno(CvorJSListe pom){
		if(pom == null){
			return 0;
		}
		else{
			if(pom.podatak > 0){
				return 1+ brojPozitivnihRekurzivno(pom.sledeci);
			}
			else{
				return brojPozitivnihRekurzivno(pom.sledeci);
			}
		}
	}
	
	
}
