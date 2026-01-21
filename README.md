IMPORTANTE. 
Este programa compila con el paquete de JUNIT instalado debido a la diferencia de IDES
Utilizados por nosotros dos. 

Para compilar y ejecutar tests, nosotros decargamos https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.1/junit-platform-console-standalone-1.10.1.jar
y el archivo colocarlo en la raiz del programa (Radio/)

luego, ejecutar javac -cp junit-platform-console-standalone-1.10.1.jar src/*.java

y luego java src/Main