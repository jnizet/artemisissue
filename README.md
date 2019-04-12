# Description

This is a reproduction test case for issue [ARTEMIS-2304](https://issues.apache.org/jira/browse/ARTEMIS-2304)

## Steps to reproduce

 - clone this project
 - download and install Apache Artemis (tested with version 2.7.0)
 - create a new broker using `artemis create somedirectory`
     - choose `admin` as username, `password` as password, `N` when asked to allow anonymous access
 - run the broker using `./somedirectory/bin/artemis run`
 - execute `./gradlew test`
 
The test `shouldSendAndReceiveWithoutDelay` should succeed, whereas the test `shouldSendAndReceiveWithDelay` should fail.

If you repeat all these steps, but add the following lines in `somedirectory/etc/broker.xml` under the element
`configuration/core/address-settings/address-setting[match="#"]` before starting the broker:

```
            <auto-delete-addresses>false</auto-delete-addresses>
            <auto-delete-queues>false</auto-delete-queues>
```
 
Then the tests should now both succeed.
