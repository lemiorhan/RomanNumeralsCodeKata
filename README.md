# Integer to Roman Numerals Converter TDD Code Kata

**This is my second attempt for this code kata. The output is totally different, that's fascinating! You can check the code and commits of both master (the first attempt) and secondAttemp branches.**

This is the code kata I use in some of my coder dojos and trainings. The rules of the problem is as follows:

## RULES 

**We should convert integers to Roman Numerals.**
* 1, 2 and 3 become I, II and III respectively.
* 5 and 10 become V and X respectively.
* 6 become VI, as symbols are additive.
* 4 becomes IV, as symbols are used subtractively (in this case subtracting 1 from 5) to avoid repeating a symbol more than three times in a row.
* Only one small-value symbol may be subtracted from any large-value symbol.
* The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear more than three times if they appear non-sequentially, such as XXXIX.) "D", "L", and "V" can never be repeated.
* "I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
* A number written in Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. In the above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.

**For reference purposes, here are some integers and the corresponding roman numerals.**

- 1000 - M
- 900 - CM
- 500 - D
- 400 - CD
- 100 - C
- 90 - XC
- 50 - L
- 40 - XL
- 10 - X
- 9 - IX
- 5 - V
- 4 - IV
- 1 - I

You can check the commits and the diffs to identify how TDD evolves the code from scratch.

## ADDITIONAL RULES FOR THE KATA

* Only one character roman numbers (such as I, V, X, L, C, D, M) can be kept in a map. 
* Code coverage should be 100%.
* Your code should contain answers of these following questions:
     * how to determine adding specific single character
     * how to determine adding multiple characters having a prefix, like IV or XC.
     * how to determine adding multiple characters having suffixes, like XIII or CX.
