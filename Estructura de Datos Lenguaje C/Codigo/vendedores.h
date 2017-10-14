void    cargarVendedores(struct NodoVendedor **);
struct  Vendedor *crearVendedor(char *, char *, char *, char *);
struct  NodoVendedor *crearNodoVendedor(struct Vendedor *);
void    enlazarNodoVendedor(struct NodoVendedor **, struct NodoVendedor *);
void    agregarVendedor(struct NodoVendedor **);
void    guardarVendedores(struct NodoVendedor *);
void    listarVendedores(struct NodoVendedor *);
void    mostrarVendedor(struct Vendedor *);
void    menuVendedores(struct NodoVendedor **);
void    menuEliminarVendedor(struct NodoVendedor **);
void    menuModificarVendedor(struct NodoVendedor **);
void    modificarVendedor(struct Vendedor *, char *, char *, char *, char *);
void    eliminarVendedor(struct NodoVendedor **, char*);
struct Vendedor * obtenerReferenciaVendedor(struct NodoVendedor **, char *);

// Crea la interfaz de usuario para modificar un vendedor
void menuModificarVendedor(struct NodoVendedor **cabeza)
{

    char buscarRut[20];
    char bufferNombre[60];
    char bufferRut[20];
    char bufferEmail[80];
    char bufferTelefono[20];
    int ultimoTurno;

    struct NodoVendedor *aux = NULL;

    do
    {   
        printf("\nIngresar Rut (sin dv)): ");
        fflush(stdin);   
        scanf("%20[^\n]", buscarRut);  
    }while(es_numero(buscarRut) == 0 || strlen(buscarRut) > 8);

    if(existeVendedor(*cabeza, buscarRut) == 0)
    {
        printf("\nNo existe vendedor");
    }
    else
    {
        printf("\nIngrese el nuevo valor para cada campo");
        aux = *cabeza;
        while(aux)
        {
            if(strcmp(aux->vendedor->rut, buscarRut) == 0)
            {
                printf("\nIngresar Nombre (%s): ", aux->vendedor->nombre);
                fflush(stdin);
                scanf("%50[^\n]", bufferNombre);
                do
                {
                    printf("Ingresar Rut (%s) (sin dv): ", aux->vendedor->rut);
                    fflush(stdin);
                    scanf("%20[^\n]", bufferRut);
                }while(es_numero(bufferRut) == 0 || ((existeVendedor(*cabeza, bufferRut) == 1 && strcmp(bufferRut, aux->vendedor->rut) != 0)));
                printf("Ingresar Telefono (%s): ", aux->vendedor->telefono);
                fflush(stdin);                
                scanf("%20[^\n]", bufferTelefono);
                printf("Ingresar Email (%s): ", aux->vendedor->email);
                fflush(stdin);               
                scanf("%70[^\n]", bufferEmail);

                modificarVendedor(aux->vendedor, bufferRut, bufferNombre, bufferTelefono, bufferEmail);
                return;
            }
            aux = aux->siguiente;
        }
    }
}

void modificarVendedor(struct Vendedor *vendedor, char *rut, char *nombre, char *telefono, char *email)
{
    
    vendedor->nombre = (char *)malloc(sizeof(char )*strlen(nombre));
    vendedor->rut = (char *)malloc(sizeof(char )*strlen(rut));
    vendedor->telefono = (char *)malloc(sizeof(char )*strlen(telefono));
    vendedor->email = (char *)malloc(sizeof(char )*strlen(email));

    strcpy(vendedor->nombre,nombre);
    strcpy(vendedor->rut,rut);
    strcpy(vendedor->telefono,telefono);
    strcpy(vendedor->email,email);
}
// Obtiene la referencia de un vendedor
struct Vendedor * obtenerReferenciaVendedor(struct NodoVendedor **cabeza, char *rut)
{
    struct NodoVendedor *aux = *cabeza;
    struct Vendedor *nodo = NULL;
    while(aux)
    {
        if(strcmp(aux->vendedor->rut, rut) == 0)
        {
            nodo = aux->vendedor;
        }
        aux = aux->siguiente;
    }
    return nodo;
}

