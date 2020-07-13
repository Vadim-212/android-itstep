package kz.step.stepeducation.domain

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.IOException
import java.util.*

class HelperClass {
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
}