## Steps to reproduce

### Grails 3

```
cd grailsthree;
./gradlew bootRun
curl localhost:8080/home
{"ids":[1,2]}
```

### Grails 4

```
cd grailsfour;
./gradlew bootRun
curl localhost:8080/home
Unable to locate Attribute  with the the given name [role] on this ManagedType [example.grails.UserRole]. Stacktrace follows:
...
```
