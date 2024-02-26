package models

class Figura {
    private var numCostats:Int = 0
    private var costats:IntArray = intArrayOf()

    //Sol·lució 1: creant classes especials: NumeroDeCostatsInsuficientException i NumeroDeCostatsIncorrecteException
    /*constructor(numCostats:Int, vararg costats:Int){
        try {
            if (numCostats < 3) throw NumeroDeCostatsInsuficientException()
            else if (numCostats != costats.size) throw NumeroDeCostatsIncorrecteException()
            else {
                this.numCostats = numCostats
                this.costats = costats
            }
        } catch (e:NumeroDeCostatsInsuficientException){
            println(e.message)
        } catch (e:NumeroDeCostatsIncorrecteException){
            println(e.message)
        }
    }*/

    //Sol·lució 2: fent servir l'excepció existent IllegalArgumentException, passant-li un missatge personalitzat
    constructor(numCostats:Int, vararg costats:Int){
        try {
            if (numCostats < 3) throw IllegalArgumentException("Número de costats insuficients, una figura ha de tenir 3 o més costats!")
            else if (numCostats != costats.size) throw IllegalArgumentException("Incoherència en el pas de paràmetres, no coincideixen els costats de la figura amb els paràmetre introduits")
            else {
                this.numCostats = numCostats
                this.costats = costats
            }
        } catch (e:IllegalArgumentException){
            println(e.message)
        }
    }

    fun perimetre():Int{
        var perimetreFigura:Int = 0
        for(c in this.costats)
            perimetreFigura += c

        return perimetreFigura
    }
}