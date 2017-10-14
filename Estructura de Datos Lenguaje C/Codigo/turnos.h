void    menuTurnos(struct NodoVendedor **, struct NodoProducto **, struct NodoSector **);
struct  Turno *crearTurno(char *, char *, char *);
void enlazarTurno(struct Turno **, struct Turno*, int);
void menuListarTurnos(struct NodoVendedor *);
void menuTurno(struct NodoVendedor **);
void listarTurnos(struct Turno **, int );
void mostrarTurno(struct Turno *);
struct Vendedor * obtenerVendedor(struct NodoVendedor *, char *);
void menuAgregarTurno(struct NodoVendedor **, struct NodoProducto *, struct NodoSector *);
void menuEliminarTurno(struct NodoVendedor **);
void menuModificarTurno(struct NodoVendedor **, struct NodoProducto *, struct NodoSector*);
void modificarTurno(struct Turno **, char *, int , struct NodoProducto *, struct NodoSector *);
void eliminarTurno(struct Turno **, char *, int );
int existeTurno(struct Turno **, char *, int );
int existeVendedor(struct NodoVendedor *, char*);

// Recibe los parametros fecha, horainicio, y hora termino para crear un Turno y retornarlo
struct  Turno *crearTurno(char *fecha, char *horainicio, char *horatermino)
{
    struct Turno *turno = NULL;

    turno = (struct Turno *)malloc(sizeof(struct Turno));
    strcpy(turno->fecha, fecha);
    strcpy(turno->horainicio, horainicio);
    strcpy(turno->horatermino, horatermino);
    turno->ventas = NULL;
    turno->sector = NULL;
    return turno;
}

// Agrega un nuevo Turno a la lista contigua en la posicion que se pasa como parametro
void enlazarTurno(struct Turno **lista, struct Turno *nuevoNodo, int posicion)
{
    lista[posicion] = nuevoNodo;
}

// Muestra el menu de los turnos
void menuTurnos(struct NodoVendedor **vendedores, struct NodoProducto **productos, struct NodoSector **sectores)
{
    int opcion;
    do{
        system("cls");
        imprimirCabecera();
        printf("[1] LISTAR TURNOS POR VENDEDOR\n");
        printf("[2] AGREGAR TURNO\n");
        printf("[3] ELIMINAR TURNO\n");
        printf("[4] MODIFICAR TURNO\n");
        printf("[0] VOLVER\n");

        do
        {
            printf("\nINGRESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d", &opcion);
        }while(opcion < 0 || opcion > 4 || opcion != (int)opcion);

        switch(opcion)
        {
            case 1:
                system("cls");
                imprimirCabecera();
                menuListarTurnos(*vendedores);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 2:
                system("cls");
                imprimirCabecera();
                menuAgregarTurno(&(*vendedores), *productos, *sectores);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 3:
                system("cls");
                imprimirCabecera();
                menuEliminarTurno(&(*vendedores));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 4:
                system("cls");
                imprimirCabecera();
                menuModificarTurno(&(*vendedores), *productos, *sectores);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
        }
        
    }while(opcion != 0);
}

