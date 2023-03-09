/**
 * @Question Command line Argument.
 */
 const args = require('yargs').argv;

 
 function meth1() {
     //Usind process.argv
     console.log("Usind process.argv")
     for (let index = 0; index < process.argv.length; index++) {
         cmndArgs(`index ${index} argument -> ${process.argv[index]}`)
 
     }
 }
 function meth2() {
     //Usind yargs
     console.log("Usind yargs")
 
     cmndArgs(`arg1: ${args.argument1}`)
     cmndArgs(`arg2: ${args.argument2}`)
 }
 meth1();

