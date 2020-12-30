package com.thirkazh.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_tambah.setOnClickListener {
            validasi(edt_awal.text.toString(), edt_akhir.text.toString(),"+")
        }

        btn_kurang.setOnClickListener {
            validasi(edt_awal.text.toString(), edt_akhir.text.toString(),"-")
        }

        btn_kali.setOnClickListener {
            validasi(edt_awal.text.toString(), edt_akhir.text.toString(),"x")
        }

        btn_bagi.setOnClickListener {
            validasi(edt_awal.text.toString(), edt_akhir.text.toString(),":")
        }
    }

    fun validasi(awal : String, akhir : String, operator : String) {

        if (awal.isEmpty() || akhir.isEmpty()){
            Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
        }
        else{
            kalkulasi(awal.toDouble(),akhir.toDouble(),operator)
        }
    }

    fun kalkulasi(awal: Double, akhir: Double, operator: String){

        var hasil : Double? = null

        when(operator){
            "+" -> hasil = awal + akhir
            "-" -> hasil = awal - akhir
            "x" -> hasil = awal * akhir
            ":" -> hasil = awal / akhir
        }

        tv_hasil.text = hasil.toString()
    }
}
