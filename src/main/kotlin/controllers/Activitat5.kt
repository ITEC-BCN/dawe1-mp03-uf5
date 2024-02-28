package controllers

import java.text.Normalizer
import java.util.regex.Matcher
import java.util.regex.Pattern

fun main(){
    //Exercici 1
    val arrayFrases = arrayOf(
        "Amor a Roma",
        "Dábale arroz a la zorra el abad",
        "¿Será lodo o dólares?",
        "Aquesta frase és una trampa",
        "Sara Baras",
        "Llepa la pell",
        "A dit, sorprès, a l'obert avenc nevat, rebo la serp rostida.",
        "Malfia't, animal, astut rival. La virtut: salami, nata i flam.",
        "Truca'm a casa, camacurt!",
        "Amor a Roma2"
    )

    for (frase in arrayFrases){
        println("La frase '$frase' és ${esPalindrom(frase)} que sigui palíndrom")
    }


    //Exercici 2
    var fraseExercici2:String = "Un plat blanc pla ple de pebre negre està"


    //Exercici 2 -> forma 1
    var fraseExercici2Tunejada = fraseExercici2.lowercase().replace("[^p]".toRegex(),"")
    println(fraseExercici2Tunejada)
    println("La frase '$fraseExercici2' té un total de " + fraseExercici2Tunejada.length + " p's")


    //Exercici 2 -> forma 2
    val expressioRegular = "pl|bl"
    val regles: Pattern = Pattern.compile(expressioRegular)
    val textAnalitzar: Matcher = regles.matcher(fraseExercici2)
    var qTrobades=0
    while(textAnalitzar.find()){
        print(textAnalitzar.group() + " - ")
        qTrobades++
    }
    println("\nQuantitat trobades: $qTrobades")


    //Exercici 3 -> forma 1: només té en compte un espai en blanc
    var arrayParaules = fraseExercici2.split(" ")
    println("La frase '$fraseExercici2' té ${arrayParaules.size} paraules")


    //Exercici 3 -> forma 2: té en compte si hi ha un espai en blanc o més
    fraseExercici2Tunejada = fraseExercici2.lowercase().replace("\\s{2,}".toRegex()," ")
    fraseExercici2 = "Un plat blanc pla ple de pebre  negre   està"
    println(fraseExercici2Tunejada)
    arrayParaules = fraseExercici2Tunejada.split(" ")
    println("La frase '$fraseExercici2' té ${arrayParaules.size} paraules")


    //Exercici 4
    println("12345678Z: ${comprobarDNI("12345678Z")}")  //correcte
    println("1234567Z: ${comprobarDNI("1234567Z")}")  //incorrecte
    println("123456F8Z: ${comprobarDNI("123456F8Z")}")  //incorrecte
    println("S12345678: ${comprobarDNI("S12345678")}")  //incorrecte

}

//Exercici 1 - funció utilitzada
fun esPalindrom(frase:String): Boolean {
    var expRegular = "[^\\p{L}^\\d]"//treure espais i signes de puntuació
    var fraseTunejada = frase.lowercase().replace(expRegular.toRegex(),"")
    //println("$fraseTunejada - sense espais ni signes de puntuació")

    fraseTunejada = Normalizer.normalize(fraseTunejada, Normalizer.Form.NFD)//Canonical decomposition -> transforma á en a´, ä en a¨
    expRegular = "[^\\p{ASCII}]"//treure símbols 'estranys'
    fraseTunejada = fraseTunejada.replace(expRegular.toRegex(),"")
    //println("$fraseTunejada - sense accents")

    var fraseReves = fraseTunejada.reversed()

    return if (fraseTunejada.compareTo(fraseReves)==0) true
    else false
}


//Exercici 4 - funció utilitzada
fun comprobarDNI(dni:String):Boolean {
    val regex: String = "[\\d]{8}[\\D]"
    val filtre: Pattern = Pattern.compile(regex)

    val filtrarDNI: Matcher = filtre.matcher(dni)

    return filtrarDNI.matches()
}
