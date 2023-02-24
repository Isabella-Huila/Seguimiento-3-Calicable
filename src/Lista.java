public class Lista {

    Nodo primero;
    Nodo ultimo;
    Nodo actual;

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public Nodo getActual() {
        return actual;
    }

    public void setActual(Nodo actual) {
        this.actual = actual;
    }

    public void agregar(int turno) {
        Nodo nuevo = new Nodo(turno);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            actual=nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            ultimo = nuevo;
        }
    }

    public void eliminar(Nodo nodo) {
        if (nodo == primero && nodo == ultimo) {
            primero = null;
            ultimo = null;
        } else if (nodo == primero) {
            primero = primero.siguiente;
            ultimo.siguiente = primero;
            primero.anterior = ultimo;
        } else if (nodo == ultimo) {
            ultimo = ultimo.anterior;
            primero.anterior = ultimo;
            ultimo.siguiente = primero;
        } else {
            nodo.anterior.siguiente = nodo.siguiente;
            nodo.siguiente.anterior = nodo.anterior;
        }
        actual = actual.siguiente;
    }

    public void mostrarActual() {
        if (actual == null) {
            System.out.println("No hay turnos aún.");
        } else {
            System.out.println("Turno actual: " + actual.turno);
        }
    }

    public void pasarTurno() {
        actual = actual.siguiente;
        actual.anterior.saltos--;
        if (actual.anterior.saltos== 0) {
            eliminar(actual.anterior);
        }
    }

    public void mostrarLista() {
        if (primero == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo actual = primero;
            do {
                System.out.println("Turno " + actual.turno);
                actual = actual.siguiente;
            } while (actual != primero);
        }
    }
}

