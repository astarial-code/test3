package com.shopapp.ui.category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.shopapp.R
import com.shopapp.gateway.entity.Category
import kotlinx.android.synthetic.main.activity_category_list.*

class CategoryListActivity : AppCompatActivity() {

    companion object {

        val PARENT_CATEGORY = "parent_category"
        const val IS_GRID_MODE = "is_grid_mode"

        fun getStartIntent(context: Context, category: Category, isGrid: Boolean): Intent {
            val intent = Intent(context, CategoryListActivity::class.java)
            intent.putExtra(PARENT_CATEGORY, category)
            intent.putExtra(IS_GRID_MODE, isGrid)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_list)
        val parentCategory: Category? = intent.getParcelableExtra(PARENT_CATEGORY)
        val isGrid = intent.getBooleanExtra(IS_GRID_MODE, true)

        toolbar.setTitle(parentCategory?.title ?: "")
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(false)
            it.setHomeAsUpIndicator(R.drawable.ic_arrow_left)
        }
        val fragment = CategoryListFragment.newInstance(parentCategory, isGrid)
        supportFragmentManager.beginTransaction()
            .replace(content.id, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_cart, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            false
        }
    }
}