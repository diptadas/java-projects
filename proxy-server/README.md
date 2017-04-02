# Proxy Server

1. Run the project to start server at localhost 5000 port (127.0.0.1:5000).
2. proxy_server.html is just a shortcut to send a request to server using http GET method.
3. Open proxy_server.html and enter any address (`https://www.google.com.bd/`) to send request to server.
4. Server will then download the page(if it was not previously downloaded) and send you response except it is a blocked site (facebook, youtube).
5. It is multi-threaded, so multiple client can send request at the same time.
