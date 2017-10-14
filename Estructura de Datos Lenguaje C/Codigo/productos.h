void    cargarProductos(struct NodoProducto **);
struct  Producto *crearProducto(char *, char *, int , int , char *);
struct  NodoProducto *crearNodoProducto(struct Producto *);
void    enlazarNodoProducto(struct NodoProducto **, struct NodoProducto *);
void    agregarProducto(struct NodoProducto **);
void    guardarProductos(struct NodoProducto *);
void    listarProductos(struct NodoProducto *);
void    mostrarProducto(struct Producto *);
void    menuProductos(struct NodoProducto **);
int     existeProducto(struct NodoProducto *, char*);
void    menuEliminarProducto(struct NodoProducto **);
void    menuModificarProducto(struct NodoProducto **);
void    eliminarProducto(struct NodoProducto **, char*);

// Retorna un Producto
// Recibe la cabeza de los productos y el criterio de busqueda es el codigo
struct Producto * obtenerProducto(struct NodoProducto *cabeza, char *codigo)
{
    struct NodoProducto *aux = cabeza;
    while(aux)
    {
        if(strcmp(aux->producto->codigo, codigo) == 0)
        {
            return aux->producto;
        }
        aux = aux->siguiente;
    }
    return NULL;
}

// Crea la interfaz de usuario para eliminar un producto
void menuModificarProducto(struct NodoProducto **cabeza)
{

    char buscarCodigo[4];
    char bufferNombre[60];
    char bufferCodigo[4];
    int  bufferPrecioCosto;
    int  bufferPrecioVenta;
    char bufferDescripcion[200];
    struct NodoProducto *aux = NULL;

    
	// Leo un código
	do
    {
        printf("\nIngresar Codigo (3 caracteres): ");
        fflush(stdin);
        scanf("%4[^\n]", buscarCodigo);
    }while(strlen(buscarCodigo) != 3);
    // Si es que no existe el producto
	if(existeProducto(*cabeza, buscarCodigo) == 0)
    {
        printf("\nNo existe producto");
    }
    else
    {
        printf("\nIngrese el nuevo valor para cada campo");
        aux = *cabeza;
		// Mientras exista el nodo que estamos visitando
        while(aux)
        {
			// Veo si es que es el codigo del producto
            if(strcmp(aux->producto->codigo, buscarCodigo) == 0)
            {
				// Si es entonces pido los nuevos valores que sobreescriben al Producto
                printf("\nIngresar Nombre (%s): ", aux->producto->nombre);
                fflush(stdin);
                scanf("%60[^\n]", bufferNombre);
                do
                {
                    printf("\nIngresar Codigo (%s) (3 caracteres): ", aux->producto->codigo);
                    fflush(stdin);
                    scanf("%4[^\n]", bufferCodigo);
                }while(strlen(bufferCodigo) != 3 || (existeProducto(*cabeza, bufferCodigo) == 1 && strcmp(bufferCodigo, aux->producto->codigo) != 0));
                
                do
                {
                    printf("Ingresar Precio Costo ($ %d): ", aux->producto->precioCosto);
                    fflush(stdin);
                    scanf("%d", &bufferPrecioCosto);
                }while(bufferPrecioCosto < 0 || bufferPrecioCosto != (int)bufferPrecioCosto);

                do
                {
                    printf("Ingresar Precio Venta ($ %d): ", aux->producto->precioVenta);
                    fflush(stdin);
                    scanf("%d", &bufferPrecioVenta);
                }while(bufferPrecioVenta < 0 || bufferPrecioVenta != (int)bufferPrecioVenta);

                printf("Ingresar Descripcion (%s): ", aux->producto->descripcion);
                fflush(stdin);
                scanf("%200[^\n]", bufferDescripcion);

                free(aux->producto);
                aux->producto = crearProducto(bufferNombre, bufferCodigo, bufferPrecioCosto, bufferPrecioVenta, bufferDescripcion);
                return;
            }
            aux = aux->siguiente;
        }
    }
}

