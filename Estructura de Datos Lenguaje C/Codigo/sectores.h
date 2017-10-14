void    cargarSectores(struct NodoSector **);
struct  Sector *crearSector(char *, char *, char *);
struct  NodoSector *crearNodoSector(struct Sector *);
void    enlazarNodoSector(struct NodoSector **, struct NodoSector*);
void    agregarSector(struct NodoSector **);
void    guardarSectores(struct NodoSector *);
void    listarSectores(struct NodoSector *);
void    mostrarSector(struct Sector *);
void    menuSectores(struct NodoSector **);
int     existeSector(struct NodoSector *, char*);
void    menuEliminarSector(struct NodoSector **);
void    menuModificarSector(struct NodoSector **);
void    eliminarSector(struct NodoSector **, char*);
struct Sector * obtenerSector(struct NodoSector *, char *);

// Dado un código de sector, retorna el nodo del sector que posea ese codigo
struct Sector * obtenerSector(struct NodoSector *cabeza, char *codigo)
{
    struct NodoSector *aux = cabeza;
    while(aux)
    {
        if(strcmp(aux->sector->codigo, codigo) == 0)
        {
            return aux->sector;
        }
        aux = aux->siguiente;
    }
    return NULL;
}

// Crea la interfaz de usuario para eliminar un sector
void menuModificarSector(struct NodoSector **cabeza){

    char buscarCodigo[4];
    char bufferNombre[60];
    char bufferCodigo[4];
    char bufferDescripcion[200];
    struct NodoSector *aux = NULL;
    do
    {
        printf("\nIngresar Codigo (3 caracteres): ");
        fflush(stdin);
        scanf("%4[^\n]", buscarCodigo);
    }while(strlen(buscarCodigo) != 3);
    if(existeSector(*cabeza, buscarCodigo) == 0)
    {
        printf("\nNo existe sector");
    }
    else
    {
        printf("\nIngrese el nuevo valor para cada campo");
        aux = *cabeza;
        while(aux)
        {
            if(strcmp(aux->sector->codigo, buscarCodigo) == 0)
            {
                printf("\nIngresar Nombre (%s): ", aux->sector->nombre);
                fflush(stdin);
                scanf("%60[^\n]", bufferNombre);
                do
                {
                    printf("\nIngresar Codigo (%s) (3 caracteres): ", aux->sector->codigo);
                    fflush(stdin);
                    scanf("%4[^\n]", bufferCodigo);
                }while(strlen(bufferCodigo) != 3 || (existeSector(*cabeza, bufferCodigo) && strcmp(bufferCodigo, aux->sector->codigo) != 0));
                printf("Ingresar Descripcion (%s): ", aux->sector->descripcion);
                fflush(stdin);
                scanf("%200[^\n]", bufferDescripcion);

                free(aux->sector);
                aux->sector = crearSector(bufferNombre, bufferCodigo, bufferDescripcion);
                return;
            }
            aux = aux->siguiente;
        }

    }
}

// Crea la interfaz de usuario para eliminar un sector
void menuEliminarSector(struct NodoSector **cabeza)
{
    char bufferCodigo[4];
    do
    {
        printf("\nIngresar Codigo (3 caracteres): ");
        fflush(stdin);
        scanf("%4[^\n]", bufferCodigo);
    }while(strlen(bufferCodigo) != 3);
    if(existeSector(*cabeza, bufferCodigo) == 1)
    {
        eliminarSector(&(*cabeza), bufferCodigo);
        printf("\nSe ha eliminado el sector");
    }
    else
    {
        printf("\nNo existe sector");
    }
}


// Retorna 1 si se encuentra el sector y 0 si no se encuentra el sector
int existeSector(struct NodoSector *cabeza, char* codigo)
{
    while(cabeza)
    {
        if(strcmp(cabeza->sector->codigo, codigo) == 0)
        {
            return 1;
        }
        cabeza = cabeza->siguiente;
    }
    return 0;
}

// Elimina el sector desde la lista sectores
void eliminarSector(struct NodoSector **cabeza, char *codigo)
{
    struct NodoSector *actual = NULL, *anterior = NULL;

    // Si es que no existe la cabeza
    if(!*cabeza)
        return;

    // Si es que estoy eliminando la cabeza
    if(strcmp((*cabeza)->sector->codigo, codigo) == 0)
    {
        actual = *cabeza;
        *cabeza = actual->siguiente;
        actual->siguiente = NULL;
        free(actual->sector);
        free(actual);
    }
    else  // Si es que no es la cabeza
    {
        actual = (*cabeza)->siguiente;
        anterior = *cabeza;
        while(actual)
        {
            if(strcmp(actual->sector->codigo, codigo) == 0)
            {
                anterior->siguiente = actual->siguiente;
                actual->siguiente = NULL;
                free(actual->sector);
                free(actual);
                return;
            }
            anterior = actual;
            actual = actual->siguiente;
        }
    }
}

