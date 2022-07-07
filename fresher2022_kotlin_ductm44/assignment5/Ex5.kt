package com.example.fresher2022_kotlin_ductm44.assignment5

import kotlin.random.Random

class Employee() {
    var name: String = ""
    var gender: String = ""
    var doB: String = ""
    var phoneNum: String = ""
    var id: Int = 0
    var qualifi: String = ""

    fun inputInfor() {
        id = Random.nextInt(0, 100)
        print("Name: ")
        name = readLine()!!.toString()
        while (name.isEmpty()) {
            print("Name is required.\nName: ")
            name = readLine()!!.toString()
        }

        print("Gender (male/female): ")
        gender = readLine()!!.toString()

        while (gender.lowercase() != "male" && gender.lowercase() != "female" || gender.isEmpty()) {
            print("Gender is not valid.\nGender (male/female):")
            gender = readLine()!!.toString()
        }

        print("Date of Birth (dd/mm/yyyy): ")
        doB = readLine()!!.toString()

        while (doB.length != 10 || doB.isEmpty()) {
            print("Date of Birth is not valid. Must contains 10 characters\nDate of Birth (dd/mm/yyyy): ")
            doB = readLine()!!.toString()
        }

        print("Phone Number: ")
        phoneNum = readLine()!!.toString()
        while (phoneNum.isEmpty()) {
            print("Phone Number is required.\nPhone Number: ")
            phoneNum = readLine()!!.toString()
        }

        print("Qualification (Intermediate/College/University): ")
        qualifi = readLine()!!.toString()
        while (qualifi != "Intermediate" && qualifi != "College" && qualifi != "University" && qualifi.isNotEmpty()) {
            print("Qualification is not valid.\nQualification (Intermediate/College/University): ")
            qualifi = readLine()!!.toString()
        }
        if (qualifi.isEmpty()) qualifi = "None"
    }

    fun display() {
        println("ID: $id")
        println("Name: $name")
        println("Gender: $gender")
        println("Date of Birth: $doB")
        println("Phone Number: $phoneNum")
        println("Qualification: $qualifi")
    }

    fun update() {
        inputInfor()
    }
}

fun main() {

    var id = 0
    var count = 0
    var listEmployee: MutableList<Employee> = mutableListOf()
    while (true) {
        print("\nEnter control (add/display/update/find): ")
        var control: String = readLine()!!.toString()

        when (control.lowercase()) {
            "add" -> {
                count++
                var nv = Employee()
                nv.inputInfor()
                listEmployee.add(nv)
            }
            "display" -> {
                if (count == 0) {
                    println("Not found information")
                } else {
                    for (i in 0 until count) {
                        println("------------------------")
                        println("Employee ${i + 1}")
                        listEmployee[i].display()
                    }
                }
            }
            "update" -> {
                if (count == 0) {
                    println("Not found information")
                } else {
                    print("\nEnter employee position (1,2,3,....): ")
                    var i: Int = readLine()!!.toInt()
                    i -= 1

                    try {
                        if (i >= listEmployee.size) throw Exception("Out of range. Number of employees is: ${listEmployee.size}")
                        listEmployee[i].update()
                    } catch (e: Exception) {
                        println(e.message)
                    }
                }
            }

            "find" ->{
                print("Please enter your information (ID or Name): ")
                var idName = readLine()!!
                for(i in 0 until listEmployee.size){
                    if(listEmployee[i].name == idName || listEmployee[i].id.toString() == idName) listEmployee[i].display()
                    else println("Not found information")
                }
            }
        }
    }
}