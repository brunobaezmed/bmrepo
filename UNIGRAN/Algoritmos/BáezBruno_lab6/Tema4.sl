//Tema4
var palabra:cadena
var v:numerico
inicio
	cls()
	imprimir("Ingrese una palabra\n")
	leer(palabra)
	v=palindromo(palabra)
	si(v==1){
		imprimir("Es palindromo")
		sino
		imprimir("No es palindromo")
		}
fin

subrutina palindromo(ref palabra:cadena) retorna numerico
	var b=0
	var m=1
	var l=strlen(palabra)
	var palindromo=palabra
	inicio  //eyE   eye 
		palabra=lower(palabra)
		mientras(l>=1){
			palindromo[m]=palabra[l]
			
			m=m+1
			l=l-1

			}
		si(palindromo==palabra){
			b=1
				}
		
		retorna b
	fin