package com.example.rma23_19084_projekat

import android.content.res.Configuration
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navArgument
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeActivity : AppCompatActivity() {
    //kreiram instance fragmenata
    lateinit var homeFragment: HomeFragment
    lateinit var gameDetailsFragment: GameDetailsFragment
     var clicked = false

//ne moram postavljati koji je home fragment jer je to definisano kada se u navigaciji dodaju

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        /* val orientation = resources.configuration.orientation
         if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
             setContentView(R.layout.activity_home_landscape)
         } else {
            setContentView(R.layout.activity_home)
         }*/

        // val screenOrient = resources.configuration.orientation
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_home)
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_home) as NavHostFragment  //nasli smo fragment u xml i castali ga u NavHost
            val navController = navHostFragment.navController
            //navController.setGraph(R.navigation.navgame)
            //val navController = Navigation.findNavController(this, R.id.nav_host_fragment) //uzimamo njegov kontroler
            // navHostFragment.navController.setGraph(R.navigation.navgame)

            //  navController.navigate(R.id.homeFragment)
            //inicijaliziram fragmente:
            // homeFragment = HomeFragment()
            //gameDetailsFragment = GameDetailsFragment()

//inicijalizacija mora biti drukcija jer vise nisu navHost, jer ne zelim da mii se sve prikazuje u jednom containeru, zbog ladnscape-a
            val navHostFragmentDetails =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_details) as NavHostFragment  //nasli smo fragment u xml i castali ga u NavHost

            val navControllerDetails =navHostFragmentDetails.navController //uzimamo njegov kontroler
            //navHostFragmentDetails.navController.setGraph(R.navigation.navgame)
            //inicijalno prikazujemo nultu igricu
            //setupam navhost containers sa odgovarajucim fragmentima


            navControllerDetails.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", GameData.getAll()[0].title) })

        }
        else {
            setContentView(R.layout.activity_home)

            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment //nasli smo fragment u xml i castali ga u NavHost

            val navController = navHostFragment.navController //uzimamo njegov kontroler
            val navigationView: BottomNavigationView =
                findViewById(R.id.bottom_nav)  //casta se u bottmnacigationview

            //nasli smo bottomnavigation
            navigationView.setupWithNavController(navController)  //povezujemo ga sa kontrolerom
            navController.navigate(R.id.homeFragment)  //PROVJERITI - radi!
            //inicijaliziram fragmente:
            homeFragment = HomeFragment()
            gameDetailsFragment = GameDetailsFragment()

            //  val currentFragment = navHostFragment.childFragmentManager.fragments.get(0)

            navController.addOnDestinationChangedListener(object :
                NavController.OnDestinationChangedListener {
                override fun onDestinationChanged(
                    controller: NavController,
                    destination: NavDestination,
                    @Nullable arguments: Bundle?
                ) {
                    if (destination.id == R.id.homeFragment) {
                        navigationView.menu.findItem(R.id.gameDetailsItem).isEnabled = false
                        navigationView.menu.findItem(R.id.homeItem).isEnabled = false
                        if (clicked) {
                            navigationView.menu.findItem(R.id.gameDetailsItem).isEnabled = true
                            val details = navigationView.menu.findItem(R.id.gameDetailsItem)
                            details.setOnMenuItemClickListener {
                                // findNavController(R.id.gameDetailsFragment).navigate(R.id.action_gameDetailsFragment_to_homeFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                                //  navController.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                                //val title:String = "Minecraft"var receivedTitle:String = requireArguments().getString("game_title").toString()
                                navController.navigate(R.id.gameDetailsFragment, Bundle().apply {
                                    putString(
                                        "game_title",
                                       arguments?.getString("game_title")
                                    )
                                })
                                true
                            }
                        }

                    } else {
                        navigationView.menu.findItem(R.id.gameDetailsItem).isEnabled = false
                        navigationView.menu.findItem(R.id.homeItem).isEnabled = true
                        val home = navigationView.menu.findItem(R.id.homeItem)
                        // home.setOnMenuItemClickListener { home -> {findNavController().navigate(R.id.action_gameDetailsFragment_to_homeFragment)} }
                        home.setOnMenuItemClickListener {
                            // findNavController(R.id.gameDetailsFragment).navigate(R.id.action_gameDetailsFragment_to_homeFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                            //  navController.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                            clicked = true
                            navController.navigate(
                                R.id.homeFragment,
                                Bundle().apply {
                                    putString(
                                        "game_title",
                                        arguments?.getString("game_title")
                                    )
                                })
                            //ne treba gameDetailsFragment ispred!
                            true
                        }
                    }
                }
            })
        }
    }

    //ova metoda se koristi ukoliko se rucno zeli rukovati prelazom iz portrait u landscape i obrnuto, no efikasnije je implementirana varijanta
