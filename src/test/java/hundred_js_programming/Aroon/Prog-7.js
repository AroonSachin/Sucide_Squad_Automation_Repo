/**
 * @Question How to swap 2 no without using 3rd variable
 */

function swapWithout3rdVar(aVal,bVal){
    console.log(`Value of A is: ${aVal} and B is : ${bVal}`)
    aVal=bVal + aVal;
    bVal=aVal-bVal;
    aVal=aVal-bVal
    console.log(`Value of A is: ${aVal} and B is : ${bVal} (After Swap)`)
}
swapWithout3rdVar(10,20)