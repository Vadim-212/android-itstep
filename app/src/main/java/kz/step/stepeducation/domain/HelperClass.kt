package kz.step.stepeducation.domain

import java.util.*
import kotlin.collections.ArrayList


class HelperClass {

    // https://leetcode.com/problems/add-two-numbers/solution/
    fun addTwoNumbers(list1: LinkedList<Int>, list2: LinkedList<Int>): LinkedList<Int> {
        val newList = LinkedList<Int>()
        val list1Elem = list1
        val list2Elem = list2
        var remainder = 0

        while(list1Elem.lastOrNull() != null || list2Elem.lastOrNull() != null) {
            val list1Last = if(list1Elem.lastOrNull() != null) list1Elem.pollLast() else 0
            val list2Last = if(list2Elem.lastOrNull() != null) list2Elem.pollLast() else 0
            val sum = remainder + list1Last + list2Last
            remainder = sum / 10
            newList.addLast(sum.rem(10))
        }

        if(remainder > 0)
            newList.addLast(remainder)

        return newList
    }

    // https://leetcode.com/problems/palindrome-number/
    fun palindromeNumber(number: Int): Boolean {
        var originalNumber = number
        if(originalNumber < 0)
            return false

        var invertedNumber = 0
        while(originalNumber > invertedNumber) {
            invertedNumber = invertedNumber * 10 + originalNumber.rem(10)
            originalNumber /= 10
        }

        return originalNumber == invertedNumber || originalNumber == invertedNumber / 10
    }

    // https://leetcode.com/problems/two-sum/
    fun twoSum(givenNums: ArrayList<Int>, target: Int): ArrayList<Int> {
        var firstIndex: Int = -1
        var secondIndex: Int = -1

        for (i: Int in 0 until(givenNums.size)) {
            for(j: Int in 0 until(givenNums.size)) {
                if(i != j) {
                    if(givenNums[i] + givenNums[j] == target) {
                        firstIndex = i
                        secondIndex = j
                    }
                }
            }
        }

        return arrayListOf(firstIndex, secondIndex)
    }

    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    fun lengthOfLongestSubstring(string: String): Int {
        var subStr: String = ""

        for(i: Int in string.indices) {
            if(subStr.contains(string[i]))
                break
            else
                subStr += string[i]
        }

        return subStr.length
    }

    // https://leetcode.com/problems/median-of-two-sorted-arrays/
    fun findMedianSortedArrays(nums1: ArrayList<Int>, nums2: ArrayList<Int>): Double {
        var med = 0.0
        var array1: ArrayList<Int> = nums1
        var array2: ArrayList<Int> = nums2

        array1.sort()
        array2.sort()

        var m: Int = nums1.size
        var n: Int = nums2.size
        if (m > n) {
            val temp: ArrayList<Int> = array1
            array1 = array2
            array2 = temp
            val tmp = m
            m = n
            n = tmp
        }
        var iMin = 0
        var iMax = m
        val half = (m + n + 1) / 2
        while (iMin <= iMax) {
            val i = (iMin + iMax) / 2
            val j = half - i
            if (i < iMax && array2[j - 1] > array1[i])
                iMin = i + 1
            else if (i > iMin && array1[i - 1] > array2[j])
                iMax = i - 1
            else {
                var firstMax: Int
                if (i == 0) {
                    firstMax = array2[j - 1]
                } else if (j == 0) {
                    firstMax = array1[i - 1]
                } else {
                    firstMax = Math.max(array1[i - 1], array2[j - 1])
                }
                if ((m + n) % 2 == 1)
                    med = firstMax.toDouble()
                var secondMin: Int
                if (i == m)
                    secondMin = array2[j]
                else if (j == n)
                    secondMin = array1[i]
                else
                    secondMin = Math.min(array2[j], array1[i])
                med = (firstMax + secondMin) / 2.0
            }
        }
        return med
    }

    // https://leetcode.com/problems/longest-palindromic-substring/
    fun longestPalindrome(str: String): String {
        if(str.isEmpty())
            return str

        var palindromeString = ""
        for(i: Int in str.indices) {
            for(j: Int in str.lastIndex downTo i) {
                if(palindromeString.length >= j - i)
                    break
                else if(str.substring(i,j) == str.substring(i,j).reversed()) {
                    palindromeString = str.substring(i,j)
                    break
                }
            }
        }
        return palindromeString
    }

    // https://leetcode.com/problems/zigzag-conversion/
    fun zigZagConversion(str: String, numRows: Int): String {
        if(numRows == 1)
            return str

        var rows = ArrayList<String>()
        for(i: Int in 0 until numRows)
            rows.add("")

        var curRow = 0
        var down = false

        for(c in str) {
            rows.set(curRow, rows[curRow] + c)
            if(curRow == 0 || curRow == numRows - 1)
                down = down xor true
            curRow += if(down) 1 else -1
        }

        return rows.joinToString("")
    }

    // https://leetcode.com/problems/reverse-integer/
    fun reverseInteger(number: Int): Int {
        var originalNumber = number
        var reversedNumber = 0

        while (originalNumber != 0) {
            val digit = originalNumber % 10
            originalNumber /= 10
            if(reversedNumber > Int.MAX_VALUE || reversedNumber < Int.MIN_VALUE)
                return 0
            reversedNumber = reversedNumber * 10 + digit
        }
        return reversedNumber
    }

    // https://leetcode.com/problems/string-to-integer-atoi/
    fun atoi(str: String): Int {
        val asciiDifference = 48
        var number = 0
        var numberSign = 1

        if(str[0] == '-')
            numberSign *= -1

        for(symbol in str) {
            if(symbol < '0' || symbol > '9')
                if(symbol != '-' && symbol != '+')
                    break
            if(symbol == '-' || symbol == '+' || symbol == ' ')
                continue
            number = (number * 10) + (symbol.toInt() - asciiDifference)

            if(number > Int.MAX_VALUE)
                return if(numberSign < 0) Int.MIN_VALUE else Int.MAX_VALUE
        }

        return number * numberSign
    }


    // https://leetcode.com/problems/regular-expression-matching/
    fun isMatch(str: String, pattern: String): Boolean {
        if (pattern.isEmpty())
            return str.isEmpty()

        if(str.isEmpty())
            return false

        val match = pattern.first() == str.first() || pattern.first() == '.'

        return if (pattern.length >= 2 && pattern[1] == '*')
            isMatch(str, pattern.substring(2)) || match && isMatch(str.substring(1), pattern)
        else
            match && isMatch(str.substring(1), pattern.substring(1))
    }
}