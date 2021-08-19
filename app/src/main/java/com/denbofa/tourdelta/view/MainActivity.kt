package com.denbofa.tourdelta.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.denbofa.tourdelta.R
import com.denbofa.tourdelta.databinding.ActivityMainBinding
import com.denbofa.tourdelta.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mySiteAdapter: SiteAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        mySiteAdapter = SiteAdapter(listOf())
        binding.recycler.adapter = mySiteAdapter

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.apply {
            getAllPhotos()
            items.observe(this@MainActivity, {
                mySiteAdapter.lists = it
                mySiteAdapter.notifyDataSetChanged()
            })
        }

        spinnerArray()

        binding.planetsSpinner.onItemSelectedListener = this

    }

    fun spinnerArray(){
        ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.planetsSpinner.adapter = adapter
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(position === 0){

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

