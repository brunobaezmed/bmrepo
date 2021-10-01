//Tema3 


inicio
	cls()
	imprimir(acumuladorM())
	

fin	

subrutina acumuladorM()retorna cadena
	var list1="123456789123456"
	var list2="123456789123456"
	var n1=15
	var n2=15
	var n=1
	var value:cadena
inicio
	mientras(n<=n1){
		imprimir("Inserte el valor n",n," de la lista 1")
		leer(value)
		list1[n]=value
		n=n+1
		}
	n=1
		mientras(n<=n2){
		imprimir("Inserte el valor n",n," de la lista 2")
		leer(value)
		list2[n]=value
		n=n+1
		}
	eval{
		caso(list1>list2)
			value="Lista 1 mayor"
		caso(list1<list2)
			value="Lista 2 mayor"
		caso(list1==list2)
			value="Listas iguales"
	

	}
	imprimir(list1,"\n",list2)


	retorna value
fin