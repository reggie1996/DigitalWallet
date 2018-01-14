package com.reggie.digitalwallet.Test

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.reggie.digitalwallet.Activity.MainActivity
import com.reggie.digitalwallet.Activity.QRCodeActivity
import com.reggie.digitalwallet.R
import com.reggie.digitalwallet.Utils.QRCodeGenerator
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        buttonmain.setOnClickListener{startActivity(Intent(this, MainActivity::class.java))}
        buttonqrcode.setOnClickListener { startActivityForResult(Intent(this, QRCodeActivity::class.java),1) }
        buttonqrcode2.setOnClickListener{
            //生成二维码
            val bitmap : Bitmap =  QRCodeGenerator.createQRCode("www.baidu.com",800)
            Glide.with(this).load(bitmap).into(qrcode)
        };
        buttonsfz.setOnClickListener { startActivity(Intent(this, SFZActivity::class.java)) }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            1 ->{
                Toast.makeText(this,data?.getStringExtra("result"),Toast.LENGTH_LONG).show()
            }
        }
    }
}
