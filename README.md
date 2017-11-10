

# JCppJs-java-js
java uses v8 as an engin to execute javascript 

## cpp
https://github.com/buzhidaolvtu/JCppJs-cpp.git

## just a demo
* set -Djava.library.path={cpp v8HelloWorld lib path}
* run HelloJNI

## javascipt
* Connection
javascript不存在这样的内置对象，本demo的目的是增强javascript的内置函数。
```java
    var conn = new Connection('jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8');
```  
* query 
```java
    var query = conn.query('select * from dual');   
    console.log(query);
```

