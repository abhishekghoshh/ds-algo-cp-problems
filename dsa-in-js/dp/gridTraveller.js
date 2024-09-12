//memoization
const gridTravellerMemo = (row, column,memo={}) => {
    let key = row+"_"+column;
    if (row == 0 || column == 0) return 0;
    if (row == 1 && column == 1) return 1;
    memo[key]= gridTravellerMemo(row - 1, column,memo) + gridTravellerMemo(row, column - 1,memo);
    return memo[key]
}

const gridTraveller = (row, column) => {
    if (row == 0 || column == 0) return 0;
    if (row == 1 && column == 1) return 1;
    return gridTraveller(row - 1, column) + gridTraveller(row, column - 1);
}


console.log(gridTravellerMemo(3,3))