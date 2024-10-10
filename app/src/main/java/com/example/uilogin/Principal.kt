package com.example.uilogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.uilogin.ui.theme.UIloginTheme

class PrincipalMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIloginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Principal(
        navController = rememberNavController(),
        modifier = Modifier.padding(innerPadding)
    )
}
            }
        }
    }
}

class PrincipalGreeting(name: String, modifier: Modifier) {

}

@Composable
fun Principal(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(247,247,247,255))
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Image(
                painter = painterResource(R.drawable.whatsapp_image_2024_10_10_at_13_22_15),
                contentDescription = "Login Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
            )
            Spacer(modifier = Modifier.height(75.dp))

Button(
    onClick = { navController.navigate("LoginScreen") },
    modifier = Modifier.fillMaxWidth()
) {
    Text("Iniciar Sesión")
}
Spacer(modifier = Modifier.height(5.dp))
Button(
    onClick = { /* Handle registration */ },
    modifier = Modifier.fillMaxWidth()
) {
    Text("Registrarse")
            }
        }
    }
}

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "Principal"
) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("LoginScreen") {
            //val navController = null
           LoginScreen(navController = navController)
    }
      //  composable("Pantalla2") {
        //    val navController = null
          //  Pantalla2(navController)
    //}
    }
}

fun composable(s: String, function: @Composable () -> Unit) {

}

@Preview(showBackground = true)
@Composable
fun PrincipalPreview() {
    UIloginTheme {
Principal(navController = rememberNavController())
    }
}

