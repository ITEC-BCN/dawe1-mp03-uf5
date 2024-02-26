package models

class NumeroDeCostatsInsuficientException: Exception {
    constructor() : this("Número de costats de la figura insuficients per tenir volum!") { }
    constructor(missatge: String) : super(missatge) { }
}