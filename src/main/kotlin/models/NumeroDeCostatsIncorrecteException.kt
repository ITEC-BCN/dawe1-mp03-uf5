package models

class NumeroDeCostatsIncorrecteException: Exception {
    constructor() : this("No coincideixen els costats de la figura amb els costats introduïts!") { }
    constructor(missatge: String) : super(missatge) { }
}