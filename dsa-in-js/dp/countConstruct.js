//Memoization
const countConstructMemo = (target,words,memo={})=>{
    if(target in memo) return memo[target]
    if(target == "") return 1
    let count = 0
    for(let word of words){
        if(target.indexOf(word)==0){
            let suffix = target.slice(word.length)
            count = count+countConstructMemo(suffix,words,memo)
        }
    }
    memo[target]=count
    return count
}

const countConstruct = (target,words)=>{
    if(target == "") return 1
    let count = 0
    for(let word of words){
        if(target.indexOf(word)==0){
            let suffix = target.slice(word.length)
            count = count+countConstruct(suffix,words)
        }
    }
    return count
}

console.log(countConstructMemo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",["a","aa","aaa"]))