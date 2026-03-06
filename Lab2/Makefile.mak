# Variables
KC = kotlinc
KFLAGS = -include-runtime -d
JAR_NAME = Sudoku.jar
SRC = Sudoku.kt

BOARD ?= 530070000600195000098000060800060003400803001700020006060000280000419005000080079

all: compile

compile:
	$(KC) $(SRC) $(KFLAGS) $(JAR_NAME)

run: compile
	java -jar $(JAR_NAME) $(BOARD)

clean:
	rm -f $(JAR_NAME)