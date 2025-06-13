var findMedianSortedArrays = function(nums1, nums2) {
    // let ConcatArr = Array.concat(num1,num2);
    let ConcatArr = [...nums1,...nums2];

    ConcatArr = ConcatArr.sort((a,b)=>{ return a-b})
    if(ConcatArr.length%2 == 0 ){
        val1 = ConcatArr[(ConcatArr.length/2)-1];
        val2 = ConcatArr[ConcatArr.length/2];
        return (val1+val2)/2
    }else{
        return ConcatArr[Math.floor(ConcatArr.length/2)] 
    }
};

console.log(findMedianSortedArrays([1,2],[3,4]))