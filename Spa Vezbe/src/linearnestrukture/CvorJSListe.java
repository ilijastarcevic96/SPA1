package linearnestrukture;

public class CvorJSListe {

	public int podatak;
	public CvorJSListe sledeci;
	
	public CvorJSListe(int p,CvorJSListe s) {
		podatak = p;
		sledeci = s;
	}
}
