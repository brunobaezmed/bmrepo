
//Tema1
var r,a,b:numerico
	inicio
	cls()
   imprimir("Ingrese dos numeros enteros\n")
	leer(a,b)
	r=esMultiplo(a,b)
	eval{
		
		caso(r==0) imprimir("Ninguno es multiplo de otro")
		caso(r==1) imprimir(a," es multiplo de ",b)
		caso(r==2) imprimir(b," es multiplo de ",a)
		
	
		}


	fin

subrutina esMultiplo(ref a:numerico;ref b:numerico)retorna numerico	
	var q:numerico
	inicio
   
	si((a<>0&&b<>0)&&(a%b==0 || b%a==0 )){
	  eval{
		  caso(a%b==0) q=1
		  caso(b%a==0) q=2

		}	

	
	sino
	q=0
		}


   retorna q
	fin



