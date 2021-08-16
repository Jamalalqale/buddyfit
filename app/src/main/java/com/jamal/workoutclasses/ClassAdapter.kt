package com.jamal.workoutclasses


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ClassAdapter(private val mContacts: List<ClassItems>) : RecyclerView.Adapter<ClassAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val class_name = itemView.findViewById<TextView>(R.id.class_name)
        val classlayout = itemView.findViewById<LinearLayout>(R.id.classlayout)
        val backgraounImage = itemView.findViewById<ImageView>(R.id.backgraounImage)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassAdapter.ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val classtView = inflater.inflate(R.layout.recyclerview_adapter, parent, false)
        return ViewHolder(classtView)
    }


    override fun onBindViewHolder(viewHolder: ClassAdapter.ViewHolder, position: Int) {

        val classItems: ClassItems = mContacts.get(position)
        val class_name = viewHolder.class_name
        val classlayout = viewHolder.classlayout
        val backgraounImage = viewHolder.backgraounImage

        class_name.setText(classItems.className)
        Picasso.get().load(classItems.picture).into(backgraounImage);




        classlayout.setOnClickListener {


            viewHolder.apply {
                with(viewHolder.itemView) {

                    val action = ListFragmentDirections.actionListFragmentToDetailsFragment(classItems.className,
                            classItems.startsAt,
                            classItems.endsAt,
                            classItems.duration,
                            classItems.lang,
                            classItems.category,
                            classItems.picture,
                            classItems.trainerFullName,
                            classItems.trainerProfilePicture)
                    findNavController().navigate(action)


                }

            }


        }


    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mContacts.size
    }
}