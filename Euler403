import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class Euler403 {
	
	private ArrayList<Long> primes;
	private Long subCount = 0L;
	public boolean isRationalArea(double area){
		return Utils.isWholeNumber(area);
	}
	
	public Long getDomainPoints(Long f1, Long f2, Long a, Long b){
		//x^3/3 - (a)*x^2/2 - b*x
		//x^2-(a)x -b
		// y=x^2 & y = ax +b 
		
		Long from  = f1>f2? f2:f1;
		Long to    = f1>f2? f1:f2;
		Long count = 0L;
		for (Long i = from; i <= to; i++){  
			Long y1 = (long)Math.pow(i,2);
			Long y2 = a*i + b;
			count = count + 1 + y2-y1;		
		}
		//System.out.println(count);
		return count;
	}
	
	public Long[] determineRoots2(Long b, Long c){
		Long [] roots = null;
		double discriminent = Math.pow(b,2)- 4*(1)*(c);
		
		if(discriminent>=0){
			Long discriminent_sqrt = (long)Math.sqrt(discriminent);
			if(discriminent == discriminent_sqrt * discriminent_sqrt){
				roots = new Long[2];
				roots[0] = (long)(-b - discriminent_sqrt) /2;
				roots[1] = (long)(-b + discriminent_sqrt) /2;
				//System.out.println("y = x^2 &  y = ("+-b+")x + ("+-c+")");
				//System.out.println("x^2 +("+b+")x + ("+c+")");
				//System.out.println("Has Roots "+roots[0]+", "+roots[1]);
			}
		}

		return roots;
	}
	
	public Long[] determineRoots(Collection<Long> factors, Long a, Long b){
		Long count = 0L;
		Long[] roots = new Long[2];
		roots[0] = 0L;
		roots[1] = 0L;
		Long secFactor = 0L;
		boolean foundRoot = false;
		for (Long factor : factors){
			if (factor == 0L){
				secFactor = -a;
				roots[0] = factor;
				roots[1] = -a;
				foundRoot = true;
				break;
			}
			
			secFactor = b/factor;
			if (Math.abs(a) == Math.abs(secFactor + factor) || Math.abs(a) == Math.abs(factor - secFactor)){
				if (secFactor == a - factor){
					roots[0] = -factor;
					roots[1]  = -secFactor;
					foundRoot = true;
					break;
				} else {
					factor = - factor;
					secFactor = b/factor;
					if (Math.abs(a) == Math.abs(secFactor + factor) || Math.abs(a) == Math.abs(factor - secFactor)){
						if (secFactor == a - factor){
							roots[0] = -factor;
							roots[1] = -secFactor;
							foundRoot = true;
							break;
						}
					}
				}

			} 
		}
		if(foundRoot) {
			//System.out.println("y = x^2 &  y = ("+-a+")x + ("+-b+")");
			//System.out.println("x^2 +("+a+")x + ("+b+")");
			//System.out.println("Has Roots "+roots[0]+", "+roots[1]);
			return roots;
		} else {
			return null;
		}
	}


	public Long getRangeCount(Long a, Long b){
		
		//System.out.println(b);
		//determineRoots(factors, a, b);
		ArrayList<Long> factors;
		//TreeSet<Long> factorsSet;
		
		Long count = 0L;
		Long roots[] = null; 
		//factors = getFactors(b);
		//roots = determineRoots(factors, -a, -b);
		/*
		roots = determineRoots2(-a, -b);
		if(roots!=null){
			if(a == 0  || roots[0] == roots[1]){
				subCount = subCount + getDomainPoints(roots[0], roots[1], a, b);
				//System.out.println("subCount : "+subCount);
			} else if(a<0){
				count =  count + getDomainPoints(roots[0], roots[1], a, b);
				//System.out.println(count);
			}
		}
		*/
		
		if(a == 0){
			roots = determineRoots2(-a, -b);
			if(roots!=null){
				subCount = subCount + getDomainPoints(roots[0], roots[1], a, b);
				//System.out.println("subCount : "+subCount);
			}
		} else if(a<0){
			roots = determineRoots2(-a, -b);
			if(roots!=null){
				if (roots[0] != roots[1]){
					count =  count + getDomainPoints(roots[0], roots[1], a, b);
				}
			}
			//System.out.println(count);
		}
		
		
		// x^2-ax-b
		// find all factors of b which add up to -> a
		return count;
	}
	
	public ArrayList<Long> getFactors(Long b){
		
		ArrayList<Long> lcm = new ArrayList<Long>();
		ArrayList<Long> factors = new ArrayList<Long>();
		if (b==0L){
			factors.add(0L);
			return factors;
		}
		Map<Long, Boolean> factorsMap = new HashMap<Long, Boolean>();
		double sqrt = Math.sqrt(Math.abs(b));
		Long init = System.nanoTime();
		Long remain = b.longValue();
		for (int i=0; i<primes.size(); i++){
			Long prime = primes.get(i);
			if(remain%prime == 0){
				remain = remain/prime;
				lcm.add(prime);
				
				ArrayList<Long> newFactors = new ArrayList<Long>();
				for(Long factor: factors){
					
					Long tempFactor = factor * prime;
					if( tempFactor <= sqrt){                     // I can break at this point if the insertion sort was used
						if(!factorsMap.containsKey(tempFactor)){
							newFactors.add(tempFactor);
							factorsMap.put(tempFactor, true);
						}
					}
				}
				if(!factorsMap.containsKey(prime)){
					factors.add(prime);
					factorsMap.put(prime, true);
				}
				factors.addAll(newFactors);
				
				i--;
			}
			if(remain== 1)
				break;
		}
		//System.out.println(System.nanoTime()-init);
		//System.out.println(lcm);
		//System.out.println(factors);
		factors.add(1L);
		return factors;
	}
	
	public TreeSet<Long> getFactorsSet(Long b){
		ArrayList<Long> lcm = new ArrayList<Long>();
		TreeSet<Long> factors = new TreeSet<Long>();
		Map<Long, Boolean> factorsMap = new HashMap<Long, Boolean>();
		double sqrt = Math.sqrt(b);
		Long init = System.nanoTime();
		Long remain = b.longValue();
		for (int i=0; i<primes.size(); i++){
			Long prime = primes.get(i);
			if(remain%prime == 0){
				remain = remain/prime;
				lcm.add(prime);
				
				ArrayList<Long> newFactors = new ArrayList<Long>();
				for(Long factor: factors){
					
					Long tempFactor = factor * prime;
					if( tempFactor <= sqrt){                     
						if(!factorsMap.containsKey(tempFactor)){
							newFactors.add(tempFactor);
							factorsMap.put(tempFactor, true);
						}
					} else {
						break;
					}
				}
				if(!factorsMap.containsKey(prime)){
					factors.add(prime);
					factorsMap.put(prime, true);
				}
				factors.addAll(newFactors);
				
				i--;
			}
			if(remain== 1)
				break;
		}
		System.out.println(System.nanoTime()-init);
		//System.out.println(lcm);
		System.out.println(factors);
		return factors;
	}
	
	public TreeSet<Long> getFactorsSet2(Long b){
		ArrayList<Long> lcm = new ArrayList<Long>();
		TreeSet<Long> factors = new TreeSet<Long>();
		double sqrt = Math.sqrt(b);
		
		Long remain = b.longValue();
		for (int i=0; i<primes.size(); i++){
			Long prime = primes.get(i);
			if(remain%prime == 0){
				remain = remain/prime;
				lcm.add(prime);
				
				ArrayList<Long> newFactors = new ArrayList<Long>();
				for(Long factor: factors){
					Long tempFactor = factor * prime;
					if( tempFactor <= sqrt){
							newFactors.add(tempFactor);
					} else {
						break;
					}
				}
				factors.add(prime);
				factors.addAll(newFactors);
				i--;
			}
			if(remain== 1)
				break;
		}
		
		//System.out.println(lcm);
		//System.out.println(factors);
		return factors;
	}
	
	public static double calculateEnclosedArea(int a, int b){
		int i=1;
		for (int j= 1; j<10; i=i*10,j++);
		//System.out.println(i);
		//x^3/3 - (a)*x^2/2 - b*x
		return i;
	}
	
	public void compute(){
		
		calculateEnclosedArea(1,1);
		Long aMax = 1000L;  // 1000000000000L;
		Long bMax = 1000L;  // 1000000000000L;
		//Long primesRange = 1L + (long)(Math.sqrt(bMax));
		//System.out.println(primesRange);
		
		//primes = Utils.getPrimesInRange(2,primesRange);
		
		//primes = Utils.getPrimesInRange(2,10000003);
		Long count = 0L;
		Long init = System.nanoTime();
		for (long i = -aMax; i<=0; i++) {
			for (long j = -bMax; j<=bMax; j++) {
				if(Math.abs(i) -1 >Math.abs(j) && j != 0L) 
					continue;
				count = count + getRangeCount(i, j);
			}
		}
		System.out.println(System.nanoTime()-init);
		count = 2*count + subCount + 2*Math.abs((long)Math.sqrt(bMax));
		
		System.out.println("Count: "+count);
		//System.out.println(getRangeCount(1L, 0L));
	}
	/**
	*   For integers a and b, we define D(a, b) as the domain enclosed by the parabola y = x2 and the line y = a·x + b:
		D(a, b) = { (x, y) | x2 <= y <= a·x + b }.
		
		L(a, b) is defined as the number of lattice points contained in D(a, b).
		For example, L(1, 2) = 8 and L(2, -1) = 1.
		
		We also define S(N) as the sum of L(a, b) for all the pairs (a, b) such that the area of D(a, b) is a rational number and |a|,|b| <= N.
		We can verify that S(5) = 344 and S(100) = 26709528.
		
		Find S(1012). Give your answer mod 108.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Euler403 e = new Euler403();
		e.compute();
	}
}
