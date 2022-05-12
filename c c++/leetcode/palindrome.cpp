/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1

*/

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