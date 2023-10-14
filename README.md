# RoverClient
Intrefaz grafica del rover
Buen día, espero que todo bien, esta es la V2 del Mars Rover Kata, https://github.com/ravenfahs/RoverClient.git, 
lo tengo en java Swing que dibuja un circulo azul obstáculos, un triangulo rojo es Rover  y una cuadricula X,Y, 
tiene una configuración inicial ancho, alto, grid size, numero de obstáculos, los objetos están en un plano cartesiano (x,y) 
el cual puede tener varios tamaños de configuración, alto y ancho, se pueden dividir para definir en cuantas cuadriculas o espacios deben existir, 
ejemplo 800 alto x 800 ancho, no es necesario que sera cuadrados perfectos también puedo ser 800x600 (estos valores pueden cambiar hasta 1000*1000 son pixeles) 
se puede dividir entre 4 o 8  o 20 y puede dar un plano de 4x4 o un plano de 8x8, puedo tener uno de 20x20 ese parámetro de configuración se llama Grid Size, 
se puedo adicionar n obstáculos los cuales se verifica su posición o el lugar si esta libre o no y demás si esta fuera del área que la limita las secciones en que se dividió, 
el Rover también tiene su ubicación inicial, y sentido o dirección y se valida si la posición esta libre o no, puede moverse hacia adelante: "F", retroceder: "B", girar derecha: "R", 
izquierda: "L", por lineas de comandos como FFRLB, también se valida la cadena de carreteares que sean validos, el plano generado tiene limites en los bordes, 
y cuando llega al limite pregunta que hacer derecha o izquierda depende del caso o regresar con B, además muestra un historial de los pasos que ha dado y los giros.

Se utilizó tecnologías como Spring boot, MySql, Lombok, Unit-test, Jpa, Api-rest, códigos de respuesta HTTP, 
para manejar los datos del rober https://github.com/ravenfahs/RoverServer.git, tiene varios endpoints para realizar varias acciones crud, 
también tiene la parte de testing en los lados, como el front como en el back, se debe correr primero la Api luego el Rover, 
porque se hace un solicitud de prueba para ver si el Api esta corriendo. Se debe configurar el archivo de application.properties deacuerdo con su entorno de Mysql, 
