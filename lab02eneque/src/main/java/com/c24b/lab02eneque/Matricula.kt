package com.eneque.lab02viernes

fun main() {
    println("=============================================")
    println("       BIENVENIDO AL SISTEMA DE MATRICULA")
    println("=============================================")

    print("Nombre del estudiante: ")
    val nombreEstudiante = readLine() ?: ""

    print("Cantidad de cursos: ")
    val cantidadCursos = readLine()!!.toInt()

    print("Turno (Mañana / Tarde / Noche): ")
    val turno = readLine() ?: ""

    val nombresCursos = mutableListOf<String>()
    val creditosCursos = mutableListOf<Int>()
    val valoresCredito = mutableListOf<Double>()
    val costosCursos = mutableListOf<Double>()

    println()

    for (i in 1..cantidadCursos) {
        println("Curso $i")

        print("Nombre del curso: ")
        val nombreCurso = readLine() ?: ""

        print("Cantidad de creditos: ")
        val creditos = readLine()!!.toInt()

        print("Valor por credito: S/ ")
        val valorCredito = readLine()!!.toDouble()

        val costoCurso = creditos * valorCredito

        nombresCursos.add(nombreCurso)
        creditosCursos.add(creditos)
        valoresCredito.add(valorCredito)
        costosCursos.add(costoCurso)

        println()
    }

    var totalCreditos = 0
    var totalPagar = 0.0

    for (i in 0 until cantidadCursos) {
        totalCreditos += creditosCursos[i]
        totalPagar += costosCursos[i]
    }

    val cargaAcademica = when {
        totalCreditos <= 12 -> "Matricula Regular"
        totalCreditos <= 18 -> "Carga Completa"
        else -> "Requiere Autorizacion"
    }

    val cantidadCuotas: Int

    if (totalPagar > 2500) {
        cantidadCuotas = 3
    } else {
        cantidadCuotas = 2
    }

    val valorCuota = totalPagar / cantidadCuotas

// Calculo del descuento segun el turno
    val porcentajeDescuento = when (turno.lowercase()) {
        "mañana", "manana" -> 0.10
        "tarde" -> 0.15
        "noche" -> 0.20
        else -> 0.0
    }

    val montoDescuento = totalPagar * porcentajeDescuento
    val totalConDescuento = totalPagar - montoDescuento

    println()
    println("==============================================")
    println("             RESUMEN DE MATRICULA")
    println("==============================================")
    println("Estudiante: $nombreEstudiante")
    println("Turno: $turno")
    println()

    println(
        String.format(
            "%-25s %10s %15s",
            "Curso", "Creditos", "Costo"
        )
    )

    println("----------------------------------------------")

    for (i in 0 until cantidadCursos) {
        println(
            String.format(
                "%-25s %10d %15.2f",
                nombresCursos[i],
                creditosCursos[i],
                costosCursos[i]
            )
        )
    }

    println("----------------------------------------------")
    println()

    println("Cursos matriculados: $cantidadCursos")
    println("Total de creditos: $totalCreditos")
    println(String.format("TOTAL: S/ %.2f", totalPagar))
    println(String.format("Descuento por turno: %.0f%%", porcentajeDescuento * 100))
    println(String.format("Monto de descuento: S/ %.2f", montoDescuento))
    println(String.format("TOTAL CON DESCUENTO: S/ %.2f", totalConDescuento))
    println("Carga academica: $cargaAcademica")
    println(
        String.format(
            "Forma de pago: %d cuotas de S/ %.2f",
            cantidadCuotas,
            valorCuota
        )
    )

    println("==============================================")

}
