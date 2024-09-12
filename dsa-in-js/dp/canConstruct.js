//Memoization
const canConstructMemo=(targetString,words,memo={})=>{
    if(targetString in memo) return memo[targetString]
    if(targetString=="") return true
    for(let word of words){
        if(targetString.indexOf(word)==0){
            let suffix = targetString.slice(word.length)
            if(canConstruct(suffix,words,memo)){
                memo[targetString]=true
                return true
            }
        }
    }
    memo[targetString]=false
    return false
}

const canConstruct=(targetString,words)=>{
    if(targetString=="") return true
    for(let word of words){
        if(targetString.indexOf(word)==0){
            let suffix = targetString.slice(word.length)
            if(canConstruct(suffix,words)){
                return true
            }
        }
    }
    return false
}

console.log(canConstructMemo("abcaeop",["abc","ab","ac","c","a","e","op"]))