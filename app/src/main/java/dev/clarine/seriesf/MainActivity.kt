package dev.clarine.seriesf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.clarine.recyclerviews.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayNamesList()
    }
    fun  displayNamesList() {

        var names = listOf(
            0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811
        )
        binding.rvNames.layoutManager = LinearLayoutManager(this)//GridLayoutManager{this,3}
        val namesAdapter = NamesRvAdapter(names)
        binding.rvNames.adapter = namesAdapter
    }

}