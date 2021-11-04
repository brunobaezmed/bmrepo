#include <exception>
class Vector{
public:
     
     Vector(int s):elem{new double[s]},sz{s}{
         for(int i=0;i<s ;++i)elem[0]=0;
     };
     
     ~Vector(){delete[]elem;};

     double & operator [](int i);
     int size() {
         return sz;
     };
     
 private:
     double *elem;
     int sz;             

};



