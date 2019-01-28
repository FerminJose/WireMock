# WireMock
Client that test a GET and POST request.

Having a wiremock server that have a GET endpoint that reports a status code (in my case 207) and the uptime. Another POST endpoint that matches a JSON POST on the request body, and it responses with "Created" and 201, or if something was wrong with "Not found" and 404. I have used MockLab for symplify the server implementation, and the URL is http://1ql1o.mocklab.io/status (for the GET) and http://1ql1o.mocklab.io/json (for the POST)

I have installed spring boot framework and used jUnit5 to do the tests implementation.

The "Exercise1Application.java" is the runnable spring boot class and the "Exercise1ApplicationTests.java" is the class for the test implementations.
To run the code, just create a spring boot project, put the 2 Java files in the respective locations as it here, and Run the Exercise1ApplicationTests.java as JUnit Test.
