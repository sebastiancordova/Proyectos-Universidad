struct  VentaProducto *crearVentaProducto(int, int);
void enlazarVentaProducto(struct VentaProducto **, struct VentaProducto *);
void mostrarVentaProducto(struct VentaProducto *);
void mostrarVentasProducto(struct VentaProducto *);

// Recibe la cantidad inicial y la cantidad vendida en un turno, reserva memoria para el turno y lo retorna
struct  VentaProducto *crearVentaProducto(int cantidadInicial, int cantidadVendida)
{

    struct VentaProducto *ventaProducto=NULL;
    ventaProducto = (struct VentaProducto *)malloc(sizeof(struct VentaProducto));
    ventaProducto->cantidadInicial  = cantidadInicial;
    ventaProducto->cantidadVendida  = cantidadVendida;
    ventaProducto->producto  = NULL;
    ventaProducto->siguiente = NULL;

    return ventaProducto;
}

// Agrega un nuevo nodo a la lista de Ventas de Producto asociada a un Turno
void enlazarVentaProducto(struct VentaProducto **cabeza, struct VentaProducto *nuevoNodo)
{
    struct VentaProducto *auxiliar = *cabeza;
    if(!*cabeza)
    {
        *cabeza = nuevoNodo;
    }
    else
    {
        while(auxiliar->siguiente)
        {
            auxiliar = auxiliar->siguiente;
        }
        auxiliar->siguiente = nuevoNodo;
    }
}

// Muestra cada una de las ventas en el listado de ventas de un turno
void mostrarVentasProducto(struct VentaProducto *nodoLista)
{
    while(nodoLista)
    {
        mostrarVentaProducto(nodoLista);
        nodoLista = nodoLista->siguiente;
    }
}

// Muestra la venta de un producto
void mostrarVentaProducto(struct VentaProducto *ventaProducto)
{

    printf("\n\nVENTA PRODUCTO\n");
    printf("Nombre Producto\t: %s", ventaProducto->producto->nombre);
    printf("\nCantidad Entregada: %d", ventaProducto->cantidadInicial);
    printf("\nCantidad Vendida: %d", ventaProducto->cantidadVendida);
    printf("\n");
}
