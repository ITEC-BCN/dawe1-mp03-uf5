package models

class CaracterNoValidException: Exception {
    constructor() : this("Caràcter no vàlid!") { }
    constructor(missatge: String) : super(missatge) { }
}