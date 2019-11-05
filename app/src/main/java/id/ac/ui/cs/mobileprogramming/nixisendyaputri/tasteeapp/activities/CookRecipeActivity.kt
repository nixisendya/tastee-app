package id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.nixisendyaputri.tasteeapp.R
import kotlinx.android.synthetic.main.activity_cookrecipe.*
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_cook_time
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_difficulty
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_image_title
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_prep_time
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_preptime
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_rating
import kotlinx.android.synthetic.main.fragment_recipedetail.card_view_servings

class CookRecipeActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cookrecipe)
        val intImage: Int = Integer.parseInt(intent.getStringExtra("Image"))

        val strName: String = intent.getStringExtra("Name")
        val strRating: String = intent.getStringExtra("Rating")
        val strTotalTime: String = intent.getStringExtra("TotalTime")
        val strDifficulty: String = intent.getStringExtra("Difficulty")
        val strServings: String = intent.getStringExtra("Servings")
        val strPrepTime: String = intent.getStringExtra("PrepTime")
        val strCookTime: String = intent.getStringExtra("CookTime")

        card_view_image.setImageResource(intImage)
        card_view_image_title.text = strName
        card_view_rating.text = strRating
        card_view_preptime.setText(strTotalTime)
        card_view_difficulty.setText(strDifficulty)
        card_view_servings.setText(strServings)
        card_view_prep_time.setText(strPrepTime)
        card_view_cook_time.setText(strCookTime)

        //BUTTON CLICK
        button_add_photo_from_gallery.setOnClickListener {
            //check runtime permission
            if (VERSION.SDK_INT >= VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }


    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size >0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            image_placeholder.setImageURI(data?.data)
        }
    }




}