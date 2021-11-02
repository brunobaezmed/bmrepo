    /*!
    * Start Bootstrap - SB Admin v7.0.3 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2021 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
// 
// Scripts



        
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

window.addEventListener('keydown', (event) => {

    const entlog = document.getElementById("inputPassword");
    const entReg = document.getElementById("inputPasswordConfirm");
    const entRecPass = document.getElementById("inputemail");

    if (event.key === "Enter" && entReg != null) {

        registrar();
        return;
    }


    if (event.key === "Enter" && entlog != null) {

        authenticate();
        return;
    }

    if (event.key === "Enter" && entRecPass != null) {
        event.preventDefault();
        recuperarcontr();
        return;
    }


});


async function registrar() {


    let datos = {};
    datos.name = document.getElementById('inputFirstName').value;
    datos.lastname = document.getElementById('inputLastName').value;
    datos.password = document.getElementById('inputPassword').value;
    datos.email = document.getElementById('inputEmail').value;
    datos.numberphone = document.getElementById('inputNumberPhone').value;
    confirmpass = document.getElementById('inputPasswordConfirm').value;

    if (datos.name == '' || datos.lastname == '' || datos.email == '' || datos.numberphone == '' || datos.password == '') {
        console.log(datos);
        alert("Complete fields to register");
        return;
    }

    if (confirmpass != datos.password) {
        alert("Passwords doesn't match");
        return;
    }



    fetch('user/post', {


        method: 'POST',
        headers: {

            'Cache-Control': 'no-store',
            'Cache-Control': 'private',
            'Accept': 'application/json',
            'Content-Type': 'application/json'

        },
        body: JSON.stringify(datos),
    });


    alert("You have been registered");
    return location.replace('login.html')

}



    async function authenticate() {

    let modal = document.getElementById('modal');
    let span = document.getElementsByClassName('close')[0];

    let credentials = {};
    credentials.email = document.getElementById('inputEmail').value;
    credentials.password = document.getElementById('inputPassword').value;

    let request = await fetch('user/cred', {


        method: 'POST',
        headers: {


            'Accept': 'application/json',
            'Content-Type': 'application/json'

        },
        body: JSON.stringify(credentials),
    });


    if (request.status == 403) {

        modal.style.display = 'block';

        span.onclick = function (event) {
            modal.style.display = 'none';
        }
        window.onclick = function (event) {
            if (event.target == modal) {
                modal.style.display = 'none';
            }
        }
        return;
    }


    var accesstoken = 'Bearer ' + request.headers.get('access_token');
    var refreshtoken = 'Bearer ' + request.headers.get('refresh_token');

    let Mheaders = new Headers();

    Mheaders.append('Authorization', accesstoken);
    Mheaders.append('Accept', 'application/json');
    Mheaders.append('Accept', 'text/html');
    Mheaders.append('Content-Type', 'application/json');
    Mheaders.append('Content-Type', 'text/plain');
    Mheaders.append('Accept', 'application/xhtml+xml')


    localStorage.setItem('Authorization', accesstoken);
    localStorage.setItem('Authorization2', refreshtoken);
    let req = new Request('/adm/home.html', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,

    });


    let html = await fetch(req).then((res) => {
        return res.text();
    }).catch(e => {
        console.log(e);
    });

    document.open();
    document.write(html);
    document.close();
    document.URL = 'home.html'

    req = new Request('get/users', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,

    });
    request = await fetch(req)
        .catch(e => {
            console.log(e);
        });


    const users1 = await request.json();
    let listhtml = '';  



    for (let list of users1) {

        let listusers = ' <tr><td>' + list.id + '</td><td>' + list.name + '</td><td>' + list.lastname + '</td><td>' + list.numberphone + '</td></tr>'

        listhtml += listusers;


    }

    document.querySelector('#datatablesSimple tbody').outerHTML = listhtml;


}
async function recuperarcontr() {


    let modal = document.getElementById("modal");
    let span = document.getElementsByClassName("close")[0];

    let email = document.getElementById('inputemail').value;

    const request = await fetch('user/recpass', {
        method: 'POST',
        headers: {
            'Cache-Control': 'no-store',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: (email),

    });
    const response = await request.text();

    if (response == 'true') {
        document.querySelector('#modal h2').innerHTML = 'Sucess';
        document.querySelector('#modal p').innerHTML = "A code sent to " + email;
        modal.style.display = "block";
    }
    else {
        modal.style.display = "block";

    }


    span.onclick = function () {
        modal.style.display = "none";
        if (response == 'true') location.reload();
    }
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
            if (response == 'true') location.reload();
        }

    }


}
async function logout() {


    const req = await fetch("/logout")
    if (req.status == 404) {
        location.replace('/login.html');

    }
    else {

    }

}

async function tab() {

    let Mheaders = new Headers();

    Mheaders.append('Authorization', localStorage.getItem('Authorization'));
    Mheaders.append('Accept', 'application/json');
    Mheaders.append('Accept', 'text/html');
    Mheaders.append('Content-Type', 'application/json');
    Mheaders.append('Content-Type', 'text/plain');
    Mheaders.append('Accept', 'application/xhtml+xml')

    let req = new Request('/adm/tables.html', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,
    });
    
    let request = await fetch(req).then((res) => {
        if (res.status == 403) {
            Mheaders.set('Authorization', localStorage.get('Authorization2'));
            return res;
        }
        else {
            return res.text();
        }


    }).catch((e) => {
        console.log(e);

    });

    let html = request;
    document.open();
    document.write(html);
    document.close();
    document.URL = 'tables.html'

    req = new Request('get/users', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,
    });


    request = await fetch(req)
        .catch(e => {
            console.log(e);
        });


    const users1 = await request.json();

    let listhtml = '';



    for (let list of users1) {

        let listusers = ' <tr><td>' + list.id + '</td><td>' + list.name + '</td><td>' + list.lastname + '</td><td>' + list.numberphone + '</td></tr>'

        listhtml += listusers;


    }

    document.querySelector('#datatablesSimple tbody').outerHTML = listhtml;
    console.log('0');

}


async function char() {

    let Mheaders = new Headers();

    Mheaders.append('Authorization', localStorage.getItem('Authorization'));
    Mheaders.append('Accept', 'application/json');
    Mheaders.append('Accept', 'text/html');
    Mheaders.append('Content-Type', 'application/json');
    Mheaders.append('Content-Type', 'text/plain');
    Mheaders.append('Accept', 'application/xhtml+xml')

    let req = new Request('/adm/charts.html', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,
    });

    let request = await fetch(req).then((res) => {
        if (res.status == 403) {
            Mheaders.set('Authorization', localStorage.get('Authorization2'));
            return res;
        }
        else {
            return res.text();
        }


    }).catch((e) => {
        console.log(e);

    });

    let html = request;
    document.open();
    document.write(html);
    document.close();
    document.URL = 'charts.html';

}
async function homepage() {

    let Mheaders = new Headers();
    Mheaders.append('Authorization', localStorage.getItem('Authorization'));
    Mheaders.append('Accept', 'application/json');
    Mheaders.append('Accept', 'text/html');
    Mheaders.append('Content-Type', 'application/json');
    Mheaders.append('Content-Type', 'text/plain');
    Mheaders.append('Accept', 'application/xhtml+xml')

    let req = new Request('/adm/home.html', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,
    });

    let request = await fetch(req).then((res) => {
        if (res.status == 403) {
            Mheaders.set('Authorization', localStorage.get('Authorization2'));
            return res;
        }
        else {
            return res.text();
        }


    }).catch((e) => {
        console.log(e);

    });

    let html = request;
    document.open();
    document.write(html);
    document.close();
    document.URL = 'home.html'

    req = new Request('get/users', {
        method: 'GET',
        headers: Mheaders,
        keepalive: true,
    });


    request = await fetch(req)
        .catch(e => {
            console.log(e);
        });


    const users1 = await request.json();

    let listhtml = '';



    for (let list of users1) {

        let listusers = ' <tr><td>' + list.id + '</td><td>' + list.name + '</td><td>' + list.lastname + '</td><td>' + list.numberphone + '</td></tr>'

        listhtml += listusers;


    }

    document.querySelector('#datatablesSimple tbody').outerHTML = listhtml;
    console.log('0');


}


async function erase(id){
   
    let result = confirm("Delete");
    if(result ){
    const request = await fetch('user/delete/'+id,{
        method: 'DELETE',
        headers: {
            'Cache-Control': 'no-store',
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': 'Bearer '+ localStorage.getItem('Authorization')
        },
    
    }).catch(e =>{
        console.log(e);
    })
   
    tab();
   }  



}
