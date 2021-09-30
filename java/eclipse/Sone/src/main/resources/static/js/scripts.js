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

    if(confirmpass != datos.password){
        alert("Password doesn't match");
        return;
    }

   const sent= fetch('user/post',{
        

        method:'POST',
        headers:{

            'Accept':'application/json',
            'Content-Type':'application/json'
        
        },
        body:JSON.stringify(datos), 
    });

   // body:JSON.stringify(datos);
  //  window.postMessage("Success");
   alert("You have been registered");

}