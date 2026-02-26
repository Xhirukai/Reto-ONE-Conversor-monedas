public class Main {
    public static void main(String[] args) {

        Consulta consultaIntercambio = new Consulta();

        ValorConversion valor = consultaIntercambio.obtenerValorConversion("USD", "EUR");

        System.out.println(valor);
    }
}
