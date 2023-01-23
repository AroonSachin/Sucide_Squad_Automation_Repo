/**
 * @Question .How to convert Fahrenheit to Celsius Program
 * @param {*} cTemp 
 */


function CtoF(cTemp){
    var converter = cTemp*9 / 5 + 32;
    console.log(cTemp+'\xB0C is ' + converter + ' \xB0F.')
}

CtoF(100)