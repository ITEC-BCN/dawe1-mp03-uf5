package models

import java.util.Scanner

class Division {
    private var num1:Int = 0
    private var num2:Int = 0
    private var res:Int = 0

    constructor()

    /*fun getRes():Int{
        return this.res
    }*/

    fun dividir(){
        this.num1 = llegirNum("Introdueix un numèric sencer: ")
        this.num2 = llegirNum("Introdueix un numèric sencer: ")

        try {
            this.res = this.num1/this.num2
            println("El resultat de dividir ${this.num1} entre ${this.num2} és ${this.res}")
        } catch (e: ArithmeticException){
            println("La divisió no s'ha pogut realitzar")
        }
    }

    fun llegirNum(missatge:String="Introdueix un valor: "):Int{
        val scan:Scanner = Scanner(System.`in`)
        var numOK:Boolean = true
        var num:Int = 0

        do {
            print(missatge)
            try {
                num = Integer.parseInt(scan.next())
                numOK = true
            } catch (e: NumberFormatException) {
                println("El valor introduït és incorrecte. Ha de ser numèric sencer.")
                numOK = false
            }
        } while(!numOK)
        return num
    }

}