package com.example.mvpdaggertest.data

import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GitRepository {
    //Retrofitインターフェース(APIリクエストを管理)
    var HTTPS_API_GITHUB_URL = "https://api.github.com/"

    private var gitRepository: GitRepository? = null

    // Github取得API
    private fun gitClient(): GitService {
        return getRetrofitService(HTTPS_API_GITHUB_URL)
    }

    private fun getRetrofitService(baseUrl: String) : GitService {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GitService::class.java)
    }

    @Synchronized
    fun getInstance(): GitRepository {
        if (gitRepository == null) {
            gitRepository = GitRepository
        }
        return gitRepository as GitRepository
    }

    suspend fun getGitListData(name:String): List<Data> = GlobalScope.async(Dispatchers.Default){
        val data = gitClient().getProjectList(name)
        val res = data.execute()
        return@async res.body()!!
    }.await()

    suspend fun getGitData(name: String, projectName: String): Data = GlobalScope.async(Dispatchers.Default){
        val data = gitClient().getProjectDetails(name,projectName)
        val res = data.execute()
        return@async res.body()!!
    }.await()
}