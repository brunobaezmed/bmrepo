const https = require('https');
const process = require('process');
const data = JSON.stringify({

        name:"Bruno",
        lastname:"Báez Medina",
        numberphone:"594847",
        email:"brunomatias33@gmail.com",
        password:"337723",
    

});
const options = {
    hostname  :'localhost',
    port : 2333,
    path : '/user/post',
    method: 'POST',
    headers: {
        'Accept':'application/json',
        'Content-Type': 'application/json',
         body:data,
    }
   

}
const req = https.request(options,res =>{
    console.log(`statuscode: ${res.statusCode}`)
    res.on('data',d => {

        process.stdout.write(d);


    })

})

req.on('error', error => {

    console.error(error)
})
req.write(data);
req.end();

