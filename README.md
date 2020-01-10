# curl-logging-interceptor
Clean HTTP request curl logs

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
