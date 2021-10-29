/*!
    * Start Bootstrap - SB Admin v7.0.3 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2021 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    // 
// Scripts
// 


window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
            // Uncomment  Below to persist sidebar toggle between refreshes
            // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        }); 
    }
  

});










const loginpage = 'login.html';
const url = '/index.html';

async function registrar(){

    let datos={};
    datos.name=document.getElementById('inputFirstName').value;
    datos.lastname=document.getElementById('inputLastName').value;
    datos.password=document.getElementById('inputPassword').value;
    datos.email=document.getElementById('inputEmail').value;
    datos.numberphone=document.getElementById('inputNumberPhone').value;
    confirmpass=document.getElementById('inputPasswordConfirm').value;

    if(datos.name==''||datos.lastname==''||datos.email==''||datos.numberphone==''||datos.password==''){
        console.log(datos);
      alert("Complete fields to register"); 
       return;
    }

    if(confirmpass != datos.password){
        alert("Passwords doesn't match");
        return;
    }
  
  

  fetch('user/post',{
         

        method:'POST',
        headers:{
			
			'Cache-Control':'no-store',
			'Cache-Control':'private',
            'Accept':'application/json',
            'Content-Type':'application/json'
        
        },
        body:JSON.stringify(datos), 
    });

 
   alert("You have been registered");
	return location.replace(loginpage)

}



async function authenticate(){

    let credentials={};
    credentials.email=document.getElementById('inputEmail').value;
    credentials.password=document.getElementById('inputPassword').value;
  
   const request= await fetch('user/cred',{
         

        method:'POST',
        headers:{
			'Cache-Control':'no-store',
			'Cache-Control':'private',
            'Accept':'application/json',
            'Content-Type':'application/json'
        
        },
        body:JSON.stringify(credentials), 
    });
    console.log(request.status);
    if(request.status == 403){
        alert("Password or email incorrect");
        return;
        }
  	var accesstoken = 'Bearer '+request.headers.get('access_token');
    var refreshtoken = request.headers.get('refresh_token');
   
    var Mheaders = new Headers();

    Mheaders.append('Authorization',accesstoken);
   // Mheaders.append('Cache-Control','no-store');
    Mheaders.append('Accept','application/json');
    Mheaders.append('Accept','text/html');
    Mheaders.append('Content-Type','application/json');
    Mheaders.append('Content-Type','text/plain');
    
    
    
    localStorage.setItem('Autorization',accesstoken);
    
    var req = new Request(url,{
        method : 'GET',
        headers: Mheaders,
        redirect: "follow",
        keepalive : true,
        
    });

    let fow=await fetch(url,req).then(function(res){
            if(res.status == 403){
                location.replace(loginpage)
                }
           location.replace(req.url);
    });
    
      
}
async function recuperarcontr(){
            
   
    var modal =document.getElementById("modal");
    var span =document.getElementsByClassName   ("close")[0];
     
    let email= document.getElementById('inputEmail').value;
    const request = await fetch('user/recpass',{
        method :'POST',
        headers : {
             'Cache-Control':'no-store',
             'Accept' : 'application/json',
             'Content-Type' : 'application/json'
         },
        body:(email),
    
    });
    const response = await request.text();
    if(response == 'true'){
        document.querySelector('#messageEmail p').outerHTML="A code sent to "+email;
        modal.style.display ="block";
            }
    else{
        modal.style.display ="block";
        document.querySelector('#messageEmail p').outerHTML="Is not a valid account";
        }

    
    span.onclick = function(){
    modal.style.display= "none";
    location.reload();
        }
    window.onclick = function(event){
    if(event.target == modal){
          modal.style.display= "none";
              location.reload();
            }

    }
   }