// Muestra el menu de los sectores
void    menuSectores(struct NodoSector **cabeza)
{
    int opcion;
    do
    {
        system("cls");
        imprimirCabecera();
        printf("[1] LISTAR SECTORES\n");
        printf("[2] AGREGAR SECTOR\n");
        printf("[3] ELIMINAR SECTORES\n");
        printf("[4] MODIFICAR SECTOR\n");
        printf("[0] VOLVER\n");

        do
        {
            printf("\r\nINGRESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d", &opcion);
        }while(opcion < 0 || opcion > 5 || opcion != (int)opcion);

        switch(opcion)
        {
            case 1:
                system("cls");
                imprimirCabecera();
                listarSectores(*cabeza);
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 2:
                system("cls");
                imprimirCabecera();
                agregarSector(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 3:
                system("cls");
                imprimirCabecera();
                menuEliminarSector(&(*cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
            case 4:
                system("cls");
                imprimirCabecera();
                menuModificarSector(&*(cabeza));
                printf("\nPresione Enter para volver...");
                fflush(stdin);
                getchar();
                break;
        }
    }while(opcion != 0);
}

// Desde un archivo de texto, lee los datos de los sectores que han sido ingresados previamente al sistema
// Creando una nueva lista, la cual será enlistada en la variable cabeza que recibe como parámetro
void cargarSectores(struct NodoSector **cabeza)
{
    FILE *archivo;

    char bufferNombre[60];
    char bufferCodigo[4];
    char bufferDescripcion[200];
    archivo = fopen("sectores.txt", "r");
    if(archivo)
    {
        while(fscanf(archivo, "%[^|]|%[^|]|%[^\n]\n", bufferNombre, bufferCodigo, bufferDescripcion)==3)
        {
            enlazarNodoSector(&(*cabeza), crearNodoSector(crearSector(bufferNombre, bufferCodigo, bufferDescripcion )));
        }
        fclose(archivo);
    }else
    {
        printf("No se puede abrir el archivo de Sectores");
        exit(1);
    }
}

// Recibe como parámetros los valores para poder crear un Sector
// Retorna un Sector
struct Sector *crearSector(char *nombre, char *codigo, char *descripcion)
{
    struct Sector *sector=NULL;

    sector = (struct Sector *)malloc(sizeof(struct Sector));

    strcpy(sector->codigo, codigo);
    sector->nombre = (char *)malloc(sizeof(char)*strlen(nombre));
    strcpy(sector->nombre, nombre);
    sector->descripcion = (char *)malloc(sizeof(char)*strlen(descripcion));
    strcpy(sector->descripcion, descripcion);

    return sector;
}

// Recibe como parametro un Sector
// Retorna un NodoSector
struct NodoSector *crearNodoSector(struct Sector* sector)
{
    struct NodoSector *nodoSector=NULL;
    nodoSector = (struct NodoSector *)malloc(sizeof(struct NodoSector));
    nodoSector->sector = sector;
    nodoSector->siguiente = NULL;
    return nodoSector;
};

// Recibe un NodoSector, y una Cabeza de NodoSector
// Enlista el Nodo nuevo en la cabeza
void enlazarNodoSector(struct NodoSector **cabeza, struct NodoSector *nuevoNodo)
{
    struct NodoSector *auxiliar = *cabeza;
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

// Crea la interfaz de usuario para ingresar un sector
void agregarSector(struct NodoSector **cabeza)
{

    char bufferNombre[60];
    char bufferCodigo[4];
    char bufferDescripcion[200];

    printf("\nIngresar Nombre: ");
    fflush(stdin);
    scanf("%60[^\n]", bufferNombre);
    do
    {
        printf("\nIngresar Codigo (3 caracteres): ");
        fflush(stdin);
        scanf("%4[^\n]", bufferCodigo);
    }while(strlen(bufferCodigo) != 3 || existeSector(*cabeza, bufferCodigo) == 1);
    printf("Ingresar Descripcion: ");
    fflush(stdin);
    scanf("%200[^\n]", bufferDescripcion);

    enlazarNodoSector(&(*cabeza), crearNodoSector(crearSector(bufferNombre, bufferCodigo, bufferDescripcion )));
}

// Recibe la cabeza de la lista NodSector y lo respalda en el archivo de texto
void guardarSectores(struct NodoSector *cabeza)
{
    FILE *archivo;
    archivo = fopen("sectores.txt", "w");
    if(archivo)
    {
        while(cabeza)
        {
            fprintf(archivo, "%s|%s|%s\n", cabeza->sector->nombre, cabeza->sector->codigo, cabeza->sector->descripcion);
            cabeza = cabeza->siguiente;
        }
        fclose(archivo);
    }
}

// Recorro la lista
void listarSectores(struct NodoSector *cabeza)
{
    while(cabeza)
    {
        mostrarSector(cabeza->sector);
        cabeza = cabeza->siguiente;
    }
}

// Muestro un sector de tipo struct Sector
void mostrarSector(struct Sector *sector)
{
    printf("Nombre Sector\t\t: %s"      , sector->nombre);
    printf("\nCodigo Sector\t\t: %s"      , sector->codigo);
    printf("\nDescripcion Sector\t: %s"   , sector->descripcion);
    printf("\n\n");
}

