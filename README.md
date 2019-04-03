# thrift
A sample spring boot Thrift server and client.

The server is hosted on the port 8000 and the client exposes an api on the 6972 port. After building and deploying both applications, you can call the client on the exposed endpoint and will in turn communicate with the thrift server and print its response:

Example:
http://localhost:6972/thrift/test?name=Andreas&lastname=Schoinas&middleName=Rock&age=24

Response:
Your name is: Andreas Rock Schoinas. Your age is: 24
