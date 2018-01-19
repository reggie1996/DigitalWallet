package com.reggie.digitalwallet.Test

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoActivity
import com.jph.takephoto.model.InvokeParam
import com.jph.takephoto.model.TResult
import com.jph.takephoto.permission.InvokeListener
import com.jph.takephoto.permission.PermissionManager
import com.reggie.digitalwallet.Activity.MainActivity
import com.reggie.digitalwallet.Activity.QRCodeActivity
import com.reggie.digitalwallet.R
import com.reggie.digitalwallet.Utils.QRCodeGenerator
import kotlinx.android.synthetic.main.activity_test.*
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.permission.TakePhotoInvocationHandler
import com.jph.takephoto.permission.PermissionManager.TPermissionType
import com.jph.takephoto.model.TContextWrap
import com.reggie.digitalwallet.Activity.WebActivity


class TestActivity : Activity() , TakePhoto.TakeResultListener, InvokeListener {

    private val TAG = TakePhotoActivity::class.java.name
    private var takePhoto: TakePhoto? = null
    private var invokeParam: InvokeParam? = null



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this)
    }

    override fun takeSuccess(result: TResult?) {
        val path = result?.getImage()?.getCompressPath()
        Toast.makeText(this, path, Toast.LENGTH_LONG).show()
        //Log.i(TAG,"takeSuccess：" + result?.getImage()?.getCompressPath());
    }

    override fun takeCancel() {
        Toast.makeText(this, "取消", Toast.LENGTH_LONG).show()
    }

    override fun takeFail(result: TResult?, msg: String?) {
        Toast.makeText(this, "失败" + msg, Toast.LENGTH_LONG).show()
    }

    override fun invoke(invokeParam: InvokeParam?): PermissionManager.TPermissionType {
        val type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam!!.getMethod())
        if (TPermissionType.WAIT == type) {
            this.invokeParam = invokeParam
        }
        return type
    }

    /**
     *
     * 获取TakePhoto实例
     *
     * @return
     */

    fun getTakePhoto(): TakePhoto? {
        if (takePhoto == null) {
            takePhoto = TakePhotoInvocationHandler.of(this).bind(TakePhotoImpl(this, this)) as TakePhoto
        }
        return takePhoto
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        getTakePhoto()?.onCreate(savedInstanceState)
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

        buttonchoosephoto.setOnClickListener{ takePhoto?.onPickFromDocuments()}

        buttonweb.setOnClickListener {  startActivity(Intent(this, WebActivity::class.java)) }

        buttonface.setOnClickListener { startActivity(Intent(this, com.reggie.digitalwallet.ArcFace.MainActivity::class.java)) }

        buttonpager.setOnClickListener { startActivity(Intent(this, PagerActivity::class.java))  }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        getTakePhoto()?.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        getTakePhoto()?.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1 ->{
                Toast.makeText(this,data?.getStringExtra("result"),Toast.LENGTH_LONG).show()
            }
        }
    }
}
