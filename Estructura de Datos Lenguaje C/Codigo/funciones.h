// Valida que la entrada guardada en un string sea un numero
// Retorna 1 si es válido, 0 si no lo es
int es_numero(char *numero)
{
    int i;

    for(i = 0; i < strlen(numero); i++)
    {
        if(numero[i] < '0' || numero[i] > '9')
        {
            return 0;
        }
    }

    return 1;
}
