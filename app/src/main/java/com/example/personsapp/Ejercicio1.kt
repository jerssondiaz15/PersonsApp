package com.example.personsapp

private fun exercise(){
    readLine()
    var happiness = 0
    //Aqui se pondra lo que ingrese el usuario pero por ejemplo lo eh puesto en duro.
    val array = "1,5,3".split(",")
    val a = "3,1".split(",")
    val b = "5,7".split(",")
    for (i in array){
        if (a.contains(i)){
            happiness = happiness.plus(1)
        }
        if (b.contains(i)){
            happiness = happiness.minus(1)
        }
    }
    println(happiness)
}