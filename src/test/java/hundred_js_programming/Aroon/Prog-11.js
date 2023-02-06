/**
 * @Question If Else clause in java- Program 2
 */
 const prompt = require('prompt-sync')({sigint: true});
function ifElse2(){
    const name = prompt("Please enter your name: ")
    const mark = prompt("Enter your mark : ")

    if(mark>35){
        console.log(`Hi ${name} you passed.`)
    }else{
        console.error(`Hey ${name}! You failed looser.`)
    }
}
ifElse2()