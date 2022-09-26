package src.starducks;
import pizza.*;

public class Matriz {
    private int [][] valores;
    private Interfaz interfaz;
    private String nombre;
    private String [] nombresFilas;
    private String [] nombresColumnas;
    private int cantidadFilas;
    private int cantidadColumnas;
    private final int ESPACIOS_IMPRIMIR = 15; //Esto se puede encontrar de los datos para hacerlo variable

    public Matriz(String nombre, String [] nombresFilas, String [] nombresColumnas){
        //Se guarda la informacion de la matriz
        this.nombre = nombre;
        this.nombresFilas = nombresFilas;
        this.nombresColumnas = nombresColumnas;
        this.cantidadFilas = nombresFilas.length;
        this.cantidadColumnas = nombresColumnas.length;

        //Crea la matriz vacias
        this.valores = new int [cantidadFilas][cantidadColumnas];

        //Crea la interfaz
        this.interfaz = new Interfaz();
    }

    private void imprimirNombre(){
        String separador = "*".repeat(30);
        this.interfaz.imprimir(separador);
        this.interfaz.imprimir(this.nombre.toUpperCase());
        this.interfaz.imprimir(separador);
        this.interfaz.imprimir("");
    }

    /**
     * Obtiene los valores de una matriz
     */
    public void obtenerValores(){

        this.imprimirNombre();
        for(int i = 0; i < cantidadFilas ; i++){
            for (int j = 0; j < cantidadColumnas; j++){
                String mensaje = String.format("Digite las %s de [%d][%d]: ", this.nombre, i, j);
                int elemento = this.interfaz.pedirEntero(mensaje, "ERROR al ingresar el dato");
                this.valores[i][j] = elemento;
            }
        }
    }

    /**
     * Imprime una matriz
     */
    public void imprimir(){
        this.imprimirNombre();

        String formatCampo;
        String texto;

        formatCampo = "%" + ESPACIOS_IMPRIMIR + "S";
        texto = String.format(formatCampo, "LOCALES");
        this.interfaz.imprimirNoNewLine(texto);

        for (int j = 0; j < cantidadColumnas; j++){
            //Imprime un elemento de la matriz
            formatCampo = "%" + ESPACIOS_IMPRIMIR + "S";
            texto = String.format(formatCampo, this.nombresColumnas[j]);
            this.interfaz.imprimirNoNewLine(texto);
        }
        this.interfaz.imprimir("");

        for(int i = 0; i < cantidadFilas ; i++){
            //Imprime el local
            formatCampo = "%" + ESPACIOS_IMPRIMIR + "s";
            texto = String.format(formatCampo, this.nombresFilas[i]);
            this.interfaz.imprimirNoNewLine(texto);

            for (int j = 0; j < cantidadColumnas; j++){
                //Imprime un elemento de la matriz
                formatCampo = "%" + ESPACIOS_IMPRIMIR + "d";
                texto = String.format(formatCampo, this.valores[i][j]);
                this.interfaz.imprimirNoNewLine(texto);
            }
            this.interfaz.imprimir("");
        }
    }

    public int [][] restar(Matriz otraMatriz){
        int [][] b = otraMatriz.valores;

        int [][] resultado = this.valores.clone();

        for(int i = 0; i < cantidadFilas ; i++){
            for (int j = 0; j < cantidadColumnas; j++){
                resultado[i][j] -= b[i][j];
            }
        }
        return resultado;
    }    
}