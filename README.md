# Laboratorio1_Algoritmos3_2010168
# Laboratorio 1: Grados de separación 🌐

**Universidad Simón Bolívar** 
**Departamento de Computación y Tecnología de la Información** 
**Curso:** CI-2693 - Laboratorio de Algoritmos y Estructuras III (Enero-Marzo 2026)  

---

## 👤 Datos del Estudiante

- **Nombre:** Santiago Bueno
- **Carnet:** 20-10168

---

## 📝 Descripción del Proyecto

Este proyecto implementa una solución en Kotlin para calcular los **grados de separación** entre dos personas dentro de una red social simulada.El grado de separación se define como el número de personas (aristas) que hay que atravesar en un grafo para ir de una persona a otra.

El programa lee un archivo de texto (`input.txt`) que contiene pares de nombres que representan amistades y construye un grafo bidireccional utilizando listas de adyacencia. Para encontrar la distancia mínima entre dos personas, se implementó una modificación del algoritmo de búsqueda en anchura (**BFS**).

### Consideraciones:
Si las personas son amigos directos, la distancia es `1`.
La distancia de una persona a sí misma es `0`.
Si no existe conexión entre dos personas en el grafo, el programa retorna `-1`.


---

## 🚀 Cómo compilar y ejecutar
Luego de descargar todos los archivos ejecutar 'make' para compilar. Luego, para ejecutar se hace 'java -jar DegreesOfSeparation.jar <nombre1> <nombre2>'

**NOTA: entre los archivos se encuentra un input.txt. Se recomienda probar los siguiente pares de nombres para probar casos borde: * Diego; * Rosa; Carlos Jose; Carlos Pedro.

