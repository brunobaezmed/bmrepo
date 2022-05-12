#include<iostream>
#include <bits/stdc++.h> 
#include<vector>
#include <string>
using namespace std;
class Solution {
public:
    int countVowelStrings(int n) {
        if(n == 1) return 5;
        int c = 0;
        string lexi[] = {"a","e","i","o","u"};
        
        c = count(n,lexi,c);
        
        return c;
    }
    int count(int n,string *last_character,int c){
        string *str = last_character;
        vector<string> s;
        int q = 0;
        for(int b = q ; q!= 5 && s.empty() || s.back().length()<= n   ; b++){
            if(b < 5 && (s.empty() || (s.back().length() < n && *str > *(str + b))   ) ){
                    
                    c++;

                    s.push_back(*str + *(last_character + b) );
                }
                else{
                   str = str + q; 
                   q++;
                   b = q;
                }


            }

            cout<<s.back();
            return c;
    }       
    
};

int main(){
    Solution s;

    cout<<s.countVowelStrings(2)<<endl;

    system("PAUSE");
    return 0;
    }