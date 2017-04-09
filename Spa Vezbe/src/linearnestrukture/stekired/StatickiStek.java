package linearnestrukture.stekired;

import java.util.EmptyStackException;

import linearnestrukture.IStek;

public class StatickiStek implements IStek {

	private int[] stek;
	private int vrh;
	
	public StatickiStek(int kapacitet) {
		stek = new int[kapacitet];
		vrh = -1;
	}
	
	@Override
	public int brojElemenata() {
		return vrh + 1;
	}

	@Override
	public boolean jePun() {
		
		return vrh + 1 == stek.length; 
	}

	@Override
	public boolean jePrazan() {
		return vrh == -1;
	}

	@Override
	public boolean push(int podatak) {
		if(jePun()){
			return false;
		}
		vrh++;
		stek[vrh] = podatak;
		return true;
	}

	@Override
	public int pop() throws EmptyStackException {
		if(jePrazan()){
			throw new EmptyStackException();
		}
		int podatak = stek[vrh];
		vrh --;
		return  podatak;
	}

	@Override
	public int peek() throws EmptyStackException {
		if(jePrazan()){
			throw new EmptyStackException();
		}
		return stek[vrh];
	}

}
