/*

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> result;
        
        vector <int> r;
        sort(nums.begin(),nums.end());
        do{
            
            for(const auto & b: nums){
                r.push_back(b);
            }
                result.push_back(r);
                r.clear();
            
            
        }while(next_permutation(nums.begin(),nums.end()));
        return result;
        
    }
};

int main(int argvh,char **args){

    Solution s;
    vector<int> test = {1,2,3};
    vector<vector<int>> r ;
    r = s.permuteUnique(test);

    for(const auto & b : r){
        for(const auto & u : b)
        cout<<u<<" ";
        cout<<endl;
    }

    system("pause");
    return 0;
}