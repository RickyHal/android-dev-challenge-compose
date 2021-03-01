/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.entities.Pet
import com.example.androiddevchallenge.ui.public.AppBar
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes

class MainActivity : AppCompatActivity() {
    private val petList = ArrayList<Pet>().apply {
        add(Pet(0,
            "银渐层",
            1f,
            "boy",
            R.drawable.cat1,
            "英短银渐层是由英国短毛猫（蓝灰色）与金吉拉猫繁育而出的英短品种色，具备了金吉拉猫白色的毛色，又具备了英国短毛猫重要的特征。在银渐层的繁育过程中，出现了毛色为点状色的金点、银点、金渐层、蓝金渐层等。"))
        add(Pet(1,
            "美短银虎斑",
            2f,
            "girl",
            R.drawable.cat2,
            "美国银虎斑猫是一种贵族猫，为银、黑为主体颜色。此猫不是我们常见的黑白土猫，而是从美国虎斑猫培育出来的猫种。美国虎斑猫有黄虎斑、金虎斑、黑虎斑、红虎斑等品种 。 美国银虎斑性格友好、善良、非常需要我们的关注和轻柔的抚摸。 美短是一种真正的工作品种的猫，它的整体结构非常适和工作，并没有解剖上夸大的养育缺点。一般来说它应该给人一种身体强壮，平衡良好，身体结实且比例匀称，良好的忍耐力和敏捷度。性格乖巧且通人性。美国短毛猫是美国特有的品种，它的祖先来自欧洲，跟随早期的开拓者进入北美洲。有纪录显示在《5月花号》上饲养了数头猫儿，它们的职责就是捕捉船上那些偷食物及传播病菌的老鼠。经过不断的繁殖，最终建立了土生的北美洲短毛猫。"))
        add(Pet(2,
            "金渐层",
            1f,
            "boy",
            R.drawable.cat3,
            "通常人们说的金渐层，指的是英国短毛猫里面的一个稀有色，即金渐层色。金渐层是一种颜色，而不是一个品种，这一点常常被误解。\n" +
                    "英短金渐层是由英短蓝猫改良而来，它体形圆胖，四肢粗短发达，毛短而密，头大脸圆，性格极为友善温柔，极易饲养。它在保留了英短蓝猫的粗壮可爱的体态和大脸之外，还演化出更加迷人的绿色或蓝绿色大圆眼睛，虎头虎脑，更加很让人们喜爱。颜色包括金色、蓝金色、金点色、蓝金点色，黑金色，也有银色、银点色等等。（例图为蓝金渐层）\n" +
                    "金渐层被很多人称为“土豪金”，也被称作是“招财猫”。"))
        add(Pet(3,
            "狸花猫",
            1.5f,
            "girl",
            R.drawable.cat4,
            "\"中华田园猫\"是对中国本土家猫类的统称。多用于驱赶老鼠，保护农作物，现如今也多作为宠物。"))
        add(Pet(4,
            "豹猫",
            2f,
            "girl",
            R.drawable.cat5,
            "豹猫（学名：Prionailurus bengalensis）是猫科、豹猫属动物。头体长360-660毫米；尾长200-370毫米；后足长80-130毫米；耳长35-55毫米；颅全长75-96毫米；体重1.5-5千克。豹猫在中国也被称作“钱猫”，因为其身上的斑点很像中国的铜钱。体型和家猫相仿，但更加纤细，腿更长。南方种的毛色基调是淡褐色或浅黄色，而北方的毛基色显得更灰且周身有深色的斑点。体侧有斑点，但从不连成垂直的条纹。明显的白色条纹从鼻子一直延伸到两眼间，常常到头顶。耳大而尖，耳后黑色，带有白斑点。两条明显的黑色条纹从眼角内侧一直延伸到耳基部。内侧眼角到鼻部有一条白色条纹，鼻吻部白色。尾长（大约是头体长的40-50%），有环纹，至黑色尾尖。"))
        add(Pet(5,
            "暹罗猫",
            1f,
            "boy",
            R.drawable.cat6,
            "暹（xiān）罗猫是世界著名的短毛猫，也是短毛猫的代表品种。种族原产于暹罗（今泰国），故名暹罗猫。在200多年前，这种珍贵的猫仅在泰国的皇宫和大寺院中饲养，是足不出户的贵族。暹罗猫能够较好适应主人当地的气候，且性格刚烈好动，机智灵活，好奇心特强，善解人意。"))
        add(Pet(6,
            "犬猫",
            3f,
            "boy",
            R.drawable.cat7,
            "我是一只猫"))
        add(Pet(7,
            "英短",
            1f,
            "girl",
            R.drawable.cat8,
            "我是一只英短猫"))
        add(Pet(8,
            "困猫",
            2.5f,
            "girl",
            R.drawable.cat9,
            "我是一只困猫"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = getPets()
        setContent {
            MyTheme {
                MyApp(dataSource){
                    val intent = Intent(this,DetailActivity::class.java)
                    intent.putExtra(DetailActivity.KEY_PET,it)
                    startActivity(intent)
                }
            }
        }
    }

    private fun getPets(): ArrayList<Pet> {
        val dataSource = ArrayList<Pet>()
        repeat(10) { index ->
            if (index % 2 == 0) {
                dataSource.addAll(petList)
            } else {
                dataSource.addAll(petList.reversed())
            }
        }
        return dataSource
    }
}

// Start building your app here!
@Composable
fun MyApp(dataSource: List<Pet>,onItemClick:(Pet)->Unit) {
    LazyColumn {
        item { AppBar("Welcome to Cat House") }
        items(dataSource) { pet ->
            Row(Modifier.clickable { onItemClick(pet)}) {
                Image(painter = painterResource(id = pet.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp)
                        .clip(shapes.small),
                    contentScale = ContentScale.Crop)
                Column {
                    Text(
                        text = pet.name,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp
                            )
                            .wrapContentWidth(Alignment.Start),
                        maxLines = 1
                    )
                    Text(
                        text = pet.description,
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 16.dp,
                                top = 8.dp,
                                end = 16.dp,
                                bottom = 8.dp
                            )
                            .wrapContentWidth(Alignment.Start),
                        color = Color.Gray,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 2
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
        item {
            Text(text = "There is no more cats...",
                color = Color.Gray,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.CenterVertically),
                textAlign = TextAlign.Center)
        }
    }
}
//@Preview("Light Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun LightPreview() {
//    MyTheme {
//        MyApp()
//    }
//}
//
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}
