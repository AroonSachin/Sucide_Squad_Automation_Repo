/**
 * @Question How to swap 2 no using 3rd variable Program
 */


function swapNumber(aVal,bVal){
    console.log(`Value of A is: ${aVal} and B is : ${bVal}`)
    const temp = aVal;
    aVal=bVal;
    bVal=temp;
    console.log(`Value of A is: ${aVal} and B is : ${bVal} (After Swap)`)
}

swapNumber(10,20)