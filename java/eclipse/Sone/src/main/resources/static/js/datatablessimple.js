
window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki
  
    load();
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

async function load(){


    const request= await fetch('get/users',{
		method: 'GET',
		'Cache-Control':'no-store',
		'Cache-Control':'private',
		 
		});


    const users1 =  await request.json();

    console.log(users1);

	let	listhtml='';
 
 
    
    for(let list of users1){

	let listusers=' <tr><td>'+list.id+'</td><td>'+list.name+'</td><td>'+list.lastname+'</td><td>'+list.numberphone+'</td></tr>'
	 
    listhtml+=listusers;
    
 
        }
         
    document.querySelector('#datatablesSimple tbody').outerHTML=listhtml;
   
    }
















/*async function loadusers(){
    const url='http:localhost:2333/users';
    const request =await fetch(url,{
    method: 'GET',
    headers: {
        'Accept': 'application/json',
        'Content-Type ' :'application/json'
        
        }
    });
    const users1 = await request.json();
    console.log(users1);
}*/


