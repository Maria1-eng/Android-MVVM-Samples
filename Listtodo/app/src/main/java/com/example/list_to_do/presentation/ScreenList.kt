package com.example.list_to_do.presentation

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ScreenList() {
    val viewModel = ListViewModel()
    ScreenContent(modifier = Modifier, viewModel = viewModel)
}

//@Composable
//fun ScreenContent(modifier: Modifier) {
//    //val list = mutableListOf<String>("merli", "chata","pulga") // mmutable porque voy a poner y quitar cosas
//    //list.removeAt(index= 0) // tener cuidado con remove y remove at uno es para string y otro para enteros
//    val list = remember { mutableStateListOf("merli","chata","pulga") } // Crea una lista mutable observable
//    // no puedes utilizar la asignacion "by", mutableStateListof no devuelve un State<T>
//    // puedes hacerlo e.g var list by remember{mutableStateOf(listOf("merli","pulga")}
//    // ahora para agregar valores list = list + "hola", si solo quieres ver su estado entonces pondrias val.
//    // crea una nueva lista, Compose observa el cambio.
//    // Importante mutableStateOf no sabe que hay en la lista solo la referencia.
//    // Si crearas una mutable dentro y quisieras ocupar los comando como list.add() no podrias porque mutableSTateOf no sabe que hay dentro.
//
//
//
//    MutableStateOf Guarda un valor. Notifica a Compose cuando ese valor cambia
//Compose detecta que ese estado cambió. Se vuelve a ejecutar (recomponer) la función composable que usa ese estado.
//La UI se actualiza automáticamente.
//    Recomposición (Recomposition)
// Compose:  Vuelve a ejecutar solo las funciones que leen ese estado.
// No reconstruye toda la pantalla.
//Solo actualiza la parte necesaria.
//
//
//
//    LazyColumn(
//        modifier
//            .fillMaxSize()
//            .safeContentPadding(),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        itemsIndexed(list) { index, item ->
//            Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
//                Box(modifier.align(Alignment.CenterVertically)) {
//                    Text("${index + 1} $item")
//                }
//                IconButton(onClick = {list.removeAt(index)}) {
//                    Icon(
//                        imageVector = Icons.Default.Close,
//                        contentDescription = "Remove"
//                    )
//                }
//            }
//
//        }
//    }
//}


//@Composable
//fun ScreenContent(modifier: Modifier, viewModel: ListViewModel) {
//
//    val list by viewModel.list.collectAsStateWithLifecycle()
//    val text by viewModel.text.collectAsStateWithLifecycle()
//    Column(
//        modifier
//            .fillMaxSize()
//            .safeContentPadding()
//    ) {
//        LazyColumn(
//            modifier
//                .weight(1f)
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            itemsIndexed(list) { index, item ->
//                Row(
//                    modifier = Modifier
//                        .padding(4.dp)
//                        .background(MaterialTheme.colorScheme.tertiaryContainer)
//                        .fillMaxWidth()
//                        .padding(horizontal = 6.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(text = " ${index + 1}  $item") // el align que podria pone aqui solo funciona dentro de un text. No con column o row, text no tiene dimensiones como box por eso no se puede.
//                    IconButton(onClick = { viewModel.Remove(index) }) {
//                        Icon(
//                            imageVector = Icons.Default.Close,
//                            contentDescription = "Remove"
//                        )
//                    }
//                }
//
//            }
//
//
//        }
//        Row(
//            modifier = modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = text,
//                onValueChange = {newText -> viewModel.OnClickChanged(newText)},
//                enabled = true,
//                placeholder = { Text("Nueva tarea") })
//            Box() {
//                FloatingActionButton(
//                    onClick = { viewModel.Add() },
//                    modifier = Modifier.align(Alignment.BottomEnd) // Box trabaja en dos dimensiones por eso hay que especificar si es bottom.End, center.End, top.End
//                ) {
//                    Icon(Icons.Default.Add, contentDescription = "Agregar")
//                }
////        Button(modifier = modifier.align(Alignment.CenterEnd),onClick = {}) {
////            Text("+")
////        }
//
//            }
//        }
//
//
//    }
//}

@Composable
fun ScreenContent(modifier: Modifier, viewModel: ListViewModel) {
    Scaffold(
        modifier = Modifier.safeContentPadding(),
        topBar = { TopAppBar()},
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Agregar")
            }
        }) { }
}