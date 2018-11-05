package com.maclaurin.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ui = MainActivityUI().apply {
            setContentView(this@MainActivity)
            rvClubs.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        initData()

        ui.rvClubs.adapter = ClubAdapter(items){
            startActivity<DetailsActivity>("club" to it)
            val toast = Toast.makeText(this, it.name, Toast.LENGTH_SHORT)
            toast.show()
        }

    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val info = resources.getStringArray(R.array.club_info)

        items.clear()

        for (i in name.indices) {
            items.add(Club(name[i],
                image.getResourceId(i, 0),
                info[i]))
        }

        image.recycle()
    }
}
