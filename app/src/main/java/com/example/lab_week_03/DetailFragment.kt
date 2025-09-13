package com.example.lab_week_03

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    private val coffeeTitle: TextView?
        get() = view?.findViewById(R.id.coffee_title)

    private val coffeeDesc: TextView?
        get() = view?.findViewById(R.id.coffee_desc)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeId = arguments?.getInt(COFFEE_ID) ?: 0
        setCoffeeData(coffeeId)

        view.findViewById<Button>(R.id.back_button)?.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun setCoffeeData(id: Int) {
        when (id) {
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }
            R.id.cappuccino -> {
                coffeeTitle?.text = getString(R.string.cappuccino_title)
                coffeeDesc?.text = getString(R.string.cappuccino_desc)
            }
            R.id.mocha -> {
                coffeeTitle?.text = getString(R.string.mocha_title)
                coffeeDesc?.text = getString(R.string.mocha_desc)
            }
            else -> {
                coffeeTitle?.text = getString(R.string.coffee_list)
                coffeeDesc?.text = ""
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
        private const val TAG = "DetailFragment"
    }
}
