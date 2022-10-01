package machine

import kotlin.system.exitProcess

open class Drinks(val name: String, var milk: Int, val water: Int, val coffeeBeans: Int, val cost: Int)

class Espresso: Drinks("espresso", 0, 250, 16, 4)
class Latte: Drinks ("latte", 75, 350, 20, 7)
class Cappuccino: Drinks("cappuccino", 100, 200, 12, 6)

var water = 400
var milk = 540
var coffeeBeans = 120
var dispCups = 9
var money = 550

var userWater = 0
var userMilk = 0
var userCB = 0
var userCups = 0

fun main() {
    mainMenu()
}

fun fillMachine(){
    println("Write how many ml of water you want to add:")
    userWater = readln().toInt()
    water += userWater

    println("Write how many ml of milk you want to add:")
    userMilk = readln().toInt()
    milk += userMilk

    println("Write how many grams of coffee beans you want to add:")
    userCB = readln().toInt()
    coffeeBeans += userCB

    println("Write how many disposable cups you want to add:")
    userCups = readln().toInt()
    dispCups += userCups
}

fun checkAmounts()  {
    println("The coffee machine has:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$coffeeBeans g of coffee beans\n" +
            "$dispCups cups\n" +
            "$$money of money\n")
}

fun getDrink() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:")
    val choice = readln()
    val espresso = Espresso()
    val latte = Latte()
    val cappuccino = Cappuccino()
    if (choice == "1") {
        if( water >= 250 && coffeeBeans >= 16) {
            water -= espresso.water
            coffeeBeans -= espresso.coffeeBeans
            dispCups -= 1
            money += espresso.cost
            println("I have enough resources, making you a coffee!")
        } else {
            if ( water < 250 ) {
                println("Sorry, not enough water!")
            } else {
                println("Sorry, nor enough coffee beans!")
            }
        }

    } else if (choice == "2") {
        if (water >= 350 && milk >= 75 && coffeeBeans >= 20){
            water -= latte.water
            milk -= latte.milk
            coffeeBeans -= latte.coffeeBeans
            dispCups -= 1
            money += latte.cost
            println("I have enough resources, making you a coffee!")
        } else {
            if (water < 350) {
                println("Sorry, not enough water!")
            } else if (milk < 75) {
                println("Sorry, not enough milk!")
            } else {
                println("Sorry, nor enough coffee beans!")
            }
        }

    } else if (choice == "3"){
        if ( water >= 200 && milk >= 100 && coffeeBeans > 12) {
            water -= cappuccino.water
            milk -= cappuccino.milk
            coffeeBeans -= cappuccino.coffeeBeans
            dispCups -= 1
            money += cappuccino.cost
            println("I have enough resources, making you a coffee!")
        } else {
            if (water < 200) {
                println("Sorry, not enough water!")
            } else if (milk < 100) {
                println("Sorry, not enough milk!")
            } else {
                println("Sorry, nor enough coffee beans!")
            }
        }
    } else {
        mainMenu()
    }
}

fun takeMoney() {
    println("I gave you $$money\n")
    money -= money
}

fun mainMenu() {
    var exit =  false
    while (!exit) {
        println("Write action (buy, fill, take, remaining, exit):")
        val choice = readln()
        if (choice == "buy") {
            getDrink()
        }
        else if (choice == "fill"){
            fillMachine()
        } else if (choice == "take") {
            takeMoney()
        } else if (choice == "remaining") {
            checkAmounts()
        } else {
            exit = true
            exitProcess(0)
        }
    }
}