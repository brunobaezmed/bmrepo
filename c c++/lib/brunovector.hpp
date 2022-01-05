#include <iostream>
#include <initializer_list>

#ifndef brunonamespace 
#define  brunonamespace namespace
#endif

#ifndef bruno_vector
#define bruno_vector
brunonamespace bruno{
template<typename B> 
class bector{
  
     
     B *brector;
     B *mtemp;
     u_int32_t bsize,acsize;
   
public:     
   bector(std::initializer_list <B> list):brector{new B[list.size()]},bsize{(u_int32_t)list.size()}
   {
     std::copy(list.begin(),list.end(),brector);

   };
   bector(){
        brector = new B[7]();
        bsize = 0;
        acsize = 7;
   };
   bector(const bector &) = default;
   ~bector(){ delete []brector;}
   B &operator[](int index)const{
        return brector[index];
   } ;
 
  void b_ins(B value) {
       if(bsize == acsize){
            mtemp = new B[bsize*2];
          for(int mat = 0;mat < bsize;++mat){
               mtemp[mat] = brector[mat];
          }
          delete []brector;
          brector = mtemp;
          acsize = bsize*2;
       }

       
        bector::brector[bsize] = value;
        ++bsize;
   };
   int bsz(){return bsize;}

     };
}
#endif
