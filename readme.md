Tsearch Rest 

Rest service layer, stores rest services for tsearch application and welcomes ui section. 

It is a Jersey implementation  

Getting Started 

git clone https://github.com/mehmetyaman/tsearch.rest.git

cd tsearch.rest

mvn clean install -U 

to run on tomcat server

mvn tomcat:run or you can first install than run on tomcat together 

mvn clean install -U tomcat:run

Sample Services

for getting all texture elements -> http://localhost:8080/tsearch.rest/rest/texture/all

getting specified element by id -> http://localhost:8080/tsearch.rest/rest/texture/show/1

result 
{content: "dasdasd", id: 1, title: "asdsa"}
content: "dasdasd"
id: 1
title: "asdsa"


