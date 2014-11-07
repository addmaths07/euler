import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Euler249 {
	public Map<Integer, Boolean> sumPrimes;
	public ArrayList<Integer> primes;
	public ArrayList<Integer> sumPrimesList = new ArrayList<Integer>();
	public Euler249(int number){
		sumPrimes = deserializeAndRetriveMaxPrimes();
		primes = getPrimes(5000);
	}
	public Euler249(){
		computeMaxPrimesAndSerialize(1548136);
	}
	/**\
	 * 41538
		7.78sec
	 * @param n
	 * @return
	 */
	public static ArrayList<Integer> getPrimes(int n){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		//primes.add(2); // do this at end as this adds that much iterations
		boolean isPrime = true;
		
		for (int i = 3; i<n; i=i+2){
			isPrime = true;
			for (int prime : primes){
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
		primes.add(2);
		return primes;
	}
	
	public Map<Integer, Boolean> getPrimesInMap(int n){
		Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
		primes.put(2,true); // do this at end as this adds that much iterations
		sumPrimesList.add(2);
		boolean isPrime = true;
		for (int i = 3; i<n; i=i+2){
			isPrime = true;
			for (int prime : sumPrimesList){
				if(prime>Math.sqrt(i)){
					break;
				}
				if(i%prime == 0){
					isPrime = false;
					break;
				}
				
			}
			if(isPrime){
				sumPrimesList.add(i);
				primes.put(i,true);
			}
			
		}
		
		return primes;
	}
	
	public void computePrimesAndSerialize(Integer number){
		ArrayList<Integer> primes = getPrimes(number);
		// 669 with 5000	7 times   sum = 1548136
		// 78498 with 1000000 12 times
		System.out.println(primes); //30 sec
		System.out.println(primes.size());
		BigInteger bigSum =new BigInteger("0");
		//Long sum = 0L;
		for (int prime : primes) {
			bigSum = bigSum.add(new BigInteger(Integer.toString(prime)));
			//sum = sum + prime;
		}
		
		SerializerUtil<Integer> u = new SerializerUtil<Integer>();
		u.serializeArrayList(primes, "primes.out");
		System.out.println("Max sum of primes : "+bigSum.toString());
	}
	
	
	public ArrayList<Integer> deserializeAndRetrivePrimes(){
		ArrayList<Integer> primes = null;

		SerializerUtil<Integer> u = new SerializerUtil<Integer>();
		primes =u.deserializeArrayList("primes.out");
		//System.out.println(primes);
		System.out.println("Deserialized Primes ");
		BigInteger bigSum =new BigInteger("0");
		//Long sum = 0L;
		for (int prime : primes) {
			bigSum = bigSum.add(new BigInteger(Integer.toString(prime)));
			//sum = sum + prime;
		}
		//System.out.println("Max sum of primes : "+sum);
		System.out.println("Max sum of primes : "+bigSum.toString());
		
		return primes;
	}
	
	public void computeMaxPrimesAndSerialize(Integer number){
		Map<Integer, Boolean> primes = getPrimesInMap(number);
		// 669 with 5000	7 times   sum = 1548136
		// 78498 with 1000000 12 times
		System.out.println(primes); //30 sec
		System.out.println(primes.size());
		//Long sum = 0L;
		
		SerializerUtil<Integer> u = new SerializerUtil<Integer>();
		u.serializeMap(primes, "primesMaxMap.out");
		u.serializeArrayList(sumPrimesList, "primesMaxList.out");
	}
	
	public Map<Integer, Boolean> deserializeAndRetriveMaxPrimes(){
		Map<Integer, Boolean> primes = null;

		SerializerUtil<Integer> u = new SerializerUtil<Integer>();
		primes =u.deserializeMap("primesMaxMap.out");
		sumPrimesList = u.deserializeArrayList("primesMaxList.out");
		//System.out.println(primes);
		System.out.println("Deserialized Primes ");
		BigInteger bigSum =new BigInteger("0");
		//Long sum = 0L;
		for (Map.Entry<Integer, Boolean> prime : primes.entrySet()){
			bigSum = bigSum.add(new BigInteger(Integer.toString(prime.getKey())));
			//sum = sum + prime;
		}
		//System.out.println("Max sum of primes : "+sum);
		System.out.println("Max sum of primes : "+bigSum.toString());
		
		return primes;
	}
	/**
	 * @param args
	 */
	
	public boolean isPrime(Integer num){
		if(sumPrimes.containsKey(num)){
			return true;
		} else {
			return false;
		}
		
	}
	
	public Long sumSetofPrimes(){
		Long count = 0L;
		for (int i =0; i<sumPrimesList.size(); i++){
			int primeSum = sumPrimesList.get(i);
			for (int j = 2 ; j <=i && j <primes.size(); j++){
				int prime2 = primes.get(j);
				int sum = prime2;
				for (int k = j; sum<=primeSum && k <primes.size(); k++ ) {
				//if(isPrime(prime1+prime2, sumPrimes)){
					if(primeSum == sum){
						count++;
						break;
					}
					sum = sum + primes.get(k);
				}
				
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double startTime = System.currentTimeMillis();
		//euler249 e= new euler249();
		//euler249 e= new euler249(5000);
		//System.out.println(e.sumSetofPrimes());
		//e.computePrimesAndSerialize(1548136);
		//e.deserializeAndRetrivePrimes();
		
		
		//e.computeMaxPrimesAndSerialize(1548136);
		
		
		/*
		Long count = 0L;
		for (int prime1: e.primes){
			for (int prime2: e.primes){
				if(e.isPrime(prime1+prime2)){
					count++;
				}
				
			}
		}k
		
		*/
		System.out.println(Euler249.getPrimes(10000000).size());
		
		double endTime   = System.currentTimeMillis();
		double totalTime = endTime - startTime;
		System.out.println(totalTime/1000);
		
		
	}

}
