//Memoization
const bestSumMemo=(targetSum,numbers,memo={})=>{
    if(targetSum in memo) return memo[targetSum]
    if(targetSum==0) return []
    if(targetSum<0) return null
    let bestCombination =null
    for(let number of numbers){
        let reminder = targetSum-number
        let reminderCombination = bestSumMemo(reminder,numbers,memo);
        if(reminderCombination!=null){
            reminderCombination= [number,...reminderCombination]
            if(null==bestCombination || reminderCombination.length<bestCombination.length) {
                bestCombination=reminderCombination
            } 
        }
    }
    memo[targetSum]=bestCombination
    return bestCombination
};

const bestSum=(targetSum,numbers)=>{
    if(targetSum==0) return []
    if(targetSum<0) return null
    let bestCombination =null
    for(let number of numbers){
        let reminder = targetSum-number
        let reminderCombination = bestSum(reminder,numbers);
        if(reminderCombination!=null){
            reminderCombination= [number,...reminderCombination]
            if(null==bestCombination || reminderCombination.length<bestCombination.length) {
                bestCombination=reminderCombination
            } 
        }
    }
    return bestCombination
};

console.log(bestSumMemo(100,[1,2,5,25]))