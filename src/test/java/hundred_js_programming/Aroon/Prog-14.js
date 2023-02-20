/**
 * @Question Find factorial for given no Program 
 */

 function findFactorial(num){
	 let fact =1n;
	 
	 if(num<0){
		 console.log("Number should be higher than 0")
	 }else{
		 for(ind= 1n;ind<=num;ind++){
			 fact *= ind
			 console.log(`The Factorial is ${fact}`)
		 }
		 console.log(`The factorial of ${num} is ${fact}`)
	 }
	 
 }
 
 findFactorial(10n)