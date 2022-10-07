package tictactoe

import kotlin.system.exitProcess

fun main() {
    var gameInput = "         "

    printGame(gameInput)

    val playerxturn = true
    val playeroturn = false

    playGame(gameInput, playerxturn, playeroturn)
}

fun printGame(gameInput: String) {
    println("---------")
    println("| ${gameInput[0]} ${gameInput[1]} ${gameInput[2]} |")
    println("| ${gameInput[3]} ${gameInput[4]} ${gameInput[5]} |")
    println("| ${gameInput[6]} ${gameInput[7]} ${gameInput[8]} |")
    println("---------")
    analyzeGame(gameInput)
}

fun analyzeGame(gameInput: String): String {
    var xAmount = 0
    var oAmount = 0
    var threeXs = 0
    var threeOs = 0
    var blanks = 0

    for (i in gameInput) {
        if ( i == 'X') {
            xAmount += 1
        } else if ( i == 'O') {
            oAmount += 1
        }
    }

    if (gameInput[0] == 'X' && gameInput[1] == 'X' && gameInput[2] == 'X') {
        threeXs += 1
    }
    if (gameInput[3] == 'X' && gameInput[4] == 'X' && gameInput[5] == 'X') {
        threeXs += 1
    }
    if (gameInput[6] == 'X' && gameInput[7] == 'X' && gameInput[8] == 'X') {
        threeXs += 1
    }
    if (gameInput[0] == 'X' && gameInput[3] == 'X' && gameInput[6] == 'X') {
        threeXs += 1
    }
    if (gameInput[1] == 'X' && gameInput[4] == 'X' && gameInput[7] == 'X') {
        threeXs += 1
    }
    if (gameInput[2] == 'X' && gameInput[5] == 'X' && gameInput[8] == 'X') {
        threeXs += 1
    }
    if (gameInput[0] == 'X' && gameInput[4] == 'X' && gameInput[8] == 'X') {
        threeXs += 1
    }
    if (gameInput[2] == 'X' && gameInput[4] == 'X' && gameInput[6] == 'X') {
        threeXs += 1
    }

    if (gameInput[0] == 'O' && gameInput[1] == 'O' && gameInput[2] == 'O') {
        threeOs += 1
    }
    if (gameInput[3] == 'O' && gameInput[4] == 'O' && gameInput[5] == 'O') {
        threeOs += 1
    }
    if (gameInput[6] == 'O' && gameInput[7] == 'O' && gameInput[8] == 'O') {
        threeOs += 1
    }
    if (gameInput[0] == 'O' && gameInput[3] == 'O' && gameInput[6] == 'O') {
        threeOs += 1
    }
    if (gameInput[1] == 'O' && gameInput[4] == 'O' && gameInput[7] == 'O') {
        threeOs += 1
    }
    if (gameInput[2] == 'O' && gameInput[5] == 'O' && gameInput[8] == 'O') {
        threeOs += 1
    }
    if (gameInput[0] == 'O' && gameInput[4] == 'O' && gameInput[8] == 'O') {
        threeOs += 1
    }
    if (gameInput[2] == 'O' && gameInput[4] == 'O' && gameInput[6] == 'O') {
        threeOs += 1
    }

    if (gameInput.contains(' ') ) {
        blanks = 1
    } else if (' ' !in gameInput) {
        blanks = 0
    }

    if ( xAmount - oAmount >= 2 || oAmount - xAmount >= 2 || threeXs == 1 && threeOs == 1 ) {
        return "Impossible"
    } else if (threeXs == 0 && threeOs == 0) {
        return " "
    } else if (threeXs == 0 && threeOs == 0 && blanks == 0) {
        return "Draw"
    } else if (threeXs == 1 && threeOs == 0) {
        return "X wins"
    } else if (threeXs == 0 && threeOs == 1) {
        return "O wins"
    } else {
        exitProcess(0)
    }
}

fun playGame (gameInput: String, playerX: Boolean, playerO: Boolean) {

    val userChoice = readln()
    val choice1 = userChoice[0]
    val choice2 = userChoice[2]

    try {
        var intChoice1 = choice1.code
        var intChoice2 = choice2.code
    } catch (e: java.lang.Exception) {
        println("You should enter numbers!")
        playGame(gameInput, playerX, playerO)
    }

    val intChoice1 = choice1.toString().toInt()
    val intChoice2 = choice2.toString().toInt()

    val charArray2  = gameInput.toCharArray()

    if (intChoice1 < 0 || intChoice1 > 3) {
        println("Coordinates should be from 1 to 3!")
        playGame(gameInput, playerX, playerO)
    }

    if (intChoice2 < 0 || intChoice2 > 3) {
        println("Coordinates should be from 1 to 3!")
        playGame(gameInput, playerX, playerO)
    }
    var playerXturn = playerX
    var playerOturn = playerO

    if (playerOturn) {
        if(intChoice1 == 1) {
            if (gameInput[intChoice2 - 1] == 'X' || gameInput[intChoice2 - 1] == 'O') {
                println("This cell is occupied! Choose another one!")
                playGame(gameInput, playerXturn, playerOturn)
            } else {
                charArray2[intChoice2 - 1] = 'O'
                playerXturn = true
                playerOturn = false
            }

        } else if (intChoice1 == 2) {
            if (gameInput[intChoice2 + 2] == 'X' || gameInput[intChoice2 + 2] == 'O') {
                println("This cell is occupied! Choose another one!")
                playGame(gameInput, playerXturn, playerOturn)
            } else {
                charArray2[intChoice2 + 2] = 'O'
                playerXturn = true
                playerOturn = false
            }
        } else if (intChoice1 == 3) {
            if (gameInput[intChoice2 + 5] == 'X' || gameInput[intChoice2 + 5] == 'O') {
                println("This cell is occupied! Choose another one!")
                playGame(gameInput, playerXturn, playerOturn)
            } else {
                charArray2[intChoice2 + 5] = 'O'
                playerXturn = true
                playerOturn = false
            }
        }
    } else if (playerXturn){
        if(intChoice1 == 1) {
            if (gameInput[intChoice2 - 1] == 'X' || gameInput[intChoice2 - 1] == 'O') {
                println("This cell is occupied! Choose another one!")
                playGame(gameInput, playerXturn, playerOturn)
            } else {
                charArray2[intChoice2 - 1] = 'X'
                playerOturn = true
                playerXturn = false
            }

        } else if (intChoice1 == 2) {
            if (gameInput[intChoice2 + 2] == 'X' || gameInput[intChoice2 + 2] == 'O') {
                println("This cell is occupied! Choose another one!")
                playGame(gameInput, playerXturn, playerOturn)
            } else {
                charArray2[intChoice2 + 2] = 'X'
                playerOturn = true
                playerXturn = false
            }
        } else if (intChoice1 == 3) {
            if (gameInput[intChoice2 + 5] == 'X' || gameInput[intChoice2 + 5] == 'O') {
                println("This cell is occupied! Choose another one!")
                playGame(gameInput, playerXturn, playerOturn)
            } else {
                charArray2[intChoice2 + 5] = 'X'
                playerOturn = true
                playerXturn = false
            }
        }
    }

    val gameInput2 = String(charArray2)

    printGame(gameInput2)

    val isGameWon = analyzeGame(gameInput2)

    if (isGameWon == " ") {
        playGame(gameInput2, playerXturn, playerOturn)
    } else {
        println(isGameWon)
        exitProcess(0)
    }
}
