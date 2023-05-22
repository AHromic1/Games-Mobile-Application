package com.example.rma23_19084_projekat

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GameDetailsFragment : Fragment() {
    private lateinit var commentsView: RecyclerView
    private lateinit var customAdapter: AdaptersGameDetails
    private var gamesList = GameData.getAll()
    private lateinit var game: Game
    private lateinit var sortedComments: List<UserImpression>
    private lateinit var gameTitle: TextView
    private lateinit var coverImage: ImageView
    private lateinit var platform: TextView
    private lateinit var esbrRating: TextView
    private lateinit var developer: TextView
    private lateinit var publisher: TextView
    private lateinit var genre: TextView
    private lateinit var description: TextView
    private lateinit var releaseDate: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =
            inflater.inflate(R.layout.fragment_game_details, container, false)  //inflaetam fragment

        //pronalazimo sve elemente

        gameTitle = view.findViewById(R.id.item_title_textview)
        coverImage = view.findViewById(R.id.cover_imageview)
        platform = view.findViewById(R.id.platform_textview)
        esbrRating = view.findViewById(R.id.esrb_rating_textview)
        developer = view.findViewById(R.id.developer_textview)
        publisher = view.findViewById(R.id.publisher_textview)
        genre = view.findViewById(R.id.genre_textview)
        description = view.findViewById(R.id.description_textview)
        releaseDate = view.findViewById(R.id.release_date_textview)

        commentsView = view.findViewById(R.id.comments_list)
        commentsView.layoutManager = GridLayoutManager(activity,1)

        var receivedTitle:String = requireArguments().getString("game_title").toString()
        game = getGameByTitle(receivedTitle) //prima title iz  i nalazi odgovarajucu game
        populateDetails()  //punimo sve detalje i views s onima iz pronadjene igre
        //game je ona koju sam dobile preko game title - moram ga sada preuzeti
        sortedComments = game.userImpressions.sortedByDescending { it.timestamp }
        customAdapter=AdaptersGameDetails(sortedComments)
        commentsView.adapter = customAdapter


        //receivedTitle saljem nazad u home
        // findNavController().navigate(R.id.action_gameDetailsFragment_to_homeFragment, Bundle().apply { putString("game_title",receivedTitle) })

        /*commentsView = findViewById(R.id.comments_list)
    commentsView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)*/
        return view
    }

    private fun getGameByTitle(title: String): Game{
        game = gamesList.find { game -> title==game.title }!!
        return game?:Game("","","",0.0,"","", "", "", "", "", listOf())
        //elvis operator - default vrijednost ako je null je u zagradi
    }

    private fun populateDetails(){
        gameTitle.text = game.title
        coverImage.setImageURI(Uri.parse(game.coverImage))
        platform.text = game.platform
        releaseDate.text = game.releaseDate
        esbrRating.text = game.esrbRating
        developer.text = game.developer
        publisher.text = game.publisher
        genre.text = game.genre
        description.text = game.description
    }
}