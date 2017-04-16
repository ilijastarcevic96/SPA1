package main;

import labis.cvorovi.CvorDSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;
import labis.test.ListGenerator;

public class DSLista extends ADSLista {

	
	public CvorDSListe sortirajDveUJednu(CvorDSListe prvi1,CvorDSListe prvi2){
		
		CvorDSListe pom1 = prvi1;
		CvorDSListe pom2 = prvi2;
		CvorDSListe novi = null;
		
		while(pom1 != null && pom2 != null){
			if(pom1.podatak >= pom2.podatak){
				novi = new CvorDSListe(pom1.podatak, null, novi);
				pom1 = pom1.sledeci;
			}
			else{
				novi = new CvorDSListe(pom2.podatak, null, novi);
				pom2 = pom2.sledeci;
			}
		}
		
		if(pom1 == null){
			while(pom2 != null){
				novi = new CvorDSListe(pom2.podatak, null, novi);
				pom2 = pom2.sledeci;
			}
		}
		
		if(pom2 == null){
			while(pom1 != null){
				novi = new CvorDSListe(pom1.podatak, null, novi);
				pom1 = pom1.sledeci;
			}
		}
		
		return novi;
	}
	
	public void zameniPrvaDva(){
		if(prvi == null || prvi.sledeci == null){
			return;
		}
		
		CvorDSListe pom = prvi.sledeci;
		
		prvi.sledeci = pom.sledeci;
		prvi.prethodni = pom;
		if(pom.sledeci != null){
			pom.sledeci.prethodni = prvi;
		}
		pom.sledeci = prvi;
		pom.prethodni = null;
		prvi = pom;
	}
	
	private int minValue() throws LabisException{
		if(prvi == null){
			throw new LabisException();
		}
		
		CvorDSListe pom = prvi;
		int min = prvi.podatak;
		
		while(pom != null){
			if(pom.podatak < min){
				min = pom.podatak;
			}
			pom = pom.sledeci;
		}
		
		return min;
	}
	
	public int zbirDeljivihSaMinimumom() throws LabisException{
		
		if(prvi == null){
			throw new LabisException();
		}
		
		CvorDSListe pom = prvi;
		int zbir = 0;
		
		while(pom != null){
			
			if(pom.podatak % minValue() == 0){
				zbir += pom.podatak;
			}
			
			pom = pom.sledeci;
		}
		
		return zbir;
	}
	
	public void invertujSaPomocnom(){
		if(prvi == null || prvi.sledeci == null){
			return;
		}
		
		CvorDSListe pom = prvi;
		CvorDSListe novi = null;
		
		while(pom != null){
			novi = new CvorDSListe(pom.podatak, null, novi);
			if(novi.sledeci != null){
				novi.sledeci.prethodni = novi;
			}
			pom = pom.sledeci;
		}
		
		prvi = novi;
	}
	
	public void invertuj(){
		if(prvi == null || prvi.sledeci == null){
			return;
		}
		
		CvorDSListe pom = prvi;
		CvorDSListe p = prvi;
		
		while(p.sledeci != null){
			pom = p.sledeci;
			p.sledeci = pom.sledeci;
			p.prethodni = pom;
			pom.sledeci = prvi;
			pom.prethodni = null;
			if(p.sledeci != null){
				p.sledeci.prethodni = p;
			}
			prvi = pom;
		}
	}
	
	public CvorDSListe najvecaRazlikaLevoIDesno() throws LabisException{
		if(prvi == null || prvi.sledeci == null || prvi.sledeci.sledeci == null){
			throw new LabisException();
		}
		
		int zbirLevo = 0;
		int zbirDesno = 0;
		int max = 0;
		CvorDSListe maks = null;
		
		CvorDSListe pom = prvi.sledeci;
		
		while(pom.sledeci != null){
			
			zbirLevo = 0;
			zbirDesno = 0;
			CvorDSListe levi = prvi;
	
			while(levi != pom){
				zbirLevo = zbirLevo + levi.podatak;
			}
			
			CvorDSListe desni = pom.sledeci;
			
			while(desni != null){
				zbirDesno += desni.podatak;
			}
			
			if(Math.abs(zbirDesno-zbirLevo) > max){
				max = Math.abs(zbirDesno-zbirLevo);
				maks = pom;
			}
			
			pom = pom.sledeci;
		}
		
		return maks;
	}
	
	public void izbaciSaParnihPozicija(){
		if(prvi == null){
			return;
		}
		
		CvorDSListe pom = prvi;
		
		while(pom != null && pom.sledeci != null){
			pom.sledeci = pom.sledeci.sledeci;
			if(pom.sledeci != null){
				pom.sledeci.prethodni = pom;
			}
			
			pom = pom.sledeci;
		}
	}
	
	public static void main(String[] args) {
		DSLista lista = new DSLista();
		int[] niz = {1,2,3,4};
		ListGenerator.napraviDSListuCommon(lista, niz, false);
		ListGenerator.ispisiDSListu(lista.prvi);
		//lista.zameniPrvaDva();
		//lista.invertujSaPomocnom();
		lista.invertuj();
		ListGenerator.ispisiDSListu(lista.prvi);
	}
}
