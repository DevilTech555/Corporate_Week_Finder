package com.dk24.corporateweekfinder.utilites

import android.app.Activity
import android.widget.Toast

fun Activity.ShowToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,message, duration).show()
}
