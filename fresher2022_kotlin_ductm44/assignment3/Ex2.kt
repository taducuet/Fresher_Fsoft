package com.example.fresher2022_kotlin_ductm44.assignment3

import java.nio.DoubleBuffer

open class Employee {
    var name: String
    var doB: String
    var wage: Double

    constructor() {
        name = ""
        doB = ""
        wage = 0.0
    }

    constructor(_name: String, _doB: String, _wage: Double) {
        name = _name
        doB = _doB
        wage = _wage
    }

    open fun inputInfo() {
        print("Name: ")
        name = readLine()!!.toString()
        print("Date of Birth: ")
        doB = readLine()!!.toString()
    }

    open fun showInfo() {
        print("Name: $name\nDate of Birth: $doB")
    }
}

class productionWorker : Employee() {
    var baseWage: Double = 0.0
    var numProduct: Int = 0
    override fun inputInfo() {
        print("Enter Production Employee Information\n")
        super.inputInfo()
        print("Base Salary: ")
        baseWage = readLine()!!.toDouble()
        print("Product number: ")
        numProduct = readLine()!!.toInt()
    }

    override fun showInfo() {
        print("Production Employee Information\n")
        super.showInfo()
        print("\nBase Salary: $baseWage\nProduct number: $numProduct")
    }

    fun calcWage() {
        print("\nProduction Employee Salary: ${baseWage + numProduct * 5000}")
    }
}

class officeStaff : Employee() {
    var dayWork: Int = 0
    override fun inputInfo() {
        print("\n-------------------------------\n")
        print("Enter Office Staff Information\n")
        super.inputInfo()
        print("Number of working days: ")
        dayWork = readLine()!!.toInt()
    }

    override fun showInfo() {
        print("Office Staff Information\n")
        super.showInfo()
        print("Number of working days: $dayWork")
    }

    fun calcWage() {
        print("\nOffice Staff Salary: ${dayWork * 100_000}")
    }
}

fun main() {
    var worker: productionWorker = productionWorker()
    worker.inputInfo()
    worker.showInfo()
    worker.calcWage()

    var office: officeStaff = officeStaff()
    office.inputInfo()
    office.showInfo()
    office.calcWage()
}
