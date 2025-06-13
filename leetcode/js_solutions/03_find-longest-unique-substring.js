var lengthOfLongestSubstring = function(s) {
    let uniqueChars = [];
    let longestSubLen = 0;

    for(let i = 0; i < s.length; i++) {
        if (!uniqueChars.includes(s[i])) {
            uniqueChars.push(s[i]);
        } else {
            longestSubLen = Math.max(longestSubLen, uniqueChars.length);

            let dupIndex = uniqueChars.indexOf(s[i]);
            uniqueChars = uniqueChars.slice(dupIndex + 1);
            uniqueChars.push(s[i]);
        }
    }

    longestSubLen = Math.max(longestSubLen, uniqueChars.length);

    return longestSubLen;
};

console.log(lengthOfLongestSubstring("abcadsbads"))