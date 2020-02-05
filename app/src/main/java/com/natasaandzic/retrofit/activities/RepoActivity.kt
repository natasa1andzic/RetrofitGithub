package com.natasaandzic.retrofit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.natasaandzic.retrofit.R
import com.natasaandzic.retrofit.model.Repo
import com.natasaandzic.retrofit.model.RepoAdapter
import com.natasaandzic.retrofit.rest.APIClient
import com.natasaandzic.retrofit.rest.APIEndpoints
import kotlinx.android.synthetic.main.activity_repo.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RepoActivity : AppCompatActivity() {

    private var repoAdapter : RepoAdapter? = null
    private val repoList : MutableList<Repo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)


        val bundle = intent.extras
        val username = bundle!!.getString("Username")
        usernameTv.text = username

        reposRv.layoutManager = LinearLayoutManager(this)
        repoAdapter = RepoAdapter(R.layout.repo_list_item, applicationContext,repoList)
        reposRv.adapter = repoAdapter

        loadRepos(username)

    }

    private fun loadRepos(username :String) {
            val apiService = APIClient.getClient().create(APIEndpoints.RepoEndpoint::class.java)
        val call = apiService.getRepo(username)
        call.enqueue(object: retrofit2.Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.e("Repos", t.toString())
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                repoList.clear()
                response.body()?.let { repoList.addAll(it) }
                repoAdapter!!.notifyDataSetChanged()

            }


        })
    }
}
