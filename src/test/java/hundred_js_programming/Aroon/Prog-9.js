/**
 * @Question Find Largest no
 */

let arr = [20,50,30,10,60,80,40,11,22]
console.log(`The largest number is : ${Math.min.apply(this,arr)}`)
console.log(`The largest number is : ${arr.reduce((a, b) => Math.max(a, b))}`)
console.log(arr.length)