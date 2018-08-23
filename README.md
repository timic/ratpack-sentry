[![Download](https://api.bintray.com/packages/timic/generic/ratpack-sentry/images/download.svg)](https://bintray.com/timic/generic/ratpack-sentry/_latestVersion)
[![Build Status](https://travis-ci.org/timic/ratpack-sentry.svg?branch=master)](https://travis-ci.org/timic/ratpack-sentry)
[![codecov](https://codecov.io/gh/timic/ratpack-sentry/branch/master/graph/badge.svg)](https://codecov.io/gh/timic/ratpack-sentry)

This library aims to integrate [Sentry](https://sentry.io) (an error tracking solution) 
into [Ratpack](https://ratpack.io) web-framework.

### Install

Via gradle:

```groovy
repositories {
    jcenter()
}

dependencies {
    compile "com.github.timic:ratpack-sentry:x.y.z"
}
```

### Usage

Library has a customized `SentryClientFactory` which provides ratpack's execution threads aware `ContextManager` and also
properly handles http request attributes.

You can configure client factory either in code

```java
import com.github.timic.ratpack.sentry.RatpackSentryClientFactory;


class Application {
  
  public static void main(String[] args){
    Sentry.init(new RatpackSentryClientFactory());
    RatpackServer.start(server -> server 
         // ...
    );
  }

}
``` 

or in sentry [config file](https://docs.sentry.io/clients/java/config/#configuration-via-properties-file):

```properties
factory=com.github.timic.ratpack.sentry.RatpackSentryClientFactory
```