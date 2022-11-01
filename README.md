# GuessNumberFragment

Autor:Daniel Casado Carvajal<br>
Fecha de Finalización del proyecto:30/10/2022<br>
App que se compone de 1 Activiti y 3 fragments: el primer fragment sirve para configurar el juego(ConfigFragment), el segundo para jugar al juego(PlayFragment) y 
finalmente el tercer fragment nos dara resultado final(EndPlayFragment), ademas de esto se ha añadido una activity con informacion sobre nosotros<br>
Versión API:31<br>
Minimun SDK:26<br>
<h3>Contenido del ejercicio:</h3><br>
Este ejercicio cuentra con 3 Fragment.<br>
El primero (ConfigFragment) se pide al usuario un nombre y el numero de intentos para jugar, estos se almacenaran en una clase Juego. El numero de intentos debe cumplir el requisito de ser mayor que cero.
y ningun campo puede estar vacio.<br> Si al pulsar el boton se cumplen estos requisitos se pasa al siguiente Fragment.<br>
<br>
En el segundo (PlayFragment) se pide al usuario el numero para jugar y se actua en consecuencia. Este fragment cuenta con dos botones, uno para borrar los campos introducidos
y otro para comprobar si el numero es correcto o no.<br>
<br>
El tercero (EndPlayFragment) muestra el resultado del juego una vez este ha concluido.<br>

<h1>ConfigActivity</h1>
Es la primera pantalla que se ejecutará al lanzar la Aplicación.</br> En ella se nos pedira nuestro nombre de usuario y el numero de intentos con el que queremos jugar.
<br>

![Imagen_Config](https://github.com/DaniCasado13/GuessNumber/blob/master/app/src/main/res/imagenes/1.JPG))

Se ha creado una clase Application personalizada para inicializar los valores por defecto del juego a traves del codigo.

![aplication](https://user-images.githubusercontent.com/71752283/198864249-61072453-7d38-46f5-a276-b40cf3a84ab2.JPG)
![codigo](https://user-images.githubusercontent.com/71752283/198864322-436c0d7d-d682-439c-8f36-d4436b08bcce.JPG)


<br>
<h1>PlayActivity</h1>
Es la pantalla que realmente gestiona nuestro juego.</br> En ella se pide al usuario introducir el numero que cree que es el correcto y se actua segun el caso:<br>
<ol>
<li> El numero es menor: Se informa al usuario que el numero que se busca es menor que el introducido y se le consume un intento para poder jugar.</li>
<li> El numero es mayor: Se informa al usuario que el numero que se busca es mayor que el introducido y se le consume un intento para poder jugar.</li>
<li> Acierto: El numero introducido por el usuario es el correcto y gana el juego</li>
</ol>
<br>

![Imagen_Play](https://github.com/DaniCasado13/GuessNumber/blob/master/app/src/main/res/imagenes/2.JPG))

<br>
<h1>EndPlayActivity</h1>
Es la pantalla final de nuestro juego, en la cual se informa al usuario lo que ha ocurrido segun el caso, el juego finaliza de las siguientes maneras:
<ol>
<li> El usuario gana: Se informa al usuario de que ha ganado y el numero de intentos que ha consumido para ello.</li>
<li> El usuario pierde: Se informa al usuario de que ha perdido y se muetra el numero que era el correcto</li>

</ol>
<br>
<br>
<br>

![Imagen_End1](https://github.com/DaniCasado13/GuessNumber/blob/master/app/src/main/res/imagenes/3.JPG))

![Imagen_End2](https://github.com/DaniCasado13/GuessNumber/blob/master/app/src/main/res/imagenes/4.JPG))

<br>
Para la navegacion entre Fragment se ha utilizado el componente navigation.<br>
A continuacion se muestra el grafo de navegacion asi como el codigo que inicia la navegacion de un fragment a otro.<br> 
<br>

![grafo](https://user-images.githubusercontent.com/71752283/198864442-760c3f24-4164-4d33-879a-bb56c96fc461.JPG)

![codnav](https://user-images.githubusercontent.com/71752283/198864508-a8cd5eea-1f44-49e1-8e92-490c8122a4d2.JPG)

<h1> Ampliacion</h1><br>
Se ha creado un recurso de tipo color para añadirlo al tema de la aplicacion y asi cambiar el aspecto visual de esta.

![colors](https://user-images.githubusercontent.com/71752283/198902573-0481d98e-e2b5-4d40-985a-1a797faf2594.JPG)


![colortema](https://user-images.githubusercontent.com/71752283/198902603-604442c2-3f84-48a4-a30c-a1c981a970ae.JPG)



Documentacion utilizada

https://moronlu18.com/wordpress/
