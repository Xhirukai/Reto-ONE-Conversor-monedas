# Conversor de Monedas - Java Challenge

Bienvenido al **Sistema de Conversión de Monedas**. Esta aplicación de consola funciona como entrega del primer reto de la especializacion Backend del programa ONE y permite realizar conversiones de divisas en tiempo real, consultando datos actualizados directamente desde una API externa.

## Características

- Conexión con [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio oficiales. 
- Por preferencia personal se intento reducir la presencia de logica de calculos en la clase Main y se define en una clase aparte conocida como Conversor, que a su vez contiene el menu desplegado en pantalla, permitiendo asi reducir a un simple llamado al metodo menu desde la clase Main para emplear el programa.
- Se usaron Records para adaptar y manejar el valor asociado al factor de conversion entre monedas obtenido del JSON.
- El menu emplea un Switch para validar las opciones de conversion y dos condicionales tanto para la opcion de slida del programa como para manejar el ingreso de opciones no validas.

---

## Tecnologías y Librerías

* **Java 25**: En los cursos emplean la version 17 de Java pero decidí instalar la version 25 ya que es la mas reciente y si bien cambian detalles de sintaxis, en este proyecto estan descritos tal y como se enseña en el programa ONE.
* **Gson (Google)**: Para la deserialización de objetos JSON a clases/records de Java.
* **ExchangeRate-API**: Proveedor de los datos de conversión.

---

## ️ Estructura del Proyecto

El proyecto contiene 3 clases y un record para realizar todos los aspectos de la conversion:

- Main simplemente hace el llamado al metodo menu() de la clase conversor para desplegar y ejecutar el calculo de la conversión. 
- Conversor contiene el método menu, que emplea un ciclo y condicionales para validar y mantener el flujo de las entradas del usuario, de igual forma obtiene el valor de conversion de la opcion ingresada y realiza el calculo del valor final, desplegandolo como un mensaje al final de la interaccion.
- El Record ValorConversion funciona como el puente para tomar el valor del factor de conversion de la respuesta JSON de la API y poder emplearla dentro de los calculos de la clase conversor.
- La clase consulta contiene al cliente http, como la peticion y la respuesta de esta, manejando las excepciones que se puedan disparar en caso de ocurrir un error en el ingreso de los datos, aunque por como esta estructurado el proyecto el usuario no tiee forma de alterar esta entrada en la solicitud hacia la API, pero es una contramedida util para emplear los conocimientos adquiridos en el desarrollo de la etapa. La respuesta http se deserializa gracias a Gson y se transforma mediante el record ValorConversion para poder usarlo dentro de los calculos del sistema.



---

## Ejemplo de Funcionamiento

El sistema valida las opciones del usuario antes de proceder. Si se ingresa una opción inexistente, un condicional verifica que la opcion no sea ninguna de las mostradas en el menu y reinicia el flujo de este.

```text
----------------------
Bienvenido al sistema de conversion de monedas.
Porfavor seleccione la conversion que desea realizar: "

1) Dolar Estadounidense (USD) a Peso Colombiano (COP)
2) Peso Colombiano (COP) a Dolar Estadounidense (USD)
3) Dolar Estadounidense (USD) a Peso Chileno (CLP)
4) Peso Chileno (CLP) a Dolar Estadounidense (USD)
5) Dolar Estadounidense (USD) a Peso Argentino (ARS)
6) Peso Argentino (ARS) a Dolar Estadounidense (USD)
7) SALIR
Elija una opción válida:
----------------------