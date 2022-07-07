package com.example.fresher2022_kotlin_ductm44.assignment1

fun main() {
    print("Enter month: ")
    val month: Int = readLine()!!.toInt()
    print("Enter year: ")
    val year: Int = readLine()!!.toInt()

    if (month in 1..12 && year > 0) {
        daysInMonth(month, year)
    } else println("Month or year is not valid")
}


fun checkLeapYear(year: Int): Boolean {
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        return true
    return false
}

fun daysInMonth(month: Int, year: Int) {
    when (month) {
        1, 3, 5, 7, 8, 10, 12 -> print("There are 31 days in month $month, year $year")
        4, 6, 9, 11 -> print("There are 30 days in month $month, year $year")
        2 -> {
            if (checkLeapYear(year))
                print("There are 29 days in month $month, year $year")
            else
                print("There are 28 days in month $month, year $year")
        }
    }
}