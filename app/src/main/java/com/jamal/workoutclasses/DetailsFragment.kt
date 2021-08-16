package com.jamal.workoutclasses


import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment(R.layout.detailsfragment_layout) {


    private lateinit var className: TextView
    private lateinit var startsAt: TextView
    private lateinit var endsAt: TextView
    private lateinit var duration: TextView
    private lateinit var lang: TextView
    private lateinit var category: TextView
    private lateinit var picture: ImageView
    private lateinit var trainerFullName: TextView
    private lateinit var trainerProfilePicture: ImageView

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val className: TextView = view.findViewById(R.id.className)
        val startsAt: TextView = view.findViewById(R.id.startsAt)
        val endsAt: TextView = view.findViewById(R.id.endsAt)
        val duration: TextView = view.findViewById(R.id.duration)
        val lang: TextView = view.findViewById(R.id.lang)
        val category: TextView = view.findViewById(R.id.category)
        val picture: ImageView = view.findViewById(R.id.picture)
        val trainerFullName: TextView = view.findViewById(R.id.trainerFullName)
        val trainerProfilePicture: ImageView = view.findViewById(R.id.trainerProfilePicture)

        Picasso.get().load(args.picture).into(picture);

        className.text = args.className
        startsAt.text = args.startsAt
        endsAt.text = args.endsAt
        duration.text = args.duration
        lang.text = args.lang
        category.text = args.category

        Picasso.get().load(args.trainerProfilePicture).into(trainerProfilePicture);
        trainerFullName.text = args.trainerFullName


    }

}