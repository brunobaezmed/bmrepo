const express = require('express');
const cors = require("cors");

const app = express();

var corsOptions = { origin:
	"http://localhost:23337"
};

app.use(cors(corsOptions));

app.use(express.json());
app.use(express.urlencoded({extended:true}));

app.get("/",(req,res) =>{
	res.json({message: "Welcome to app "});

});

const PORT = process.env.PORT || 2333;
app.listen(PORT, () =>{

	console.log(`Server is running on port ${PORT}.`);		


});