// Crea la interfaz de usuario para eliminar un producto
void menuEliminarProducto(struct NodoProducto **cabeza)
{
	// Buffer del codigo leido
    char bufferCodigo[4];
	// Leo el codigo
    do
    {
        printf("\nIngresar Codigo (3 caracteres): ");
        fflush(stdin);        
        scanf("%4[^\n]", bufferCodigo);
    }while(strlen(bufferCodigo) != 3);
	// Si es que existe el producto
    if(existeProducto(*cabeza, bufferCodigo) == 1)
    {
		// Lo elimino
        eliminarProducto(&(*cabeza), bufferCodigo);
        printf("\nSe ha eliminado el producto");
    }
    else
    {
        printf("\nNo existe producto");
    }
}


// Retorna 1 si se encuentra el producto y 0 si no se encuentra el producto
int existeProducto(struct NodoProducto *cabeza, char* codigo)
{
    while(cabeza)
    {
        if(strcmp(cabeza->producto->codigo, codigo) == 0)
        {
            return 1;
        }
        cabeza = cabeza->siguiente;
    }
    return 0;
}

// Elimina el producto desde la lista productos
void eliminarProducto(struct NodoProducto **cabeza, char *codigo)
{
    struct NodoProducto *actual = NULL, *anterior = NULL;

    // Si es que no existe la cabeza
    if(!*cabeza)
        return;

    // Si es que estoy eliminando la cabeza
    if(strcmp((*cabeza)->producto->codigo, codigo) == 0)
    {
        actual = *cabeza;
        *cabeza = actual->siguiente;
        actual->siguiente = NULL;
        free(actual->producto);
        free(actual);
    }
    else
    {
        // Si es que no es la cabeza
        actual = (*cabeza)->siguiente;
        anterior = *cabeza;
        while(actual)
        {
            if(strcmp(actual->producto->codigo, codigo) == 0)
            {
                anterior->siguiente = actual->siguiente;
                actual->siguiente = NULL;
                free(actual->producto);
                free(actual);
                return;
            }
            anterior = actual;
            actual = actual->siguiente;
        }
    }
}

