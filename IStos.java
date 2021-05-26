public interface IStos {
	public class PustyStos extends Exception {
		private static final long serialVersionUID = 7859916563669371818L;
	
		PustyStos() {
			super();
		}
	
	
		PustyStos(String wiadomosc) {
			super(wiadomosc);
		}
	}


	public class PelnyStos extends Exception {
		private static final long serialVersionUID = 1299761034854177828L;
	
		PelnyStos() {
			super();
		}
	
	
		PelnyStos(String wiadomosc) {
			super(wiadomosc);
		}
	}


	public boolean pusty();


	public void wstaw(int i) throws PelnyStos;


	public int pobierz() throws PustyStos;
}
