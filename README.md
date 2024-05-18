# MultiplicacionMatrices
En esta asignacion se desarrollaron los conocimientos sobre, memoria compartida, memoria distribuida y  paso de mensajes. Ademas, se analizaron temas como multiplicacion secuencial y multiplicacion paralela.

El funcionamiento del programa sigue el esquema mostrado a continuacion:
![Captura de pantalla 2024-05-18 155128](https://github.com/EleazarPe/MultiplicacionMatrices/assets/71235444/f6dfa40f-5b90-4dd2-b97d-da9c53ea0e41)
Como se puede observar se genera un mensaje desde el main, el mensaje esta compuesto por un ArrayList<int[][]>, luego el boker lo distribuye entre las dos implementaciones, a su vez se crean dos procesos trabajando en paralelo donde se divide la matriz en dos partes que luego se unen, por lo que la carga se distribuye a la mitad.
Emeplos de la corrida del programa en forma paralela:
![explicacion](https://github.com/EleazarPe/MultiplicacionMatrices/assets/71235444/c13c5b6f-3c36-4bb8-8656-af71a9524add)
<p style="color:red;">Tiempo de corrida</p>
<p style="color:green;">secuencia de ejecucion.</p>
<p style="color:cian;">Matriz resultante</p>
Se puede observar que la memoria compartida fue mas rapido que la memoria distribuida, en ambos casos la secuencia de ejecucion fue arbitraria y las matrices de resultado identicas.
Emeplos de la corrida del programa en forma secuencial:
![explicacion2](https://github.com/EleazarPe/MultiplicacionMatrices/assets/71235444/8ee01237-8b91-40f1-8120-e1801406302a)
<p style="color:red;">Tiempo de corrida</p>
<p style="color:green;">secuencia de ejecucion.</p>
<p style="color:cian;">Matriz resultante</p>
Se puede observar que la memoria compartida fue mas rapido que la memoria distribuida, en ambos casos la secuencia de ejecucion fue secuencial y las matrices de resultado identicas.
Observacion: al ser matrices aleatorias en cada corrida el tiempo de ejecucion puede variar en cada caso.
