import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Utils {

	/**
	 * @param args
	 */
	
	public static ArrayList<Long> getPrimes(long n){
		ArrayList<Long> primes = new ArrayList<Long>();
		//primes.add(2); // do this at end as this adds that much iterations
		boolean isPrime = true;
		
		for (long i = 3; i<n; i=i+2){
			isPrime = true;
			for (long prime : primes){
				if(prime>Math.sqrt(i)){
					break;
				}
				if(i%prime == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
			}
			
		}
		primes.add(2L);
		return primes;
	}
	
	public static ArrayList<Long> getPrimesInRange(long from, long to){
		ArrayList<Long> primes = new ArrayList<Long>();
		ArrayList<Long> primesFinal = new ArrayList<Long>();
		//primes.add(2); // do this at end as this adds that much iterations
		boolean isPrime = true;
		for (long i = 3; i<to; i=i+2){
			isPrime = true;
			for (long prime : primes){
				if(prime>Math.sqrt(i)){
					break;
				}
				if(i%prime == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				primes.add(i);
				if(i>from){
					primesFinal.add(i);
				}
			}
		}
		primesFinal.add(0,2L);
		return primesFinal;
	}
	
	public static Map<Long, Boolean> getPrimesInMap(long n){
		ArrayList<Long> primes = new ArrayList<Long>();
		Map<Long, Boolean> primesMap =  getPrimesInMap(n, primes);
		//System.out.println(primes);
		return primesMap;
	}
	
	public static Map<Long, Boolean> getPrimesInMap(long n, ArrayList<Long> primesList){
		Map<Long, Boolean> primes = new HashMap<Long, Boolean>();
		primes.put(2L,true); // do this at end as this adds that much iterations
		boolean isPrime = true;
		for (long i = 3; i<n; i=i+2){
			isPrime = true;
			for (long prime : primesList){
				if(prime>Math.sqrt(i)){
					break;
				}
				if(i%prime == 0){
					isPrime = false;
					break;
				}
				
			}
			if(isPrime){
				primesList.add(i);
				primes.put(i,true);
			}
			
		}
		primesList.add(0, 2L);
		return primes;
	}
	
	
	public static Map<Long, Boolean> getPrimesInRangeInMap(long from, long to){
		ArrayList<Long> primes = new ArrayList<Long>();
		Map<Long, Boolean> primesMap =  getPrimesInMap(to, primes);
		//System.out.println(primes);
		return primesMap;
	}
	
	public static Map<Long, Boolean> getPrimesInRangeInMap(long from, long to, ArrayList<Long> primesFinal){
		Map<Long, Boolean> primes = new HashMap<Long, Boolean>();
		ArrayList<Long> primesList = new ArrayList<Long>();
		primes.put(2L,true); // do this at end as this adds that much iterations
		boolean isPrime = true;
		for (long i = 3; i<to; i=i+2){
			isPrime = true;
			for (long prime : primesList){
				if(prime>Math.sqrt(i)){
					break;
				}
				if(i%prime == 0){
					isPrime = false;
					break;
				}
				
			}
			if(isPrime){
				primesList.add(i);
				if(i>from){
					primesFinal.add(i);
					primes.put(i,true);
				}
				
			}
			
		}
		primesList.add(0, 2L);
		return primes;
	}
	
	public static Long getPower(long x, long y){
		long temp = x;
		for (long i=0; i<y-1; i++){
			x = x*temp;
			//x = x % 100000000000L;
			//System.out.println(x);
		}
		return x;
	}

	

	public static Long getPower(long x, long y, long limit){
		BigInteger limitI = new BigInteger(String.valueOf(limit)); 
		BigInteger temp = new BigInteger(String.valueOf(x));
		BigInteger xI = new BigInteger(String.valueOf(x));
		//BigInteger yI = new BigInteger(String.valueOf(y));
		//System.out.println(String.valueOf(x));
		for (long i=0; i<y-1; i++){
			xI = xI.multiply(temp);
			xI = xI.mod(limitI);
		}
		//xI = xI.multiply(new BigInteger("27363973596"));
		//xI = xI.mod(limitI);
		return xI.longValue();
	}
	
	public static double raise(double x, int exponent) {
		
        if (exponent < 0) return 1/raise(x, -exponent);
        double power = 1;
        // Loop to compute x^exponent.
        while (exponent > 0) {

            // Is the rightmost exponent bit a 1?
            if ((exponent & 1) == 1) power *= x;

            // Square x and shift the exponent 1 bit to the right.
            x *= x;
            exponent >>= 1;
        }

        return power;
    }

	public static boolean isWholeNumber(double variable){
		
		if ((variable == Math.floor(variable)) && !Double.isInfinite(variable)) {
		    return true;
		} else 
			return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(Utils.getPrimesInMap(1000L));
		Long t1 = System.nanoTime();
		for (int i= 0; i<1000; i++)
		Utils.getPower(12, 17);
		Long t2 = System.nanoTime();
		
		for (int i= 0; i<1000; i++)
		Utils.raise(12, 17);
		Long t3 = System.nanoTime();
		
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		
	}

}
