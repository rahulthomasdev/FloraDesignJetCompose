package com.example.floradesignjetcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.floral_green))){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(
                    id = R.color.floral_green
                )
            )) {
            Row(modifier = Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(painter = painterResource(id = R.drawable.baseline_branding_watermark_24),
                        contentDescription = "Brand Icon", modifier = Modifier.size(48.dp), tint = Color.White)
                    Text(text = "BRAND NAME", fontSize = 30.sp, color = Color.White)
                }
            }
            Row(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.floral_green))){
                Box(modifier= Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
                    ),
                    contentAlignment = Alignment.TopCenter
                ){
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp)) {
                        val text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = colorResource(id = R.color.floral_green))){
                                append("Log in ")
                            }
                            append("to your account.")

                        }
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                            Text(text = text, fontSize = 25.sp, modifier = Modifier.padding(top = 30.dp), color = Color.Gray)
                        }
                        Spacer(modifier = Modifier.size(25.dp))
                        Text(text = "Email Address", fontSize = 18.sp, color = Color.Gray, modifier = Modifier.padding(start= 16.dp))
                        Card(modifier = Modifier
                            .padding(16.dp)
                            .wrapContentHeight()
                            .wrapContentHeight()
                            .background(color = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ){
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .background(color = Color.White),  contentAlignment = Alignment.Center){
                                Row(modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_email_24), contentDescription = null, modifier = Modifier
                                        .size(30.dp)
                                        .padding(2.dp), tint = colorResource(id = R.color.floral_green))
                                    Divider(color = colorResource(id = R.color.gray_100), modifier= Modifier
                                        .fillMaxHeight(0.5f)
                                        .width(2.dp))
                                    TextField(value = "Email Address", onValueChange = {}, colors = TextFieldDefaults.textFieldColors(
                                        textColor= Color.Gray,
                                        containerColor = Color.White,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent
                                    ))
                                }

                            }
                        }
                        Spacer(modifier = Modifier.size(25.dp))
                        Text(text = "Password", fontSize = 18.sp, color = Color.Gray, modifier = Modifier.padding(start= 16.dp))
                        Card(modifier = Modifier
                            .padding(16.dp)
                            .wrapContentHeight()
                            .wrapContentHeight()
                            .background(color = Color.White), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ){
                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min)
                                .background(color = Color.White),  contentAlignment = Alignment.Center){
                                Row(modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                                    Icon(painter = painterResource(id = R.drawable.baseline_lock_24), contentDescription = null, modifier = Modifier
                                        .size(30.dp)
                                        .padding(2.dp), tint = colorResource(id = R.color.floral_green))
                                    Divider(color = colorResource(id = R.color.gray_100), modifier= Modifier
                                        .fillMaxHeight(0.5f)
                                        .width(2.dp))
                                    TextField(value = "Password", onValueChange = {}, colors = TextFieldDefaults.textFieldColors(
                                        textColor= Color.Gray,
                                        containerColor = Color.White,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        disabledIndicatorColor = Color.Transparent
                                    ))
                                }

                            }
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp), horizontalArrangement = Arrangement.End) {
                            Text(text = "Forgot Password", fontSize = 16.sp, color = colorResource(
                                id = R.color.floral_green
                            ))
                        }
                        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(16.dp), modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .wrapContentHeight(), colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.floral_green),
                            contentColor = Color.White
                            )
                            ) {
                                Text(text = "Login", fontSize = 21.sp, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
                        }
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                            horizontalArrangement = Arrangement.Center
                        ){
                            val text = buildAnnotatedString {
                                append("Don't have an account?")
                                    withStyle(style = SpanStyle(color = colorResource(id = R.color.floral_green))){
                                        append("Sign In")
                                    }
                                }
                            Text(text=text, fontSize = 16.sp, color = Color.Gray)
                        }

                    }

                }

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}