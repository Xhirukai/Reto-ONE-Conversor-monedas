import java.util.Scanner;

public class Conversor {

    Consulta consultaIntercambio = new Consulta();
    Scanner lecturaMenu = new Scanner(System.in);
    Scanner lecturaCantidad = new Scanner(System.in);
    boolean menuActivo = true;

    public void menu(){

        while (menuActivo){
            String codigoMonedaOrigen = "";
            String codigoMonedaDestino = "";
            double cantidad;
            double cantidadConvertida;
            String opcionesConversion = "123456";

            System.out.println("----------------------");
            System.out.println("Bienvenido al sistema de conversion de monedas.");
            System.out.println("Porfavor seleccione la conversion que desea realizar: ");
            System.out.println("""
                                1) Dolar Estadounidense (USD) a Peso Colombiano (COP)
                                2) Peso Colombiano (COP) a Dolar Estadounidense (USD)
                                3) Dolar Estadounidense (USD) a Dolar Canadiense (CAD)
                                4) Dolar Canadiense (CAD) a Dolar Estadounidense (USD)
                                5) Dolar Estadounidense (USD) a Libra Esterlina (GBP)
                                6) Libra Esterlina (GBP) a Dolar Estadounidense (USD)
                                7) SALIR
                                ----------------------""");

            String entradaMenu = lecturaMenu.nextLine();

            if (entradaMenu.equals("7")){
                menuActivo = false;
                break;
            } else if (!(opcionesConversion.contains(entradaMenu))){
                System.out.println("La opcion ingresada no es valida, por favor intentelo nuevamente.");
                continue;
            }

            switch (entradaMenu){
                case "1":
                    codigoMonedaOrigen = "USD";
                    codigoMonedaDestino = "COP";
                    break;

                case "2":
                    codigoMonedaOrigen = "COP";
                    codigoMonedaDestino = "USD";
                    break;

                case "3":
                    codigoMonedaOrigen = "USD";
                    codigoMonedaDestino = "CAD";
                    break;

                case "4":
                    codigoMonedaOrigen = "CAD";
                    codigoMonedaDestino = "USD";
                    break;

                case "5":
                    codigoMonedaOrigen = "USD";
                    codigoMonedaDestino = "GBP";
                    break;

                case "6":
                    codigoMonedaOrigen = "GBP";
                    codigoMonedaDestino = "USD";
                    break;

            }


            System.out.println("Indique el valor a convertir desde la moneda inicial: ");
            cantidad = lecturaCantidad.nextDouble();

            if (cantidad <= 0){
                System.out.println("La cantidad ingresada no puede ser menor o igual a cero, por favor intentelo nuevamente. ");
                continue;
            } else {

                ValorConversion valor = consultaIntercambio.obtenerValorConversion(codigoMonedaOrigen, codigoMonedaDestino);

                cantidadConvertida = cantidad * valor.conversion_rate();

                System.out.printf("El resultado de la conversion es de %.2f %s (El factor de conversion fue de %.4f)\n", cantidadConvertida, codigoMonedaDestino, valor.conversion_rate());
            }



        }

    }



}
