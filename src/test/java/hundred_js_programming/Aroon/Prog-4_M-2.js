/**
 *@Question How to get Using input using Scanner 
 *Program in java
 */

let readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

function type1() {
    readline.question('Who are you?', function (para) {
        console.log(`Hi ${para}`)
        readline.close();
    });
}

function type2() {
    readline.question('Who are you?', function (para) {
        console.log(`Hi ${para}`)
        readline.setPrompt(`How are you? ${para}`)
        readline.prompt();
        readline.on('line',function(para2){
            if((para2.toLowerCase()).trim() === 'fine'){
                console.log("Good to hear :)")
                readline.close();
            }else{
                console.log("Hope your doing well ")
                readline.close();
            }
        })
        readline.on('close',function(){
            console.log(`Bye ${para}`)
            process.exit();
        })
    });
}

readline.on('SIGINT',function(){
    readline.close();
    process.exit();
})

type2();