package com.android.negaraasean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAsean: RecyclerView
    private val list = ArrayList<Asean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAsean = findViewById(R.id.rv_asean)
        rvAsean.setHasFixedSize(true)

        list.addAll(getListAsean())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val about = Intent(this, AboutActivity::class.java)
                startActivity(about)
            }
            R.id.action_asean -> {
                val asean = Intent(this, AboutAseanActivity::class.java)
                startActivity(asean)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListAsean(): ArrayList<Asean> {
        val dataName = resources.getStringArray(R.array.data_state)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_flag)
        val listAsean = ArrayList<Asean>()
        for (i in dataName.indices) {
            val asean = Asean(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listAsean.add(asean)
        }
        return listAsean
    }

    private fun showRecyclerList() {
        rvAsean.layoutManager = LinearLayoutManager(this)
        val listAseanAdapter = ListAseanAdapter(list)
        rvAsean.adapter = listAseanAdapter
        listAseanAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("key_asean", it)
            startActivity(intent)
        }
    }
}