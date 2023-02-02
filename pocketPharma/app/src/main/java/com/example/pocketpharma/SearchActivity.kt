package com.example.pocketpharma

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.pocketpharma.SULKApi.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


var suklId  = "sukl1ID"



class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val APIButton = findViewById<Button>(R.id.apiButton)
        val SaveButton = findViewById<Button>(R.id.buttonSave)

        val textResultid = findViewById<TextView>(R.id.textResultid)
        val textResultKodLatky = findViewById<TextView>(R.id.textResultKodLatky)
        val textResultNazevInn = findViewById<TextView>(R.id.textResultNazevInn)
        val textResultNazevEn = findViewById<TextView>(R.id.textResultNazevEn)
        val textResultNazev = findViewById<TextView>(R.id.textResultNazev)
        val suklIdInput = findViewById<EditText>(R.id.suklIdInput)

        suklIdInput.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                  suklId = s.toString()

            }
        })


        APIButton.setOnClickListener {

            val filter = "{\"where\":{\"KOD_LATKY\":"+ suklId+"}}"
            val call = apiService.getData(filter)
            if (call != null) {
                call.enqueue(object : Callback<SUKLProperty> {
                    override fun onResponse(call: Call<SUKLProperty>, response: Response<SUKLProperty>) {
                        Log.d("Retrofit","apicalled")
                        if (response.isSuccessful) {
                            // Do something with the response data
                            val data = response.body()
//                            if(textResult != null && data != null){
                            if(data != null){
                                val firstItem = data.data[0]
                                textResultid.text = firstItem.id
                                textResultKodLatky.text = firstItem.KOD_LATKY
                                textResultNazevInn.text = firstItem.NAZEV_INN
                                textResultNazevEn.text = firstItem.NAZEV_EN
                                textResultNazev.text = firstItem.NAZEV
                            }



                            Log.d("Retrofit", suklId)
                            Log.d("Retrofit",data.toString())
                        } else {
                            val error = response.errorBody()
                            val data = response.body()
                            if (error != null) {
                                Log.d("Retrofit",error.string())
                                Log.d("Retrofit",filter.toString())
                                Log.d("Retrofit",data.toString())

                            }}
                    }

                    override fun onFailure(call: Call<SUKLProperty>, t: Throwable) {
                        // Handle failure

                        Log.d("Retrofit",t.message.toString())
                    }
                })
            }


            SaveButton.setOnClickListener {
//                private val recordViewModel: recordViewModel by viewModels {
//                    recordViewModelFactory((application as pocketPharmaApplication).repository)
//                }
//                var recordDAO = database.recordDAO()
//                var record = Record(11,textResultid.toString(),textResultKodLatky.toString(),textResultNazevInn.toString(),textResultNazevEn.toString(),textResultNazev.toString())
//                recordDAO.insert(record)
            }
        }


        }
    }



