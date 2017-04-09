package linearnestrukture;

public class CvorDSListe {

	public int podatak;
	public CvorDSListe sledeci;
	public CvorDSListe prethodni;
	
	public CvorDSListe(int p,CvorDSListe pret,CvorDSListe sled) {
		
		podatak = p;
		sledeci = sled;
		prethodni = pret;
	}
	
}
