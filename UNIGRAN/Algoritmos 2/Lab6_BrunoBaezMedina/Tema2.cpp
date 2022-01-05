//Tema2
#include <iostream>
#include <cstring>
using namespace std;
int main(){
    int l = 0;
    int i = 0;
    int j = 0;
    int tm = 1;
    int q = 0;
    int m = 0;
    char pal[100];

    cout << "Ingrese la frase ";
    cin.getline(pal,100,'\n');
    l = strlen(pal);
    for(q = 0;q < l ;q++){
        if(pal[q] == ' '){
            tm++;
        }

    }
    char pal2[tm][100];
    for(q = 0;q < l;q++){

        if(pal[q] == ' ' ){
            pal2[i][j] = '\0';
            i++;
            j = 0;
        }
        else{
            pal2[i][j] = pal[q];
            j++;
        }

    }
    pal2[i][j] = '\0';
    for(q = 0;q < tm;q++){
        if(strlen(pal2[q]) > m){
            m = strlen(pal2[q]);
            j = q;
        }
    }
    cout<< "La palabra mayor es "<<pal2[j]<<" con  "<<m<<" caracteres";

    return 0;
}
