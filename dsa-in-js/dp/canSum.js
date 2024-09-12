//Memoization
const canSumMemo = (sum,numbers,memo={})=>{
    if(sum in memo) return memo[sum];
    if (sum == 0) return true;
    if (sum < 0) return false;
    for(let number of numbers){
        let reminder = sum-number;
        if(canSum(reminder,numbers,memo)){
            memo[sum]=true;
            return true
        }
    }
    memo[sum]=false
    return false;
}

const canSum = (sum,numbers)=>{
    if (sum == 0) return true;
    if (sum < 0) return false;
    for(let number of numbers){
        let reminder = sum-number;
        if(canSum(reminder,numbers)){
            return true
        }
    }
    return false;
}
console.log(canSumMemo(10000,[7,9,23]))