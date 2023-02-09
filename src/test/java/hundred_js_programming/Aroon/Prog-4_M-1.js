/**
 *@Question How to get Using input using Scanner 
 *Program in java
 */
//npm install prompt-sync

const prompt = require('prompt-sync')({sigint: true});
// const input = prompt("Please enter your name:")
// console.log(`Hi ${input}`)
console.log("Hi "+ prompt("Please enter your name:"))