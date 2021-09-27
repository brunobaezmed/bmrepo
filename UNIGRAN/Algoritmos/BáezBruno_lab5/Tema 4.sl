//Tema4
var x,y,q:numerico
	inicio
		cls()
		imprimir("Ingrese las coordenadas x e y\n")
		leer(x,y)
		q=cuadrante(x,y)
		eval{

			caso(q==-1)
				imprimir("El punto esta en el centro")
			caso(q==0&&x==0)
				imprimir("El punto esta sobre el eje y")
			caso(q==0&&y==0)
				imprimir("El punto esta sobre el eje x")	
			sino

			imprimir("El punto esta en el ",q," cuadrante")
			}
	fin

subrutina cuadrante(ref x:numerico;ref y:numerico)retorna numerico
	var resp:numerico
	inicio
		eval{
			caso(x==0&&y==0)
				resp=-1
			caso(x==0||y==0)
				resp=0
			caso(x>0&&y>0)
				resp=1
			caso(x<0&&y>0)
				resp=2
			caso(x<0&&y<0)
				resp=3
			caso(x>0&&y<0)
				resp=4
		

			}


			retorna resp
	fin
	