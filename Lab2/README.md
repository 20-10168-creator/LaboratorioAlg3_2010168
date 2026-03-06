   # Laboratorio 2: El juego de Sudoku ▦

**Universidad Simón Bolívar** 
**Departamento de Computación y Tecnología de la Información** 
**Curso:** CI-2693 - Laboratorio de Algoritmos y Estructuras III (Enero-Marzo 2026)  

---

## 👤 Datos del Estudiante

- **Nombre:** Santiago Bueno
- **Carnet:** 20-10168

---

## 📝 Descripción del Proyecto

Este proyecto implementa una solución en Kotlin para **resolver un sudoku** dada su representación como string.

El programa lee un string de 81 caracteres que representan un sudoku a resolver.

##  🔙 1. Lógica de Retroceso (Backtracking) Implementada

Para resolver este Sudoku, el programa utiliza un algoritmo de búsqueda exhaustiva basado en la técnica de Backtracking. La lógica se implementó en la función `resolver` de la siguiente manera:

* **Búsqueda de espacios:** El algoritmo recorre la matriz de 9x9 buscando celdas vacías (representadas por un `0`).
* **Intento de asignación:** Al encontrar una celda vacía, el programa entra en un ciclo probando los números del 1 al 9.
* **Llamada recursiva:** Si un número es válido en esa posición, se coloca en el tablero y la función `resolver` se llama a sí misma recursivamente para intentar llenar la siguiente celda vacía.
* **Retroceso (Backtracking):** Si la llamada recursiva devuelve `false` (lo que indica que ese camino lleva a un callejón sin salida donde el tablero no se puede completar), o si ningún número del 1 al 9 es válido, el algoritmo deshace su movimiento volviendo a colocar un `0` en la celda actual. Luego, retrocede al paso anterior para intentar con el siguiente número disponible.
* **Caso Base:** El algoritmo termina exitosamente y devuelve `true` cuando logra recorrer toda la matriz sin encontrar celdas vacías.

## ✂️ 2. Condiciones de Poda Utilizadas

Para asegurar que el programa termine en un tiempo razonable y no explore combinaciones inútiles (lo cual tomaría demasiado tiempo dado el tamaño del árbol de decisiones del Sudoku), se implementaron las siguientes estrategias de poda (*pruning*):

* **Verificación a cada acción:**  Cuando se intenta colocar un número del 1 al 9, se ejecutan las funciones `esFilaValida`, `esColumnaValida` y `esCuadroValido`. Si alguna de estas validaciones falla, se descarta ese número inmediatamente sin hacer la llamada recursiva, cortando de raíz millones de combinaciones incorrectas.
* **Uso de Estructuras Set:** Para las validaciones, se utilizaron Conjuntos (`Set`). Dado que los Sets no permiten elementos duplicados, si al intentar agregar un número la operación devuelve `false`, la función de validación se detiene inmediatamente (retornando `false`) sin necesidad de recorrer el resto de la fila/columna/cuadro. Esto optimiza el tiempo de verificación en cada paso.

---

## 3. 🚀 Compilación y ejecución

1. Compilar y ejecutar pasándole el tablero como argumento:
   Si desea probar el sudoku propuesto en las instrucciones del laboratorio solo debe ejecutar
   `make`, luego `make run`. Si desea probar otro sudoku, ejecute `make` y luego `java -jar Sudoku.jar <sudoku>` donde `<sudoku>` es la cadena de 81 caracteres que representa un sudoku.



