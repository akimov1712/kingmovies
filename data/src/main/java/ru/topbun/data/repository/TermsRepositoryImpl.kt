package ru.topbun.data.repository

import android.content.Context
import ru.topbun.domain.entity.terms.TermsEntity
import ru.topbun.domain.repository.terms.TermsRepository

class TermsRepositoryImpl(private val context: Context): TermsRepository {

    private fun getArray(res: Int) = context.resources.getStringArray(res)

    override suspend fun loadPrivacy(): List<TermsEntity> {
        val titles = getArray(ru.topbun.ui.R.array.policy_titles)
        val points = mutableListOf<List<String>>().apply {
            (1..titles.size).forEach {
                val resourceName = "policy_point_$it"
                val resourceId = context.resources.getIdentifier(resourceName, "array", context.packageName)
                val pointList = getArray(resourceId).toList().map {
                    it.replace("·", "\n\t·")
                }
                add(pointList)
            }
        }
        return titles.zip(points).map {
            TermsEntity(it.first, it.second)
        }
    }

}