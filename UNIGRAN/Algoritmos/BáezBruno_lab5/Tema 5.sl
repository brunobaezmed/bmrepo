//Tema5
var ganador_game,n1games,n2games:numerico
	inicio
	cls()




	mientras(n1games<3&&n2games<3){

		ganador_game=ping_pong()

		si(ganador_game==1){
				n1games=n1games+1;
				imprimir("Ngames= ",n1games+n2games," J1= ",n1games," J2= ",n2games,"\n")
			sino
				n2games=n2games+1;
				imprimir("Ngames= ",n1games+n2games," J1= ",n1games," J2= ",n2games,"\n")
				}
			}
	si(n1games==3){
		
		imprimir("Gano el jugador 1")
		sino
		imprimir("Gano el jugador 2")
		}
	fin

subrutina ping_pong()retorna numerico
	var g=0
	var p1,p2:numerico
	inicio			
			mientras(p1<11&&p2<11){
				imprimir("Ingrese el ganador del punto, 1 para jugador1 y 2 para jugador2\n")
				leer(g)
					si(g==1){
						p1=p1+1
						sino
						p2=p2+1
						}
			
					}
			
		si(p1==11){
			
					g=1
				sino
					g=2
				}
	retorna g
	fin