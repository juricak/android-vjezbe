package com.example.spacedrepetition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.spacedrepetition.fragments.GameRulesFragment
import com.example.spacedrepetition.fragments.HomeFragment
import com.example.spacedrepetition.fragments.ImportSetsFragment
import com.example.spacedrepetition.fragments.ManageSetsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        excerciseBtn.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val homeFragment = HomeFragment()
        val gameRulesFragment = GameRulesFragment()
        val importSetsFragment = ImportSetsFragment()
        val manageSetsFragment = ManageSetsFragment()

        makeCurentFragment(homeFragment)


            bottom_navigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.ic_home -> makeCurentFragment(homeFragment)
                    R.id.ic_menu_book -> makeCurentFragment(gameRulesFragment)
                    R.id.ic_import_export -> makeCurentFragment(importSetsFragment)
                    R.id.ic_file -> makeCurentFragment(manageSetsFragment)

                }
                true

            }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun makeCurentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}