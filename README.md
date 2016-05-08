# fakeAirline

## build
```
cd C:\IdProj\oDesk\fakeAirline
gradle clean build -x test
java -jar build/libs/fakeAirline-0.0.1-SNAPSHOT.jar

# or to build war
gradle clean war -x test
ls -la build/libs/fakeAirline.war

# and now you can open it in browser:
chrome http://127.0.0.1:8080/swagger-ui/index.html
```