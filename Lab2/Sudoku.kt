fun main(args: Array<String>) {
    if (args[0].length != 81) {
        println("Ingrese exactamente 81 caracteres") 
        return
    }
    
    val entry = args[0]
    
    val sudoku = Array(9) { IntArray(9) }

    for (i in 0..80) {
        val fila = i / 9
        val columna = i % 9
        sudoku[fila][columna] = entry[i].digitToInt()
    }

    if (resolver(sudoku)) {
        println(sudokuToString(sudoku))
    } else {
        println("NOSOLUTION")
    }
}

fun esFilaValida(fila: IntArray): Boolean {
    val seen = mutableSetOf<Int>()
    for (num in fila) {
        if (num != 0 && !seen.add(num)) return false
    }
    return true
}

fun esColumnaValida(columna: IntArray): Boolean {
    val seen = mutableSetOf<Int>()
    for (num in columna) {
        if (num != 0 && !seen.add(num)) return false
    }
    return true
}

fun esCuadroValido(sudoku: Array<IntArray>, startRow: Int, startCol: Int): Boolean {
    val seen = mutableSetOf<Int>()
    for (i in 0..2) {
        for (j in 0..2) {
            val num = sudoku[startRow + i][startCol + j]
            if (num != 0 && !seen.add(num)) return false
        }
    }
    return true
}

fun getCol(sudoku: Array<IntArray>, col: Int): IntArray = IntArray(9) { sudoku[it][col] }

fun sudokuToString(sudoku: Array<IntArray>): String {
    return sudoku.flatMap { it.asIterable() }.joinToString("")
}

fun resolver(sudoku: Array<IntArray>): Boolean {
    for (fila in 0..8) {
        for (columna in 0..8) {
            if (sudoku[fila][columna] == 0) {
                for (num in 1..9) {
                    sudoku[fila][columna] = num
                    if (esFilaValida(sudoku[fila]) && esColumnaValida(getCol(sudoku, columna)) && esCuadroValido(sudoku, (fila / 3) * 3, (columna / 3) * 3)) {
                        if (resolver(sudoku)) return true
                    }
                    sudoku[fila][columna] = 0
                }
                return false
            }
        }
    }
    return true
}