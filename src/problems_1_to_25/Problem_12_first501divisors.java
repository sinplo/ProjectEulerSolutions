package problems_1_to_25;


public class Problem_12_first501divisors {
	private static long currentTriangle =3;
	private static long triangleOrder = 2;

	public static void calculateFirstDivisor(){

		int dividerCount = 0;

		for(long index = 1; index < currentTriangle ; index++){
			long smallDivider = index;
			long bigDivider = currentTriangle / smallDivider;
			if(bigDivider < smallDivider){
				triangleOrder +=1;
				currentTriangle +=triangleOrder;
				index = 0;
				dividerCount =0;
			}else {
				if(currentTriangle % index == 0){
					if(bigDivider == smallDivider){
						dividerCount ++;
					}else{

						dividerCount +=2;
					}

					if(dividerCount > 500 ){
						break;
					}
				}
			}
		}

	}

	//reverse order performance
	//much Slower than with incremented index calculateFirstDivisor
	public static void calculateFirstDivisor2(){

		int dividerCount = 0;

		for(long index = currentTriangle; index > 0 ; index--){
			long bigDivider = index;
			long smallDivider = currentTriangle / bigDivider;
			if(bigDivider < smallDivider){
				triangleOrder +=1;
				
				currentTriangle +=triangleOrder;
				index = currentTriangle +1;
				System.out.println(currentTriangle);
				dividerCount =0;
			}else {
				if(currentTriangle % index == 0){
					if(bigDivider == smallDivider){
						dividerCount ++;
					}else{

						dividerCount +=2;
					}

					if(dividerCount > 500 ){
						break;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		calculateFirstDivisor2();
		//correct answer 76576500
		System.out.println(currentTriangle);

	}

}
