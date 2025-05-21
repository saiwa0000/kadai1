.SUFFIXES: .java .class

JAVAC	= javac -cp ./:sqlite-jdbc-3.30.1.jar -cp ./:junit-4.13.2.jar:hamcrest-core-1.3.jar
JAVA	= java -cp ./:sqlite-jdbc-3.30.1.jar -cp ./:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore

SRC	= $(wildcard *.java)
CLASS	= $(SRC:.java=.class)
PROGRAM	= $(shell pwd)
MAIN	= #WordListDAOTest

all: $(CLASS)

test: $(CLASS)
	$(JAVA) $(MAIN)

$(CLASS): $(SRC)
	$(JAVAC) $(SRC)

#$(CLASS): $(SRC)

#.java.class:
#	$(JAVAC) $<

clean:;	\rm -f *.class

