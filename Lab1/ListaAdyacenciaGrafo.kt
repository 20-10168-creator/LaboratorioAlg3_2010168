/**
 * Implementación de Grafo<T> utilizando listas de adyacencia.
 * Mantiene un mapa de vértices a listas de sucesores.
 * No se permiten arcos duplicados.
 */
class ListaAdyacenciaGrafo<T> : Grafo<T> {

    // Mapa principal: vértice -> lista de sucesores
    private val adyacencia = mutableMapOf<T, MutableList<T>>()

    override fun agregarVertice(v: T): Boolean {
        return if (adyacencia.containsKey(v)) {
            false
        } else {
            adyacencia[v] = mutableListOf()
            true
        }
    }

    override fun conectar(desde: T, hasta: T): Boolean {
        val listaDesde = adyacencia[desde] ?: return false
        if (!adyacencia.containsKey(hasta)) return false
        // Evitar arcos duplicados
        if (!listaDesde.contains(hasta)) {
            listaDesde.add(hasta)
        }
        return true
    }

    override fun contiene(v: T): Boolean = adyacencia.containsKey(v)

    override fun obtenerArcosSalida(v: T): List<T> =
        adyacencia[v]?.toList() ?: emptyList()

    override fun obtenerArcosEntrada(v: T): List<T> =
        adyacencia
            .filter { it.value.contains(v) }
            .map { it.key }
            .toList()

    override fun eliminarVertice(v: T): Boolean {
        if (!adyacencia.containsKey(v)) return false
        adyacencia.remove(v)
        // Remover todas las ocurrencias de v en las listas de otros vértices
        adyacencia.values.forEach { lista ->
            lista.remove(v) // remove() borra la primera ocurrencia; como no hay duplicados, basta
        }
        return true
    }

    override fun tamano(): Int = adyacencia.size

    override fun subgrafo(vertices: Collection<T>): Grafo<T> {
        val subGrafo = ListaAdyacenciaGrafo<T>()
        // Conjunto de vértices válidos (existen en el grafo original)
        val verticesValidos = vertices.filterTo(mutableSetOf()) { adyacencia.containsKey(it) }

        // Agregar los vértices
        verticesValidos.forEach { subGrafo.agregarVertice(it) }

        // Agregar arcos que conectan vértices dentro del subgrafo
        verticesValidos.forEach { origen ->
            adyacencia[origen]?.forEach { destino ->
                if (destino in verticesValidos) {
                    subGrafo.conectar(origen, destino)
                }
            }
        }
        return subGrafo
    }
}
