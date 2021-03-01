package com.example.androiddevchallenge.entities

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Pet(
    val id:Int,
    val name:String,
    val age:Float,
    val gender:String,
    @DrawableRes
    val photo:Int,
    val description:String
):Serializable
