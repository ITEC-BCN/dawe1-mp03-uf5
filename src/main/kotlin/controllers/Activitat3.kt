package org.example.controllers

import models.Calculadora
import models.Division
import models.Figura

fun main() {

    //Exercici 3
    var figura1: Figura = Figura(3, 5, 6, 7)
    println("${figura1.perimetre()}")

    var figura2: Figura = Figura(3, 5, 7)   //error
    println("${figura2.perimetre()}")

    var figura3: Figura = Figura(4, 5, 6, 7, 8)
    println("${figura3.perimetre()}")

    var figura4: Figura = Figura(4, 5, 6, 7, 8, 9)  //error
    println("${figura4.perimetre()}")

    var figura5: Figura = Figura(2, 5, 6)  //error
    println("${figura5.perimetre()}")

}