/*
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //navhost2
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment //nasli smo fragment u xml i castali ga u NavHost

        val navController = navHostFragment.navController //uzimamo njegov kontroler



        //inicijaliziram fragmente:
        homeFragment = HomeFragment()
        gameDetailsFragment = GameDetailsFragment()

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_home_landscape)

            //navhost2
            val navHostFragmentDetails =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment_details) as NavHostFragment //nasli smo fragment u xml i castali ga u NavHost

            val navControllerDetails = navHostFragmentDetails.navController //uzimamo njegov kontroler

            //inicijalno prikazujemo nultu igricu
            //setupam navhost containers sa odgovarajucim fragmentima
            navController.navigate(R.id.homeFragment)
            navControllerDetails.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", GameData.getAll().get(0).title) })

        }

        else{
            setContentView(R.layout.activity_home)
            val navigationView: BottomNavigationView = findViewById(R.id.bottom_nav)  //casta se u bottmnacigationview

            //nasli smo bottomnavigation
            navigationView.setupWithNavController(navController)  //povezujemo ga sa kontrolerom

            navController.addOnDestinationChangedListener(object :
                NavController.OnDestinationChangedListener {
                override fun onDestinationChanged(
                    controller: NavController,
                    destination: NavDestination,
                    @Nullable arguments: Bundle?
                ) {
                    if (destination.id == R.id.homeFragment) {
                        navigationView.menu.findItem(R.id.gameDetailsItem).isEnabled = false
                        navigationView.menu.findItem(R.id.homeItem).isEnabled = false
                        if(arguments!=null) {
                            navigationView.menu.findItem(R.id.gameDetailsItem).isEnabled = true
                            val details = navigationView.menu.findItem(R.id.gameDetailsItem)
                            details.setOnMenuItemClickListener {
                                // findNavController(R.id.gameDetailsFragment).navigate(R.id.action_gameDetailsFragment_to_homeFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                                //  navController.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                                //val title:String = "Minecraft"var receivedTitle:String = requireArguments().getString("game_title").toString()
                                navController.navigate(R.id.gameDetailsFragment, Bundle().apply {
                                    putString(
                                        "game_title",
                                        arguments?.getString("game_title")
                                    )
                                })
                                true
                            }
                        }

                    }
                    else {
                        navigationView.menu.findItem(R.id.gameDetailsItem).isEnabled = false
                        navigationView.menu.findItem(R.id.homeItem).isEnabled = true
                        val home = navigationView.menu.findItem(R.id.homeItem)
                        // home.setOnMenuItemClickListener { home -> {findNavController().navigate(R.id.action_gameDetailsFragment_to_homeFragment)} }
                        home.setOnMenuItemClickListener {
                            // findNavController(R.id.gameDetailsFragment).navigate(R.id.action_gameDetailsFragment_to_homeFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })
                            //  navController.navigate(R.id.gameDetailsFragment, Bundle().apply { putString("game_title", gameDetailsFragment.arguments.toString()) })

                            navController.navigate(R.id.homeFragment, Bundle().apply { putString("game_title", arguments?.getString("game_title") )})
                            //ne treba gameDetailsFragment ispred!
                            true
                        }
                    }
                }
            })

        }
    }

*/

}




