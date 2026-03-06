import java.io.File

fun main(args: Array<String>){
    val grafo = grafoDeAmigos(File("input.txt"))
    val distancia = buscarDistancia(args[0], args[1], grafo)
   
    println(distancia)
}

fun grafoDeAmigos(archivo: File): ListaAdyacenciaGrafo<String> {
    var grafo = ListaAdyacenciaGrafo<String>()

    archivo.forEachLine { linea ->
    val (persona1, persona2) = linea.split(" ")
    grafo.agregarVertice(persona1)
    grafo.agregarVertice(persona2)
    grafo.conectar(persona1, persona2)
    grafo.conectar(persona2, persona1)}
    return grafo

}

fun buscarDistancia(principal: String, amigo: String, grafo: ListaAdyacenciaGrafo<String>): Int {
        if (principal == amigo) return 0
        if (!grafo.contiene(principal) || !grafo.contiene(amigo)) return -1

        val visitados = mutableSetOf<String>()
        val cola: ArrayDeque<Pair<String, Int>> = ArrayDeque()

        visitados.add(principal)
        cola.addLast(principal to 0)

        while (cola.isNotEmpty()) {
            val (actual, distancia) = cola.removeFirst()
            for (vecino in grafo.obtenerArcosSalida(actual)) {
                if (vecino == amigo) return distancia + 1
                if (vecino !in visitados) {
                    visitados.add(vecino)
                    cola.addLast(vecino to distancia + 1)
                }
            }
        }

        return -1
    }