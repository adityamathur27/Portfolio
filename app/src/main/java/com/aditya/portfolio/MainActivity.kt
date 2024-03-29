package com.aditya.portfolio

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aditya.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White){
                    CreateBizCard()
                }
            }
        }
    }
}


@Composable
fun CreateBizCard(){
    val ButtonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()){
        Card(modifier = Modifier
            .height(390.dp)
            .width(200.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )
        ){
            Surface(modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
                .padding(8.dp),
                shape = RoundedCornerShape(50), color = Color.White , shadowElevation = 15.dp){
                Image(painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "Profile Image")

            }

            Divider(color = Color.LightGray, thickness = 2.dp)
            Column(modifier = Modifier.fillMaxWidth()){
                Text(text ="Aditya Mathur", fontSize = 30.sp, fontFamily = FontFamily.Serif, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Blue)
                Text(text = "Android Developer" , fontSize = 15.sp, fontFamily = FontFamily.Default, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black)

            }
            Button(modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(Color.Blue),
                onClick = {
                    ButtonClickedState.value = !ButtonClickedState.value;
                }) {
                Text("Portfolio", fontStyle = FontStyle.Normal, fontFamily = FontFamily.Serif, modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally), color = Color.White)
            }
            if(ButtonClickedState.value){
                ButtonClickfun()
            }

        }


    }
}
//@Preview(showBackground = true)
@Composable
fun ButtonClickfun(){
    val openURL = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult())
    { result ->        // Handle the returned result here if needed

    }
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .verticalScroll(scrollState)
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(3.dp),shape = RoundedCornerShape(CornerSize(10.dp)),border = BorderStroke(4.dp, color = Color.LightGray)) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(4.dp)) {
                Text(text = "ChatKaro App" , fontSize = 25.sp, fontFamily = FontFamily.Serif, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black)
                Text(text = "ChatKaro is a Chatting App made using Kotlin and Firebase" , fontSize = 13.sp, fontFamily = FontFamily.Default,modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Start),color = Color.Black)
                Text(text ="Features : ",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 13.sp, fontFamily = FontFamily.Serif, color = Color.Black)
                Text(text = "1. Login and Register using Email and Password",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "2. Developed a user-friendly chatting application in Android designed for day-to-day task management.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "3. Designed and implemented real-time chat functionality using Firebase Cloud Messaging (FCM).",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "Github Link : https://github.com/adityamathur27/Chat-Karo",modifier = Modifier
                    .absolutePadding(4.dp, 1.dp)
                    .clickable(enabled = true) {
                        openURL.launch(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/adityamathur27/Chat-Karo")
                            )
                        )
                    }, fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Blue)
                Divider(thickness = 1.dp , color = Color.Black,modifier = Modifier.absolutePadding(0.dp,4.dp))
                Text(text = "Portfolio App" , fontSize = 25.sp, fontFamily = FontFamily.Serif, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black)
                Text(text = "Portfolio is a Portfolio App made using Kotlin and Jetpack Compose" , fontSize = 13.sp, fontFamily = FontFamily.Default,modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Start),color = Color.Black)
                Text(text ="Features : ",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 13.sp, fontFamily = FontFamily.Serif, color = Color.Black)
                Text(text = "1. Designed and implemented a Portfolio App using Jetpack Compose.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "2. Developed a user-friendly Portfolio application in Android designed for day-to-day task management.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "3. Designed and implemented real-time chat functionality using Firebase Cloud Messaging (FCM).",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "Github Link :https://github.com/adityamathur27/Portfolio.git",modifier = Modifier
                    .absolutePadding(4.dp, 1.dp)
                    .clickable(enabled = true) {
                        openURL.launch(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/adityamathur27/Portfolio.git")
                            )
                        )
                    }, fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Blue)
                Divider(thickness = 1.dp , color = Color.Black,modifier = Modifier.absolutePadding(0.dp,4.dp))
                Text(text = "Sticky Notes App" , fontSize = 25.sp, fontFamily = FontFamily.Serif, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black)
                Text(text = "Sticky Notes is a Notes App made using Java" , fontSize = 13.sp, fontFamily = FontFamily.Default,modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Start),color = Color.Black)
                Text(text ="Features : ",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 13.sp, fontFamily = FontFamily.Serif, color = Color.Black)
                Text(text = "1. Designed and implemented a Notes App using Java.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "2. Developed a user-friendly Notes application in Android designed for day-to-day task management.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "3. Designed and implemented real-time chat functionality using Firebase Cloud Messaging (FCM).",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "Github Link :https://github.com/adityamathur27/Sticky-Notes-App.git",modifier = Modifier
                    .absolutePadding(4.dp, 1.dp)
                    .clickable(enabled = true) {
                        openURL.launch(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/adityamathur27/Sticky-Notes-App.git")
                            )
                        )
                    }, fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Blue)
                Divider(thickness = 1.dp , color = Color.Black,modifier = Modifier.absolutePadding(0.dp,4.dp))
                Text(text = "Sticky Notes App" , fontSize = 25.sp, fontFamily = FontFamily.Serif, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black)
                Text(text = "Sticky Notes is a Notes App made using Java" , fontSize = 13.sp, fontFamily = FontFamily.Default,modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Start),color = Color.Black)
                Text(text ="Features : ",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 13.sp, fontFamily = FontFamily.Serif, color = Color.Black)
                Text(text = "1. Designed and implemented a Notes App using Java.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "2. Developed a user-friendly Notes application in Android designed for day-to-day task management.",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "3. Designed and implemented real-time chat functionality using Firebase Cloud Messaging (FCM).",modifier = Modifier.absolutePadding(4.dp,1.dp), fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Black)
                Text(text = "Github Link :https://github.com/adityamathur27/Sticky-Notes-App.git",modifier = Modifier
                    .absolutePadding(4.dp, 1.dp)
                    .clickable(enabled = true) {
                        openURL.launch(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://github.com/adityamathur27/Sticky-Notes-App.git")
                            )
                        )
                    }, fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Blue)
                Divider(thickness = 1.dp , color = Color.Black,modifier = Modifier.absolutePadding(0.dp,4.dp))
                Text("Contact Me", fontSize = 25.sp, fontFamily = FontFamily.Serif, modifier = Modifier.align(Alignment.CenterHorizontally), color = Color.Black)
                Text(text = "Email :adimathur272001@gmail.com",modifier = Modifier.absolutePadding(4.dp,1.dp).clickable (enabled = true){
                    openURL.launch(
                        Intent(
                            Intent.ACTION_SENDTO,
                            Uri.parse("mailto:adimathur272001@gmail.com")
                        )
                    )
                }, fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Blue)
                Text(text = "Call Me : 8302073496",modifier = Modifier.absolutePadding(4.dp,1.dp).clickable(enabled = true) {
                    openURL.launch(
                        Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse("tel:8302073496")
                        )
                    )
                }, fontSize = 12.sp, fontFamily = FontFamily.Default, color = Color.Blue)



            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PortfolioTheme {
        CreateBizCard()
    }
}