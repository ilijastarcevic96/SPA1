package linearnestrukture;

import java.util.EmptyStackException;

public interface IStek {

	public int brojElemenata();
	public boolean jePun();
	public boolean jePrazan();
	public boolean push(int podatak);
	public int pop() throws EmptyStackException;
	public int peek() throws EmptyStackException;
}