// DEfino el Submenu de los productos
void menuProductos(struct NodoProducto **cabeza)
{
    int opcion;
    do
    {
        system("cls");
        imprimirCabecera();
        printf("[1] LISTAR PRODUCTOS\n");
        printf("[2] AGREGAR PRODUCTOS\n");
        printf("[3] ELIMINAR PRODUCTOS\n");
        printf("[4] MODIFICAR PRODUCTO\n");
        printf("[0] VOLVER\n");

		// Leo la opcion
        do
        {
            printf("\nINGRESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d", &opcion);
        }while(opcion < 0 || opcion > 4 || opcion != (int)opcion);

		// DEpendiendo el valor que ingrese el usuario entro a la opcion
        switch(opcion)
        {
            case 1:
                system("cls");
                imprimirCabecera();
                listarProductos(*cabeza);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 2:
                system("cls");
                imprimirCabecera();
                agregarProducto(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 3:
                system("cls");
                imprimirCabecera();
                menuEliminarProducto(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 4:
                system("cls");
                imprimirCabecera();
                menuModificarProducto(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar(); 
                break;
        }
    }while(opcion != 0);
}

// Desde un archivo de texto, lee los datos de los productos que han sido ingresados previamente al sistema
// Creando una nueva lista, la cual será enlistada en la variable cabeza que recibe como parámetro
void cargarProductos(struct NodoProducto **cabeza)
{
    FILE *archivo;

    char bufferNombre[60];
    char bufferCodigo[4];
    int  bufferPrecioCosto;
    int  bufferPrecioVenta;
    char bufferDescripcion[200];
    archivo = fopen("productos.txt", "r");
    if(archivo)
    {
        while(fscanf(archivo, "%[^|]|%[^|]|%d|%d|%[^\n]\n", bufferNombre, bufferCodigo, &bufferPrecioCosto, &bufferPrecioVenta, bufferDescripcion)==5)
        {
            enlazarNodoProducto(&(*cabeza), crearNodoProducto(crearProducto(bufferNombre, bufferCodigo, bufferPrecioCosto, bufferPrecioVenta, bufferDescripcion )));
        }
        fclose(archivo);
    }
    else
    {
        printf("No se puede abrir el archivo de Productos");
        exit(1);
    }
}

// Recibe como parámetros los valores para poder crear un Producto
// Retorna un Producto
struct Producto *crearProducto(char *nombre, char *codigo, int precioCosto, int precioVenta, char *descripcion)
{
    struct Producto *producto=NULL;

    producto = (struct Producto *)malloc(sizeof(struct Producto));
    producto->precioCosto = precioCosto;
    producto->precioVenta =precioVenta;
    strcpy(producto->codigo, codigo);
    producto->nombre = (char *)malloc(sizeof(char)*strlen(nombre));
    strcpy(producto->nombre, nombre);
    producto->descripcion = (char *)malloc(sizeof(char)*strlen(descripcion));
    strcpy(producto->descripcion, descripcion);

    return producto;
}

// Recibe como parametro un Producto
// Retorna un NodoProducto
struct NodoProducto *crearNodoProducto(struct Producto* producto)
{
    struct NodoProducto *nodoProducto = NULL;

    nodoProducto = (struct NodoProducto *)malloc(sizeof(struct NodoProducto));
    nodoProducto->producto = producto;
    nodoProducto->siguiente = NULL;

    return nodoProducto;
};

// Recibe un NodoProducto, y una Cabeza de NodoProducto
// Enlista el Nodo nuevo en la cabeza
void enlazarNodoProducto(struct NodoProducto **cabeza, struct NodoProducto *nuevoNodo)
{
    struct NodoProducto *auxiliar = *cabeza;

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

// Crea la interfaz de usuario para ingresar un producto
void agregarProducto(struct NodoProducto **cabeza)
{

    char bufferNombre[60];
    char bufferCodigo[4];
    int  bufferPrecioCosto;
    int  bufferPrecioVenta;
    char bufferDescripcion[200];

    printf("\nIngresar Nombre: ");
    fflush(stdin);
    scanf("%60[^\n]", bufferNombre);

    do
    {
        printf("\nIngresar Codigo (3 caracteres): ");
        fflush(stdin);
        scanf("%4[^\n]", bufferCodigo);
    }while(strlen(bufferCodigo) != 3 || existeProducto(*cabeza, bufferCodigo) == 1);
    
    do
    {
        printf("Ingresar Precio Costo: ");
        scanf("%d", &bufferPrecioCosto);
    }while(bufferPrecioCosto < 0 || bufferPrecioCosto != (int)bufferPrecioCosto);

    do
    {
        printf("Ingresar Precio Venta: ");
        scanf("%d", &bufferPrecioVenta);
    }while(bufferPrecioVenta < 0 || bufferPrecioVenta != (int)bufferPrecioVenta);

    printf("Ingresar Descripcion: ");
    fflush(stdin);
    scanf("%200[^\n]", bufferDescripcion);

    enlazarNodoProducto(&(*cabeza), crearNodoProducto(crearProducto(bufferNombre, bufferCodigo, bufferPrecioCosto, bufferPrecioVenta, bufferDescripcion )));
}

// Recibe la cabeza de la lista NodProducto y lo respalda en el archivo de texto
void guardarProductos(struct NodoProducto *cabeza)
{
    FILE *archivo;
    archivo = fopen("productos.txt", "w");
    if(archivo)
    {
        while(cabeza)
        {
            fprintf(archivo, "%s|%s|%d|%d|%s\n", cabeza->producto->nombre, cabeza->producto->codigo, cabeza->producto->precioCosto, cabeza->producto->precioVenta, cabeza->producto->descripcion);
            cabeza = cabeza->siguiente;
        }
        fclose(archivo);
    }
}

// Recorro la lista
void listarProductos(struct NodoProducto *cabeza)
{
    while(cabeza)
    {
        mostrarProducto(cabeza->producto);
        cabeza = cabeza->siguiente;
    }
}

// Muestro un producto de tipo struct Producto
void mostrarProducto(struct Producto *producto)
{
    printf("Nombre Producto\t\t: %s"      , producto->nombre);
    printf("\nCodigo Producto\t\t: %s"      , producto->codigo);
    printf("\nDescripcion Producto\t: %s"   , producto->descripcion);
    printf("\nPrecio Costo\t\t: $ %d"       , producto->precioCosto);
    printf("\nPrecio Venta\t\t: $ %d"       , producto->precioVenta);
    printf("\n\n");
}

