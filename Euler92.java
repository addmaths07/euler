import java.util.HashMap;
import java.util.Map;


public class Euler92 {

	public Map<Long, Boolean> oneMap = new HashMap<Long, Boolean>();
	public Map<Long, Boolean> eightyNineMap = new HashMap<Long, Boolean>();
	
	public Euler92() {
		oneMap.put(1L, true);
		oneMap.put(44L, true);
		oneMap.put(32L, true);
		oneMap.put(13L, true);
		oneMap.put(10L, true);
		
		eightyNineMap.put(89L, true);
		eightyNineMap.put(85L, true);
		eightyNineMap.put(145L, true);
		eightyNineMap.put(42L, true);
		eightyNineMap.put(20L, true);
		eightyNineMap.put(4L, true);
		eightyNineMap.put(16L, true);
		eightyNineMap.put(37L, true);
		eightyNineMap.put(58L, true);
		eightyNineMap.put(89L, true);
		
	}
	public Long getDigiSqSum(long num){

		Long sum = 0L;
		while(num!=0){
			Long dig = num%10;
			sum = sum + dig*dig;
			num = num/10;
			
		}
		return sum;
	}
	
	public void populateEightNineMap(Long num){
		
		
	}
	
	public boolean isSpecialNum(Long num){
		
		Long temp = num;
		Map<Long, Boolean> tempMap = new HashMap<Long, Boolean>();
		do{
			if(eightyNineMap.containsKey(temp)){
				eightyNineMap.putAll(tempMap);
				//System.out.println(num);
				return true;
			} else if (oneMap.containsKey(temp)){
				oneMap.putAll(tempMap);
				//System.out.println(num);
				return false;
			}
			
			tempMap.put(num, true);
			temp = getDigiSqSum(temp);
			
			//System.out.println(temp);
			
		} while(true);
	}
	public String compute(Long input){
		Long total = 0L;
		Long i;
		for (i=1L; i< input; i++){
			if(isSpecialNum(i))
				total = total +1;
			
		}
		
		return total.toString();
	}
	public static void main(String[] args) {
		Euler92 e = new Euler92();
		//System.out.println(e.compute(10000000L));
		System.out.println(e.compute(10000000L));
		//System.out.println(e.isSpecialNum(44L));
	}
}
