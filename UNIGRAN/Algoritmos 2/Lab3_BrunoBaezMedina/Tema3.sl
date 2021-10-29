//Tema3
tipos alumno: registro{
	nombre,apellido: cadena
	nro_documento : numerico
	notaPrimerParcial: numerico
	notaSegundoParcial: numerico
  
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
	inicio
		dim(acta,3)
		mientras(q<=3){

		 imprimir("Ingrese el nombre,apellido y el nro_documento\n")
		 leer(acta[q].nombre,acta[q].apellido,acta[q].nro_documento)
			
		 imprimir("Ingrese la nota del Primer y Segundo Parcial \n")
		 leer(acta[q].notaPrimerParcial,acta[q].notaSegundoParcial)

			q = q+1
		}


	fin

subrutina imprimiralumnos(ref acta: ACTA)
	var i = 0

	inicio
		  desde i=1 hasta 3{
			imprimir(acta[i].nombre," ",acta[i].apellido)
			imprimir(" CI: ",acta[i].nro_documento," ")
			imprimir("Nota PrimerParcial ",acta[i].notaPrimerParcial)
			imprimir(" Nota SegundoParcial ",acta[i].notaSegundoParcial,"\n")  
	  
		  }
	fin


