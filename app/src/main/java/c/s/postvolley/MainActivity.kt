package c.s.postvolley

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.*
import com.android.volley.Request.Method.POST
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject





class MainActivity : AppCompatActivity() {
    var rq: RequestQueue? = null
    var stringreq: StringRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "blhr", Toast.LENGTH_LONG).show()
        rq = Volley.newRequestQueue(this)
        Log.e("first", "point8")
        button.setOnClickListener {
            Toast.makeText(this, "asfasf", Toast.LENGTH_LONG).show()
            Log.e("first", "point9")
            post_data()

        }
    }

    fun post_data() {

        val name = name.text
        val mjob = job.text
        Log.e("first", "point1")
        val url = "https://reqres.in/api/users"
        var jsonBody = JSONObject()
       // jsonBody.put("name", name)
        //jsonBody.put("job", mjob)
       // val body = jsonBody.toString()
        stringreq = object : StringRequest(Request.Method.POST, url, Response.Listener<String> { response ->
            val parser = JSONObject(response)
            Log.e("first", "point2")
            Log.e("response", response)
            val nm = parser.getString("name")
            val jb = parser.getString("position")
            val id = parser.getString("id")
            val date = parser.getString("createdAt")
            xjb.text = nm
            xnm.text = jb
            Log.e("first", "point3")
            Log.e("resp", id)
            Log.e("resp", date)
        }, Response.ErrorListener { error ->
            Log.e("Volley Error: ", error.toString())
        }) {
            override fun getParams(): Map<String, String> {
                //Creating HashMap
                val params = HashMap<String, String>()

                Log.e("first", "point4")
                params["name"] = name.toString()
                params["position"] = mjob.toString()


                return params
            }

        }
        Log.e("first", "point5")




        rq!!.add(stringreq)
        Log.e("first","point7")

    }
}
