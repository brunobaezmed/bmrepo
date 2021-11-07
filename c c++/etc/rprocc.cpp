#include <iostream>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
using namespace std;

 class cpaths{
    public:
        const char *path = "//home/bruno/Documents/c c++/vlc";
        const char *bash = "/bin/bash";
        const char *scr = "/home/bruno/Desktop/vlc.desktop";
        const char *directory = "/usr/bin/vlc";

    public: 
           
           const char * getpaths(){
           return directory;
            }
       

    };
   


void progress_bar()
{
    cout<< "#####	       	               ";
    sleep(1);
    cout << "###############               ";
    sleep(1);
    cout << "##############################";
    sleep(1);
}

int main(int argc, char *argv[])
{
   
  
    int t=strtoul("007",0,8);
    int b=0;
    cpaths *cpath=new cpaths;
    b=lchmod(cpath->path,t);
    b=fork();
    //symlink(cpath->directory,cpath->scr);
    if(b==-1){
        
        cout<<"error"<<b;
        return 0;

    }
     delete cpath;
      int forkb=getppid();
      cout<<" "<<getpid()<<" "<<getppid;
      
      
    return 0;
}