// Muestra el menu para agregar turno
void menuAgregarTurno(struct NodoVendedor **vendedores, struct NodoProducto *productos, struct NodoSector *sectores)
{
    // Buffers para leer los datos
    int opcion;
	char bufferRut[9];
    char bufferSector[4];
    char bufferFecha[9];
    char bufferHorainicio[5];
    char bufferHoratermino[5];
    int bufferCantidadInicial;
    int bufferCantidadVendida;
    char bufferCodigoProducto[4];
	// Estructuras que serviran para crear el nuevo turno
    struct NodoVendedor *aux = NULL;
    struct Vendedor *vendedor = NULL;
    struct Sector   *sector   = NULL;
    struct Producto *producto = NULL;
    struct VentaProducto *ventaProducto = NULL;
    struct Turno *turno = NULL;

    do
    {
        printf("\nIngrese rut del vendedor: ");
        fflush(stdin);
        scanf("%9[^\n]", bufferRut);
    }while(es_numero(bufferRut) != 1 || strlen(bufferRut) > 8);
    // Si es que no existe el vendedor
    if(existeVendedor(*vendedores, bufferRut) == 0)
    {
        printf("No existe vendedor\n");
        return;
    }
    // Rescato el vendedor
    aux = *vendedores;
	// REcorro la lista
    while(aux)
    {
        if(strcmp(aux->vendedor->rut, bufferRut) == 0)
        {
            vendedor = aux->vendedor;
        }
        aux = aux->siguiente;
    }
    aux = NULL;
    
    do
    {
        printf("Ingrese codigo del sector: ");
        fflush(stdin);
        scanf("%4[^\n]", bufferSector);
    }while(strlen(bufferSector) != 3);

    //Obtengo es sector
    sector = obtenerSector(sectores, bufferSector);

    //Si es que existe el sector
    if(!sector)
    {
        printf("No existe sector\n");
        return;
    }

    do
    {
        printf("Ingrese fecha del turno: ");
        fflush(stdin);
        scanf("%9[^\n]", bufferFecha);
    }while(es_numero(bufferFecha) != 1 || strlen(bufferFecha) > 8);
    
    do
    {
        printf("Ingrese hora inicio del turno: ");
        fflush(stdin);
        scanf("%5[^\n]", bufferHorainicio);
    }while(es_numero(bufferHorainicio) != 1 || strlen(bufferHorainicio) > 4);

    do
    {
        printf("Ingrese hora termino del turno: ");
        fflush(stdin); 
        scanf("%5[^\n]", bufferHoratermino);
    }while(es_numero(bufferHoratermino) != 1 || strlen(bufferHoratermino) > 4);
    
	// Creo el turno
    turno = crearTurno(bufferFecha, bufferHorainicio, bufferHoratermino);
	// le asigno el sector
    turno->sector = sector;

    printf("\nINGRESAR VENTAS DE LOS PRODUCTOS\n");
    do
    {
        //Se da la posibilidad de ver los productos para sacar su codigo
        do
        {
            printf("\n[1] INGRESAR CODIGO DEL PRODUCTO QUE SE VENDIO");
            printf("\n[2] MOSTRAR PRODUCTOS");
            printf("\n\nINGRESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d",&opcion);
            if(opcion == 2)
            {
                system("cls");
                imprimirCabecera();
                listarProductos(productos);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
            }
        }while(opcion != 1);
        do
        {
            printf("\nIngrese codigo del producto: ");
            fflush(stdin);
            scanf("%4[^\n]", bufferCodigoProducto);
        }while(strlen(bufferCodigoProducto) != 3);
        
        // Obtengo el producto a partir de su codigo
        producto = obtenerProducto(productos, bufferCodigoProducto);

        if(!producto)
        {
            printf("No existe producto\n");
            return;
        }
        do
        {
            printf("Ingrese la cantidad de productos que fueron entregados al vendedor: ");
            fflush(stdin);
            scanf("%d", &bufferCantidadInicial);
        }while(bufferCantidadInicial != (int)bufferCantidadInicial);
        do
        {
            printf("Ingrese la cantidad de productos vendidos: ");
            fflush(stdin);
            scanf("%d", &bufferCantidadVendida);
        }while(bufferCantidadVendida != (int)bufferCantidadVendida);

		// Creo la venta de producto
        ventaProducto = crearVentaProducto(bufferCantidadInicial, bufferCantidadVendida);
        ventaProducto->producto = producto;
        enlazarVentaProducto(&(turno->ventas), ventaProducto);
		// Mientras diga que si, se agregara otra venta de productos
        do
        {
            printf("\nDESEA AGREGAR OTRA VENTA? \n[1] Si\n[2] No\n\nINRGESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d", &opcion);
        }while(opcion != 1 && opcion != 2 || opcion != (int)opcion);
    }while(opcion == 1);
	// Se agrega el turno
    vendedor->turnos[vendedor->ultimoTurno] = turno;
	// se aumenta la cantida de turnos
    vendedor->ultimoTurno++;
    vendedor = NULL;
}

// Menu que lista los turnos
void menuListarTurnos(struct NodoVendedor *cabeza)
{
    char bufferRut[9];
    struct Vendedor *vendedor = NULL;

    printf("Ingresar el rut del vendedor: ");
    fflush(stdin);
    scanf("%9[^\n]", bufferRut);
	// Pide el rut del vendedor que desea mostrar turnos y valida su existencia
    if(existeVendedor(cabeza, bufferRut) == 1)
    {
        vendedor = obtenerVendedor(cabeza, bufferRut);
        printf("\nSe encontraron %d Turnos para este vendedor\n", vendedor->ultimoTurno);
		// Llama a la funcion que lista los turnos
        listarTurnos(vendedor->turnos, vendedor->ultimoTurno);
    }else
    {
        printf("No existe vendedor\n");
    }
}

