//Tema3
var n_anhos,n_horasmes,retencion,salario_neto:numerico
	inicio
		cls()
		imprimir("Ingrese el numero de horas trabajadas en el mes y el numero de años del trabajador\n")
		leer(n_horasmes,n_anhos)
		salario_neto=SalarioTrabajador(n_horasmes,n_anhos)
			
		eval{
			caso(n_anhos>=20)
				imprimir("El salario es ",salario_neto," y la retencion es 4000")
			caso(n_anhos>=10)
				imprimir("El salario es ",salario_neto," y la retencion es 1500")
			sino
				imprimir("El salario es ",salario_neto," y la retencion es 2000")
			}
	

	fin

subrutina SalarioTrabajador(ref n_horasmes:numerico;ref n_anhos:numerico)retorna numerico	
	var salario:numerico
	inicio
		eval{
			caso(n_horasmes>=40&&n_anhos>=20)
				salario=n_horasmes*30000-4000
				

			caso(n_horasmes>=40&&n_anhos>=10)
				salario=n_horasmes*20000-1500
				

		sino 
		salario=10000*n_horasmes-2000
		
		}
	retorna salario

	
	fin