package reproductor_de_musica;

public class lista {
    //Las listas doblemente enlazadas tienen dos apuntandores, uno al nodo siguiente y el otro al nodo anterior, adicional el nodo que contiene la información
    //Por ellos se declaran los dos primeros objetos tipo nodo y la variable int de nombre tam para el tamaño de la lista.
    nodo primero;
    nodo ultimo;
    int tam;

    public lista() {
        primero = ultimo = null;//Se inician los nodos en null porque al iniciar el programa estarán vacíos
        tam = 0;
    }

    public boolean IsVacio() {
        return primero == null;
    }

    public void clear() {
        while (!IsVacio()) {
            borrar(primero);
        }
    }

    public void insertar(String nom, String dir) {
        nodo nuevo = new nodo(nom, dir);
        if (IsVacio()) {//Si se encuentra vació creará nodos nuevos para primero y último
            primero = nuevo;
            ultimo = nuevo;
        } else {  //Caso contrario anterior pasará a siguiente y siguiente a nodo nuevo
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tam++;// y aumentará el tamaño de la lita
    }//Fin de insertar

    public int indice(nodo b) {
        nodo aux = primero;
        int con = 0;

        while (aux != null) {
            if (aux == b) {
                return con;
            }
            aux = aux.siguiente;
            con++;
        }
        return -1;
    }
    
    public nodo get_cancion(int indice){
        if (indice < 0 || indice >= tam) {
            return null;
        }
        
        int n = 0;
        nodo aux = primero;
        while (n != indice) {            
            aux = aux.siguiente;
            n++;
        }
        
        return aux;
    }

    public void borrar(nodo b) {
        if (b == primero) {
            if (tam == 1) {
                primero = null;
                tam--;
                return;
            }
            primero.siguiente.anterior = null;
            primero = primero.siguiente;
            tam--;
            return;
        }
        tam--;
        if (b == ultimo) {
            ultimo.anterior.siguiente = null;
            ultimo = ultimo.anterior;
            return;
        }
        b.siguiente.anterior = b.anterior;
        b.siguiente.anterior.siguiente = b.siguiente;
    }//Fin de borrar
    
    public boolean buscar(String nombre, String ruta){
        nodo aux = primero;

        while (aux != null) {
            if (aux.nombre.equals(nombre) && aux.direccion.equals(ruta)) {
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }//Buscar
}
