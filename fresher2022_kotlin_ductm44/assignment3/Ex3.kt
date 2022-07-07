package com.example.fresher2022_kotlin_ductm44.assignment3

import kotlin.math.max

open class client {
    var numProduct: Int
    var unitPrice: Double
    var tax: Double

    constructor() {
        numProduct = 0
        unitPrice = 0.0
        tax = 0.0
    }

    constructor(_numProduct: Int, _unitPrice: Double, _tax: Double) {
        numProduct = _numProduct
        unitPrice = _unitPrice
        tax = _tax
    }

    open fun inputInfo() {
        print("Product number: ")
        numProduct = readLine()!!.toInt()
        print("Unit Price: ")
        unitPrice = readLine()!!.toDouble()
        tax = 0.1 * unitPrice * numProduct
    }
}
class normalClient: client(){
    override fun inputInfo() {
        print("Enter Normal Customer Information\n")
        super.inputInfo()
    }

    fun price():Double{
        return (numProduct * unitPrice) + tax
    }

    fun priceMustPay(){
        print("Customer must pay: ${(numProduct * unitPrice) + tax}\n")
    }
}
class loyalCustomer : client() {
    var year: Int = 0
    override fun inputInfo() {
        print("Enter Loyal Customer Information\n")
        super.inputInfo()
        print("Number of years being close: ")
        year = readLine()!!.toInt()
    }

    var discountPercent = max(year * 0.05, 0.5)

    fun price():Double{
        return (numProduct * unitPrice) * (1 - discountPercent) + tax
    }

    fun priceMustPay(){
        print("Customer must pay: ${(numProduct * unitPrice) * (1 - discountPercent) + tax}\n")
    }
}

class specialCustomer: client(){
    override fun inputInfo() {
        print("Enter Special Customer Information\n")
        super.inputInfo()
    }

    fun price():Double{
        return (numProduct * unitPrice)*0.5 + tax
    }

    fun priceMustPay(){
        print("Customer must pay: ${(numProduct * unitPrice)*0.5 + tax}\n")
    }
}

fun main(){
    var totalPrice: Double = 0.0
    print("Number of normal customer: ")
    var x: Int = readLine()!!.toInt()
    var listnormalClient:MutableList<normalClient> = mutableListOf()
    for(i in 0 until x){
        print("---------------------------------------------------")
        print("\nNormal Customer no.${i+1}\n")
        var temp: normalClient = normalClient()
        temp.inputInfo()
        listnormalClient.add(temp)
        listnormalClient[i].priceMustPay()
        totalPrice += temp.price()
    }

    print("\n\n***************************************************")
    print("\nNumber of loyal customer: ")
    var y: Int = readLine()!!.toInt()
    var listloyalClient:MutableList<loyalCustomer> = mutableListOf()
    for(i in 0 until y){
        print("---------------------------------------------------")
        print("\nLoyal Customer no.${i+1}\n")
        var loyal: loyalCustomer = loyalCustomer()
        loyal.inputInfo()
        listloyalClient.add(loyal)
        listloyalClient[i].priceMustPay()
        totalPrice += loyal.price()
    }

    print("\n\n***************************************************")
    print("\nNumber of special customer: ")
    var z: Int = readLine()!!.toInt()
    var listSpecialClient:MutableList<specialCustomer> = mutableListOf()
    for(i in 0 until z){
        print("---------------------------------------------------")
        print("\nSpecial Customer no.${i+1}\n")
        var special: specialCustomer = specialCustomer()
        special.inputInfo()
        listSpecialClient.add(special)
        listSpecialClient[i].priceMustPay()
        totalPrice += special.price()
    }
    print("\n\n***************************************************")
    print("\nTotal amount the company obtained: $totalPrice\n")
}