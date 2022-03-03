package com.example.demojetpack.ui.screen.home.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.demojetpack.data.api.ApiService
import com.example.demojetpack.data.model.UnplashPhoto
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class UnplashPagingSource(
    private val unplashApi: ApiService,
    private val query: String
) : PagingSource<Int, UnplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnplashPhoto> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = unplashApi.getPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, UnplashPhoto>): Int? {
        return null
    }
}