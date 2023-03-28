/**
 * @Question If Else clause
 */

function useIf(name){
    let pat = /^[a-z]+$/i;
    if (pat.test(name)) {
        console.log(`Hi ${name}`)
    } else {
        console.error("The parameter contains unsupported characters in it")
    }
}

useIf("Aroon1")