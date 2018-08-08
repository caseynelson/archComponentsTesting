package com.example.caseynelson.leaguearchitecture.ui;

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.Toast
import com.example.caseynelson.leaguearchitecture.ChampionApplication
import com.example.caseynelson.leaguearchitecture.R
import com.example.caseynelson.leaguearchitecture.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var championRecyclerViewAdapter: ChampionRecyclerViewAdapter

    val viewModel: ChampionViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ChampionViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as ChampionApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.init()

        championRecyclerViewAdapter = ChampionRecyclerViewAdapter(emptyList())

        rv_champion_list.apply {
            adapter = this@MainActivity.championRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this.context)
        }

        viewModel.getChampionList()?.observe(this, Observer { list ->
            if (list != null) {
                championRecyclerViewAdapter.update(list)
            }

        })
    }
}
