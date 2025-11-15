package eu.luftiger.cae.web.presenter.task

import eu.luftiger.cae.application.common.ErrorResponse
import eu.luftiger.cae.application.task.usecase.GetTaskResponse
import eu.luftiger.cae.web.mapper.toSchema
import eu.luftiger.cae.web.presenter.JsonRestPresenter
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Component

@Component
internal class TaskPresenter(
    httpServletResponse: HttpServletResponse,
    jacksonConverter: MappingJackson2HttpMessageConverter
) : JsonRestPresenter<GetTaskResponse>(httpServletResponse, jacksonConverter) {

    override fun present(response: GetTaskResponse) {
        response.toSchema().presentAsJson()
    }

    override fun presentFailure(error: ErrorResponse) {
        when (error) {
            is ErrorResponse.NotFound -> error.presentAsJson(HttpStatus.NOT_FOUND)
            is ErrorResponse.Unauthorized -> error.presentAsJson(HttpStatus.UNAUTHORIZED)
            is ErrorResponse.BadRequest -> error.presentAsJson(HttpStatus.BAD_REQUEST)
            is ErrorResponse.InternalServerError -> error.presentAsJson(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}