package main;

import labis.exception.LabisException;

public class Niz {

	public int najveciNeparan(int[] niz) throws LabisException{
		
		if(niz == null){
			throw new LabisException();
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] % 2 != 0 && niz[i] > max){
				max = niz[i];
			}
		}
		
		if(max == Integer.MIN_VALUE){
			throw new LabisException();
		}
		
		return max;
	}
	
	public int vratiDvocifreni1(int[] niz) throws LabisException{
		
		if(niz == null || niz.length < 1){
			throw new LabisException();
		}
		
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] >= 10 && niz[i] <= 99){
				return niz[i];
			}
		}
		
		throw new LabisException();
	}
	
	public int[] spojiNeopadajuce(int[] niz1,int[] niz2) throws LabisException{
		if(niz1 == null || niz2 == null){
			throw new LabisException();
		}
		
		int i = 0;
		int j = 0;
		int[] novi = new int[niz1.length + niz2.length];
		int brojac = 0;
		
		while(i != niz1.length && j != niz2.length){
			if(niz1[i] <= niz2[j]){
				novi[brojac] = niz1[i++];
			}
			else{
				novi[brojac] = niz2[j++];
			}
			brojac++;
		}
		
		if(i == niz1.length){
			while( j != niz2.length){
				novi[brojac++] = niz2[j++];
			}
		}
		
		if(j == niz2.length){
			while(i != niz1.length){
				novi[brojac++] = niz1[i++];
			}
		}
		
		return novi;
	}
	
	private double aritmetickaSredina( double[] niz){
		
		double zbir = 0;
		
		for (int i = 0; i < niz.length; i++) {
			zbir = zbir + niz[i];
		}
		
		return zbir/niz.length;
	}
	
	public void parneUvecajZaAS(double[] niz){
		
		double as = aritmetickaSredina(niz);
		
		for (int i = 0; i < niz.length; i++) {
			if(i%2 != 0 && niz[i] % 2 == 0 && niz[i] != 0){
				niz[i] = niz[i] + as;
			}
		}
	}
}
