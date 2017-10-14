// Cantidad Maxima de turnos que se pueden ingrear por vendedor
#define MAX_CANTIDAD_TURNOS 365

// Estructura NodoProducto
struct NodoProducto
{
    struct Producto *producto;
    struct NodoProducto *siguiente;
};

// Estructura Producto
struct Producto
{
	// Nombre del Producto
    char *nombre;
	// Código del Producto
    char codigo[4];
	// Precio Costo
    int precioCosto;
	// Precio Venta
    int precioVenta;
	// Descripcion
    char *descripcion;
};

// Encapusla los sectores
struct NodoSector
{
    struct Sector *sector;
    struct NodoSector *siguiente;
};

// Estructura Sector
struct Sector
{
	// Codigo del Sector
    char codigo[4];
	// Nombre
    char *nombre;
	// Descripcion
    char *descripcion;
};

// Estructura VentaProducto
struct VentaProducto
{
	// Cantidad de productos que se le pasan al vendedor
    int cantidadInicial;
	// Cantidad de productos vendida
    int cantidadVendida;
	// Producto de esta venta
    struct Producto *producto;
	// Siguiente Venta
    struct VentaProducto *siguiente;
};
// Turno
struct Turno
{
    // Fecha ddmmyyyy
    char fecha[9];
    // Hora del inicio del turno hhmm
    char horainicio[5];
    // Hora del final del turno hhmm
    char horatermino[5];
    // Cabeza de la lista de ventas
    struct VentaProducto *ventas;
    // Sector donde se realizó el turno
    struct Sector *sector;
};

// Vendedor
struct Vendedor
{
	// Rut del Vendedor
    char *rut;
	// Nombre
    char *nombre;
	// Telefono
    char *telefono;
	// Email
    char *email;
	// Lista contigua de Turnos
    struct Turno *turnos[MAX_CANTIDAD_TURNOS];
	// Ultimo turno registrado para este vendedor
    int ultimoTurno;
};

// Nodo que encapsula un vendedor
struct NodoVendedor
{
    struct Vendedor *vendedor;
    struct NodoVendedor *siguiente;
};
