package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_slider.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer

class SliderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
//        val tabs: TabLayout = findViewById(R.id.tabs)
//        tabs.setupWithViewPager(viewPager)


        val timer= object :CountDownTimer (2000,1000){
            override fun onFinish() {
                start()
            }

            override fun  onTick(p0 :Long) {
                Log.d("countdown","timervalue= $p0")
                Log.d("countdown","timervalue= ${TimeUnit.MILLISECONDS.toSeconds(p0)}")
                when (TimeUnit.MILLISECONDS.toSeconds(p0)) {
                    2L -> {
                        viewPager.currentItem = 1
                    }
                    1L -> {
                        viewPager.currentItem = 0

                    }
                }
            }
        }
        timer.start()

        btn_donation.setOnClickListener{
            val a= Intent(this,Donationacticity::class.java)
            startActivity(a)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.example_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_about ->{
                val intent= Intent(this,about_activity::class.java)
                startActivity(intent)

            }
            R.id.menu_help ->{
                val intent= Intent(this,help_activity::class.java)
                startActivity(intent)

            }
            R.id.menu_rateus ->{
                val intent= Intent(this,help_activity::class.java)
                startActivity(intent)


            }
            R.id.menu_language ->{
                val intent= Intent(this, languageActivity::class.java)
                startActivity(intent)
            }
        }


        return super.onOptionsItemSelected(item)
    }



}