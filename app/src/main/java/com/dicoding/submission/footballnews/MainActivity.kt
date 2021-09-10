package com.dicoding.submission.footballnews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.dicoding.submission.footballnews.ui.account.AccountActivity
import com.dicoding.submission.footballnews.ui.home.HomeFragment
import com.dicoding.submission.footballnews.ui.match.MatchesFragment
import com.dicoding.submission.footballnews.ui.news.NewsFragment
import com.dicoding.submission.footballnews.ui.shop.ShopFragment
import com.dicoding.submission.footballnews.ui.team.TeamActivity
import com.dicoding.submission.footballnews.ui.tvsc.HighlightFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var title: String = "Home"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val matchesFragment = MatchesFragment()
        val newsFragment = NewsFragment()
        val shopFragment = ShopFragment()
        val highlightFragment = HighlightFragment()

        makeCurrentFragment(homeFragment)

        bottom_nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.match -> makeCurrentFragment(matchesFragment)
                R.id.chat -> makeCurrentFragment(newsFragment)
                R.id.shop -> makeCurrentFragment(shopFragment)
                R.id.video -> makeCurrentFragment(highlightFragment)
            }
            true
        }
        setSupportActionBar(findViewById(R.id.toolbar))
        setSupportActionBarTitle(title)

    }

    private fun setSupportActionBarTitle(title:String?) {
        supportActionBar?.title = title

    }

    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
            replace(R.id.countiner, fragment)
            commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_account -> {
                val moveIntent = Intent(this@MainActivity, AccountActivity::class.java)
                startActivity(moveIntent)
                title = "Account"
            }
            R.id.nav_team -> {
                val moveIntent = Intent(this@MainActivity, TeamActivity::class.java)
                startActivity(moveIntent)
                title = "Team"
            }
        }
        return super.onOptionsItemSelected(item)
    }
}