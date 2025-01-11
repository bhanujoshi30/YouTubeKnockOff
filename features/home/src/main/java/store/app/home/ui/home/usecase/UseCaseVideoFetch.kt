package store.app.home.ui.home.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import store.app.core.utils.BaseResponse
import store.app.core.utils.MyConstants
import javax.inject.Inject
import javax.inject.Singleton

class UseCaseVideoFetch @Inject constructor() {


    private val productNames= arrayListOf("Nike","Reebok","Boots","Adidas","Asic")

    fun getHomeVideos()= flow{
        when (val response=getShoesListAsync()){
            is BaseResponse.Success->{ emit(response) }
            is BaseResponse.Failed ->
                emit(BaseResponse.Failed(MyConstants.SOMETHING_WENT_WRONG))

            else->{

            }
        }
    }

    private suspend fun getShoesListAsync():BaseResponse<ArrayList<String>>{
        delay(2000)

        ArrayList<String>().apply {
            for(i in 1..100){
                add(productNames.get(0))
            }
        }.let {
            return BaseResponse.Success(it)
        }
    }
}