// Obtiene un vendedor
struct Vendedor * obtenerVendedor(struct NodoVendedor *cabeza, char *rut)
{
    struct NodoVendedor *aux = cabeza;
    while(aux)
    {
        if(strcmp(aux->vendedor->rut, rut) == 0)
        {
            return aux->vendedor;
        }
        aux = aux->siguiente;
    }
    return NULL;
}

// Crea la interfaz de usuario para eliminar un vendedor
void menuEliminarVendedor(struct NodoVendedor **cabeza)
{
    char bufferRut[20];
    do
    {
        printf("\nIngresar Rut (sin dv)): ");
        fflush(stdin);
        scanf("%20[^\n]", bufferRut);
    }while(es_numero(bufferRut) == 0 || strlen(bufferRut) > 8);
    if(existeVendedor(*cabeza, bufferRut) == 1)
    {
        eliminarVendedor(&(*cabeza), bufferRut);
        printf("\nSe ha eliminado el vendedor");
    }
    else
    {
        printf("\nNo existe vendedor");
    }
}


// Retorna 1 si se encuentra el vendedor y 0 si no se encuentra el vendedor
int existeVendedor(struct NodoVendedor *cabeza, char* rut)
{
    while(cabeza)
    {
        if(strcmp(cabeza->vendedor->rut, rut) == 0)
        {
            return 1;
        }
        cabeza = cabeza->siguiente;
    }
    return 0;
}

// Elimina el vendedor desde la lista vendedores
void eliminarVendedor(struct NodoVendedor **cabeza, char *rut)
{
    struct NodoVendedor *actual = NULL, *anterior = NULL;

    // Si es que no existe la cabeza
    if(!*cabeza)
        return;

    // Si es que estoy eliminando la cabeza
    if(strcmp((*cabeza)->vendedor->rut, rut) == 0)
    {
        actual = *cabeza;
        *cabeza = actual->siguiente;
        actual->siguiente = NULL;
        free(actual->vendedor);
        free(actual);
    }
    else  // Si es que no es la cabeza
    {  
        actual = (*cabeza)->siguiente;
        anterior = *cabeza;
        while(actual)
        {
            if(strcmp(actual->vendedor->rut, rut) == 0)
            {
                anterior->siguiente = actual->siguiente;
                actual->siguiente = NULL;
                free(actual->vendedor);
                free(actual);
                return;
            }
            anterior = actual;
            actual = actual->siguiente;
        }
    }
}

