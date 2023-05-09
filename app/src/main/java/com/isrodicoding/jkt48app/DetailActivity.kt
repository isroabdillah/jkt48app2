package com.isrodicoding.jkt48app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.isrodicoding.jkt48app.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.title = "Detail Member"
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<Member>("Data")
        Log.d("Detail Data", data.toString())

        Glide.with(this)
            .load(data?.photo)
            .apply(RequestOptions().override(800, 600))
            .into(detailBinding.imgItemPhoto)
        detailBinding.tvItemName.text = data?.name
        detailBinding.tvItemDetail.text = data?.detail
        detailBinding.tvItemFacts.text = data?.facts

    }
}
