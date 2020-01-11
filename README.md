# curl-logger-interceptor
A clean HTTP request curl logs for Retrofit and OkHttp

Sample:
```
2020-01-11 11:38:25.423 18850-18909/com.ralphordanza.curlsample D/CURL: ────────────────────────────────────────────
    cURL -g -X GET  "https://jsonplaceholder.typicode.com/posts?userId=1" -L  
    ──────────────────────────────────────────── 
```

# How to use
1. Add jitpack.io to your project's root build.gradle
```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

2. Add the dependency to your app's build.gradle
```
dependencies {
	  implementation 'com.github.mendelordanza:curl-logging-interceptor:1.0'
}
```

3. Add interceptor to your OkHttp 
```
val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(CurlLoggerInterceptor("CURL"))
            .build()
```

# That's it!
