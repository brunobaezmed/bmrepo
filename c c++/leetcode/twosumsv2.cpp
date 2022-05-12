/*


Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
*/
#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
class Solution{

    public:
        vector<int> twosum(vector<int>& nums , int target){
           
            unordered_map<int,int> map;
        
            int j = 0;
            int i = 0;
            const int vsize = nums.size();
            int requiredmin = 0;

            vector<int> indexs;

            for(i = 0 ; i < vsize ; i++){

              requiredmin =  target - nums[i];
              if(map[requiredmin] != NULL){
                
                indexs.push_back(map[requiredmin]);
                indexs.push_back(i);

                return indexs;
                }
                map[nums[i]]=i;
              }





            
             indexs.push_back(0);
             indexs.push_back(0);

              return indexs ;

        }


};


int main(int argv,char *arg[]){
    vector<int> t = {2,7,11,15};//9
   
    Solution s;
   
   
   
    vector<int> v = s.twosum(t,9);

    for(auto & Vel : v){
        cout<<Vel<<" " ;
    }

    vector<int> t2 = {3,2,4};//6

    vector<int> v2 = s.twosum(t2,6);

    for(auto & Vel2 : v2){
        cout<<Vel2<<" " ;
    }


    system("PAUSE");
    return 0;
}