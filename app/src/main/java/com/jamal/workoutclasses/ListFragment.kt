package com.jamal.workoutclasses

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class ListFragment : Fragment(R.layout.listfragmet_layout) {


    private var classadapter: ClassAdapter? = null
    lateinit var classitem: ArrayList<ClassItems>
    private var requestQueue: RequestQueue? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView = view.findViewById(R.id.classes_recycleView)
        classitem = ClassItems.createClassList()
        classadapter = ClassAdapter(classitem)
        recyclerView.adapter = classadapter
        recyclerView.layoutManager = LinearLayoutManager(getActivity())

        requestQueue = Volley.newRequestQueue(getActivity())

        requestAPI()


    }


    private fun requestAPI() {

        val url = "https://public-api.buddyfit.club/api/v1/classes/"
        val request = JsonObjectRequest(Request.Method.GET, url, null, { response ->

            try {

                val jsonArray = response.getJSONArray("data")
                for (i in 0 until jsonArray.length()) {


                    val employee = jsonArray.getJSONObject(i)
                    val firstName = employee.getString("type")
                    val age = employee.getString("_id")

                    val attributes = jsonArray.getJSONObject(i).getJSONObject("attributes")

                    val className = attributes.getString("name")
                    val startsAt = attributes.getString("startsAt")
                    val endsAt = attributes.getString("endsAt")
                    val duration = attributes.getString("duration")
                    val language = attributes.getString("lang")
                    val category = attributes.getString("category")
                    val picture = attributes.getString("listPictureUrl")


                    classitem.add(i, ClassItems(className, startsAt, endsAt, duration, language, category, picture))
                    classadapter?.notifyItemInserted(i)

                }


            } catch (e: JSONException) {
                e.printStackTrace()

                Log.d("Error", e.printStackTrace().toString())

            }
        }, { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }


}
