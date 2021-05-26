import java.util.List;
import java.util.ArrayList;


public class Stos implements IStos {
	private List<Integer> zawartosc;


	Stos() {
		zawartosc = new ArrayList<Integer>();
	}


	public int dajRozmiar() {
		return zawartosc.size();
	}


	public boolean pusty() {
		return zawartosc.size() == 0;
	}


	public void wstaw(int i) throws IStos.PelnyStos {
		try {
			zawartosc.add(i);
		} catch (OutOfMemoryError error) {
			throw new IStos.PelnyStos();
		}
	}


	public int pobierz() throws IStos.PustyStos {
		if (zawartosc.size() == 0) {
			throw new IStos.PustyStos();
		}

		return zawartosc.remove(zawartosc.size() - 1);
	}
}
