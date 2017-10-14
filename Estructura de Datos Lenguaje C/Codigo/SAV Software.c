#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "funciones.h"
#include "interfaz.h"
#include "estructuras.h"
#include "productos.h"
#include "sectores.h"
#include "ventaproductos.h"
#include "turnos.h"
#include "vendedores.h"
#include "reportes.h"

int main()
{
    int opcion;
    struct NodoProducto *productos = NULL;
    struct NodoSector *sectores = NULL;
    struct NodoVendedor *vendedores = NULL;

	// Cargo desde un archivo de texto todos los productos
    cargarProductos(&productos);
	// Cargo desde un archivo de texto todos los sectores
    cargarSectores(&sectores);
	// Cargo desde un archivo de texto todos los vendedores
    cargarVendedores(&vendedores);
    do
    {
        system("cls");
        imprimirCabecera();
        printf("[1] VENDEDORES\n");
        printf("[2] TURNOS\n");
        printf("[3] PRODUCTOS\n");
        printf("[4] SECTORES\n");
        printf("[5] REPORTES\n");
        printf("[0] SALIR\n");
		// Ingresa una opcion el usuario
        do
        {
            printf("\nINGRESE UNA OPCION: ");
            fflush(stdin);
            scanf("%d", &opcion);
        }while(opcion < 0 || opcion > 5 || opcion != (int)opcion);

        // Debpendiendo el valor que ingresa, muestro el submenu corrspondiente
        switch(opcion)
        {
            case 1:
                menuVendedores(&vendedores);
                break;
            case 2:
                menuTurnos(&vendedores, &productos, &sectores);
                break;
            case 3:
                menuProductos(&productos);
                break;
            case 4:
                menuSectores(&sectores);
                break;
            case 5:
                menuReportes(vendedores, sectores);
                break;
        }
    }while(opcion != 0);
	// Respaldo en el archivo de texto los productos
    guardarProductos(productos);
	// Respaldo en el archivo de texto los sectores
    guardarSectores(sectores);
	// Respaldo en el archivo de texto los vendedores
    guardarVendedores(vendedores);

    return 0;
}