// Menu para eliminar un turno
void menuEliminarTurno(struct NodoVendedor **vendedores){
    char bufferRut[9];
    char bufferFecha[9];
    struct Vendedor *vendedor = NULL;
    struct NodoVendedor *aux = NULL;

    do
    {
        printf("Ingresar el rut del vendedor: ");
        fflush(stdin);
        scanf("%9[^\n]", bufferRut);
    }while(es_numero(bufferRut) != 1 || strlen(bufferRut) > 8);

	// Valida que exista el vendedor
    if(existeVendedor(*vendedores, bufferRut) == 1)
    {
        aux = *vendedores;
		// REcorro para encontrar la referencia al vendedor
        while(aux)
        {
            if(strcmp(aux->vendedor->rut, bufferRut) == 0)
            {
                vendedor = aux->vendedor;
            }
            aux = aux->siguiente;
        }
        aux = NULL;
		// Pido la fecha del turno a eliminar
        do
        {
            printf("Ingresar fecha del turno del vendedor (ddmmyyyy): ");
            fflush(stdin);
            scanf("%9[^\n]", bufferFecha);
        }while(es_numero(bufferFecha) != 1 || strlen(bufferFecha) > 8);

        if (existeTurno(vendedor->turnos, bufferFecha, vendedor->ultimoTurno) == 0)
        {
            eliminarTurno(vendedor->turnos, bufferFecha, vendedor->ultimoTurno);
            vendedor->ultimoTurno--;
            vendedor = NULL;
        }
        else
        {
            printf("No existe turno\n");
        }
    }
    else
    {
        printf("No existe vendedor\n");
    }
}

// Retorna 1 si no existe un turno dada una fecha
// Retorna 0 si existe
int existeTurno(struct Turno **turnos, char *fecha, int ultimoTurno)
{
    int i;
    for(i = 0; i < ultimoTurno; i++)
    {
        if(strcmp(turnos[i]->fecha, fecha) == 0)
        {
            return 0;
        }
    }
    return 1;
}

// Dado una lista de turnos, una fecha y el ultimo turno ingresado
// Elimina el turno del día en la lista
void eliminarTurno(struct Turno **turnos, char *fecha, int ultimoTurno)
{
    int i, j;
	// Recorro la lista
    for(i = 0; i < ultimoTurno; i++)
    {
		// Si es que es el turno de la fecha que se desea eliminar
        if(strcmp(turnos[i]->fecha, fecha) == 0)
        {
            free(&turnos[i]);
			// Si el turno no es el último
            if(i + 1 < ultimoTurno)
            {
				// Corro a la izquierda todos los elementos
                for(j = i; j < ultimoTurno; j++)
                {
                    turnos[j] = turnos[j+1];
                }
            }
            printf("\nTurno Eliminado\n");
            return;
        }
    }
}

void menuModificarTurno(struct NodoVendedor **vendedores, struct NodoProducto *productos, struct NodoSector *sectores)
{
    char bufferFecha[9];
    char bufferRut[9];
    struct Vendedor *vendedor = NULL;
    struct NodoVendedor *aux = NULL;

    do
    {
        printf("\nIngrese rut del vendedor (sin dv): ");
        fflush(stdin);
        scanf("%9[^\n]",bufferRut);
    }while(es_numero(bufferRut) != 1 || strlen(bufferRut) > 8);

    if(existeVendedor(*vendedores, bufferRut) == 1)
    {
        aux = *vendedores;
        // Recorro para encontrar la referencia al vendedor
        while(aux)
        {
            if(strcmp(aux->vendedor->rut, bufferRut) == 0)
            {
                vendedor = aux->vendedor;
            }
            aux = aux->siguiente;
        }

        // Pido la fecha del turno a modificar
        do
        {
            printf("Ingresar fecha del turno que quiere modificar (ddmmyyyy): ");
            fflush(stdin);
            scanf("%9[^\n]", bufferFecha);
        }while(es_numero(bufferFecha) != 1 || strlen(bufferFecha) > 8);

        //Si es que existe el turno, lo modifico
        if (existeTurno(vendedor->turnos, bufferFecha, vendedor->ultimoTurno) == 0)
        {
            modificarTurno(vendedor->turnos, bufferFecha, vendedor->ultimoTurno, productos, sectores);
        }
        else
        {
            printf("No existe turno\n");
        }
    }
    else
    {
        printf("No existe vendedor\n");
    }
}

