package com.example.fresher2022_kotlin_ductm44.assignment3

open class Person(_name: String) {
    var name: String = ""
    var gender: String = ""
    var doB: String = ""
    var addr: String = ""

    constructor(_name: String, _gender: String, _doB: String, _addr: String) : this(_name) {
        this.name = _name
        this.gender = _gender
        this.doB = _doB
        this.addr = _addr
    }

    open fun inputInfo() {
        print("Name: ")
        name = readLine()!!.toString()
        print("Gender: ")
        gender = readLine()!!.toString()
        print("Date of Birth: ")
        doB = readLine()!!.toString()
        print("Address: ")
        addr = readLine()!!.toString()
    }

    open fun showInfo() {
        print("Name: $name\nGender: $gender\nDate of Birth: $doB\nAddress: $addr")
    }
}

class Student(_name: String, _gender: String, _doB: String, _addr: String) :
    Person(_name, _gender, _doB, _addr) {
    var id: String = ""
    var gpa: Double = 0.0
    var email: String = ""

    override fun inputInfo() {
        print("Enter Student Information\n")
        super.inputInfo()
        print("Student ID: ")
        id = "SV" + readLine().toString()
        print("GPA: ")
        gpa = readLine()!!.toDouble()
        while (gpa < 0.0 || gpa > 10.0) {
            print("GPA is not valid, must be in range (0,10)")
            print("\nGPA: ")
            gpa = readLine()!!.toDouble()
        }
        print("Email: ")
        email = readLine()!!.toString()
        while (!email.contains("@")) {
            print("Email is not valid, must contains '@'")
            print("\nEmail: ")
            email = readLine()!!.toString()
        }
        email = email.trim()
    }

    override fun showInfo() {
        print("Student Information\n")
        super.showInfo()
        print("\nStudent ID: $id\nGPA: $gpa\nEmail: $email")
    }

    open fun scholarship() {
        if (gpa >= 8) print("\nEligible for Scholarship")
        else print("\nIneligible for Scholarship")
    }
}

class Teacher(_name: String, _gender: String, _doB: String, _addr: String) :
    Person(_name, _gender, _doB, _addr) {
    var _class: String = ""
    var hourlyWage: Double = 0.0
    var monthlyTeachHour: Int = 0

    override fun inputInfo() {
        print("\n-------------------------------")
        print("\nEnter Teacher Information\n")
        super.inputInfo()
        print("Class: ")
        _class = readLine()!!.toString()
        while (_class[0] != 'G' && _class[0] != 'H' && _class[0] != 'I' && _class[0] != 'K' && _class[0] != 'L' && _class[0] != 'M') {
            print("Class name is not valid, must starts by: G,H,I,K,L,M")
            print("\nClass: ")
            _class = readLine()!!.toString()
        }
        print("Hourly Wage: ")
        hourlyWage = readLine()!!.toDouble()
        print("Monthly Teaching Hour: ")
        monthlyTeachHour = readLine()!!.toInt()
    }

    override fun showInfo() {
        print("Teacher Information\n")
        super.showInfo()
        print("\nClass: $_class\nHourly Wage: $hourlyWage\nMonthly Teaching Hour: $monthlyTeachHour")
    }

    fun calcWage() {
        when (_class[0]) {
            'G', 'H', 'I', 'K' -> print("\nTeacher's Salary: ${hourlyWage * monthlyTeachHour}")
            'L', 'M' -> print("Teacher's Salary: ${hourlyWage * monthlyTeachHour + 500000}")
        }
    }
}


fun main() {
    var name: String = ""
    var gender: String = ""
    var doB: String = ""
    var addr: String = ""
    var stu1: Student = Student(name, gender, doB, addr)
    stu1.inputInfo()
    stu1.showInfo()
    stu1.scholarship()

    var tea1: Teacher = Teacher(name, gender, doB, addr)
    tea1.inputInfo()
    tea1.showInfo()
    tea1.calcWage()
}




