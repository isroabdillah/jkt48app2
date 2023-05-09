package com.isrodicoding.jkt48app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MemberJkt48 : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<Member> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_jkt48)

        supportActionBar?.title = "Member JKT 48"
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.rv_members)
        recyclerView.setHasFixedSize(true)

        list.addAll(MembersData.listData)
        showRecycleView()

    }

    private fun showRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = CardViewMemberAdapter(list)
        recyclerView.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : CardViewMemberAdapter.OnItemClickCallback {
            override fun onItemClicked(member: Member) {
                val moveIntentDetail = Intent(this@MemberJkt48, DetailActivity::class.java)
                moveIntentDetail.putExtra("Data", member)
                startActivity(moveIntentDetail)
                showSelectedMember(member)
            }
        })
    }

    private fun showSelectedMember(member: Member) {
        Toast.makeText(this, "Kamu Memilih "+member.name, Toast.LENGTH_SHORT).show()
    }
}