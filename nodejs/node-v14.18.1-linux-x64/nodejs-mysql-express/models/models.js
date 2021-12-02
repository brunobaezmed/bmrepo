const sql = require ("./db.js");

const t = function(t){
	this.title = t.title;
	this.description = t.description;
	this.published = t.published;	
};
t.created = ( newT , result) => {
	sql.query("INSERT INTO t SET ?",newT,(err,res) =>  {
		if(err){
			console.log("error: ",err);
			result(err,null);
			return;
		}
		console.log("created t: ",{id: res.insertId,});
		
	}
}