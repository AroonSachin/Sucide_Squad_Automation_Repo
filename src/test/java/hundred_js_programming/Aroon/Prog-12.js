/**
 * @Question  Nested If Else clause
 */

const name = "Aroon";
const mark = 60;

if(mark>35){
    if(mark>90){
        console.log(`HI ${name} you passed with A grade`)
    }else{
        console.log(`Hi ${name} You passed`)
    }
}else{
    console.log("You failed")
}