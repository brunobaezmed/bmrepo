programa uso_tipos
tipos
	ALUMNO : registro
				{
					nombre : cadena
					nota : numerico
				}
	ACTA : vector [*] ALUMNO
var
	A : ACTA
inicio
	cls()
	leer_acta (A)
	ordenar_por_nota (A)
	imprimir_acta (A)
fin

subrutina imprimir_acta (A : ACTA)
/*
Imprimir el nombre y la nota de cada alumno.
*/
var
	k : numerico
inicio
	desde k=1 hasta alen (A){
		imprimir ("\n", A [k].nombre, "\t", A [k].nota)
	}
fin

subrutina leer_acta (ref c : ACTA)
/*
Leer los nombres y notas de los alumnos.
Primero pide cantidad de alumnos e inicializa el vector de
acuerdo a esto.
Observar que c DEBE ser recibido por referencia, pues de
lo contrario los datos leidos se perderan al salir de la subrutina.
*/
var
	cant, k : numerico
inicio
	imprimir ("\nIngrese cantidad de alumnos: ")
	leer (cant)
	dim (c, cant)	imprimir ("\nA continuacion tipee nombre, nota para cada alumno\n")
	desde k=1 hasta cant{
		leer ( c [k].nombre, c [k].nota )
	}
fin

subrutina ordenar_por_nota (ref A : ACTA)
/*
Ordernar A, considerando las notas, de mayor a menor. El
algoritmo es el de la burbuja.
El parametro A DEBE ser recibido por referencia, pues de
lo contrario los datos leidos se perderan al salir de la subrutina.
Muestra el uso de asignacion entre registros (variable aux).
*/
var
	aux : ALUMNO
	k, n : numerico
	g : numerico // longitud de A
inicio
	g = alen (A)
	desde n=1 hasta (g - 1){
		desde k=n+1 hasta g{
			si ( A [n].nota < A [k].nota ){
				aux = A [n]
				A [n] = A [k]
				A [k] = aux
			}
		}
	}
fin