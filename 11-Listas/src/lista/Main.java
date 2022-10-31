package lista;

/**
 * Main de la lista simplemente enlazada
 * @author Sivana Hamer
 * @version 10-31-2022
 */
public class Main{
    public static void main(String [] args){
        //Crea los nodos a pata
        Nodo temp = new Nodo(4);
        temp = new Nodo(3, temp);
        temp = new Nodo(2, temp);
        temp = new Nodo(1, temp);
        Lista l1 = new Lista(temp);

        //Crea una lista con un nodo
        Lista l2 = new Lista(1);

        //Crea una lista vacia
        Lista l3 = new Lista();

        //Imprimimos nodos
        System.out.println(l1.getHead());
        System.out.println(l2.getHead());
        l2.getHead().imprimir();
        System.out.println();

        //Imprimimos la lista
        l1.imprimir();
        l2.imprimir();
        l3.imprimir();

        //Concatenamos en una lista
        l2.concatenar(5);
        l2.concatenar(8);
        l2.imprimir();
        l3.concatenar(10);
        l3.concatenar(100);
        l3.imprimir();

        l1.insertar(2, 12);
        l1.imprimir();

    }
}