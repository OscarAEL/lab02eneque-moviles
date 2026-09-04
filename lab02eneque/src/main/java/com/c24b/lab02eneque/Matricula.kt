package com.eneque.lab02viernes

fun main() {

    println("=============================================")
    println("       SISTEMA DE MATRICULA")
    println("=============================================")

    // Aforo
    print("Ingrese el aforo: ")
    val aforo = readLine()!!.toInt()

    println()

    // Datos del estudiante
    print("Nombre del estudiante: ")
    val nombreEstudiante = readLine() ?: ""

    print("Cantidad de cursos: ")
    val cantidadCursos = readLine()!!.toInt()

    print("Turno (Manana / Tarde / Noche): ")
    val turno = readLine() ?: ""

    print("Categoria (Ordinario / Becado): ")
    val categoria = readLine() ?: ""

    // Matricula segun categoria
    var montoMatricula = 0.0

    if (categoria.lowercase() == "ordinario") {
        print("Ingrese costo de matricula: S/ ")
        montoMatricula = readLine()!!.toDouble()
    }

    val nombresCursos = mutableListOf<String>()
    val creditosCursos = mutableListOf<Int>()
    val valoresCredito = mutableListOf<Double>()
    val costosCursos = mutableListOf<Double>()

    println()

    // Registro de cursos
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

    // Calculo de totales de cursos
    var totalCreditos = 0
    var totalPagar = 0.0

    for (i in 0 until cantidadCursos) {
        totalCreditos += creditosCursos[i]
        totalPagar += costosCursos[i]
    }

    // Carga academica
    val cargaAcademica = when {
        totalCreditos <= 12 -> "Matricula Regular"
        totalCreditos <= 18 -> "Carga Completa"
        else -> "Requiere Autorizacion"
    }

    // Descuento segun el turno
    val porcentajeDescuento = when (turno.lowercase()) {
        "mañana", "manana" -> 0.10
        "tarde" -> 0.15
        "noche" -> 0.20
        else -> 0.0
    }

    val montoDescuento = totalPagar * porcentajeDescuento
    val totalConDescuento = totalPagar - montoDescuento

    // Subtotal incluyendo matricula
    val subtotal = totalConDescuento + montoMatricula

    // IGV
    val porcentajeIGV = 0.18
    val montoIGV = subtotal * porcentajeIGV

    // Total final
    val totalConIGV = subtotal + montoIGV

    // Forma de pago
    val cantidadCuotas: Int

    if (totalConIGV > 2500) {
        cantidadCuotas = 3
    } else {
        cantidadCuotas = 2
    }

    val valorCuota = totalConIGV / cantidadCuotas

    // Resultado
    println()
    println("==============================================")
    println("             RESUMEN DE MATRICULA")
    println("==============================================")

    println("Aforo: $aforo")
    println("Estudiante: $nombreEstudiante")
    println("Turno: $turno")
    println("Categoria: $categoria")

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

    println(
        String.format(
            "TOTAL CURSOS: S/ %.2f",
            totalPagar
        )
    )

    println(
        String.format(
            "Descuento por turno: %.0f%%",
            porcentajeDescuento * 100
        )
    )

    println(
        String.format(
            "Monto de descuento: S/ %.2f",
            montoDescuento
        )
    )

    println(
        String.format(
            "TOTAL CON DESCUENTO: S/ %.2f",
            totalConDescuento
        )
    )

    println(
        String.format(
            "Monto de matricula: S/ %.2f",
            montoMatricula
        )
    )

    println(
        String.format(
            "Subtotal: S/ %.2f",
            subtotal
        )
    )

    println(
        String.format(
            "IGV (18%%): S/ %.2f",
            montoIGV
        )
    )

    println(
        String.format(
            "TOTAL A PAGAR: S/ %.2f",
            totalConIGV
        )
    )

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