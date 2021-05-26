public class Main {
	public static void main(String[] args) {
		ONP onp = new ONP();

		try {
			System.out.println(onp.policz("1 2 + 3 4 + *"));
			System.out.println(onp.policz("2 7 + 3 / 14 3 - 4 * + 2 /"));
			System.out.println(onp.policz("4 2 5 * + 1 3 2 * + /"));
			System.out.println(onp.policz("15 15 -"));
			System.out.println(onp.policz("1 1 1 / -"));
			System.out.println(onp.policz("1 1"));
		} catch (ONP.BlednyZnak error) {
			System.out.println("Blad: " + error.getMessage());
		} catch (ONP.BledneObliczenie error) {
			System.out.println("Blad: " + error.getMessage());
		} catch (ONP.BledneWyrazenie error) {
			System.out.println("Blad: " + error.getMessage());
			try {
				System.out.println(onp.policz("15 14 -"));
			} catch (ONP.BledneWyrazenie err) {
				System.out.println("Oops1");
			} catch (ONP.BlednyZnak err) {
				System.out.println("Oops2");
			} catch (ONP.BledneObliczenie err) {
				System.out.println("Oops3");
			}
		}
	}
}