package com.ralphordanza.curllogginginterceptor

import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.IOException
import java.net.URLDecoder
import java.nio.charset.Charset

class CurlLoggerInterceptor(var tag: String) : Interceptor {
    private val UTF8 = Charset.forName("UTF-8")
    private var stringBuffer: StringBuffer? = null

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        this.stringBuffer = StringBuffer("")
        // add cURL command
        this.stringBuffer!!.append("cURL -g ")
        this.stringBuffer!!.append("-X ")
        // add method
        this.stringBuffer!!.append(request.method().toUpperCase()).append(" ")
        // adding headers
        for (headerName in request.headers().names()) {
            addHeader(headerName, request.headers().get(headerName))
        }

        // adding request body
        val requestBody = request.body()
        if (request.body() != null) {
            val buffer = Buffer()
            requestBody!!.writeTo(buffer)
            val contentType = requestBody.contentType()
            if (contentType != null) {
                addHeader("Content-Type", request.body()!!.contentType()!!.toString())
                val charset = contentType.charset(UTF8)
                this.stringBuffer!!.append(" -d '")
                    .append(URLDecoder.decode(buffer.readString(charset!!), "UTF-8")).append("'")
            }
        }

        // add request URL
        this.stringBuffer!!.append(" \"").append(request.url().toString()).append("\"")
        this.stringBuffer!!.append(" -L")

        if (BuildConfig.DEBUG) {
            CurlPrinter.print(tag, request.url().toString(), this.stringBuffer!!.toString())
        }
        return chain.proceed(request)
    }

    private fun addHeader(headerName: String, headerValue: String?) {
        this.stringBuffer!!.append("-H " + "\"").append(headerName).append(": ").append(headerValue)
            .append("\" ")
    }
}