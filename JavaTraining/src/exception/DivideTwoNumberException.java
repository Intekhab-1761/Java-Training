package exception;

public class DivideTwoNumberException {

	public static void main(String[] args) {

		System.out.println(divide(30,10));
		System.out.println(divide(15,0));

	}
	
	public static int divide(int dividend, int divisor) {
		try {
			if(divisor == 0) {
				throw new ZeroDivisorException("The divisor can't be zero! - Custom exception");
			}
		return dividend/divisor;
		}catch(ArithmeticException exception) {
			System.err.println(exception);
			exception.printStackTrace();
			return 0;
		}catch(ZeroDivisorException exception) {
			System.err.println(exception);
			exception.printStackTrace();
			return 0;
		}
		finally {
			System.out.println("In finally block!");
		}
	}

}
