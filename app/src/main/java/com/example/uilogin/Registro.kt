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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uilogin.ui.theme.UIloginTheme


@Composable
fun Registro(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(247, 247, 247, 255))
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

            var firstName by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }
//var password by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }

            TextField(
                value = firstName,
                onValueChange = { firstName = it.filter { char -> char.isLetter() } },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = lastName,
                onValueChange = { lastName = it.filter { char -> char.isLetter() } },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = username,
                onValueChange = {
                    username = it.take(10).filter { char -> char.isLetterOrDigit() }
                },
                label = { Text("Usuario") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo Electronico") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(5.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            if (password.length < 8 || !password.any { it.isUpperCase() } || !password.any { it.isDigit() } || !password.any { !it.isLetterOrDigit() }) {
                Text(
                    text = "La contraseña debe tener al menos 8 caracteres, una mayúscula, un número y un carácter especial.",
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(
                onClick = { /* Handle registration confirmation and save */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
    UIloginTheme {
        Registro(navController = rememberNavController())
    }
}