void menuVendedores(struct NodoVendedor **cabeza)
{
    int opcion;
    do
    {
        system("cls");
        imprimirCabecera();
        printf("[1] LISTAR VENDEDORES\n");
        printf("[2] AGREGAR VENDEDORES\n");
        printf("[3] ELIMINAR VENDEDORES\n");
        printf("[4] MODIFICAR VENDEDOR\n");
        printf("[0] VOLVER\n");

        do
        {
            printf("\nINGRESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d", &opcion);
        }while(opcion < 0 || opcion > 5 || opcion != (int)opcion);

        switch (opcion)
        {
            case 1:
                system("cls");
                imprimirCabecera();
                listarVendedores(*cabeza);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 2:
                system("cls");
                imprimirCabecera();
                agregarVendedor(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 3:
                system("cls");
                imprimirCabecera();
                menuEliminarVendedor(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 4:
                system("cls");
                imprimirCabecera();
                menuModificarVendedor(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
        }
    }while(opcion != 0);
}

// Desde un archivo de texto, lee los datos de los vendedores que han sido ingresados previamente al sistema
// Creando una nueva lista, la cual será enlistada en la variable cabeza que recibe como parámetro
void cargarVendedores(struct NodoVendedor **cabeza)
{
    FILE *archivo;

    char bufferNombre[60];
    char bufferCodigo[4];
    char bufferDescripcion[200];
    char bufferRut[20];
    char bufferEmail[80];
    char bufferTelefono[20];
    char bufferFecha[9];
    char bufferHorainicio[5];
    char bufferHoratermino[5];
    char bufferTipo[15];
    long int  bufferPrecioCosto;
    long int  bufferPrecioVenta;
    int  bufferCantidadInicial;
    int  bufferCantidadVendida;
    struct Vendedor *vendedor   = NULL;
    struct Turno    *turno      = NULL;
    struct Sector   *sector     = NULL;
    struct Producto *producto   = NULL;
    struct VentaProducto *ventaProducto= NULL;


    archivo = fopen("vendedores.txt", "r");
    if(archivo)
    {
        while(fscanf(archivo, "%[^\n]\n", bufferTipo)==1)
        {
            if(strcmp(bufferTipo, "VENDEDOR") == 0)
            {
                if(vendedor)
                {
                    if(turno)
                    {
                        enlazarTurno(vendedor->turnos, turno, vendedor->ultimoTurno);
                        vendedor->ultimoTurno++;
                        turno = NULL;
                    }
                    enlazarNodoVendedor(&(*cabeza), crearNodoVendedor(vendedor));
                }
                //Leo el Vendedor
                fscanf(archivo, "%[^|]|%[^|]|%[^|]|%[^\n]\n", bufferRut, bufferNombre, bufferTelefono, bufferEmail);
                vendedor = crearVendedor(bufferRut, bufferNombre, bufferTelefono, bufferEmail);
            }
            else if(strcmp(bufferTipo, "TURNO") == 0)
            {
                if(turno)
                {
                    enlazarTurno(vendedor->turnos, turno, vendedor->ultimoTurno);
                    vendedor->ultimoTurno++;
                }
                // Leo el Turno
                fscanf(archivo, "%[^|]|%[^|]|%[^\n]\n", bufferFecha, bufferHorainicio, bufferHoratermino);
                turno = crearTurno(bufferFecha, bufferHorainicio, bufferHoratermino);
            }
            else if(strcmp(bufferTipo, "SECTOR") == 0)
            {
                // Leo el sector
                fscanf(archivo, "%[^|]|%[^|]|%[^\n]\n", bufferNombre, bufferCodigo, bufferDescripcion);
                sector = crearSector(bufferNombre, bufferCodigo, bufferDescripcion);
                turno->sector = sector;
            }
            else if(strcmp(bufferTipo, "VENTAPRODUCTO") == 0)
            {
                // Leo la Venta Producto
                // Cantidad Inicial, Cantidad Vendida
                fscanf(archivo, "%d|%d\n", &bufferCantidadInicial, &bufferCantidadVendida);
                ventaProducto = crearVentaProducto(bufferCantidadInicial, bufferCantidadVendida);
            }
            else if(strcmp(bufferTipo, "PRODUCTO") == 0)
            {
                // Leo el producto
                fscanf(archivo, "%[^|]|%[^|]|%d|%d|%[^\n]\n", bufferNombre, bufferCodigo, &bufferPrecioCosto, &bufferPrecioVenta, bufferDescripcion);
                producto = crearProducto(bufferNombre, bufferCodigo, bufferPrecioCosto, bufferPrecioVenta, bufferDescripcion);
                ventaProducto->producto = producto;
                enlazarVentaProducto(&(turno->ventas), ventaProducto);
            }
        }

        if (vendedor)
        {
            if(turno)
            {
                enlazarTurno(vendedor->turnos, turno, vendedor->ultimoTurno);
                vendedor->ultimoTurno++;
            }
            enlazarNodoVendedor(&(*cabeza), crearNodoVendedor(vendedor));
        }

        fclose(archivo);
    }
    else
    {
        printf("No se puede abrir el archivo de Vendedores");
        exit(1);
    }
}

// Recibe como parámetros los valores para poder crear un Vendedor
// Retorna un Vendedor
struct Vendedor *crearVendedor(char *rut, char *nombre, char *telefono, char *email)
{
    struct Vendedor *vendedor=NULL;

    vendedor = (struct Vendedor *)malloc(sizeof(struct Vendedor));
    vendedor->rut = (char *)malloc(sizeof(char)*(strlen(rut) + 1));
    strcpy(vendedor->rut, rut);
    vendedor->nombre = (char *)malloc(sizeof(char)*(strlen(nombre) + 1));
    strcpy(vendedor->nombre, nombre);
    vendedor->telefono = (char *)malloc(sizeof(char)*(strlen(telefono) + 1));
    strcpy(vendedor->telefono, telefono);
    vendedor->email = (char *)malloc(sizeof(char)*(strlen(email) + 1));
    strcpy(vendedor->email, email);
    vendedor->ultimoTurno = 0;

    return vendedor;
}

// Recibe como parametro un Vendedor
// Retorna un NodoVendedor
struct NodoVendedor *crearNodoVendedor(struct Vendedor* vendedor)
{
    struct NodoVendedor *nodoVendedor = NULL;
    nodoVendedor = (struct NodoVendedor *)malloc(sizeof(struct NodoVendedor));
    nodoVendedor->vendedor = vendedor;
    nodoVendedor->siguiente = NULL;

    return nodoVendedor;
};

// Recibe un NodoVendedor, y una Cabeza de NodoVendedor
// Enlista el Nodo nuevo en la cabeza
void enlazarNodoVendedor(struct NodoVendedor **cabeza, struct NodoVendedor *nuevoNodo)
{
    struct NodoVendedor *auxiliar = *cabeza;
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

// Crea la interfaz de usuario para ingresar un vendedor
void agregarVendedor(struct NodoVendedor **cabeza)
{

    char bufferNombre[50];
    char bufferRut[20];
    char bufferTelefono[20];
    char bufferEmail[70];

    printf("\nIngresar Nombre: ");
    fflush(stdin);
    scanf("%60[^\n]", bufferNombre);
    do
    {
        printf("\rIngresar Rut (sin dv): ");
        fflush(stdin);
        scanf("%20[^\n]", bufferRut);
    }while(es_numero(bufferRut) == 0 || strlen(bufferRut) > 8);
    printf("Ingresar Telefono: ");
    fflush(stdin);
    scanf("%20[^\n]", bufferTelefono);
    printf("Ingresar Email: ");
    fflush(stdin);    
    scanf("%80[^\n]", bufferEmail);

    enlazarNodoVendedor(&(*cabeza), crearNodoVendedor(crearVendedor(bufferRut, bufferNombre, bufferTelefono, bufferEmail )));
}

// Recibe la cabeza de la lista NodVendedor y lo respalda en el archivo de texto
void guardarVendedores(struct NodoVendedor *cabeza){
    FILE *archivo;
    int i;
    struct Turno *turno  = NULL;
    struct VentaProducto *venta = NULL;
    archivo = fopen("vendedores.txt", "w");
    if(archivo)
    {
        while(cabeza)
        {
            fprintf(archivo, "VENDEDOR\n");
            fprintf(archivo, "%s|%s|%s|%s\n", cabeza->vendedor->rut, cabeza->vendedor->nombre, cabeza->vendedor->telefono, cabeza->vendedor->email);
            for(i = 0; i < cabeza->vendedor->ultimoTurno; i ++)
            {
                turno = cabeza->vendedor->turnos[i];
                fprintf(archivo, "TURNO\n");
                fprintf(archivo, "%s|%s|%s\n", turno->fecha, turno->horainicio, turno->horatermino);
                fprintf(archivo, "SECTOR\n");
                fprintf(archivo, "%s|%s|%s\n", turno->sector->nombre, turno->sector->codigo, turno->sector->descripcion);
                venta = turno->ventas;
                while(venta)
                {
                    fprintf(archivo, "VENTAPRODUCTO\n");
                    fprintf(archivo, "%d|%d\n", venta->cantidadInicial, venta->cantidadVendida);
                    fprintf(archivo, "PRODUCTO\n");
                    fprintf(archivo, "%s|%s|%d|%d|%s\n", venta->producto->nombre, venta->producto->codigo, venta->producto->precioCosto, venta->producto->precioVenta, venta->producto->descripcion);
                    venta = venta->siguiente;
                }
            }
            cabeza = cabeza->siguiente;
        }
        fclose(archivo);
    }
}

// Recorro la lista
void listarVendedores(struct NodoVendedor *cabeza)
{
    while(cabeza)
    {
        mostrarVendedor(cabeza->vendedor);
        cabeza = cabeza->siguiente;
    }
}

// Muestro un vendedor de tipo struct Vendedor
void mostrarVendedor(struct Vendedor *vendedor)
{
    printf("Nombre Vendedor\t\t: %s", vendedor->nombre);
    printf("\nRut Vendedor\t\t: %s", vendedor->rut);
    printf("\nEmail Vendedor\t\t: %s", vendedor->email);
    printf("\nTelefono Vendedor\t: %s", vendedor->telefono);
    printf("\n\n");
}

