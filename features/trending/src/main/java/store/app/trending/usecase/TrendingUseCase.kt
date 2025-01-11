package store.app.trending.usecase

import javax.inject.Inject

class TrendingUseCase @Inject constructor(private val repo : TrendingRepository) {
    fun getTrendingList() = repo.getTrendingList()
}