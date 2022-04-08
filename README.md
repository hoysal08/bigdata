# Bigdata Lab

### cmd: mongo #### start mongodb 
### cmd:use sooraj #### choose databse

### db.collection1.insertOne({"name":"ram","age":21,"status":"ready"}) { "acknowledged" : true, "insertedId" : ObjectId("624bc1d3aced1768821f36fe") }
#### can be used to insert document into collection,also creates a collection if doesn't exist
db.collection1.find() { "_id" : ObjectId("624bbbeacb1fee5a5258b95f"), "name" : "sue", "age" : 26, "status" : "pending" } { "_id" : ObjectId("624bbd27cb1fee5a5258b960"), "name" : "john", "age" : 22, "status" : "ready" } { "_id" : ObjectId("624bc1d3aced1768821f36fe"), "name" : "ram", "age" : 21, "status" : "ready" }

db.collection1.insertMany([{"name":"ram","age":21,"status":"ready"},{"name":"sam","age":28,"status":"pending"}]) { "acknowledged" : true, "insertedIds" : [ ObjectId("624bc237aced1768821f36ff"), ObjectId("624bc237aced1768821f3700") ] }

db.collection1.find() { "_id" : ObjectId("624bbbeacb1fee5a5258b95f"), "name" : "sue", "age" : 26, "status" : "pending" } { "_id" : ObjectId("624bbd27cb1fee5a5258b960"), "name" : "john", "age" : 22, "status" : "ready" } { "_id" : ObjectId("624bc1d3aced1768821f36fe"), "name" : "ram", "age" : 21, "status" : "ready" } { "_id" : ObjectId("624bc237aced1768821f36ff"), "name" : "ram", "age" : 21, "status" : "ready" } { "_id" : ObjectId("624bc237aced1768821f3700"), "name" : "sam", "age" : 28, "status" : "pending" }

db.collection1.find() { "_id" : ObjectId("624bbbeacb1fee5a5258b95f"), "name" : "sue", "age" : 26, "status" : "pending" } { "_id" : ObjectId("624bbd27cb1fee5a5258b960"), "name" : "john", "age" : 22, "status" : "ready" } { "_id" : ObjectId("624bc1d3aced1768821f36fe"), "name" : "ram", "age" : 21, "status" : "ready" } { "_id" : ObjectId("624bc237aced1768821f36ff"), "name" : "ram", "age" : 21, "status" : "ready" } { "_id" : ObjectId("624bc237aced1768821f3700"), "name" : "sam", "age" : 28, "status" : "pending" }

db.collection1.update({age:20},{$set:{age:23}}) WriteResult({ "nMatched" : 0, "nUpserted" : 0, "nModified" : 0 }) db.collection1.update({age:21},{$set:{age:23}}) WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 }) db.collection1.find() { "_id" : ObjectId("624bbbeacb1fee5a5258b95f"), "name" : "sue", "age" : 26, "status" : "pending" } { "_id" : ObjectId("624bbd27cb1fee5a5258b960"), "name" : "john", "age" : 22, "status" : "ready" } { "_id" : ObjectId("624bc1d3aced1768821f36fe"), "name" : "ram", "age" : 23, "status" : "ready" } { "_id" : ObjectId("624bc237aced1768821f36ff"), "name" : "ram", "age" : 21, "status" : "ready" } { "_id" : ObjectId("624bc237aced1768821f3700"), "name" : "sam", "age" : 28, "status" : "pending" }
