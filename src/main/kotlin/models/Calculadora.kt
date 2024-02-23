package models

import java.util.*

class Calculadora {
    private var operacio:Char = 'A'
    private var op1:Int = 0
    private var op2:Int = 0

    constructor(){
        do {
            this.operacio = llegirOperacio("Introdueix la operació a realitzar (+ - * / o Z per sortir): ")
            this.op1 = llegirNum("Introdueix un numèric sencer: ")
            this.op2 = llegirNum("Introdueix un numèric sencer: ")
            when (this.operacio) {
                '+' -> {
                    println("Resultat: ${this.op1 + this.op2}")
                }

                '-' -> {
                    println("Resultat: ${this.op1 - this.op2}")
                }

                '*' -> {
                    println("Resultat: ${this.op1 * this.op2}")
                }

                '/' -> {
                    try {
                        println("Resultat: ${this.op1 / this.op2}")
                    } catch (e: ArithmeticException) {
                        println("No sha pogut realitzar la operació (potser has intentat dividir entre 0?)")
                    }
                }
                'Z' -> println("A reveure!")
                else -> println("En fi, aprenem a llegir, si us plau.")
            }
        } while (this.operacio!='Z')
    }
    fun llegirNum(missatge:String="Introdueix un valor: "):Int{
        val scan: Scanner = Scanner(System.`in`)
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

    fun llegirOperacio(missatge:String=""):Char{
        val scan: Scanner = Scanner(System.`in`)
        var charOK:Boolean = true
        var op:Char = 'A'

        do {
            print(missatge)
            try {
                op = scan.next().single()
                comprobarCaracter(op)
                charOK = true
            } catch (e: IllegalArgumentException){
                println("El valor introduït és incorrecte. Només pot ser un caràcter. Les opcions son: + - * / o Z per sortir.")
                charOK = false
            } catch (e: CaracterNoValidException) {
                println("El valor introduït és incorrecte. Les opcions son: + - * / o Z per sortir.")
                charOK = false
            }
        } while(!charOK)
        return op
    }

    fun comprobarCaracter(caracter:Char){
        if(caracter!='+' && caracter!='-' && caracter !='*' && caracter!='/' && caracter!='Z')
            throw CaracterNoValidException ("Caràcter no vàlid!")
    }

}