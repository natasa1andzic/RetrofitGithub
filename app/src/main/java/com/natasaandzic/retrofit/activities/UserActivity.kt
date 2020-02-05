package com.natasaandzic.retrofit.activities

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.natasaandzic.retrofit.R
import com.natasaandzic.retrofit.model.User
import com.natasaandzic.retrofit.rest.APIClient
import com.natasaandzic.retrofit.rest.APIEndpoints
import com.natasaandzic.retrofit.util.ImageDownloader
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class UserActivity : AppCompatActivity() {

    private lateinit var username: String
    private lateinit var bundle: Bundle
    private  var myImage : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        bundle = intent.extras!!
        username = bundle.getString("Username")!!

        repoBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RepoActivity::class.java)
            intent.putExtra("Username", username)
            startActivity(intent)
        })

        loadData()
    }

    private fun loadData() {

        val apiService: APIEndpoints.UserEndpoints = APIClient.getClient().create(APIEndpoints.UserEndpoints::class.java)
        val call: Call<User> = apiService.getUser(username)

        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {

            }

            override fun onResponse(call: Call<User>, response: Response<User>) {

                val body = response.body()!!

                val task = ImageDownloader()

                try {
                    myImage = task.execute(body.avatar).get()
                }
                catch (e: Exception) {
                    e.printStackTrace()
                }

                avatarIv.setImageBitmap(myImage)

                    val usernameString = "Username: ${body.name}"
                    usernameTv.text = usernameString

                    val name = "Name: ${body.login}"
                    nameTv.text = name

                    val followers = "Followers:  ${body.followers}"
                    followersTv.text = followers

                    val following = "Following:  ${body.following}"
                    followingTv.text = following

                    val email = "Email: ${body.email}"
                    emailTv.text = email
                }



        })


    }
}

