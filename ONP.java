public class ONP {
	public class BledneObliczenie extends Exception {
		private static final long serialVersionUID = -6319845239020323091L;
	
		BledneObliczenie() {
			super();
		}
	
	
		BledneObliczenie(String wiadomosc) {
			super(wiadomosc);
		}
	}


	public class BledneWyrazenie extends Exception {
		private static final long serialVersionUID = -5763527089808635425L;
	
		BledneWyrazenie() {
			super();
		}
	
	
		BledneWyrazenie(String wiadomosc) {
			super(wiadomosc);
		}
	}


	public class BlednyZnak extends Exception {
		private static final long serialVersionUID = -8862936577214841968L;
	
		BlednyZnak() {
			super();
		}
	
	
		BlednyZnak(String wiadomosc) {
			super(wiadomosc);
		}
	}


	private Stos stos;


	ONP() {}


	public int policz(String wyrazenie) throws BlednyZnak, BledneObliczenie, BledneWyrazenie {
		stos = new Stos();

		String[] argumenty = wyrazenie.split(" ");

		for (String argument : argumenty) {
			if (argument.matches("[-+*/]")) {
				try {
					stos.wstaw(policz(stos, argument));
				} catch (Stos.PelnyStos error) {
					throw new BledneWyrazenie("Wyrazenie bylo zbyt skomplikowane");
				} catch (Stos.PustyStos error) {
					throw new BledneWyrazenie("Zabraklo liczb");
				} catch (BledneObliczenie error) {
					throw error;
				}
			} else {
				try {
					int liczba = Integer.parseInt(argument);
					stos.wstaw(liczba);
				} catch (NumberFormatException error) {
					throw new BlednyZnak("Nieprawidlowy znak: '" + argument + "'");
				} catch (Stos.PelnyStos error) {
					throw new BledneWyrazenie("Wyrazenie bylo zbyt skomplikowane");
				}
			}
		}

		try {
			if (stos.dajRozmiar() > 1) {
				throw new BledneWyrazenie("Zabraklo operacji");
			}
			return stos.pobierz();
		} catch (Stos.PustyStos error) {
			throw new BledneWyrazenie("Wyrazenie bylo puste");
		}
	}


	private int policz(Stos stos, String argument) throws Stos.PelnyStos, Stos.PustyStos, BledneObliczenie {
		int a, b;
		try {
			b = stos.pobierz();
			a = stos.pobierz();
		} catch (Stos.PustyStos error) {
			throw error;
		}

		if (argument.equals("+")) {
			return a + b;
		} else if (argument.equals("-")) {
			return a - b;
		} else if (argument.equals("*")) {
			return a * b;
		} else {
			if (b == 0) {
				throw new BledneObliczenie("Blad: proba dzielenia przez 0");
			}
			return a / b;
		}
	}
}
