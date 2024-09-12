//memoization
const howSumMemo = (targetSum, numbers, memo = {}) => {
    if (targetSum in memo) return memo[targetSum]
    if (targetSum == 0) return []
    if (targetSum < 0) return null
    for (let number of numbers) {
        let reminder = targetSum - number
        let reminderResulet = howSum(reminder, numbers, memo)
        if (reminderResulet !== null) {
            memo[targetSum] = [...reminderResulet, number]
            return memo[targetSum]
        }
    }
    memo[targetSum] = null
    return null
}

const howSum = (targetSum, numbers) => {
    if (targetSum == 0) return []
    if (targetSum < 0) return null
    for (let number of numbers) {
        let reminder = targetSum - number
        let reminderResulet = howSum(reminder, numbers)
        if (reminderResulet !== null) {
            return [...reminderResulet, number]
        }
    }
    return null
}

memo = {}
console.log(howSumMemo(7, [2, 3, 5], memo))
console.log(memo)