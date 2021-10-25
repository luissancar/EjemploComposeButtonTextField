package com.example.sumacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sumacompose.ui.theme.SumaComposeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.example.sumacompose.R.drawable.ic_android_black_24dp
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var textFieldValueNunmeroA by rememberSaveable { mutableStateOf("") }
    var textFieldValueNunmeroB by rememberSaveable { mutableStateOf("") }
    var textFieldValueResultado by rememberSaveable { mutableStateOf("Resultado") }



    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Espacio()
        Text(text = "Operaciones",
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth())
        Espacio()

        Row (modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Número A ",
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 8.dp)
            )
            Espacio()
            TextField(
                value = textFieldValueNunmeroA,
                onValueChange = {nuevoNumero ->
                    textFieldValueNunmeroA = nuevoNumero
                },
                label = {
                    Text(text = "Introducir número")
                },
                modifier = Modifier
                    .padding(end = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Right),
                leadingIcon = {
                    // In this method we are specifying
                    // our leading icon and its color.
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "image",
                        tint = Color.Blue
                    )
                }

            )
        }
        Row (modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Número B ",
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 8.dp)
            )
            Espacio()
            TextField(
                value = textFieldValueNunmeroB,
                onValueChange = {nuevoNumero ->
                    textFieldValueNunmeroB = nuevoNumero
                },
                label = {
                    Text(text = "Introducir número")
                },
                modifier = Modifier
                    .padding(end = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = TextStyle(textAlign = TextAlign.Right),
                leadingIcon = {
                    // In this method we are specifying
                    // our leading icon and its color.
                    Icon(
                        painter = painterResource(id = R.drawable.ic_android_black_24dp)
                        , contentDescription ="icono" )
                }

            )
        }

        Espacio()
        Text(text = textFieldValueResultado,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth())
        Espacio()
        Boton(
            sumar = {
                try {
                    val a = textFieldValueNunmeroA.toString().toInt()
                    val b = textFieldValueNunmeroB.toString().toInt()
                    val c = a + b
                    textFieldValueResultado = c.toString()
                }
                catch (e:Exception)
                {
                    textFieldValueResultado = "Error"
                }

            }
        )

    }


}


@Composable
fun Boton(
    sumar:() -> Unit
){
    Button(
        onClick = {
            sumar()
         },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp))
    {
        Text(text = "Sumar")

        
    }
}
@Composable
fun Espacio(){
    Spacer(modifier = Modifier.size(20.dp))  
}



@Preview(showBackground = true,showSystemUi = true)
@Composable
fun DefaultPreview() {
    SumaComposeTheme {
        Greeting()
    }
}