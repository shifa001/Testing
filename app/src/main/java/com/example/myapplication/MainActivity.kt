package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
