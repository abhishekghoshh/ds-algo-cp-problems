//Memoization
const allConstructMemo = (target,words,memo={})=>{
    if(target in memo) return memo[target]
    if(target=="") return [[]]
    let allPossibleways=[]
    for(let word of words){
        if(target.indexOf(word)==0){
            let suffixWays = allConstructMemo(target.slice(word.length),words,memo)
            suffixWays = suffixWays.map(way=>[word,...way])
            allPossibleways.push(...suffixWays)
        }
    }
    memo[target]=allPossibleways
    return allPossibleways
}

const allConstruct = (target,words)=>{
    if(target=="") return [[]]
    let allPossibleways=[]
    for(let word of words){
        if(target.indexOf(word)==0){
            let suffixWays = allConstruct(target.slice(word.length),words)
            suffixWays = suffixWays.map(way=>[word,...way])
            allPossibleways.push(...suffixWays)
        }
    }
    return allPossibleways
}

console.log(allConstructMemo("abcdabcdababcdabccdabababcbccdabc",["a","b","c","d","ab","cd","abc"]))
