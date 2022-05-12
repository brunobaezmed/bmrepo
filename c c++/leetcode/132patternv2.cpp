
/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109

*/
#include<iostream>
#include<vector>
#include <stack>
using namespace std;
class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int i = 0;
        int j = 0;
        int min = INT32_MIN;
        
        stack<int> s;
        const int size = nums.size();
        if(size < 3 ) return false;
         for(i = size - 1;  i >= 0 ;i--){


                            if(nums[i]<min){
                                return true;
                            }
                            else{
                                while (!s.empty() &&  nums[i] > s.top()   )
                                {
                                    min = s.top();
                                    s.pop();
                                }
                               
                            }
                        s.push(nums[i]);
                    }
                
            
            return false;

        }

};
int main(){

    vector<int> nums = {-2,1,2,-2,1,2};
    vector<int> nums2 = {1,3,2,4,5,6,7,8,9,10};
    vector<int> nums3 = {3,1,4,2};// 3 < 4 and 4 < 5 == true
    vector<int> nums4 = {1,2,3,4};
    vector<int> nums5 = {3,5,0,3,4};
    vector<int> nums6 =  {1,0,1,-4,-3};

    Solution s ;
    bool r = false;
    for(int q = 0 ; q < nums.size(); q++){
        cout << "nums["<<q<<"]"<< nums[q]<<endl;
    }
    r = s.find132pattern(nums);
    cout<<"test1 "<<r<<endl;
    r = s.find132pattern(nums2);
    cout<<"test2 "<<r<<endl;
    r = s.find132pattern(nums3);
    cout<<"test3 "<<r<<endl;
    r = s.find132pattern(nums4);
    cout<<"test4 "<<r<<endl;
    r = s.find132pattern(nums5);
    cout<<"test5 "<<r<<endl;

    r = s.find132pattern(nums6);
    cout<<"test6 "<<r<<endl;
    system("PAUSE");
    return 0;
}