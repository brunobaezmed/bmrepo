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
        // Uncomment Below to persist sidebar toggle between refreshes
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

            'Accept':'application/json',
            'Content-Type':'application/json'
        
        },
        body:JSON.stringify(datos), 
    });

 
  //  window.postMessage("Success");
   alert("You have been registered");

}



async function authenticate(){

    let credentials={};
    credentials.email=document.getElementById('InputEmail').value;
    credentials.password=document.getElementById('InputPassword').value;
  
   const request=  fetch('users',{
         

        method:'GET',
        headers:{

            'Accept':'application/json',
            'Content-Type':'application/json'
        
        },
        body:JSON.stringify(datos), 
    });
    result=await request.json();
    
    alert("Couldn't authenticate");
    return;
}