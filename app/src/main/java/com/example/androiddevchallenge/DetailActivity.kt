package com.example.androiddevchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.entities.Pet
import com.example.androiddevchallenge.ui.public.AppBar
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes

class DetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_PET = "key_pet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pet = intent.getSerializableExtra(KEY_PET) as? Pet
        if (pet == null) {
            Toast.makeText(this, "This pet doesn't exist!!!", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        setContent {
            MyTheme {
                PetIntroduce(pet) {
                    Toast.makeText(this,
                        "Congratulations!!! You have got the pet ${pet.name}",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

@Composable
fun PetIntroduce(pet: Pet, onAdopt: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.matchParentSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { AppBar(pet.name) }
            item {
                Image(painter = painterResource(id = pet.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    contentScale = ContentScale.Crop)
            }
            item {
                Text(text = "Cat Name: ${pet.name}", modifier = Modifier.padding(10.dp))
                Text(text = "Gender: ${pet.gender}", modifier = Modifier.padding(10.dp))
                Text(text = "Age: ${pet.age} years old", modifier = Modifier.padding(10.dp))
                Text(text = "Description:", modifier = Modifier.padding(10.dp))
            }
            item {
                Text(text = pet.description, style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp,bottom=100.dp)
                        .wrapContentWidth(Alignment.Start),
                    color = Color.Gray
                )
            }
        }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 20.dp)){
            FloatingActionButton(onClick = onAdopt,
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))) {
                Text(
                    text = "Adopt ${if (pet.gender == "boy") "him" else "her"}",
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 60.dp, end = 60.dp)
                )
            }
        }
    }
}
