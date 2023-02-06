/**
 * @Question Print Reverse number in java program
 */

let n = 20
let reverse = 0;
while (n != 0) {
	reverse = reverse * 10;
	reverse = reverse + n % 10;
	n = n / 10;
}
console.log("Reverse of entered number is " + reverse);