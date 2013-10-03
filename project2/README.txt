Nombre: Gauss-Jordan / Gauss-Seidel

Programadores:
Henkel Magnus_____________________ magnus.henkel@zoho.com
Trejo Juárez César Alberto________ cesaratj27@gmail.com

Descripción:

Para la eliminación de Gauss-Jordan, el programa utiliza el primer renglón como
pivote para poder obtener una constante, la cual multiplica al renglón pivote y
el resultado del producto se le resta a los valores de los renglones posteriores.
Después se hace algo similar pero ahora de abajo hacia arriba de la matriz.

En el métodoo de Gauss-Seidel, se despeja primero la variable x_1 del sistema, a
los otros se les asigna el valor 0. Se obtiene un valor (no muy preciso
todavía), para x_1 el cual se sustituye en los siguientes despejes de x_2, x_3
hasta x_5.
De esta manera se va obteniendo valores para cada variable que sirven para
obtener resultados para los que siguen. En cada paso se calcula el error y
dependiendo de la precisión que se requiere, se considera el sistema resuelta
cuando el error ya no es mayor que la tolerancia.

Programación Avanzada y Métodos
Numéricos
Profesor: Germán Santos Jaimes
UNIVERSIDAD NACIONAL AUTÓNOMA DE MÉXICO
FACULTAD DE INGENIERÍA
