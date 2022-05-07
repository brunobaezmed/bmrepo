
/*
test1 1
test2 1
test3 1
test4 0
test5 1
*/#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int i = 0;
        int j = 0;
        int k = 0;
 
        bool r1 = false;
        const int size = nums.size();
         for(i = 0 ; i < size && i+1 <size ; i++){

                    j = 0;
                    for(j = i+1 ;  j < size &&i+1 < size  &&( (nums[i] < nums[j] || nums[i] == nums[j]) || j < size)  ;j++){
                        if(j < size && k < size && nums[k] > nums[j] && k < j&& nums[i] < nums[j]  && i < j && k > i  ){
                            return true;
                        }

                       

                            for(k = i ;k < j &&  j < size && k < size  ;k++){


                                    if(j < size && k < size && nums[k] > nums[j] && k < j && nums[i] < nums[j]&& i < j && k > i  ){
                                    return true;
                                }

                            }

                        

                    }
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
    system("PAUSE");
    return 0;
}