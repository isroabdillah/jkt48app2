package com.isrodicoding.jkt48app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Member JKT48"

        val btnAboutPage: Button = findViewById(R.id.btn_about_page)
        btnAboutPage.setOnClickListener(this)

        val btnMemberTreasure: Button = findViewById(R.id.btn_member_jkt48)
        btnMemberTreasure.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_member_jkt48 -> {
                val moveIntent = Intent(this@MainActivity, MemberJkt48::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
