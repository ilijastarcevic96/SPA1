package linearnestrukture.stekired;

import linearnestrukture.IRed;

public class StatickiRed implements IRed {

	private int[] niz;
	private int p;
	private int k;
	private int brojElemenata;
	
	public StatickiRed(int kapacitet) {
		niz = new int[kapacitet];
		p = 0;
		k = -1;
		brojElemenata = 0;
	}
	
	@Override
	public boolean jePun() {
		return brojElemenata == niz.length;
	}

	@Override
	public boolean jePrazan() {
		return brojElemenata == 0;
	}

	@Override
	public boolean enqueue(int podatak) {
		if(jePun()){
			return false;
		}
		
		k++;
		
		if(k == niz.length){
			k = 0;
		}
		
		niz[k] = podatak;
		brojElemenata++;
		return true;
	}

	@Override
	public int dequeue() throws Exception {
		if(jePrazan()){
			throw new Exception();
		}
		int podatak = niz[p];
		p++;
		if(p == niz.length){
			p = 0;
		}
		brojElemenata--;
		return podatak;
	}

	@Override
	public int pocetak() throws Exception {
		if(jePrazan()){
			throw new Exception();
		}
		return niz[p];
	}

	@Override
	public int kraj() throws Exception {
		if(jePrazan()){
			throw new Exception();
		}
		return niz[k];
	}
	
	public void ispisi1(){
		if(jePrazan()){
			return;
		}
		for (int i = p; i != k;) {
			
			System.out.println(niz[i]);
			
			i++;
			if(i == niz.length){
				i = 0;
			}
		}
		
		System.out.println(niz[k]);
	}
	
	public void ispisi2(){
		if(jePrazan()){
			return;
		}
		int i = p;
		int br = 0;
		
		while(br < brojElemenata){
			System.out.println(niz[i]);
			br++;
			i++;
			if(i == niz.length){
				i=0;
			}
		}
	}

}