void modificarTurno(struct Turno **turnos, char *fecha, int ultimoTurno, struct NodoProducto *productos, struct NodoSector *sectores )
{
    int i,opcion;
    char bufferFecha[9];
    char bufferHorainicio[5];
    char bufferHoratermino [5];
    char bufferSector[4];
    char bufferCodigoProducto[4];    
    int bufferCantidadInicial;
    int bufferCantidadVendida;

    for(i = 0; i < ultimoTurno; i++)
    {
        if(strcmp(turnos[i]->fecha, fecha) == 0)
        {
            printf("\nINGRESE EL NUEVO VALOR PARA CADA CAMPO\n");
            do
            {
                do
                {
                    printf("Ingrese codigo del sector (%s) ",turnos[i]->sector->codigo);
                    fflush(stdin);
                    scanf("%4[^\n]", bufferSector);
                }while(strlen(bufferSector) != 3);

                if(!obtenerSector(sectores,bufferSector))
                {
                    printf("\nNo existe sector\n");
                }
            }while(!obtenerSector(sectores,bufferSector));
            do
            {
                printf("\nIngrese Fecha del Turno (%s): ",turnos[i]->fecha);
                fflush(stdin);
                scanf("%9[^\n]", bufferFecha);
            }while(es_numero(bufferFecha) != 1 || strlen(bufferFecha) > 8);

            do
            {
                printf("Ingrese hora inicio del turno (%s): ", turnos[i]->horainicio);
                fflush(stdin);
                scanf("%5[^\n]", bufferHorainicio);
            }while(es_numero(bufferHorainicio) != 1 || strlen(bufferHorainicio) > 4);

            do
            {
                printf("Ingrese hora termino del turno (%s): ", turnos[i]->horatermino);
                fflush(stdin); 
                scanf("%5[^\n]", bufferHoratermino);
            }while(es_numero(bufferHoratermino) != 1 || strlen(bufferHoratermino) > 4);

            printf("\nINGRESAR VENTAS DE LOS PRODUCTOS\n");
            //Repito el ingreso del producto hasta que ingrese un producto valido
            //Se da la posibilidad de ver los productos para sacar su codigo
            do
            {
                do
                {
                    printf("\n[1] INGRESAR CODIGO DEL PRODUCTO QUE SE VENDIO");
                    printf("\n[2] MOSTRAR PRODUCTOS");
                    printf("\n\nINGRESE UNA OPCION: ");
                    fflush(stdin);
                    scanf("%d",&opcion);
                    if(opcion == 2)
                    {
                        system("cls");
                        imprimirCabecera();
                        listarProductos(productos);
                        printf("\nPresione Enter para volver...");
                        fflush(stdin);
                        getchar();
                    }
                }while(opcion != 1);
                do
                {
                    printf("\nIngrese codigo del producto (%s): ", turnos[i]->ventas->producto->codigo);
                    fflush(stdin);
                    scanf("%4[^\n]", bufferCodigoProducto);
                }while(strlen(bufferCodigoProducto) != 3);  

                if(!obtenerProducto(productos, bufferCodigoProducto))
                {
                    printf("No existe producto\n");
                }
            }while(!obtenerProducto(productos, bufferCodigoProducto));    
            do
            {
                printf("Ingrese la cantidad de productos que fueron entregados al vendedor (%d): ",turnos[i]->ventas->cantidadInicial);
                fflush(stdin);
                scanf("%d", &bufferCantidadInicial);
            }while(bufferCantidadInicial != (int)bufferCantidadInicial);
            do
            {
                printf("Ingrese la cantidad de productos vendidos (%d): ", turnos[i]->ventas->cantidadVendida);
                fflush(stdin);
                scanf("%d", &bufferCantidadVendida);
            }while(bufferCantidadVendida != (int)bufferCantidadVendida);

            strcpy(turnos[i]->sector->codigo,bufferSector);
            strcpy(turnos[i]->fecha,bufferFecha);
            strcpy(turnos[i]->horainicio,bufferHorainicio);
            strcpy(turnos[i]->horatermino,bufferHoratermino);
            strcpy(turnos[i]->ventas->producto->codigo,bufferCodigoProducto);
            turnos[i]->ventas->cantidadInicial = bufferCantidadInicial;
            turnos[i]->ventas->cantidadVendida = bufferCantidadVendida;

        }
    }
}

// Listo los turnos de una lista
void listarTurnos(struct Turno **lista, int posicion)
{
    int i;
	// Muestro cada uno de los turnos
    for(i = 0; i < posicion; i++)
    {
        printf("\n[TURNO %d]\n",i+1);
        mostrarTurno(lista[i]);
    }
}

// Mostrar turno
void mostrarTurno(struct Turno *turno){
    printf("\nSector\t\t: %s" , turno->sector->nombre);
    printf("\nFecha\t\t: %s"        , turno->fecha);
    printf("\nHora Inicio\t: %s"  , turno->horainicio);
    printf("\nHora Termino\t: %s" , turno->horatermino);
	// Muestro las ventas de un producto
    mostrarVentasProducto(turno->ventas);
    printf("\n");
}
