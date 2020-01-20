package com.e.weatherapi.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.e.weatherapi.R
import com.e.weatherapi.datasource.remote.NetworkState
import com.e.weatherapi.viewmodels.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(WeatherViewModel :: class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addObserver()
        btn_get_weather.setOnClickListener {
            viewModel.getWeather(et_country.text.toString())
        }
    }

    private fun addObserver(){
        viewModel.weatherState.observe(this, Observer {
            it ?: return@Observer
            val state = it.getContentIfNotHandled() ?: return@Observer

            if (state is NetworkState.Loading) {
                progress_bar.visibility = View.VISIBLE
                return@Observer
            }
            progress_bar.visibility = View.GONE
            when(state) {
                is NetworkState.Success -> {
                    val weatherState = state.data
                    weatherState ?: return@Observer
                    tv_temp.append(weatherState.main?.temp.toString())

                }
                is NetworkState.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_LONG).show()
                }
                is NetworkState.Failure -> {
                    Toast.makeText(this, state.throwable.toString(), Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "Network Error", Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}
