//Tema3
var nombre_apellido=""
inicio
	cls()
	imprimir("Ingrese el nombre y apellido\n")
	leer(nombre_apellido)
	nombre_apellido=inic_mayus(nombre_apellido)
	imprimir(nombre_apellido)
fin

subrutina inic_mayus(nombre_apellido:cadena)retorna cadena

	var i_mayus=nombre_apellido
	var n=1
	var b=0
	inicio
			mientras(n<=strlen(nombre_apellido)){
				b=ord(nombre_apellido[n])
				eval{
					caso(n==1&&nombre_apellido[n]>='a'&&nombre_apellido[n]<='z')
						
						i_mayus[n]=agrandar(nombre_apellido[n])
					caso(nombre_apellido[n]==' '&&(n+1)<strlen(nombre_apellido))
						i_mayus[n+1]=agrandar(nombre_apellido[n+1])
						n=n+1
					caso(n>1)
							i_mayus[n]=achicar(nombre_apellido[n])
							
						}
		
					n=n+1
				}

		retorna i_mayus
	fin



subrutina achicar(palabra:cadena)retorna cadena
	var r=1
	var minus=palabra
 	inicio
			mientras(r<=strlen(palabra)){

				 si(palabra[r]>='A'&&palabra[r]<='Z'){
					minus[r]=ascii(ord(palabra[r])+32)
				
					sino
					minus[r]=palabra[r]
					}
				
				r=r+1
				}
	retorna minus
	fin

subrutina agrandar(palabra:cadena)retorna cadena
	var r=1
	var mayus=palabra
 	inicio
			mientras(r<=strlen(palabra)){

				 si(palabra[r]>='a'&&palabra[r]<='z'){
					
				
					mayus[r]=ascii(ord(palabra[r])-32)
				
					sino
					mayus[r]=palabra[r]
					}
				
			
				r=r+1
				}
	retorna mayus
	fin