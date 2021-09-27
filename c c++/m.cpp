#include<iostream>
#include<unistd.h>

const char *green="\e[0;32m";

using namespace std;
int main(){

 	long *b;
	b=new long [10000000000];
	for(int e=0;e<100000000-1;e++){
		b[e]=__LONG_LONG_MAX__;
		
     		}
	system("\e");
	for(int e=0;e<100000000-1;e++){
		cout<<b[e];
		
     		}
	cout<<sizeof(b);
	system("trap");

	return 0;
	}
