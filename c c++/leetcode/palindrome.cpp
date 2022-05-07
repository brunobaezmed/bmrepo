#include<iostream>
#include<vector>
#include <stack>
#include<math.h>
using namespace std;
class Solution {
    public:
      bool palindrome (int x){
        
        long pal = 0;
        int b = x;
        int r = 0;
        int cant = 0;
        while(b/10 > 0){
                 b = b / 10;
                 cant++;
                }
          b = x;
          
          cout<<cant<<endl;
         while(b > 0){
        
            pal = pal + (b % 10) * pow(10,cant) ;
            cant-- ;
 
            if(b < 10 && pal != x){
                pal = pal + b  ;
                b = b / 10;
            } else{   
                b = b / 10;
            }
            
            
        }
        
        return pal == x;
    }
};

int main(int argvh,char **args){

    Solution s;
    cout<<s.palindrome(1231);
    return 0;
}