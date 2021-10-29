//Tema4
tipos alumno: registro{
	nombre,apellido: cadena
	nro_documento : numerico
	notaPrimerParcial: numerico
	notaSegundoParcial: numerico
	notaExamenFinal: numerico
	calificacion: numerico
	trabajo_prac:numerico
	
	}
	ACTA : vector [*]	alumno
var A : ACTA	
inicio
	
	cls()
	leeralumnos(A)
	imprimiralumnos(A)
	

fin
subrutina leeralumnos(ref acta :ACTA)
var n =0
var q = 1
var calif = 0
inicio
	dim(acta,10)
	mientras(q<=10){

		imprimir("Ingrese el nombre,apellido y el nro_documento\n")
		leer(acta[q].nombre,acta[q].apellido,acta[q].nro_documento)
		
		imprimir("Ingrese la nota del Primer y Segundo Parcial y del Trabajo Practico\n")
		leer(acta[q].notaPrimerParcial,acta[q].notaSegundoParcial,acta[q].trabajo_prac)

		imprimir("Ingrese la nota del Examen Final\n")
		leer(acta[q].notaExamenFinal)
		
		calif = acta[q].notaPrimerParcial+acta[q].notaSegundoParcial+acta[q].trabajo_prac
		
		si(calif<30){
		
		acta[q].calificacion = 1
		sino
			calif = 0
			calif = acta[q].notaPrimerParcial+acta[q].notaSegundoParcial+acta[q].notaExamenFinal+acta[q].trabajo_prac
			
			eval{
			 caso(calif >= 0 && calif <=69)
						acta[q].calificacion = 1
				  caso(calif >= 70 && calif <=77)
						acta[q].calificacion = 2

				  caso(calif >= 78 && calif <=85)
						acta[q].calificacion = 3
           
				  caso(calif >= 86 && calif <=93)
						acta[q].calificacion = 4
          
				 caso(calif >= 94 && calif <=100)
						acta[q].calificacion = 5
						}
				
			}
				calif = 0
				q = q+1
		}

fin

subrutina imprimiralumnos(ref acta: ACTA)
var i = 0

inicio
	  desde i=1 hasta 10{
		imprimir(acta[i].nombre," ",acta[i].apellido)
		imprimir(" CI: ",acta[i].nro_documento," ")
	  	imprimir("Nota PrimerParcial ",acta[i].notaPrimerParcial)
		imprimir(" Nota SegundoParcial ",acta[i].notaSegundoParcial,"\n")  
		imprimir(" Trab_practico ",acta[i].trabajo_prac,"\n")  
		imprimir(" Nota ex final ",acta[i].notaExamenFinal,"\n")  
		imprimir(" Calificacion ",acta[i].calificacion,"\n")  
	  }
fin