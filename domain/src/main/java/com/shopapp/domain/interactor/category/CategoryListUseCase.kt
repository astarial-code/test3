package com.shopapp.domain.interactor.category

import com.shopapp.domain.interactor.base.SingleUseCase
import com.shopapp.domain.repository.CategoryRepository
import com.shopapp.gateway.entity.Category
import io.reactivex.Single
import javax.inject.Inject

class CategoryListUseCase @Inject constructor(private val categoryRepository: CategoryRepository) :
    SingleUseCase<List<Category>, CategoryListUseCase.Params>() {

    override fun buildUseCaseSingle(params: Params): Single<List<Category>> {
        return with(params) {
            categoryRepository.getCategoryList(perPage, paginationValue, rootCategoryId)
        }
    }

    data class Params(
        val perPage: Int,
        val paginationValue: String?,
        val rootCategoryId: String?
    )
}