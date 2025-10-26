package eu.luftiger.cae.web.presenter

import eu.luftiger.cae.application.OutputBoundary
import eu.luftiger.cae.web.model.ErrorWebResponse
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.DelegatingServerHttpResponse
import org.springframework.http.server.ServletServerHttpResponse
import java.io.IOException

internal abstract class JsonRestPresenter<R>(
    private val httpServletResponse: HttpServletResponse,
    private val jacksonConverter: MappingJackson2HttpMessageConverter
) : OutputBoundary<R> {
    fun Any.presentAsHttp200Response() {
        val outputMessage = DelegatingServerHttpResponse(ServletServerHttpResponse(httpServletResponse))

        httpServletResponse.status = HttpStatus.OK.value()
        try {
            jacksonConverter.write(this, MediaType.APPLICATION_JSON, outputMessage);
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    fun presentInternalServerErrorResponse(message: String) {
        val outputMessage = DelegatingServerHttpResponse(ServletServerHttpResponse(httpServletResponse))

        httpServletResponse.status = HttpStatus.INTERNAL_SERVER_ERROR.value()

        try {
            jacksonConverter.write(ErrorWebResponse(message, 500), MediaType.APPLICATION_JSON, outputMessage);
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}