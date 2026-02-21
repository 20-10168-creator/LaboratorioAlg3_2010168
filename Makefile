KC = kotlinc
JAR_NAME = DegreesOfSeparation.jar
SOURCES = Grafo.kt ListaAdyacenciaGrafo.kt DegreesOfSeparation.kt

# Regla por defecto que construye el JAR
all: $(JAR_NAME)

# Compila todos los archivos .kt juntos en un solo .jar ejecutable
$(JAR_NAME): $(SOURCES)
	$(KC) $(SOURCES) -include-runtime -d $(JAR_NAME)

# Regla para limpiar los archivos generados
clean:
	rm -rf $(JAR_NAME) META-INF *.class

# (Opcional) Regla de prueba rápida
# Puedes usarla ejecutando: make run P1="Carlos" P2="Ana"
run: $(JAR_NAME)
	java -jar $(JAR_NAME) $(P1) $(P2)

