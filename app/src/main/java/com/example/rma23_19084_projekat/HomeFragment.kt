package com.example.rma23_19084_projekat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater


import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.content.BroadcastReceiver

import android.content.IntentFilter
import android.content.res.Configuration
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment: Fragment() {
    private lateinit var gamesView: RecyclerView
    private lateinit var gamesAdapter: ArrayAdapterHome
    private var gamesList = GameData.getAll()

    override fun onCreateView(  //kreiramo pogled za fragment
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(
            R.layout.fragment_home, container,  //inflateamo odgovarajuci xm file
            false  //ovo ce android da odradi za nas
        )

        gamesView = view.findViewById(R.id.game_list) //moram mu pristupiti preko view koji sam kreirala u onCreateView
        gamesView.layoutManager = GridLayoutManager(activity,1)

       var receivedTitle:String = requireArguments().getString("game_title").toString()

       if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_details) as NavHostFragment
            val navController = navHostFragment.navController
            gamesAdapter =
                ArrayAdapterHome(gamesList) { game -> //findNavController().currentDestination?.id = R.id.homeFragment
                    navController.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", game.title) })
                }
           //potrebno je odrediti navcontroller u ovom slucaju
        }
        else {


            gamesAdapter =
                ArrayAdapterHome(gamesList) { game -> //findNavController().currentDestination?.id = R.id.homeFragment
                    findNavController().navigate(
                        R.id.gameDetailsFragment,
                        Bundle().apply { putString("game_title", game.title) })
                }
        }

       // findNavController().currentDestination?.id = R.id.homeFragment
        gamesView.adapter = gamesAdapter  //adapter umjesto setAdapter
        val message = "Hello, world!"
        //val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(message)
        //button.setOnClickListener(Navigation.createNavigateOnClickListener(action))

        return view
    }




    private fun getGameByTitle(title: String): Game{
        var game: Game
        game = gamesList.find { game -> title==game.title }!!
        return game?:Game("","","",0.0,"","", "", "", "", "", listOf())
        //elvis operator - default rijednost ako je null je u zagradi
    }

}