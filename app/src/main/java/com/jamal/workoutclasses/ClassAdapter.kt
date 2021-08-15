package com.jamal.workoutclasses


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ClassAdapter(private val mContacts: List<ClassItems>) : RecyclerView.Adapter<ClassAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val class_name = itemView.findViewById<TextView>(R.id.class_name)
        val classlayout = itemView.findViewById<LinearLayout>(R.id.classlayout)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassAdapter.ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.recyclerview_adapter, parent, false)
        return ViewHolder(contactView)
    }


    override fun onBindViewHolder(viewHolder: ClassAdapter.ViewHolder, position: Int) {

        val contact: ClassItems = mContacts.get(position)
        val class_name = viewHolder.class_name
        class_name.setText(contact.className)
        val classlayout = viewHolder.classlayout



        classlayout.setOnClickListener {


            viewHolder.apply {
                with(viewHolder.itemView) {

                    val action = ListFragmentDirections.actionListFragmentToDetailsFragment(contact.className, contact.startsAt, contact.endsAt, contact.duration, contact.lang, contact.category, contact.picture)
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