Drools microservice using approach 2


Buildd the application:

mvn clean install

Run the application:

java -jar drools-jaxrs/target/drools-jax-rs-1.0-SNAPSHOT-swarm.jar


Test the application using the following endpoint

HTTP POST http://localhost:8080/api/users/categorize

Sample Request payload: 
{
	"name":"John Doe",
	"age":16
}

Sample Response: 
{
    "name": "John Doe",
    "age": 16,
    "category": "Teenager",
    "comments": "This is Teenager"
}