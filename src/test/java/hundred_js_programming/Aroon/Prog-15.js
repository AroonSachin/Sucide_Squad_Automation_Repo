/**
 * @Question How to complete 2 string in Java program
 */

 var str1 = "abcd"
 var str2 = "abcd"
 
 function compareSTR(arg1,arg2){
	 if(arg1.localeCompare(arg2)>=0){
		 console.log("Both the strings are same")
	 }else{
		 console.log("Both the strings are not same")
	 }
 }
compareSTR(str1,str2)