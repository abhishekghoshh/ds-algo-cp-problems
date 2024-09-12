//memoization
const fibMem=(n,memo={})=>{
    if(n in memo) return memo[n];
    if(n<=2) return 1;
    memo[n]=fibMem(n-1,memo)+fibMem(n-2,memo);
    return memo[n];
}



const fib=(n)=>{
    if(n<=2) return 1;
    return fib(n-1)+fib(n-2);
}
console.log(fibMem(50))