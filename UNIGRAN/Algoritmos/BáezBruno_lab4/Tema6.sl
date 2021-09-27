//Tema6
var ndias,min_media,max_media,porcentaje,nerrores:numerico
var min,max:numerico
var condicion=1
var ctl=0
	inicio
		cls()
		
		imprimir("Ingrese la min y la max\n")
		leer(min,max)
		si(min==0&&max==0){
		condicion=0
		}

		mientras(condicion==1){
			ndias=ndias+1
			si(min==9||max==9){

				nerrores=nerrores+1
			
				
		sino
			min_media=min_media+min
			max_media=max_media+max
			ctl=ctl+1
			
					}
		imprimir("Ingrese la min y la max\n")
		leer(min,max)
		si(min==0&&max==0){
		condicion=0
		 }
			}
		si(max_media==0&&min_media==0){
			imprimir("El numero de dias es 0 La media minima es 0 la media maxima 0 n de errores= 0")
			imprimir(" y el porcentaje de errores es 0")

		sino
			imprimir("El numero de dias es ",ndias," La media minima es ",min_media/ctl," la media maxima ",max_media/ctl," n de errores= ",nerrores)
			imprimir(" y el porcentaje de errores es ",(nerrores*100)/ndias,"%")}
			fin