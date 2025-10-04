// Arboles binarios de busqueda
// Implementar las operaciones de inserción, búsqueda y recorrido en orden (in-order traversal).

import java.util.Scanner;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Tree{
    Node root;

    Tree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

public class Main {

    //Inicializo el arbol
    static Tree tree = new Tree();

    //capturo los datos
    static Scanner scan = new Scanner(System.in);

    //Expresion regular para validar texto numerico
    static String regex = "^\\d+$";

    public static void main(String[] args) {



        //cracion del menú
        String menu = new StringBuilder()
                .append("MENU DE OPCIONES ARBOL BINARIO \n ")
                .append("\t1. Inserte un numero en el arbol.\n ")
                .append("\t2. Mostrar el recorrido en orden.\n ")
                .append("\t3. Buscar un numero dentro del arbol.\n ")
                .append("\t4. salir.")
                .append("\n\nElige una opcion: ")
                .toString();

        String opcion = "";

        do {
            //Mostrar menu
            System.out.print( "\n" + menu);

            //elegir opcion
            opcion = scan.nextLine();

            //control opciones menu
            switch (opcion) {
                case "1" :
                    //inserte un numero en el arbol
                    int numero1 = obtenerEntero("\t>> inserte su numero : ");
                    tree.insert(numero1);
                    System.out.println("Numero guardado con exito.");
                    break;
                case "2" :
                    //mostrar el recorrido en orden
                    System.out.println("Recorrido en orden: ");

                    System.out.print("\t");
                    tree.inorder();
                    System.out.println();
                    break;
                case "3" :
                    //Buscar un numero dentro del arbol
                    int numero2 = obtenerEntero("\t>> ingrese el numero a buscar: ");

                    // verificar si esta el numero en el arbol
                        boolean resultadoBusqueda = tree.search(numero2);
                        if (resultadoBusqueda){
                            System.out.println("El numero '"+ numero2 + "' si esta en el arbol.");
                        }else {
                            System.out.println("El numero '"+ numero2 + "' no se encuentra en el arbol.");
                        }
                    break;
                case "4" :
                    // fin del programa
                    System.out.println("\n>>-------------------------------<<");
                    System.out.println("\n>>---    FIN DEL PROGRAMA    ---<<");
                    System.out.println("\n>>-------------------------------<<");
                    break;
                default:
                    // Opciones no validas
                    System.out.println("[Error] - Opcion " + opcion + " no es valido.");
                    System.out.println("Elija una opcion valida.");
            }
            tiempoDeEspera();

        } while (! opcion.equals("4"));

        System.out.println("\n\n");
        System.out.println("======================================================================");
        System.out.println("                            YASURY HERRERA");
        System.out.println("======================================================================");



    }

    //metodo recursivo que obtiene un dato int insertado por consola
    private static int obtenerEntero(String mensaje){

        System.out.print(mensaje);
        String texto = scan.nextLine();
        if (texto.matches(regex)) {
            return Integer.parseInt(texto);
        }
        System.out.println("Error. '" + texto + "' no es un valor valido.\n");
        return obtenerEntero(mensaje);
    }

    private static void tiempoDeEspera(){
        // Tiempo de espera para volver a mostrar el menú
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}