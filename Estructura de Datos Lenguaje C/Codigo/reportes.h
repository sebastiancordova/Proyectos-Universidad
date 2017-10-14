void menuReportes(struct NodoVendedor *, struct NodoSector *);
void mostrarVendedorMasVentas(struct NodoVendedor *);
void mostrarSectorConMasVentas(struct NodoVendedor *, struct NodoSector *);
int cantidadVentas(struct Turno **, int);
int cantidadVentasSector(struct Turno **, int , char*);

// Muestra el sector con más ventas
void mostrarSectorConMasVentas(struct NodoVendedor *vendedores, struct NodoSector *sectores){
    struct Vendedor *vendedor = NULL;
    struct NodoVendedor *auxVendedores = NULL;
    struct Sector *sectorConMasVentas = NULL, *sector = NULL;
    int ventasSector= 0, ventasSectorConMasVentas = -1;
	// Si no existen los vendedores
    if(!vendedores){
        printf("\n No hay vendedores registrados en el sistema");
        return;
    }
	// Si no existen los sectores
    if(!sectores){
        printf("\n No hay Sectores registrados en el sistema");
        return;
    }

    // Recorro los sectores
    while(sectores){
        sector = sectores->sector;
        // recorro los vendedores
        auxVendedores = vendedores;
        while(auxVendedores){
            vendedor = auxVendedores->vendedor;
			// Cuento la cantidad de ventas del sector que estoy visitando
            ventasSector += cantidadVentasSector(vendedor->turnos, vendedor->ultimoTurno, sector->codigo);
            auxVendedores = auxVendedores->siguiente;
        }
		// Si las ventas del sector que estoy visitando son mayores que la del sector con mayor ventas actual
		// Actualizo
        if(ventasSector > ventasSectorConMasVentas){
            sectorConMasVentas = sector;
            ventasSectorConMasVentas = ventasSector;
        }
        ventasSector = 0;
        sectores = sectores->siguiente;
    }

	// Imprimo el sector con más ventas
    printf("\nEL SECTOR CON MAS VENTAS ES: \n");
    printf("\n%s (CODIGO: %s)", sectorConMasVentas->nombre, sectorConMasVentas->codigo);
    printf("\nCON %d VENTAS", ventasSectorConMasVentas);
}

// Funcion que muestra el vendedor con más ventas
void mostrarVendedorConMasVentas(struct NodoVendedor *vendedores){
    struct Vendedor *vendedor = NULL, *vendedorConMasVentas = NULL;
    int ventasVendedor = 0, ventasVendedorConMasVentas = 0;

	// Si no hay vendedores
    if(!vendedores){
        printf("\n No hay vendedores registrados en el sistema");
        return;
    }
	// dejo al vendedor con más ventas al primer nodo en la lista
    vendedorConMasVentas = vendedores->vendedor;
	// Y la cantidad de ventas del primer vendedor
    ventasVendedorConMasVentas = cantidadVentas(vendedorConMasVentas->turnos, vendedorConMasVentas->ultimoTurno);
    // Mientras exista vendedor
	while(vendedores){
		// rescato e vendedor
        vendedor = vendedores->vendedor;
		// Cuento sus ventas
        ventasVendedor = cantidadVentas(vendedor->turnos, vendedor->ultimoTurno);
		// Si las ventas del vendedor actual son mayores que las del vendedor con mas ventas
		// actualizo
        if(ventasVendedor > ventasVendedorConMasVentas){
            vendedorConMasVentas = vendedor;
            ventasVendedorConMasVentas = ventasVendedor;
        }
        vendedores = vendedores->siguiente;
    }

	// Imprimo el vendedor con más ventas
    printf("\nEL VENDEDOR CON MAS VENTAS ES: \n");
    printf("\n%s (RUT: %s)", vendedorConMasVentas->nombre, vendedorConMasVentas->rut);
    printf("\nCON %d VENTAS REALIZADAS", ventasVendedorConMasVentas);
}

// Muestra el menú reportes
// Recibe como parámetros los vendedores y los sectores
void menuReportes(struct NodoVendedor * vendedores, struct NodoSector *sectores)
{
    char opcion[10];
    do{
        system("cls");
        imprimirCabecera();
        printf("[1] VENDEDOR CON MAS VENTAS\n");
        printf("[2] SECTOR CON MAS VENTAS\n");
        printf("[0] VOLVER\n");

        do
        {
            fflush(stdin);
            printf("\r\nINGRESE UNA OPCION: ");
            scanf("%10[^\n]", opcion);
        }while(strlen(opcion) > 1 || opcion[0] < '0' || opcion[0] > '2');

        if (opcion[0] == '1'){
            fflush(stdin);
            system("cls");
            imprimirCabecera();
            mostrarVendedorConMasVentas(vendedores);
            printf("\nPresione Enter para volver...");
            fflush(stdin);
            getchar();
        }else if (opcion[0] == '2'){
            fflush(stdin);
            system("cls");
            imprimirCabecera();
            mostrarSectorConMasVentas(vendedores, sectores);
            printf("\nPresione Enter para volver...");
            fflush(stdin);
            getchar();
        }
    }while(opcion[0] != '0');

}

// Dado un listado de turnos, un  código de sector
// Cuenta las ventas que se realizaron en ese sector
int cantidadVentasSector(struct Turno **turnos, int ultimoTurno, char *codigoSector){
    int cantidad = 0, i = 0;
    struct VentaProducto *venta = NULL;
	// REcorro la lista
    for(i = 0; i < ultimoTurno; i++){
		// Si es el sector
        if(strcmp(turnos[i]->sector->codigo, codigoSector) == 0){
			// Cuento
            venta = turnos[i]->ventas;
            while(venta){
                cantidad += venta->cantidadVendida;
                venta = venta->siguiente;
            }
        }
    }
    return cantidad;
}

// Dado un listado de turnos, cuenta la cantidad de ventas en dicho turno
int cantidadVentas(struct Turno **turnos, int ultimoTurno){
    int cantidad = 0, i = 0;
    struct VentaProducto *venta = NULL;
	// Recorro la lista
    for(i = 0; i < ultimoTurno; i++){
		// Visito la venta
        venta = turnos[i]->ventas;
        while(venta){
			// Contador de ventas
            cantidad += venta->cantidadVendida;
            venta = venta->siguiente;
        }
    }
    return cantidad;
}
