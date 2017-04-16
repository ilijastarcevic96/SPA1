package main;

import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;
import labis.test.ListGenerator;

public class JSLista extends AJSLista {

	public int izbaciNeki(CvorJSListe neki) throws LabisException{
		
		if(prvi == null || neki == null){
			throw new LabisException("Nema sta da se izbaci");
		}
		
		if(prvi == neki){
			prvi = prvi.sledeci;
			return neki.podatak;
		}
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci != null && pom.sledeci != neki){
			
			pom = pom.sledeci;
		}
		
		if(pom.sledeci != null){
			pom.sledeci = neki.sledeci;
			
			return neki.podatak;
		}
		
		throw new LabisException("Neki ne postoji u listi.");
	}
	
	public boolean daLiPostojiRekurzivno(CvorJSListe prvi,int p){
		return prvi != null && (prvi.podatak == p || daLiPostojiRekurzivno(prvi.sledeci,p));
	}
	
	public boolean neopadajucaRekurzivno(CvorJSListe prvi){
		if(prvi == null || prvi.sledeci == null){
			return true;
		}
		if(prvi.podatak > prvi.sledeci.podatak){
			return true;
		}
		return neopadajucaRekurzivno(prvi.sledeci);
	}
	
	public int najduzaNeopadajucaPodlista() throws LabisException{
		if(prvi == null){
			return 0;
		}
		
		CvorJSListe pom = prvi;
		int najduzi = 0;
		int trenutni = 1;
		
		while(pom.sledeci != null){
			
			if(pom.podatak <= pom.sledeci.podatak){
				trenutni++;
			}
			else{
				if(trenutni > najduzi){
					najduzi = trenutni;
					trenutni = 1;
				}
			}
			
			pom = pom.sledeci;
		}
		
		if(trenutni > najduzi){
			najduzi = trenutni;
		}
		return najduzi;
	}
	
	public void ucesljaj(CvorJSListe prvi1,CvorJSListe prvi2){
		
		if(prvi1 == null && prvi2 == null){
			return;
		}
		
		CvorJSListe p1 = prvi1.sledeci;
		CvorJSListe p2 = prvi2.sledeci;
		
		prvi1.sledeci = prvi2;
		prvi2.sledeci = p1;
		
		ucesljaj(p1,p2);
		
	}
	
	public boolean fibonacci(){
		if(prvi == null){
			return false;
		}
		
		if(prvi.sledeci == null){
			return prvi.podatak == 1;
		}
		
		if(prvi.podatak != 1 || prvi.sledeci.podatak != 1){
			return false;
		}
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci.sledeci != null){
			
			if(pom.podatak + pom.sledeci.podatak != pom.sledeci.sledeci.podatak){
				return false;
			}
			
			pom = pom.sledeci;
		}
		
		return true;
	}
	
	public void izbaciDrugiITreciOdKraja(){
		if(prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null){
			return;
		}
		
		if(prvi.sledeci.sledeci.sledeci.sledeci == null){
			prvi = prvi.sledeci.sledeci;
			return;
		}
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci.sledeci.sledeci.sledeci != null){
			
			pom = pom.sledeci;
		}
		
		pom.sledeci = pom.sledeci.sledeci.sledeci;
	}
	
	public CvorJSListe simetricnaRazlika(CvorJSListe prvi1,CvorJSListe prvi2){
		
		CvorJSListe novi = null;
		CvorJSListe pom = prvi1;
		
		while(pom != null){
			
			if(!daLiPostojiRekurzivno(prvi2, pom.podatak)){
				novi = new CvorJSListe(pom.podatak, novi);
			}
			
			pom = pom.sledeci;
		}
		
		pom = prvi2;
		
		while(pom != null){
			if(!daLiPostojiRekurzivno(prvi1, pom.podatak)){
				novi = new CvorJSListe(pom.podatak, novi);
			}
			pom = pom.sledeci;
		}
		
		return novi;
	}
	
	public void izbaciDuplikate(){
		
		if(prvi == null){
			return;
		}
		
		CvorJSListe spori = prvi;
		CvorJSListe brzi = prvi;
		
		while(spori.sledeci != null){
			brzi = spori;
			
			while(brzi.sledeci != null){
				if(brzi.sledeci.podatak == spori.podatak){
					brzi.sledeci = brzi.sledeci.sledeci;
				}
				else{
					brzi = brzi.sledeci;
				}
			}
			
			spori = spori.sledeci;
		}
		
	}
	
	public void invertuj(){
		
		 if(prvi == null || prvi.sledeci == null){
			 return;
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
	
	public CvorJSListe kloniraj(CvorJSListe pom){
		if(pom == null){
			return pom;
		}
		
		CvorJSListe novi = new CvorJSListe(pom.podatak, kloniraj(pom.sledeci));
		
		return novi;
	}
	
	public void izbaciVeceOdSvogPrethodnika(){
		if(prvi == null || prvi.sledeci == null){
			return;
		}
		
		CvorJSListe pom = prvi;
		
		while(pom.sledeci != null){
			if(pom.podatak < pom.sledeci.podatak){
				pom.sledeci = pom.sledeci.sledeci;
			}
			else{
				pom = pom.sledeci;
			}
		}
	}
	
	public static void main(String[] args) {
		JSLista lista = new JSLista();
		int[] niz = {1,2,3,4};
		
		ListGenerator.napraviJSListuCommon(lista, niz, false);
		lista.invertuj();
		ListGenerator.ispisiJSListu(lista.prvi);
	}
}
