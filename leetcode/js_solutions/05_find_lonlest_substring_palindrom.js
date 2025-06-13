function longestPalindrome(s) {
    if (s == null || s.length < 1) return "";
    let longest = "";

    for (let i = 0; i < s.length; i++) {
        let odd = expandFromCenter(s, i, i);
        let even = expandFromCenter(s, i, i + 1);

        if (odd.length > longest.length) {
            longest = odd;
        }
        if (even.length > longest.length) {
            longest = even;
        }
    }

    return longest;
}

function expandFromCenter(s, left, right) {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
        left--;
        right++;
    }
    return s.substring(left + 1, right);
}

console.log(longestPalindrome("dabbad"));