package store.app.core.models

sealed class ResponseWrapper<T> {
    data class Success<T>(val data: T) : ResponseWrapper<T>()
    class Loading<T> : ResponseWrapper<T>()
    data class Failed<T>(val errorMessage: String="Something went wrong please try again.") : ResponseWrapper<T>()
}