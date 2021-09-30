//Ejercitario Tema1
var N_ing,sum,prom:numerico
var bandera:logico
inicio
		cls()
		inf(N_ing,sum,prom,bandera)

fin

subrutina inf(ref N_ing:numerico;ref sum:numerico;ref prom:numerico;ref bandera:logico)
	var n_ingresados=0
	inicio
				bandera=TRUE
		mientras(bandera==TRUE){
					imprimir("Ingrese un numero 0 para finalizar el programa\n")
					leer(N_ing)
				//	cls()
					si(N_ing==0){
						bandera=FALSE

					sino
						n_ingresados=n_ingresados+1
						sum=sum+N_ing
						
						}
				
		}
	  imprimir("N ingresados= ",n_ingresados," suma total= ",sum ," promedio= ",sum/n_ingresados)
	fin